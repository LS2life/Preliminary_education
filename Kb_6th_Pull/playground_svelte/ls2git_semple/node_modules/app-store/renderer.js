// This file is required by the index.html file and will
// be executed in the renderer process for that window.
// All of the Node.js APIs are available in this process.

const fs = require('fs')
const path = require('path')
const rimraf = require('rimraf');
const mkdirp = require('mkdirp');

const EventEmitter = require('events');

const npm = require('npm');

const electron = require('electron');
const BrowserWindow = electron.remote.BrowserWindow;

const stateManager = {

  applyDefault: function(package){
    if(!package.state) package.state = {};
    package.state.name = 'Default'
    package.state.buttonAction = 'install-package';
    package.state.progressBar = false;
    package.state.buttonLabel = 'Install';
  },

  applyInstalling: function(package){
    package.state.name = 'Installing'
    package.state.buttonAction = 'noop';
    package.state.progressBar = true;
    package.state.buttonLabel = 'Installing';
  },

  applyUpdating: function(package){
    package.state.name = 'Updating'
    package.state.buttonAction = 'noop';
    package.state.progressBar = true;
    package.state.buttonLabel = 'Updating';
  },

  applyInstalled: function(package){
    package.state.name = 'Installed'
    package.state.buttonAction = 'launch-package';
    package.state.progressBar = false;
    package.state.buttonLabel = 'Launch';
  },

}

const envPaths = require('env-paths');
const paths = envPaths('npm-app-store');
const dirapps = path.join( paths.cache, 'installed' );

mkdirp.sync(dirapps);
mkdirp.sync(path.join( dirapps, 'node_modules' ));

// this is the initial library.
// let packages = [];
// packages.push( { name: 'bootstrap-electron', description: 'Bootstrap based Electron Application Starter Pack', state:{} } );

let packages = require('app-catalog').data;

packages.forEach(p => {
    stateManager.applyDefault(p);
})

let installed = fs.readdirSync(path.join(dirapps, 'node_modules'));
installed.forEach(i => {
  packages.forEach(p => {
    if(p.name === i){
      stateManager.applyInstalled(p);
    }
  })
})


class MyEmitter extends EventEmitter {}
const ee = new MyEmitter();

ee.on('install-package', async (package) => {
  stateManager.applyInstalling(package);
  npm.load({
    prefix: dirapps,
    loaded: false,
    global: false,
  }, function(err) {
    npm.commands.install([package.name], function(er, data) {
      stateManager.applyInstalled(package);
    });
    npm.on('log', function(message) {
      // log installation progress
      console.log(message);
    });
  });
});

ee.on('update-package', async (package) => {
  stateManager.applyUpdating(package);
  npm.load({
    prefix: dirapps,
    loaded: false,
    global: false,
  }, function(err) {
    npm.commands.update([package.name], function(er, data) {
      stateManager.applyInstalled(package);
    });
    npm.on('log', function(message) {
      // log installation progress
      console.log(message);
    });
  });
});

ee.on('uninstall-package', async (package) => {
  npm.load({
    prefix: dirapps,
    loaded: false,
    global: false,
  }, function(err) {
    npm.commands.uninstall([package.name], function(er, data) {
      stateManager.applyDefault(package);
    });
    npm.on('log', function(message) {
      // log installation progress
      console.log(message);
    });
  });
});

ee.on('launch-package', async (package) => {
   let win = new BrowserWindow({width: 800, height: 600})
   win.on('closed', () => {
     win = null
   })
   win.loadURL(`file://${path.join(dirapps, 'node_modules' ,package.name)}/index.html`)
});




Vue.component('cycle', {
  template: '#cycle-template',
  props: {
    ee: Object,
    model: Object
  },
  data: function () {
    return {
      open: false
    }
  },
  created () {

    // this.record = this.ds.record.getRecord('test/johndoe')
    //
    // this.record.subscribe(values => {
    //
    //   this.firstname = values.firstname
    //   this.lastname = values.lastname
    //
    // })

  },
  methods: {

    buttonAction: function (package) {
      this.ee.emit(package.state.buttonAction, package);
    },

    uninstallAction: function (package) {
      this.ee.emit('uninstall-package', package);
    },

    updateAction: function (package) {
      this.ee.emit('update-package', package);
    }

  }
})


var appTitle = new Vue({
  el: '#app-title',
  data: {
    name: 'App Store',
    description: 'Manage Electron Applications'
  }
});


var appPackages = new Vue({
  el: '#app-packages',

  data: {
    packages
  },
  created () {
    this.ee = ee;

    // Subscribe to events in created()
    this.ee.on('event', (o) => {
      console.log('an event occurred!', o);
    });

  },

  methods: {
    something: function (o) {
      // Dispatch events from methods
      this.ee.emit('event');
    }
  }
})

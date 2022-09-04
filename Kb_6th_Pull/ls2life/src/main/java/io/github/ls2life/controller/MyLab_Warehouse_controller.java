package io.github.ls2life.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController = @Controller + @ResponseBody
@RestController
public class MyLab_Warehouse_controller {
    
    @GetMapping("/mylab_warehouse")
    public String myLabMain() {
        return "index";
    }
}

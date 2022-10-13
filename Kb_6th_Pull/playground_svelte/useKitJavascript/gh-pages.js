import { publish } from 'gh-pages';

publish(
	'build', // path to public directory
	{
		branch: 'gh-pages',
		repo: 'https://github.com/LS2life/ls2git.git', // Update to point to your repository
		user: {
			name: 'E_San', // update to use your name
			email: 'lovemylife00@naver.com' // Update to use your email
		},
		dotfiles: true
	},
	() => {
		console.log('Deploy Complete!');
	}
);

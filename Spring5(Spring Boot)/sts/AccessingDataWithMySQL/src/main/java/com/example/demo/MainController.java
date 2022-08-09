package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser(
			@RequestParam String name,
			@RequestParam String email
			) {
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "Saved";
	}
	@PostMapping(path="/addjson")
	@ResponseBody
	public User addNewUser1(
			@RequestBody User user
			) {
		userRepository.save(user);
		return user;
	}

}

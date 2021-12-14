package arg.hero.loginAndRegistration.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arg.hero.loginAndRegistration.entity.AppUser;
import arg.hero.loginAndRegistration.serviceimpl.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public void login() {
		
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
		
		return ResponseEntity.ok(userService.save(user));
	}
	
	@GetMapping("/users")
	public List<AppUser> getAllUsers() {
		return userService.findAll();
	}
	

}

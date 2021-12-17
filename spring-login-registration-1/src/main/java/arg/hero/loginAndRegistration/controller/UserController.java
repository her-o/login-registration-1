package arg.hero.loginAndRegistration.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import arg.hero.loginAndRegistration.entity.AppUser;
import arg.hero.loginAndRegistration.serviceimpl.UserService;


@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	

	@GetMapping("/registerUser")
	public String getRegistrationForm(Model model) {
		model.addAttribute("user", new AppUser());
		return "registrationForm";
	}
	
	@PostMapping("/registration_process")
	public String registerUser(@ModelAttribute("user") AppUser user) {
		userService.save(user);
		return "redirect:login?registrationSuccessful";
		
	}
	
	@GetMapping("/users")
	public List<AppUser> getAllUsers() {
		return userService.findAll();
	}
	

}

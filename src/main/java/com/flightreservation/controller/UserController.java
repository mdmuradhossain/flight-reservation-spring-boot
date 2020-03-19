package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.model.User;
import com.flightreservation.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/showSignUpForm")
	public String showSignUpPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration/signup";
	}

	@PostMapping("/signUpUser")
	public String signUp(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "registration/signin";
	}

	@RequestMapping(value = "/signin",method = RequestMethod.POST)
	public String signin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		User user = userRepository.findByEmail(email);
		if (user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			model.addAttribute("msg", "invalid username or password");
		}
		return "registration/signin";
	}
}

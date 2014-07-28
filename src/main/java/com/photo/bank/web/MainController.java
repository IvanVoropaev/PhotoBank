package com.photo.bank.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photo.bank.entity.Users;
import com.photo.bank.service.PhotoBankService;
import com.photo.bank.service.PhotoBankUserDetailService;

@Controller
public class MainController {
	
	@Autowired
	private PhotoBankService photoBankService;
	
	@Autowired
	private PhotoBankUserDetailService userDetailService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "anonimTemplate";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.out.println(user);
		ModelAndView model = new ModelAndView();
		model.setViewName("userTemplate");
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerNewUser(Model model) {
		System.out.println("Test");
		model.addAttribute(new Users());
		return "registrationTemplate";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addNewUser(@Valid Users users, BindingResult bindingResult) {
		
		ModelAndView model = new ModelAndView();
		
		System.out.println(users);
		if (bindingResult.hasErrors()) {
			System.out.println("Validate error");
			model.setViewName("registrationTemplate");
			return model;
		}
		
		if(!photoBankService.isUserNameAvalable(users.getUserName())) {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "userName", "Specified username is already taken."));
			System.out.println("Name already token");
			model.setViewName("registrationTemplate");
			return model;
		}
		
		System.out.println("Test2");
		photoBankService.addUser(users);
		model.setViewName("registrationComplete");
		model.addObject("bindingResult", bindingResult);
		model.addObject("user", users);
		
		User user = (User) userDetailService.loadUserByUsername(users.getUserName());
		userDetailService.authenticateUser(user);
		
		//Authentication authentication = new Authentication();
		
		//SecurityContextHolder.getContext().getAuthentication().
		return model;
	}
	
	@RequestMapping(value = "/entered")
	public String enterInSystem() {

		return "welcome";
	}
	
	@RequestMapping(value = "/id{id}")
	public String showUserPage(@PathVariable String userId, Model model) {
		return "test";
	}
}

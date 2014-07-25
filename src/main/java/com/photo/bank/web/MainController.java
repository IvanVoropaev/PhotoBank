package com.photo.bank.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photo.bank.entity.Users;
import com.photo.bank.service.PhotoBankService;

@Controller
public class MainController {
	
	@Autowired
	private PhotoBankService photoBankService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "anonimTemplate";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
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
	public String addNewUser(@Valid Users users, BindingResult bindingResult) {
		
		System.out.println(users);
		if (bindingResult.hasErrors()) {
			System.out.println("Validate error");
			return "registrationTemplate";
		}
		
		if(!photoBankService.isUserNameAvalable(users.getUserName())) {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "username", "Specified username is already taken."));
			System.out.println("Name already token");
			return "registrationTemplate";
		}
		
		System.out.println("Test2");
		photoBankService.addUser(users);
		return "registrationComplete";
	}
}

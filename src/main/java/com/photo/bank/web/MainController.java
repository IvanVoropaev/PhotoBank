package com.photo.bank.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		if (bindingResult.hasErrors()) {
			return "register";
		}
		photoBankService.addUser(users);
		return "registrationComplete";
	}
}

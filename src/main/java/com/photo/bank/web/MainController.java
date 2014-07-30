package com.photo.bank.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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

@Controller
public class MainController {
	
	@Autowired
	private PhotoBankService photoBankService;
	
	@Autowired
	@Qualifier("org.springframework.security.authenticationManager")
	protected AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Principal principal) {
		if (principal == null)
			return "anonimTemplate";
		else 
			return "userTemplate";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userTemplate");
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerNewUser(Model model) {
		model.addAttribute(new Users());
		return "registrationTemplate";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addNewUser(@Valid Users users, BindingResult bindingResult, HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			model.setViewName("registrationTemplate");
			return model;
		}
		
		if(!photoBankService.isUserNameAvalable(users.getUserName())) {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "userName", "Specified username is already taken."));
			model.setViewName("registrationTemplate");
			return model;
		}
		
		photoBankService.addUser(users);
		model.setViewName("registrationComplete");
		model.addObject("bindingResult", bindingResult);
		model.addObject("user", users);
		
		// After successfully Creating user
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
		users.getUserName(), users.getPassword());
		 
		// generate session if one doesn't exist
		request.getSession();
		 
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);
		 
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		
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

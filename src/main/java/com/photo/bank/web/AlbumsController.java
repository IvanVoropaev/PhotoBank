package com.photo.bank.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Users;
import com.photo.bank.service.PhotoBankService;

@Controller
public class AlbumsController {
	
	@Autowired
	private PhotoBankService photoBankService;
	
	@RequestMapping(value = "/addalbum", method = RequestMethod.GET)
	public ModelAndView showAddAlbumForm() {
		ModelAndView model = new ModelAndView();
		
		model.addObject("album", new Albums());
		model.setViewName("addAlbumTemplate");

		return model;
	}
	
	@RequestMapping(value = "/addalbum", method = RequestMethod.POST)
	public ModelAndView addAlbum(Principal principal, Albums album) {
		ModelAndView model = new ModelAndView();
		String username = principal.getName();
		Users user = photoBankService.getUser(username);
		album.setUser(user);
		photoBankService.addAlbum(album);
		
		model.addObject("albumList", photoBankService.getAlbumList(user));
		model.setViewName("showAlbumTemplate");
	
		return model;
	}
	
	@RequestMapping(value = "/showalbums")
	public ModelAndView showAlbums(Principal principal) {
		ModelAndView model = new ModelAndView();
		String username = principal.getName();
		Users user = photoBankService.getUser(username);
		
		model.addObject("albumList", photoBankService.getAlbumList(user));
		model.setViewName("showAlbumTemplate");
	
		return model;
	}

}

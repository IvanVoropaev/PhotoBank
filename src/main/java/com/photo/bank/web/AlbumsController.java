package com.photo.bank.web;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Photos;
import com.photo.bank.entity.Users;
import com.photo.bank.service.PhotoBankService;

@Controller
public class AlbumsController {
	
	@Autowired
	private PhotoBankService photoBankService;
	
	@RequestMapping(value = "/addalbum", method = RequestMethod.GET)
	public String showAddAlbumForm(Model model) {
		
		model.addAttribute(new Albums());
		return "addAlbumTemplate";
	}
	
	@RequestMapping(value = "/addalbum", method = RequestMethod.POST)
	public ModelAndView addAlbum(@Valid Albums albums, BindingResult bindingResult, Principal principal) {
		ModelAndView model = new ModelAndView();
		String username = principal.getName();
		String albumname = albums.getAlbumName();
		
		if (bindingResult.hasErrors()) {
			model.setViewName("addAlbumTemplate");
			return model;
		}
		
		if (!photoBankService.isAlbumNameAvalable(username, albumname)) {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "albumName", "Album name is already taken for user " + principal.getName() + "."));
			model.setViewName("addAlbumTemplate");
			return model;
		}
		
		Users user = photoBankService.getUser(username);
		albums.setUser(user);
		photoBankService.addAlbum(albums);
		
		model.addObject("albumList", photoBankService.getAlbumList(user));
		model.addObject("bindingResult", bindingResult);
		model.addObject("album", albums);
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
	
	@RequestMapping(value = "/album")
	public ModelAndView showAlbumById(@RequestParam(value = "albumid", required = false) Integer albumId, Principal principal) {
		ModelAndView model = new ModelAndView();
		String username = principal.getName();
		Users user = photoBankService.getUser(username);
		List<Albums> albumList = photoBankService.getAlbumList(user);
		Albums album = new Albums();
		boolean validate = false;
		for (Albums a : albumList) {
			if (a.getId() == albumId) {
				validate = true;
				album = a;
			}
		}
		
		if (!validate) {
			model.setViewName("error");
			return model;
		}
		
		List<Photos> photoAlbum = photoBankService.getPhotosList(album);
		model.addObject("albumList", albumList);
		model.addObject("album", album);
		model.addObject("photoAlbum", photoAlbum);	
		model.addObject(new Photos());
		model.setViewName("showPhotoAlbumTemplate");
		
		return model;
	}

}

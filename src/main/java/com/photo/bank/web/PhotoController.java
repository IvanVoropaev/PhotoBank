package com.photo.bank.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.photo.bank.service.PhotoBankService;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoBankService photoBankService;
	
	@RequestMapping(value = "addphoto")
	public ModelAndView addPhoto(@RequestParam(value = "album", required = false) Integer albumId, 
			                     @RequestParam(value="image", required = true) MultipartFile image, 
			                     Principal principal) 
	{
		ModelAndView model = new ModelAndView();
		return model;
	}
	
	/*private void validateImage(MultipartFile image) {
		if(!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted");
		}
	}*/

}

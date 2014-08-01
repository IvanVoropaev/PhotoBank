package com.photo.bank.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import org.apache.commons.io.FileUtils;
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
			                     @RequestParam(value = "image", required = true) MultipartFile image, 
			                     Principal principal) 
	{
		ModelAndView model = new ModelAndView();
		saveImage("test1.jpg", image);
		model.setViewName("welldone");
		return model;
	}
	
	private void saveImage(String filename, MultipartFile image) {
		String webRootPath = "resources";
		try {
			File file = new File(webRootPath + "/resources/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*private void validateImage(MultipartFile image) {
		if(!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted");
		}
	}*/
	
	/*private void writeImageInFile(MultipartFile image) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			// read this file into InputStream
			inputStream = image.getInputStream();
	 
			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(new File("/resourses/test.jpg"));
	 
			int read = 0;
			byte[] bytes = new byte[1048576];
	 
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
	 
			System.out.println("Done!");
	 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 
			}
		}  
	}*/

}

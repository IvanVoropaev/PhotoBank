package com.photo.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.bank.dao.PhotoBankDAO;
import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Photos;
import com.photo.bank.entity.Users;

@Service
public class PhotoBankServiceImpl implements PhotoBankService {
	
	@Autowired
	private PhotoBankDAO photoBankDAO;
	
	@Transactional
	public void addUser(Users user) {		
		photoBankDAO.addUser(user);
	}

	@Transactional
	public Users getUser(String username) {		
		return photoBankDAO.getUser(username);
	}

	@Transactional
	public boolean isUserNameAvalable(String username) {		
		return photoBankDAO.isUserNameAvalable(username);
	}
	
	@Transactional
	public void loginUser(Users user) {
		
	}

	@Transactional
	public void addAlbum(Albums album) {		
		photoBankDAO.addAlbum(album);
	}

	@Transactional
	public List<Albums> getAlbumList(Users user) {		
		return photoBankDAO.getAlbumsList(user);
	}

	@Transactional
	public boolean isAlbumNameAvalable(String username, String albumname) {		
		return photoBankDAO.isAlbumNameAvalable(username, albumname);
	}

	@Transactional
	public List<Photos> getPhotosList(Albums album) {		
		return photoBankDAO.getPhotosList(album);
	}
}

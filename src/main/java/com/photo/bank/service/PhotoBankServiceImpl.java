package com.photo.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.bank.dao.PhotoBankDAO;
import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Users;

@Service
public class PhotoBankServiceImpl implements PhotoBankService {
	
	@Autowired
	private PhotoBankDAO photoBankDAO;
	
	@Transactional
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		photoBankDAO.addUser(user);
	}

	@Transactional
	public Users getUser(String username) {
		// TODO Auto-generated method stub
		return photoBankDAO.getUser(username);
	}

	@Transactional
	public boolean isUserNameAvalable(String username) {
		// TODO Auto-generated method stub
		return photoBankDAO.isUserNameAvalable(username);
	}
	
	@Transactional
	public void loginUser(Users user) {
		// TODO Auto-generated method stub
	}

	@Transactional
	public void addAlbum(Albums album) {
		// TODO Auto-generated method stub
		photoBankDAO.addAlbum(album);
	}

	@Transactional
	public List<Albums> getAlbumList(Users user) {
		// TODO Auto-generated method stub
		return photoBankDAO.getAlbumsList(user);
	}
}

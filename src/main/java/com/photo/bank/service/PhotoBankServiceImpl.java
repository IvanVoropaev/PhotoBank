package com.photo.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.bank.dao.PhotoBankDAO;
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
}

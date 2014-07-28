package com.photo.bank.service;

import com.photo.bank.entity.Users;

public interface PhotoBankService {
	void addUser(Users user);
	Users getUser(String username);
	boolean isUserNameAvalable(String username);
	void loginUser(Users user);
}

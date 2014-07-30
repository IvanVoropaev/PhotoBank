package com.photo.bank.service;

import java.util.List;

import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Photos;
import com.photo.bank.entity.Users;

public interface PhotoBankService {
	void addUser(Users user);
	void addAlbum(Albums album);
	Users getUser(String username);
	boolean isUserNameAvalable(String username);
	boolean isAlbumNameAvalable(String username, String albumname);
	void loginUser(Users user);
	List<Albums> getAlbumList(Users user);
	List<Photos> getPhotosList(Albums album);
}

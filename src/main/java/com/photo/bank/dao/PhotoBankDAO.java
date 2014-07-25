package com.photo.bank.dao;

import java.util.List;

import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Photos;
import com.photo.bank.entity.Roles;
import com.photo.bank.entity.Users;

public interface PhotoBankDAO {
	void addUser(Users user);
	void addRoles(Roles role);
	void addAlbum(Albums album);
	void addPhoto(Photos photo);
	
	void findUser(Users user);
	
	Users getUser(String username);
	
	List<Photos> getPhotos(Users user, Albums album);
	
	List<Roles> getRoles(Users user);
	
	boolean isUserNameAvalable(String username);
}

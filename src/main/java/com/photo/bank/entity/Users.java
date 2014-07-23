package com.photo.bank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="user")
	private List<Albums> albumList;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_role")
	private String userRole;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="user")
	private List<Photos> photoList;

	public List<Photos> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photos> photoList) {
		this.photoList = photoList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Albums> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Albums> albumList) {
		this.albumList = albumList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}

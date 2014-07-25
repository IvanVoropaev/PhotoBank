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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name="user_id", unique=true)
	@GeneratedValue
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="user")
	private List<Albums> albumList;
	
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
	@NotEmpty
	@Column(name="user_name", unique=true)
	private String userName;
	
	@NotEmpty @Email
	@Column(name="user_email", unique=true)
	private String userEmail;
	
	@NotEmpty
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	@Column(name="password")
	private String password;
	
	@Column(name="blocked")
	private boolean blocked;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="user")
	private List<Photos> photoList;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="user")
	private List<Roles> roleList;

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public List<Roles> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Roles> roleList) {
		this.roleList = roleList;
	}

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return getUserName() + " " + getUserEmail() + " " + getPassword();
	}

}

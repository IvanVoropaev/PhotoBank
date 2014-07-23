package com.photo.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHOTOS")
public class Photos {
	
	@Id
	@Column(name="photo_id")
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name="album_id")
	private Albums album;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;
	
	@Column(name="path")
	private String path;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public Albums getAlbum() {
		return album;
	}

	public void setAlbum(Albums album) {
		this.album = album;
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}

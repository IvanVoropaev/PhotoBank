package com.photo.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Photos;
import com.photo.bank.entity.Roles;
import com.photo.bank.entity.UserRoleEnum;
import com.photo.bank.entity.Users;


@Repository
public class HibernatePhotoBankDAO implements PhotoBankDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(Users user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		Roles role = new Roles();
		role.setUser(user);
		role.setRole(UserRoleEnum.USER);
		addRoles(role);
	}

	public void addAlbum(Albums album) {
		
		sessionFactory.getCurrentSession().save(album);
	}

	public void addPhoto(Photos photo) {
		
		sessionFactory.getCurrentSession().save(photo);
	}

	public void findUser(Users user) {
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Photos> getPhotosList(Albums album) {
		
		return (List<Photos>) sessionFactory.getCurrentSession()
					                        .createQuery("from Photos photo where photo.album = :album")
					                        .setParameter("album", album)
					                        .list();
	}

	@SuppressWarnings("unchecked")
	public Users getUser(String username) {
		
		List<Users> userList = new ArrayList<Users>();
		userList = sessionFactory.getCurrentSession()
				                 .createQuery("from Users u where u.userName = :username")
				                 .setParameter("username", username)
				                 .list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Roles> getRoles(Users user) {
		
		List<Roles> roleList = new ArrayList<Roles>();
		roleList = sessionFactory.getCurrentSession()
								 .createQuery("from Roles r where r.user = :user")
								 .setParameter("user", user)
								 .list();
		return roleList;
	}

	public void addRoles(Roles role) {
		
		sessionFactory.getCurrentSession().save(role);
	}
	
	public boolean isUserNameAvalable(String username) {	
		if(getUser(username) != null)
			return false;
		else
			return true;
	}

	@SuppressWarnings("unchecked")
	public List<Albums> getAlbumsList(Users user) {
		
		List<Albums> albumList = new ArrayList<Albums>();
		albumList = sessionFactory.getCurrentSession()
								  .createQuery("from Albums a where a.user = :user")
								  .setParameter("user", user)
								  .list();
		return albumList;
	}

	public boolean isAlbumNameAvalable(String username, String albumname) {
		Users user = getUser(username);
		List<Albums> albumList = getAlbumsList(user);
		boolean avalable = true;
		for(Albums album : albumList) {
			if (album.getAlbumName().equals(albumname))
				avalable = false;
		}
		return avalable;
	}

}

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

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		Roles role = new Roles();
		role.setUser(user);
		role.setRole(UserRoleEnum.USER);
		addRoles(role);
	}

	@Override
	public void addAlbum(Albums album) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(album);
	}

	@Override
	public void addPhoto(Photos photo) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(photo);
	}

	@Override
	public void findUser(Users user) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photos> getPhotos(Users user, Albums album) {
		// TODO Auto-generated method stub
		return (List<Photos>) sessionFactory.getCurrentSession()
					                        .createQuery("from Photos photo where photo.user = :user and photo.album = :album")
					                        .setEntity("user", user)
					                        .setEntity("album", album)
					                        .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users getUser(String username) {
		// TODO Auto-generated method stub
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
	@Override
	public List<Roles> getRoles(Users user) {
		// TODO Auto-generated method stub
		List<Roles> roleList = new ArrayList<Roles>();
		roleList = sessionFactory.getCurrentSession()
								 .createQuery("from Roles r where r.user = :user")
								 .setParameter("user", user)
								 .list();
		return roleList;
	}

	@Override
	public void addRoles(Roles role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(role);
	}
	
	@Override
	public boolean isUserNameAvalable(String username) {	
		if(getUser(username) != null)
			return false;
		else
			return true;
	}

}

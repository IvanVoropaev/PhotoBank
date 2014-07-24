package com.photo.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.photo.bank.entity.Albums;
import com.photo.bank.entity.Photos;
import com.photo.bank.entity.Users;


@Repository
public class HibernatePhotoBankDAO implements PhotoBankDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
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

}

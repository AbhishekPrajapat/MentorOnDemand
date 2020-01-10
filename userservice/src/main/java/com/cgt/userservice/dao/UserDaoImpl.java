package com.cgt.userservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.userservice.dto.UserProfile;
import com.cgt.userservice.entity.User;
import com.cgt.userservice.facade.UserDao;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entity;
	
	@Override
	public User validUser(String username, String password) {
		// TODO Auto-generated method stub
		User user=null;
		String hql = "From User u where u.username = '"+username +"' and u.password = '"+password + "' and u.isactive = "+1;
		try {
			user=(User)this.entity.createQuery(hql).getSingleResult();	
		} catch (Exception e) {
			return null;
		}
		
		return user;
		
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		this.entity.persist(user);
		return true;
	}

	@Override
	public User getUser(Integer id) {
		return this.entity.find(User.class,id);
	}

	@Override
	public boolean blockUser(Integer id) {
		User user = this.entity.find(User.class,id);
		user.setIsactive(0);
		this.entity.flush();
		return true;
	}

	@Override
	public boolean unblockUser(Integer id) {
		User user = this.entity.find(User.class,id);
		user.setIsactive(1);
		this.entity.flush();
		return true;
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = this.entity.createQuery("From User").getResultList();
		return userList;
	}

	@Override
	public boolean updateProfile(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User editProfile(Integer id) {
		User user=null;
		try {
			 user = this.entity.find(User.class,id);
		}catch(Exception ex) {
			user=null;
		}
			return user;
	}

	@Override
	public boolean updateMentorProfile(UserProfile user) {
		User updateuser = this.entity.find(User.class,user.getId());
		updateuser.setFirst_name(user.getFirst_name());
		updateuser.setLast_name(user.getLast_name());
		updateuser.setLinkedin_url(user.getLinkedin_url());
		updateuser.setContact(user.getContact());
		updateuser.setYear_of_exp(user.getYear_of_exp());
		this.entity.flush();
		return true;
	}

}

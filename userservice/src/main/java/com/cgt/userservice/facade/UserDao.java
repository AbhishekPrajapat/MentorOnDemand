package com.cgt.userservice.facade;

import java.util.List;

import com.cgt.userservice.dto.UserProfile;
import com.cgt.userservice.entity.User;

public interface UserDao {
	
	public User validUser(String username,String password);
	public boolean addUser(User user);
	public User getUser(Integer id);
	public boolean blockUser(Integer id);
	public boolean unblockUser(Integer id);
	public List<User> getAllUser();
	public boolean updateProfile(User user);
	public User editProfile(Integer id);
	public boolean updateMentorProfile(UserProfile user);
}

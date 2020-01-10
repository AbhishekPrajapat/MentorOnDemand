package com.cgt.userservice.facade;

import java.util.List;

import com.cgt.userservice.dto.UserDto;
import com.cgt.userservice.dto.UserProfile;
import com.cgt.userservice.entity.User;

public interface UserService {
	public UserDto validUser(String username,String password);
	public boolean addUser(User user);
	public UserDto getUser(Integer id);
	public boolean blockUser(Integer id);
	public boolean unblockUser(Integer id);
	public List<UserDto> getAllUser();
	public boolean updateProfile(User user);
	public UserProfile editProfile(Integer id);
	public boolean updateMentorProfile(UserProfile user);
}

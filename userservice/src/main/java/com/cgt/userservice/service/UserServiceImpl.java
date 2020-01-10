package com.cgt.userservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgt.userservice.dto.UserDto;
import com.cgt.userservice.dto.UserProfile;
import com.cgt.userservice.entity.User;
import com.cgt.userservice.facade.UserDao;
import com.cgt.userservice.facade.UserService;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto validUser(String username, String password) {
		// TODO Auto-generated method stub
		UserDto userDto = null;
		User user = this.userDao.validUser(username, password);
		if(user!=null) {
			userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getFirst_name() + " " + user.getLast_name());
			userDto.setLinkedin_url(user.getLinkedin_url());
			userDto.setYear_of_exp(user.getYear_of_exp());
			userDto.setRole_id(user.getRole_id());
		}
		return userDto;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.addUser(user);
	}

	@Override
	public UserDto getUser(Integer id) {
		// TODO Auto-generated method stub
		User user = this.userDao.getUser(id);
		UserDto userDto = null;
		if(user!=null) {
			userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getFirst_name() + " " + user.getLast_name());
			userDto.setLinkedin_url(user.getLinkedin_url());
			userDto.setYear_of_exp(user.getYear_of_exp());
		}
		return userDto;

	}

	@Override
	public boolean blockUser(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.blockUser(id);
	}

	@Override
	public boolean unblockUser(Integer id) {
		return this.userDao.unblockUser(id);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user = this.userDao.getAllUser();
		return user.stream().map(filteruser->{
			UserDto userdto = new UserDto();
			userdto.setId(filteruser.getId());
			userdto.setName(filteruser.getFirst_name()+" " + filteruser.getLast_name());
			userdto.setRole_id(filteruser.getRole_id());
			userdto.setYear_of_exp(filteruser.getYear_of_exp());
			userdto.setLinkedin_url(filteruser.getLinkedin_url());
			return userdto;
		}
		).collect(Collectors.toList());
	}

	@Override
	public boolean updateProfile(User user) {
		
		return false;
	}

	@Override
	public UserProfile editProfile(Integer id) {
		User user = this.userDao.editProfile(id);
		if(user == null)
			return null;
		UserProfile profile = new UserProfile(user.getId(), user.getFirst_name(), user.getLast_name(), 
				user.getContact(), user.getLinkedin_url(), user.getYear_of_exp());
		return profile;
	}

	@Override
	public boolean updateMentorProfile(UserProfile user) {
		return this.userDao.updateMentorProfile(user);
	}

}

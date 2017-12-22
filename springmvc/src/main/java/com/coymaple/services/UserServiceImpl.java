package com.coymaple.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coymaple.dao.iface.UserDao;
import com.coymaple.domain.User;
import com.coymaple.domain.UserDetails;
import com.coymaple.domain.UserForm;
import com.coymaple.services.iface.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public boolean checkUser(String userName, String password) {
		boolean flag = false;
		int result = 0;
		User user = new User(userName,password);
		result = userDao.queryUserByNameAndPassword(user);
		if(result == 1) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean addUser(User user, UserDetails ud) {
		boolean flag = false;
		int rownumber1 = userDao.insertUser(user);
		int rownumber2 = userDao.insertUserDetails(ud);
		if(rownumber1==1 && rownumber2==1) {
			flag = true;
		}
		return flag;
	}
	
	public boolean addUser2(User user,UserDetails ud) {
		boolean flag = false;
		int userId = userDao.insertUser(user);
		int rowNum = userDao.insertUserDetails(ud);
		if(userId !=0 && rowNum==1) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<UserForm> showUser() {
		List<UserForm> list = userDao.queryUserAll();
		return list;
	}

}

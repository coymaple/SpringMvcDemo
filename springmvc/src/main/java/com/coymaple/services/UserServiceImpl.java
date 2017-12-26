package com.coymaple.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coymaple.dao.iface.HobbyDao;
import com.coymaple.dao.iface.UserDao;
import com.coymaple.domain.Hobby;
import com.coymaple.domain.Page;
import com.coymaple.domain.User;
import com.coymaple.domain.UserDetails;
import com.coymaple.domain.UserForm;
import com.coymaple.services.iface.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	@Resource
	private HobbyDao hobbyDao;
	
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
	
	public void replaceHobbyName(List<UserForm> list) {
		List<Hobby> hobbys = hobbyDao.getAllHobby();
		for(Hobby hobby:hobbys) {
			for(UserForm uf:list) {
				String hobbyStr = uf.getHobby();
				if(hobbyStr != null && hobbyStr.indexOf(String.valueOf(hobby.getCode()))!=-1) {
					String newHobbyStr = hobbyStr.replace(String.valueOf(hobby.getCode()), hobby.getName());
					uf.setHobby(newHobbyStr);
				}
			}
		}
	}

	@Override
	public List<UserForm> showUser() {
		List<UserForm> list = userDao.queryUserAll();
		this.replaceHobbyName(list);
		return list;
	}

	@Override
	public void showUserForPage(Page<UserForm> page,String keyword) {
		userDao.queryUserForPage(page, keyword);;
		this.replaceHobbyName(page.getPageList());
	}

}

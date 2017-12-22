package com.coymaple.dao.iface;

import java.util.List;

import com.coymaple.domain.User;
import com.coymaple.domain.UserDetails;
import com.coymaple.domain.UserForm;

public interface UserDao {
	public int queryUserByNameAndPassword(User user);
	public int insertUser(User user);
	public int insertUserDetails(UserDetails ud);
	
	public List<UserForm> queryUserAll();
}

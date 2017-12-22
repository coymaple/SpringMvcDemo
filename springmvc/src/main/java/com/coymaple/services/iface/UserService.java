package com.coymaple.services.iface;

import java.util.List;

import com.coymaple.domain.User;
import com.coymaple.domain.UserDetails;
import com.coymaple.domain.UserForm;

public interface UserService {

	public boolean checkUser(String userName,String password);
	public boolean addUser(User user,UserDetails ud);
	
	public List<UserForm> showUser();
}

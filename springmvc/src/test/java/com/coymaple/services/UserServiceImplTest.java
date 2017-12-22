package com.coymaple.services;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coymaple.services.iface.UserService;
import com.coymaple.spring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class UserServiceImplTest {

//	private static Logger log = Logger.getLogger(UserServiceImplTest.class);
	
	@Resource
	UserService userService;
	
	@Test
	public void checkUserTest() {
//		log.debug(userService.checkUser("admin", "admin"));
//		System.out.println(userService.checkUser("admin", "admin"));
		System.out.println(userService.checkUser("admin", "test"));
	}
}

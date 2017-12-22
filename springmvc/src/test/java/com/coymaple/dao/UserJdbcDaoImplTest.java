package com.coymaple.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coymaple.dao.iface.UserDao;
import com.coymaple.domain.User;
import com.coymaple.spring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class UserJdbcDaoImplTest {

	@Resource
	UserDao userDao;
	
	private Logger log = Logger.getLogger(getClass());
	
	
	@Test 
	public void queryUserByNameAndPwdTest() {
		User user = new User("admin","admin");
		int result = userDao.queryUserByNameAndPassword(user);
//		System.out.println(result);
//		log.debug(userDao);
	}
}

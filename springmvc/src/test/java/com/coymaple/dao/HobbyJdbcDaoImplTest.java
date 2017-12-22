package com.coymaple.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coymaple.dao.iface.HobbyDao;
import com.coymaple.domain.Hobby;
import com.coymaple.spring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class HobbyJdbcDaoImplTest {

	@Resource
	private HobbyDao hobbyDao ;
	
	@Test
	public void testGetAllHobby() {
		List<Hobby> list = hobbyDao.getAllHobby();
		for(Hobby hobby:list) {
			System.out.println(hobby.getCode() + " , " +hobby.getName());
		}
	}
}

package com.coymaple.spring.config;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class AppConfigTest {

	@Resource
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void jdbcTemplateTest() {
		String sql = "select ename from emp";
		List<String> list =jdbcTemplate.queryForList(sql, String.class);
		for(String str:list) {
			System.out.println(str);
		}
	}
}

package com.coymaple.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.coymaple.spring.config.AppConfig;
import com.coymaple.spring.config.MvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class,MvcConfig.class})
@WebAppConfiguration("src/main/webapp")
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext was;
	
	@Autowired
	MockHttpServletRequest request;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.was).build();
	}
	
	@Test
	public void userNameCheckTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/userLogin").param("userName", "admin").param("password", "admin")) //请求模拟
			.andDo(print())   //打印
			.andExpect(MockMvcResultMatchers.status().isOk()) //断言
			.andExpect(MockMvcResultMatchers.view().name("views/main"));
	}
}

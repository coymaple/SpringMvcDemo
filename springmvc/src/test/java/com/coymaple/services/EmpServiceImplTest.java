package com.coymaple.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.coymaple.domain.Emp;
import com.coymaple.services.iface.EmpService;
import com.coymaple.spring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
public class EmpServiceImplTest {
	
	@Resource
	EmpService empService;
	
	private Logger log = Logger.getLogger(EmpServiceImplTest.class);
	
	@Test
	public void insertEmpTest() {
		Emp emp = new Emp(9874,"Coymaple","SALSEMAN",7902,LocalDate.now(),new BigDecimal(200.50),new BigDecimal(100),10);
		boolean flag = empService.insertEmp(emp);
		log.debug("Test value..." + flag);
	}
}

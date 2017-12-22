package com.coymaple.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coymaple.dao.iface.EmpDao;
import com.coymaple.domain.Emp;
import com.coymaple.spring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class EmpDaoImplTest {
	
	@Resource
	EmpDao empDao;
//	@Test
	public void queryAllTest() {
		List<Emp> list = empDao.queryAll();
		for(Emp emp:list) {
			System.out.println("name:"+emp.getEname());
		}
	}
	
	@Test
	public void insertEmpTesst() {
		Emp emp = new Emp(7936,"Coymaple","MANAGER",7902,LocalDate.now(),new BigDecimal(1000.2),new BigDecimal(800),20);
		boolean flag = empDao.insertEmp(emp);
		if(flag) {
			System.out.println("插入一条记录成功");
		}
	}
	
	@Test
	public void queryByNameTest() {
		List<Emp> list = empDao.queryByName("SMITH");
		for(Emp emp:list) {
			System.out.println("name:"+emp.getEname());
		}
	}
	
	@Test
	public void updateEmpTest() {
		Emp emp = new Emp(7936,"coymaple","MANAGER",7902,LocalDate.now(),new BigDecimal(1500.9),new BigDecimal(300),20);
		boolean flag = empDao.updateEmp(emp, 7936);
		if(flag) {
			System.out.println("修改成功！！！");
		}
	}
}

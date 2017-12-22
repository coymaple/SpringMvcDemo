package com.coymaple.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coymaple.dao.iface.NativePlaceDao;
import com.coymaple.domain.NativePlace;
import com.coymaple.spring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class NativePlaceDaoImplTest {
	
	@Resource
	private NativePlaceDao nativePlaceDao;
	
//	@Test
	public void getProvinceTest() {
		List<NativePlace> list = nativePlaceDao.getProvinces();
		for(NativePlace province:list) {
			System.out.println(province.getName()+" : "+province.getCode());
		}
	}
	
	@Test
	public void getCitiesTest() {
		List<NativePlace> list = nativePlaceDao.getCities("01");
		for(NativePlace city:list) {
			System.out.println(city.getName() + " : " + city.getCode());
		}
	}

}

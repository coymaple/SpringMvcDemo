package com.coymaple.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coymaple.dao.iface.HobbyDao;
import com.coymaple.domain.Hobby;
import com.coymaple.services.iface.HobbyService;
@Service
public class HobbyServiceImpl implements HobbyService{

	@Resource
	private HobbyDao hobbyDao;
	
	@Override
	public List<Hobby> hobbyShow() {
		return hobbyDao.getAllHobby();
	}

}

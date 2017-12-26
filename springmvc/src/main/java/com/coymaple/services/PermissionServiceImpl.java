package com.coymaple.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coymaple.dao.iface.PermissionDao;
import com.coymaple.domain.Permission;
import com.coymaple.services.iface.PermissionService;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public List<Permission> showPerssion() {
		return permissionDao.getAllPermission();
	}

}

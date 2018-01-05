package com.coymaple.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coymaple.dao.iface.PermissionDao;
import com.coymaple.domain.Permission;

@Repository
public class PermissionJdbcDaoImpl implements PermissionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Permission> getAllPermission() {
		String sql = "select * from permission";
		List<Permission> list = jdbcTemplate.query(sql, (rs,index)->
			new Permission(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5))
		);
		return list;
	}

}

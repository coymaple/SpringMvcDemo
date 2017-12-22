package com.coymaple.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coymaple.dao.iface.HobbyDao;
import com.coymaple.domain.Hobby;

@Repository
public class HobbyJdbcDaoImpl implements HobbyDao{
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Hobby> getAllHobby() {
		String sql = "select * from hobby";
		List<Hobby> list = jdbcTemplate.query(sql, (rs,index)->{
			return new Hobby(rs.getInt(1),rs.getString(2),rs.getInt(3));
		});
		return list;
	}
}


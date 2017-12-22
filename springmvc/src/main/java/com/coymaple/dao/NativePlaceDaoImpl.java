package com.coymaple.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coymaple.dao.iface.NativePlaceDao;
import com.coymaple.domain.NativePlace;

@Repository
public class NativePlaceDaoImpl implements NativePlaceDao{
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<NativePlace> getProvinces() {
		String sql = "select * from nativePlace where code=substr(code,0,2) ";
		List<NativePlace> list = jdbcTemplate.query(sql, (rs,index)->{
			return new NativePlace(rs.getInt(1),rs.getString(2),rs.getString(3));
		});
		return list;
	}

	@Override
	public List<NativePlace> getCities(String code) {
		String sql = "select * from nativePlace where substr(code,0,2) = ? and length(code)=4";
		List<NativePlace> list = jdbcTemplate.query(sql, (rs,index)->
			new NativePlace(rs.getInt(1),rs.getString(2),rs.getString(3))
		,new Object[] {code});
		return list;
	}
	
	@Override
	public List<NativePlace> getCities() {
		String sql = "select * from nativePlace where length(code)=4";
		List<NativePlace> list = jdbcTemplate.query(sql, (rs,index)->
			new NativePlace(rs.getInt(1),rs.getString(2),rs.getString(3))
		);
		return list;
	}


}

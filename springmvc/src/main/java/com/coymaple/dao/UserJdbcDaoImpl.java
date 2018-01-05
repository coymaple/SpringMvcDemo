package com.coymaple.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.coymaple.dao.iface.UserDao;
import com.coymaple.domain.Page;
import com.coymaple.domain.User;
import com.coymaple.domain.UserDetails;
import com.coymaple.domain.UserForm;

@Repository
public class UserJdbcDaoImpl implements UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int queryUserByNameAndPassword(User user) {
		int rowNumber = 0;
		String sql = "select count(*) from users where name=? and password=?";
		rowNumber = jdbcTemplate.queryForObject(sql, Integer.class,
				new Object[] { user.getUserName(), user.getPassword() });
		return rowNumber;
	}

	@Override
	public int insertUser(User user) {
		int rowNumber = 0;
		
		String sql = "insert into users values(users_id.nextval,?,?,?,?)";
		rowNumber = jdbcTemplate.update(sql,
				new Object[] { user.getUserName(), user.getPassword(), user.getSex(), user.getEmail() });
		return rowNumber;
	}
	
	public int insertUser2(User user) {
		int rowNumber = 0;
		int userId = 0;
		String sql = "insert into users values(users_id.nextval,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		rowNumber = jdbcTemplate.update((conn)->{
			PreparedStatement pstmt = conn.prepareStatement(sql,new String[] {"id"});
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getEmail());
			return pstmt;
		}, keyHolder);
		userId = keyHolder.getKey().intValue();
		if(rowNumber == 1) {
			return userId;
		}
		return 0;
	}

	@Override
	public int insertUserDetails(UserDetails ud) {
		int rowNumber = 0;
		String sql = "insert into userDetails values(userDetails_id.nextval,?,?)";
		rowNumber = jdbcTemplate.update(sql, new Object[] { ud.getNativePlaceCode(), ud.getHobbyCode() });
		return rowNumber;
	}

	@Override
	public List<UserForm> queryUserAll() {
		List<UserForm> list = new ArrayList<>();
		String sql = "select u.id,u.name,u.password,u.sex,u.email,np.name,ud.hobby_code from users u  left outer join UserDetails ud on u.id=ud.id " + 
				"left outer join nativePlace np on ud.nativePlace_code=np.code";
		list = jdbcTemplate.query(sql, (rs,index)->
			new UserForm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7))
		);
		return list;
	}

	//数据库数据分页
	@Override
	public void queryUserForPage(Page<UserForm> page, String keyword) {
		List<UserForm> list = new ArrayList<>();
		Object[] params = null;
		StringBuffer sqlBuf = new StringBuffer("");
		sqlBuf.append("select * from (select bt.*,rowNum rn from ( ");
		sqlBuf.append("select u.id id,u.name name,u.password password,u.sex sex,u.email email,np.name nativePlaceName,ud.hobby_code hobbyCode from users u  left outer join UserDetails ud on u.id=ud.id ");
		if("".equals(keyword)) {
			sqlBuf.append("left outer join nativePlace np on ud.nativePlace_code=np.code order by u.id");
			params = new Object[] {page.getCurrentPage(),page.getRowNumber(),page.getCurrentPage(),page.getRowNumber()};
		}else {
			sqlBuf.append("left outer join nativePlace np on ud.nativePlace_code=np.code where u.name like ? order by u.id ");
			params = new Object[] {"%"+keyword+"%",page.getCurrentPage(),page.getRowNumber(),page.getCurrentPage(),page.getRowNumber()};
		}
		sqlBuf.append(" ) bt where rowNum<=(?)*?) mt where rn>(?-1)*?");
		list = jdbcTemplate.query(sqlBuf.toString(),(rs,index)->
			new UserForm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7))	
		,params);
		page.setPageList(list);
	}

}

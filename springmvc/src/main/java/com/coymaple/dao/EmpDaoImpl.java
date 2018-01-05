package com.coymaple.dao;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coymaple.dao.iface.EmpDao;
import com.coymaple.domain.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{

	@Resource
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Emp> queryAll() {
		String sql = "select * from emp";
		List<Emp> list = jdbcTemplate.query(sql, (rs,index)->{
			return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5).toLocalDate(),rs.getBigDecimal(6),rs.getBigDecimal(7),rs.getInt(8));
		});
		return list;
	}

	@Override
	public List<Emp> queryByName(String name) {
		String sql = "select * from emp where ename like ?";
		List<Emp> list = jdbcTemplate.query(sql, (rs,index)->
			new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5).toLocalDate(),rs.getBigDecimal(6),rs.getBigDecimal(7),rs.getInt(8))
		,new Object[] {"%"+name+"%"});
		return list;		
	}

	@Override
	public boolean updateEmp(Emp emp,int empno) {
		boolean flag = false;
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
		int rowNumber = jdbcTemplate.update(sql,new Object[] {emp.getEname(),emp.getJob(),emp.getMgr(),Date.valueOf(emp.getHiredate()),emp.getSal(),emp.getComm(),emp.getDeptno(),empno});
		if(rowNumber == 1) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteEmp(String name,Emp emp) {
		return false;
	}

	@Override
	public boolean insertEmp(Emp emp) {
		boolean flag = false;
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		Object[] emp_insert = new Object[] {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),Date.valueOf(emp.getHiredate()),emp.getSal(),emp.getComm(),emp.getDeptno()};
		int rowNumber = jdbcTemplate.update(sql, emp_insert);
		if(rowNumber == 1) {
			flag = true;
		}
		return  flag;
		
	}
	
}

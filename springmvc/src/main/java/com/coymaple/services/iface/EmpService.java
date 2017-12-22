package com.coymaple.services.iface;

import java.util.List;

import com.coymaple.domain.Emp;

public interface EmpService {

	public List<Emp> queryAll();
	public List<Emp> queryByName(String name);
	public boolean updateEmp(Emp emp,int empno);
	public boolean deleteEmp(String name,Emp emp);
	public boolean insertEmp(Emp emp);
}

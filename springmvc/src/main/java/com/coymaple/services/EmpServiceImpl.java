package com.coymaple.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coymaple.dao.iface.EmpDao;
import com.coymaple.domain.Emp;
import com.coymaple.services.iface.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Resource
	EmpDao empDao;
	
	@Override
	public List<Emp> queryAll() {
		List<Emp> list = empDao.queryAll();
		return list;
	}

	@Override
	public List<Emp> queryByName(String name) {

		return null;
	}

	@Override
	public boolean updateEmp(Emp emp, int empno) {

		return false;
	}

	@Override
	public boolean deleteEmp(String name, Emp emp) {

		return false;
	}

	@Override
	public boolean insertEmp(Emp emp) {
		return empDao.insertEmp(emp);
	}

}

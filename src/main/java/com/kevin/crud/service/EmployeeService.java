package com.kevin.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.crud.bean.Employee;
import com.kevin.crud.dao.EmployeeMapper;

/**
 * @author kevin
 * @version 创建时间: 2018年2月8日下午4:49:19
 * @ClassName 类名称
 * @Description 类描述
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	/**
	 * 分页查询所有员工
	 * @return
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

}

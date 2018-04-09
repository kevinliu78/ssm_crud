package com.kevin.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kevin.crud.bean.Employee;
import com.kevin.crud.bean.Msg;
import com.kevin.crud.service.EmployeeService;

/**
 * @author kevin
 * @version 创建时间: 2018年2月8日下午3:58:35
 * @ClassName EmployeeController
 * @Description 处理员工的CRUD请求 
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageSize",defaultValue="5")Integer pageSize){
		PageHelper.startPage(pn, pageSize);
		//startPage后面紧跟的查询就是分页查询去去去
		List<Employee> emps = employeeService.getAll();
		PageInfo<Employee> info = new PageInfo<Employee>(emps,5);
		return Msg.success().add("pageInfo", info);
	}
	
	/**
	 * 查询员工列表（分页查询）
	 * @return
	 */
//	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="pageSize",defaultValue="5")Integer pageSize,Model model) {
		//这不是一个分页查询，需要引入PageHelper分页插件
		//在查询之前只需要调用并传入当前页码以及每页大小
		PageHelper.startPage(pn, pageSize);
		//startPage后面紧跟的查询就是分页查询
		List<Employee> emps = employeeService.getAll();
		PageInfo<Employee> info = new PageInfo<Employee>(emps,5);
		model.addAttribute("pageInfo", info);
		return "list";
	}
	
}

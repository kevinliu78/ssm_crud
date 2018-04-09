package com.kevin.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.kevin.crud.bean.Employee;

/**
 * @author kevin
 * @version 创建时间: 2018年3月20日上午10:04:09
 * @ClassName 类名称
 * @Description 类描述
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
	
	//传入Springmvc的ioc
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求，获取到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "2")).andReturn();
		
		PageInfo<Employee> pi = (PageInfo<Employee>) result.getRequest().getAttribute("pageInfo");
		System.out.println("获取当前页码:"+pi.getPageNum());
		System.out.println("获取总页码:"+pi.getPages());
		System.out.println("获取总条数:"+pi.getTotal());
		System.out.println("获取连续页码数:");
		int[] nums = pi.getNavigatepageNums();
		System.out.println("size="+nums.length);
		for (int i : nums) {
			System.out.print(" "+i);
		}
		System.out.println();
		List<Employee> list = pi.getList();
		for (Employee e : list) {
			System.out.println("ID:"+e.getEmpId()+"==>name:"+e.getEmpName());
		}
	}
}

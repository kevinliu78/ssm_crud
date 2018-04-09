package com.kevin.crud.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * mybatis逆向工程生成bean以及dao、mapper相关文件
 * @author kevin
 * @version 创建时间: 2018年1月12日下午3:08:26
 */
public class MGBTest {
	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File("mbg.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.example.springBootDemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springBootDemo.entity.Criteria;
import com.example.springBootDemo.entity.UserInfo;
import com.example.springBootDemo.service.UserInfoService;

/**
 * spring boot 单元测试
 * @author	chdaba
 * @version	1.0.0
 * @date	2018年12月27日 下午5:04:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void contextLoads() {
	}
	
	/**
	 * mysql
	 */
	@Test
	public void test1() {
		Criteria criteria = new Criteria();
		//criteria.setMysqlOffset(0);
		//criteria.setMysqlLength(5);
		List<UserInfo> list = userInfoService.selectByExample(criteria);
		System.err.println(list);
	}
	
	/**
	 * oracle
	 */
	@Test
	public void test2() {
		Criteria criteria = new Criteria();
		criteria.setOracleStart(0);
		criteria.setOracleEnd(5);
		List<UserInfo> list = userInfoService.selectByExample(criteria);
		System.err.println(list);
	}
	

}


package com.example.springBootDemo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springBootDemo.entity.Criteria;
import com.example.springBootDemo.entity.UserInfo;
import com.example.springBootDemo.service.UserInfoService;
import com.example.springBootDemo.util.ResultMap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Spring-boot + MyBatis
 * @author	chdaba
 * @version 1.0.0
 * @date	2018年12月11日
 */
@Controller
@RequestMapping("/user")
@Api(description="用户信息模块")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 用户模块主页
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ApiOperation(value="用户主页")
	public String index() {
		return "user/index.html";
	}
	
	
	/**
	 * 获取单个用户详细信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/get", method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取单个用户信息", notes="notes:根据UserId查询用户信息")
	@ApiImplicitParam(name = "userId", value = "用户主键", required = true, dataType = "int")
	public Object get(
			@RequestParam(name="userId", defaultValue="-1") Integer userId
			) {
		UserInfo userInfo = userInfoService.selectByPrimaryKey(userId);
		return ResultMap.success(userInfo);
	}
	
	
	/**
	 * list page<mysql>
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取用户列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNumber", dataType = "int"),
		@ApiImplicitParam(name = "pageSize", dataType = "int")
	})
	public Object list(
			@RequestParam(name="pageNumber", defaultValue="1")Integer pageNumber,
			@RequestParam(name="pageSize", defaultValue="20")Integer pageSize
			) {
		Criteria criteria = new Criteria();
		//criteria.setMysqlOffset((pageNumber-1)*pageSize);
		//criteria.setMysqlLength(pageSize);
		List<UserInfo> list = userInfoService.selectByExample(criteria);
		return ResultMap.success(list);
	}
	
	
	/**
	 * list page<oracle>
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/list2", method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="获取用户列表-oracle")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNumber", dataType = "int"),
		@ApiImplicitParam(name = "pageSize", dataType = "int")
	})
	public Object list2(
			@RequestParam(name="pageNumber", defaultValue="1")Integer pageNumber,
			@RequestParam(name="pageSize", defaultValue="20")Integer pageSize
			) {
		Criteria criteria = new Criteria();
		criteria.setOracleStart((pageNumber-1)*pageSize);
		criteria.setOracleEnd(pageNumber*pageSize);
		List<UserInfo> list = userInfoService.selectByExample(criteria);
		return ResultMap.success(list);
	}
	
	
}

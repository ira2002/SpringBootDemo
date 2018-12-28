package com.example.springBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
  *  首页控制器
 * @author	chdaba
 * @version	1.0.0
 * @date	2018年12月24日 下午3:28:50
 */
@Controller
@RequestMapping("/")
@Api(description="主页模块")
public class HomeController {
	
	@ApiOperation("首页")
	@RequestMapping(value={"/", "index", "home"}, method=RequestMethod.GET)
	public String home() {
		return "index.html";
	}
	
}

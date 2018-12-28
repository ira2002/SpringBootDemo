package com.example.springBootDemo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * JSON返回
 * @author	chdaba
 * @version	1.0.0
 * @date	2018年12月24日 下午5:09:41
 */
public class ResultMap {
	
	public static Map<String, Object> common(String code, String message, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("message", message);
		map.put("data", data);
		return map;
	}
	
	public static Map<String, Object> success(Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "0");
		map.put("message", "success");
		map.put("data", data);
		return map;
	}
	
	public static Map<String, Object> error(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "1");
		map.put("message", message);
		map.put("data", null);
		return map;
	}
	
	
	
	
}

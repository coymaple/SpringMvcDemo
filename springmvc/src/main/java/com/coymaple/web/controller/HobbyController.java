package com.coymaple.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.coymaple.domain.Hobby;
import com.coymaple.services.iface.HobbyService;

@Controller
public class HobbyController {
	
	//使用 @ResponseBody 前的方法见下面的网址
	//https://github.com/coymaple/SpringMvcDemo/blob/master2/README.md
	
	@Resource
	private HobbyService hobbyService;
	
	@ResponseBody
	@RequestMapping(value="/hobbyInit")
//	@RequestMapping(value="/hobbyInit",produces="application/json;charset=utf-8")
	public Map<String,Object> initHobby(HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Hobby> list=hobbyService.hobbyShow();
		if(list.size()!=0) {
			map.put("result", "success");
			map.put("list",list);
		}
		return map;
	}
	
}

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
	
	@Resource
	private HobbyService hobbyService;
	
	//使用servlet 的out对象往前端发送数据
//	@RequestMapping(value="hobbyInit")
//	public void initHobby(HttpServletResponse response) {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charest=utf-8");
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<Hobby> list = hobbyService.hobbyShow();
//		if(list.size() != 0) {
//			map.put("result", "success");
//			map.put("list", list);
//		}
//		PrintWriter out = null;
//		try {
//			out = response.getWriter();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		String jsonString = JSON.toJSONString(map);
//		System.out.println(jsonString);
//		out.println(jsonString);
//		out.flush();
//		out.close();
//	}
	
	
//	//使用ResponseBody
//	@RequestMapping(value="hobbyInit")
//	@ResponseBody
//	public String initHobby2(HttpServletResponse response) {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charest=utf-8");
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<Hobby> list = hobbyService.hobbyShow();
//		if(list.size() != 0) {
//			map.put("result", "success");
//			map.put("list", list);
//		}else {
//			map.put("result", "fail");
//		}
//		String jsonString = JSON.toJSONString(map);
//		return jsonString;
//	}
	
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

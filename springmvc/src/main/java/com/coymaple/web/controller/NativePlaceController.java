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
import com.coymaple.dao.iface.NativePlaceDao;
import com.coymaple.domain.NativePlace;

@Controller
public class NativePlaceController {

	@Resource
	private NativePlaceDao nativePlaceDao;
	
	@RequestMapping(value="/npInit")
	public void initProvince(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charest=utf-8");
		Map<String,Object> map = new HashMap<String,Object>();
		List<NativePlace> list = nativePlaceDao.getProvinces();
		if(list.size() != 0) {
			map.put("result", "success");
			map.put("list", list);
		}else {
			map.put("result", "fail");
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		out.println(jsonString);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="/npCity")
	public void initCity(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charest=utf-8");
		Map<String,Object> map = new HashMap<String,Object>();
		List<NativePlace> list = nativePlaceDao.getCities();
		if(list.size() != 0) {
			map.put("result", "success");
			map.put("list", list);
		}else {
			map.put("result", "fail");
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		out.println(jsonString);
		out.flush();
		out.close();
	}
	
//	@ResponseBody
//	@RequestMapping(value="/npInit")
//	public Map<String,Object> initProvince(HttpServletResponse response){
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charest=utf-8");
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<NativePlace> list = nativePlaceDao.getProvinces();
//		if(list.size() != 0) {
//			map.put("result", "success");
//			map.put("list", list);
//		}else {
//			map.put("result", "fail");
//		}
//		return map;
//	}
	
	
}

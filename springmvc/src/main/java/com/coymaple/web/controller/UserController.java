package com.coymaple.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coymaple.dao.iface.PageDao;
import com.coymaple.domain.Page;
import com.coymaple.domain.Permission;
import com.coymaple.domain.User;
import com.coymaple.domain.UserDetails;
import com.coymaple.domain.UserForm;
import com.coymaple.services.iface.PermissionService;
import com.coymaple.services.iface.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private PageDao pageDao;
	

//	@RequestMapping("/userLogin")
//	public String userNameCheck(HttpServletRequest request) {
//		String forward="index";
//		String userName = null == request.getParameter("userName")?"":request.getParameter("userName");
//		String password = null == request.getParameter("password")?"":request.getParameter("password");
//		if("admin".equals(userName)&&"admin".equals(password)) {
//			forward = "views/main";
//		}
//		return forward;
//	}
	
//	@RequestMapping("/userLogin")
//	public String userNameCheck(HttpServletRequest request) {
//		String forward="index";
//		String userName = null == request.getParameter("userName")?"":request.getParameter("userName");
//		String password = null == request.getParameter("password")?"":request.getParameter("password");
//		if(userService.checkUser(userName, password)) {
//			forward = "views/main";
//		}
//		return forward;
//	}
	
	//用 @RequestParam 注解得到表单内容的值。
	@RequestMapping("/userLogin")
	public ModelAndView userNameCheck(@RequestParam String userName,@RequestParam String password, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		if(userService.checkUser(userName, password)) {
			request.getSession().setAttribute("user", userName);
			mav.addObject("permissions", permissionService.showPerssion());
//			for(Permission per:permissionService.showPerssion()){
//				System.out.println(per.getUrl());
//			}
			mav.setViewName("views/main");
		}else {
			mav.addObject("message","用户名或密码错误");
		}
		return mav;
	}
	
	@RequestMapping("/userReg")
	public ModelAndView userRegesitory(HttpServletRequest request) {
		String userName=null==request.getParameter("userName")?"":request.getParameter("userName");
		String password=null==request.getParameter("password")?"":request.getParameter("password");
		String sex=null==request.getParameter("sex")?"":request.getParameter("sex");
		String city=null==request.getParameter("city")?"":request.getParameter("city");
		String email=null==request.getParameter("email")?"":request.getParameter("email");
		String[] hobby =null==request.getParameterValues("hobby")?new String[] {}:request.getParameterValues("hobby");
		
		ModelAndView mav = new ModelAndView("login");
		
		String hobbyString = "";
		if(hobby.length != 0) {
			for(int i=0,len=hobby.length;i<len;i++) {
				if(!hobbyString.equals("")) {
					hobbyString += ",";
				}
				hobbyString += hobby[i];
			}
		}
		User user = new User(userName,password,sex,email);
		UserDetails ud = new UserDetails(city,hobbyString);
		if(userService.addUser(user, ud)) {
			mav.addObject("result","success");
			mav.addObject("message","用户注册成功");
		}else {
			mav.addObject("result","fail");
			mav.addObject("message","用户注册失败");
		}
		return mav;
	}
	
	//未加分页时的操作
//	@RequestMapping("userInit")
//	public ModelAndView userInit(@RequestParam(name="currentPage",defaultValue="1") String currentPage) {
//		ModelAndView mav = new ModelAndView("views/userManager");
//		List<UserForm> list = userService.showUser();
//		System.out.println(list.toString());
//		mav.addObject("list",list);
//		return mav;
//	}
	
	//有分页时的操作
	@RequestMapping("userInit")
	public ModelAndView userInit(@RequestParam(name="currentPage",defaultValue="1") String currentPage,@RequestParam(name="keyword",defaultValue="")String keyword) {
		Page page = new Page();
		pageDao.setTotaoRows(page);
		page.setTotalPage(page.getTotalRows(),page.getRowNumber());
		page.setCurrentPage(Integer.parseInt(currentPage));
		ModelAndView mav = new ModelAndView("views/userManager");
		userService.showUserForPage(page, keyword);
		mav.addObject("page",page);
		return mav;
	}
	
}

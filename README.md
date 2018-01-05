# SpringMvcDemo
SpringMvc的一个练习

该文档用来显示曾经在项目中被用到过但最终被废弃的（即被更加优雅、简洁的代码所代替的）代码。

会在原来有过该废弃代码的地方插入注释——一个指向该页的网址，并指示代码所在的编号。

##### HobbyController.java

```
//使用servlet 的out对象往前端发送数据
@RequestMapping(value="hobbyInit")
public void initHobby(HttpServletResponse response) {
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charest=utf-8");
	Map<String,Object> map = new HashMap<String,Object>();
	List<Hobby> list = hobbyService.hobbyShow();
	if(list.size() != 0) {
		map.put("result", "success");
		map.put("list", list);
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
```

```
//使用ResponseBody
@RequestMapping(value="hobbyInit")
@ResponseBody
public String initHobby2(HttpServletResponse response) {
	response.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charest=utf-8");
	Map<String,Object> map = new HashMap<String,Object>();
	List<Hobby> list = hobbyService.hobbyShow();
	if(list.size() != 0) {
		map.put("result", "success");
		map.put("list", list);
	}else {
		map.put("result", "fail");
	}
	String jsonString = JSON.toJSONString(map);
	return jsonString;
}
```


##### NativePlace.java
```
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
	out.println(jsonString);
	out.flush();
	out.close();
}
```

```
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
	out.println(jsonString);
	out.flush();
	out.close();
}
```

##### UserController.java

```
@RequestMapping("/userLogin")
public String userNameCheck(HttpServletRequest request) {
	String forward="index";
	String userName = null == request.getParameter("userName")?"":request.getParameter("userName");
	String password = null == request.getParameter("password")?"":request.getParameter("password");
	if("admin".equals(userName)&&"admin".equals(password)) {
		forward = "views/main";
	}
	return forward;
}
```

```
@RequestMapping("/userLogin")
public String userNameCheck(HttpServletRequest request) {
	String forward="index";
	String userName = null == request.getParameter("userName")?"":request.getParameter("userName");
	String password = null == request.getParameter("password")?"":request.getParameter("password");
	if(userService.checkUser(userName, password)) {
		forward = "views/main";
	}
	return forward;
}
```

```
//未加分页时的操作
@RequestMapping("userInit")
public ModelAndView userInit(@RequestParam(name="currentPage",defaultValue="1") String currentPage) {
	ModelAndView mav = new ModelAndView("views/userManager");
	List<UserForm> list = userService.showUser();
	System.out.println(list.toString());
	mav.addObject("list",list);
	return mav;
}
```

##### main.jsp
未使用Java标准标签库的 列表 
```
<ul class="ul_level1">
	<li class="li_level1">用户管理模块</li>
	<ul class="ul_level2">
		<li class="li_level2">
		<a href="userInit.mvc" target="mainIframe">用户信息管理</a>
		</li>
		<li class="li_level2">用户权限管理</li>
		<li class="li_level2">用户角色管理</li>
	</ul>
	<li class="li_level1">邮件管理模块</li>
	<ul class="ul_level2">
		<li class="li_level2"><a href="#" target="mainIframe">收邮件</a></li>
		<li class="li_level2">写邮件</li>
		<li class="li_level2">垃圾邮件</li>
	</ul>
</ul>
```

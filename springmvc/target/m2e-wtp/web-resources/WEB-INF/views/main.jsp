<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主页面</title>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>
		<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/simple.css"/>
	</head>
	<body>
		<header>
			<nav id="headerOperation">
				<button class="simpleButton">用户切换</button><button class="simpleButton">退出</button>
			</nav>
		</header>
		<form action="" method="post">
		<article>
			<nav id="navMainMenu">
				<div id="showAndHiddenOperation" class="trans"></div>
				<h1 style="text-align: center;margin-top:5px;">系统主菜单</h1>
				<ul class="ul_level1">
					<li class="li_level1">用户管理模块</li>
					<ul class="ul_level2">
						<li class="li_level2"><a href="userInit.mvc" target="mainIframe">用户信息管理</a></li>
						<li class="li_level2">用户权限管理</li>
						<li class="li_level2">用户角色管理</li>
					</ul>
					<li  class="li_level1">邮件管理模块</li>
					<ul class="ul_level2">
						<li class="li_level2"><a href="#" target="mainIframe">收邮件</a></li>
						<li class="li_level2">写邮件</li>
						<li class="li_level2">垃圾邮件</li>
					</ul>
				</ul>
			</nav>
			<section id="sectionMainPage">
				<iframe name="mainIframe" src="views/welcome.jsp"></iframe>
			</section>
		</article>
		</form>
		<footer>
			<aside style="margin-left:20px;float:left;overflow:hidden;">
			xx管理系统模板，author:<address style="display: inline;"><a href="mailto:54397946@qq.com">yuhf</a></address>
			</aside>
			<nav id="footerShowAndHiddenOperation" class="trans"></nav>
		</footer>
	</body>
</html>

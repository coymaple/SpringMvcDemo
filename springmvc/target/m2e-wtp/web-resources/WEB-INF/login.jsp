<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="./css/base.css"/>
		<link rel="stylesheet" type="text/css" href="./css/login.css"/>
		<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<article>
		<fieldset>
			<legend hidden>用户登录</legend>
			<section id="logo">
				<div id="loginErrorMessage">
					${message}
				</div>
			</section>
			<form action="userLogin.mvc" method="post">
			<section id="userLogin">
				<label for="userName">用户名：</label>
				<input type="text" name="userName" id="userName"><br>
				<label for="password">密&nbsp;码：</label>
				<input type="password" name="password" id="password" value="" /><br>
				<input type="checkbox" name="cookie" id="cookie">
				<label for="cookie">一周之内免登录</label>
				<nav id="loginOperation">
					<button type="button" id="btn_register">注册</button>&nbsp;
					<button type="submit" id="btn_login">登录</button>
				</nav>
			</section>
			</form>
		</fieldset>
		</article>
	</body>
</html>

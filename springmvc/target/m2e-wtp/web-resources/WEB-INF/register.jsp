<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" type="text/css" href="css/register.css"/>
		<script src="js/ajaxUtils.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/register.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<article>
			<header>
				<h1>用户注册</h1>
			</header>
			<section>
				<fieldset id="userRegister">
					<legend hidden>用户注册</legend>
					<form action="userReg.mvc" method="post">
					<table class="registerTable">
						<tbody id="registerTbody">
							<tr>
								<td><label for="userName">用户名：</label></td>
								<td><input type="text" name="userName" id="userName" value="" /></td>
								<td>
									<div id="userNameImage"></div>
									<div id="userNameMessage"></div>
								</td>
							</tr>
							<tr>
								<td><label for="password">密码：</label></td>
								<td><input type="password" name="password" id="password" value="" /></td>
								<td>
									<div id="passwordImage"></div>
									<div id="passwordMessage"></div>
								</td>
							</tr>
							<tr>
								<td><label for="rePassword">重复密码：</label></td>
								<td><input type="password" name="rePassword" id="rePassword" value="" /></td>
								<td>
									<div id="rePasswordImage"></div>
									<div id="rePasswordMessage"></div>
								</td>
							</tr>
							<tr>
								<td>性别：</td>
								<td colspan="2">
									<input type="radio" name="sex" id="man" value="1" />
									<label for="man">男</label>&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="sex" id="woman" value="1" />
									<label for="woman">女</label>
								</td>
							</tr>
							<tr>
								<td>爱好：</td>
								<td colspan="2">
									<div id="hobbyInsertPoint"></div>
								</td>
							</tr>
							<tr>
								<td>来自于：</td>
								<td colspan="2">
									<select id="province">
										<option checked="true" value="00">请选择省份</option>
									</select>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<select id="city" name="city">
										<option checked="true" value="0000">请选择城市</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>email</td>
								<td><input type="text" name="email" id="email"></td>
								<td>
									<div id="emailImage"></div>
									<div id="emailMessage"></div>
								</td>
							</tr>
						</tbody>
					</table>
					<nav id="btnOperation">
						<button type="reset">重置</button>
						<button type="submit">注册</button>
					</nav>
					</form>
				</fieldset>
			</section>
		</article>
	</body>
</html>

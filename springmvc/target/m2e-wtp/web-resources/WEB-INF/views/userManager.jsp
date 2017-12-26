<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8">
	<title>用户管理</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/userManager.css" />
	<link rel="stylesheet" type="text/css" href="css/simple.css" />
	<script src="js/userManager.js" type="text/javascript"
		charset="utf-8"></script>
</head>
<body>
	<article id="articleUserInfoTable">
		<header> 用户管理模块 - 用户信息管理 </header>
		<table class="simpleTable">
			<thead>
				<tr>
					<td colspan="7" style="text-align: left;"><input type="search"
						name="keyword" id="keyword">
						<button class="simpleButton">查询</button></td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="7">
						<nav id="curdOperation">
							<button class="simpleButton" id="btnTableAddUser">新增</button>
							<button class="simpleButton">修改</button>
							<button class="simpleButton">删除</button>
						</nav>
						<%--${page.totalRow/page.rowNumber } --%>
						<nav id="pageOperation">
							第<span id="spanCurrentPage">${page.currentPage }</span>每页${page.rowNumber }行&nbsp;&nbsp;共页
							<button class="simpleButton">首页</button>
							<button class="simpleButton" id="btn_previousPage">上一页</button>
							<button class="simpleButton" id="btn_nextPage">下一页</button>
							<button class="simpleButton">末页</button>
						</nav>
					</td>
				</tr>
			</tfoot>
			<tbody id="userInfoTbody">
				<tr>
					<th><input type="checkbox" name="allCheck" id="allCheck"></th>
					<th>name</th>
					<th>password</th>
					<th>sex</th>
					<th>email</th>
					<th>nativePlace</th>
					<th>hobby</th>
				</tr>
				
				<c:forEach items="${page.getPageList() }" var="user">
					<tr id="row_${user.id }">
						<td><input type="checkbox" name="checks" id="${user.id }"></td>
						<td>${user.name }</td>
						<td>${user.password }</td>
						<td>
							<c:if test="${user.sex==0 }">女</c:if>
							<c:if test="${user.sex==1 }">男</c:if>
						</td>
						<td>${user.email }</td>
						<td>${user.nativePlaceName }</td>
						<td>${user.hobby }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</article>
</body>
</html>
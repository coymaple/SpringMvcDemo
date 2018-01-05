<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/simple.css" />
</head>
<body>
	<header>
		<nav id="headerOperation">
			<button class="simpleButton">用户切换</button>
			<button class="simpleButton">退出</button>
		</nav>
	</header>
	<form action="" method="post">
		<article>
			<nav id="navMainMenu">
				<div id="showAndHiddenOperation" class="trans"></div>
				<h1 style="text-align: center; margin-top: 5px;">系统主菜单</h1>
				<!-- 未使用标准标签库的列表见网址 
					https://github.com/coymaple/SpringMvcDemo/blob/master2/README.md -->
				<ul class="ul_level1">
					<c:forEach items="${permissions }" var="parentPermission">
						<c:if test="${parentPermission.parentId==0 }">
							<li class="li_level1">${parentPermission.name }</li>
							<ul class="ul_level2">
								<c:forEach items="${permissions }" var="permission">
									<c:if
										test="${permission.parentId !=0 && parentPermission.id == permission.parentId }">
										<li class="li_level2"><a href="${permission.url }"
											target="mainIframe">${permission.name }</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</c:if>
					</c:forEach>
				</ul>
			</nav>
			<section id="sectionMainPage">
				<iframe name="mainIframe" src="views/welcome.jsp"></iframe>
			</section>
		</article>
	</form>
	<footer>
		<aside style="margin-left: 20px; float: left; overflow: hidden;">
			xx管理系统模板，author:
			<address style="display: inline;">
				<a href="mailto:54397946@qq.com">yuhf</a>
			</address>
		</aside>
		<nav id="footerShowAndHiddenOperation" class="trans"></nav>
	</footer>
</body>
</html>

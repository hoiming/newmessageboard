<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 中间部分，现实留言，增删改留言 -->
<head>
<link rel="stylesheet" type="text/css" href="css/middle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="messageArea">
		<form action="navigate" method="get">
			<div id="createTheme">
				<a href="navigate?action=newTheme">发帖</a>
			</div>
			<div id="themeHead">
				<span>标题</span> <span>时间</span>
			</div>
		
		<div id="list">
			<ul>
				<c:forEach items="${page.datalist }" var="item">
					<li><span><a href="navigate?action=viewMessage&themeid=${item.themeid}" >${item.content }</a></span><span>${item.createdtime }</span></li>
				</c:forEach>
			</ul>
		</div>
		</form>
		<div><%@ include file="footer.jsp"%></div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="navigate" method="get" id="navigationForm">
			<a href="navigate?action=firstPage">首页</a>
			<c:choose>
				<c:when test="${page.currentPage == 1 }">
					<a>上一页</a>
				</c:when>
				<c:otherwise>
					<a href="navigate?action=prevPage">上一页</a>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${page.currentPage == page.totalPage }">
					<a>下一页</a>
				</c:when>
				<c:otherwise>
					<a href="navigate?action=nextPage">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="navigate?action=lastPage">尾页</a>
		</form>
	</div>
</body>
</html>
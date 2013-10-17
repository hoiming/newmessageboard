<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/message.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子内容</title>
</head>
<body>
	<%@ include file="top.jsp"%>
	<div id="messageArea">
		<div id="theme">
			<span>主题</span><span>${messagePage.theme.content }</span>
		</div>
		<div id="list">
			<ul id="listContent">
				<c:forEach items="${messagePage.datamap }" var="entry">
					<li ><span>${entry.value.username }</span> <span>${entry.key.content }</span>
						<span>${entry.key.createdtime }</span></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<%@ include file="bottom.jsp"%>
</body>
</html>
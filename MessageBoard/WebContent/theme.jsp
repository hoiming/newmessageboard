<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.haiming.messageboard.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/theme.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖</title>
</head>
<%
//检查session中有无user对象，判断用户有没有登录
User user = (User)session.getAttribute("user");
if(user == null){
	session.setAttribute("ErrorMessage", "发帖前请先登录");
	response.sendRedirect("login.jsp");
}
%>
<body>
	<form action="theme" method="post">
		<div id="themeArea">
			<div id="theme">
				<span>主题</span><input class="input_2x" type="text" name="theme" />
			</div>
			<div>
				<textarea rows="10" cols="80" name="message"></textarea>
			</div>
			<div id="submit_reset">
				<input type="submit" value="提交" /> <input type="reset" value="重置" />
			</div>
		</div>
	</form>
</body>
</html>
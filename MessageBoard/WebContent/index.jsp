<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.haiming.messageboard.bean.Page,com.haiming.messageboard.bean.Theme"  %>
<%@ page import="com.haiming.messageboard.logic.ThemeLogic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>
</head>
<%
	//要判断Page对象是否有数据在里面

	Page<Theme>  initPage =  (Page<Theme>)request.getSession().getAttribute("page");
	if(initPage == null){ 
		initPage = new Page<Theme>(Theme.class);
		ThemeLogic provider = new ThemeLogic();
		initPage = provider.getThemes(initPage);
		request.getSession().setAttribute("page", initPage);
	}
%>
<body>
	<%@ include file="top.jsp" %>
<%@ include file="middle.jsp" %>
<%@ include file="bottom.jsp"%>

</body>
</html>
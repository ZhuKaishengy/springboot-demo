<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'jspPage.jsp' starting page</title>
  </head>
  
  <body>
  		<c:forEach items="${users }" var="user">
  			id:${user.id}<br>
			name : ${user.name}<br>
			age:${user.age}<br>
			createTime:${user.createTime}<br>
			<c:if test="${ user.id == '1001'}">
			欢迎1001号!<br>
			</c:if>
			=========================<br>
  		</c:forEach>
  </body>
</html>

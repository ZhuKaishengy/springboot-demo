<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("page",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="${page }/js/jquery-3.2.1.js" ></script>
    <script type="text/javascript">
    	$(function(){
    	
    		alert(1);
    	})
    </script>
  </head>
  
  <body>
  <!-- springboot 对于静态资源的访问，在src/main/resources下建一个static的文件夹，访问时，不写static；http://localhost:8080/js/jquery-3.2.1.js -->
    This is my JSP page. <br>
  </body>
</html>

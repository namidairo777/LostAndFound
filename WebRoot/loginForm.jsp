<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginForm.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" media="all" href="./layout.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="login">
	<s:form action="userLogin" namespace="/" method="post">
  		<s:textfield name="user.mail" label="邮箱"/>
  		<s:password name="user.password" label="密码"/>
  		
  		<s:submit id="login-submit" value="登录"></s:submit>
  		
   	</s:form>
   	<s:a href="#">忘记密码？</s:a>
   	<s:a href="registerForm.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册新用户</s:a>
   	<s:fielderror cssStyle="color:red;"/>
   	</div>
  
  </body>
</html>

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
    
    <title>My JSP 'registerForm.jsp' starting page</title>
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
  <div id="register">
    <div id="info">
    <div id="info-context">
    	<div id="InfoTitle">注册</div>
    <s:form action="userRegister" namespace="/" method="post">
  		<s:textfield name="user.name" label="姓名"/>
  		<s:textfield name="user.mail" label="邮箱（用户名）"/>
  		<s:password name="user.password" label="密码"/>
  		<s:password name="confirmPass" label="确认密码"/>
  		<s:select name="user.question" label="密保问题" list="{'我叫什么？','我的大学是？','我支持哪支球队？'}">
  		</s:select>
  		<s:textfield name="user.answer" label="密保答案"/>
  		<s:submit value="注册"></s:submit>
   	</s:form>
   	<s:fielderror cssStyle="color:red;"/>
   	</div>
   	</div>
  </body>
</html>

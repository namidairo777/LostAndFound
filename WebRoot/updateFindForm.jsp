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
    
    <title>My JSP 'updateFindForm.jsp' starting page</title>
    
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
    <fieldset>
    <legend>What did I lost</legend>
    <s:form action="findUpdate" namespace="/" method="post">
  		<s:textfield name="pickupthings.title" label="Title" value="%{#session.lostTitle}"/>
  		<s:textfield name="pickupthings.qq" label="qq" value="%{#session.lostQQ}"/>
  		<s:textfield name="pickupthings.mobile" label="mobile" value="%{#session.lostMobile}"/>
  		<s:textarea name="pickupthings.detail" label="detail" value="%{#session.lostDetail}"/>
  		<s:submit value="确认修改"/>
  		<s:reset value="取消"/>
   	</s:form>
   	<s:fielderror cssStyle="color:red;"/>
   	</fieldset>
  </body>
</html>

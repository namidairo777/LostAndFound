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
    
    <title>My JSP 'updateLostForm.jsp' starting page</title>
    
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
    <div id="info">
    <div id="info-context">
    	<div id="infoTitle">What did I lost</div>
    	<s:iterator id="list" value="#session.list">
    <s:form action="lostUpdate" namespace="/" method="post">
    	<s:hidden name="lostthings.name" value="%{#list.name}"></s:hidden>
  		<s:textfield name="lostthings.title" label="Title" value="%{#list.title}"/>
  		<s:textfield name="lostthings.qq" label="qq" value="%{#list.qq}"/>
  		<s:textfield name="lostthings.mobile" label="mobile" value="%{#list.mobile}"/>
  		<s:textarea name="lostthings.detail" label="detail" value="%{#list.detail}"/>
  		<s:submit value="确认修改"/>
  		<s:reset value="取消"/>
   	</s:form>
   	</s:iterator>
   	<s:fielderror cssStyle="color:red;"/>
   	</div>
  </body>
</html>

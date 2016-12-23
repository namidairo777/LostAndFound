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
    
    <title>My JSP 'listContext.jsp' starting page</title>
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
    
  	<div id="list">
  		
  		<s:iterator value="#session.list" id="list" status="st">
  			<div id="listItem">
  				<div id="listTitle">
  					<h3>
  						<s:if test="#list.status==0">
  							<div style="color:#CB1B45;float:left;"><b>?</b></div>
  						</s:if>
  						<s:else>
  							<div style="color:#20604F;float:left;"><b>√</b></div>
  						</s:else>
  					 	<div id="listTitle-title">
  							<s:property value="#list.title"/>
  						</div>
  						
  						<s:if test="#list.email==#session.userEmail">
  							<div id="user-edit">
  							<s:a href="listOne.action?name=%{#list.name}"><font color="#CB1B45"><b>edit</b></font></s:a>
  							<s:a href="lostFinish.action?name=%{#list.name}"><font color="#20604F"><b>√</b></font></s:a>
  							<s:a href="lostDelete.action?name=%{#list.name}"><font color="#CB1B45"><b>×</b></font></s:a>
  						</div>
  						</s:if>
  						
  					</h3>
  				</div>
  				<table>
  					
  					<tr>
  						<td>email:</td><td><s:property value="#list.email"/></td>
  					</tr>
  					<tr>
  						<td>phone:</td><td><s:property value="#list.mobile"/></td>
  					</tr>
  					<tr>
  						<td>time:</td><td><s:property value="#list.upDate"/></td>
  					</tr>
  					<tr>
  						<td>detail:</td><td><s:a href="lostListOne.action?name=%{#list.name}">click here</s:a></td>
  					</tr>
  				</table>
  				
  			</div>
  		</s:iterator>
  	</div>
  </body>
</html>

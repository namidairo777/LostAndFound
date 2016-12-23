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
    
    <title>My JSP 'detailInfo.jsp' starting page</title>
    
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
    			
    		<s:iterator id="list" value="#session.list">
    				<div id="infoTitle">
    					<s:if test="#list.status==0">
  							<font color="#CB1B45"><b>?</b></font>
  						</s:if>
  						<s:else>
  							<font color="#20604F"><b>√</b></font>
  						</s:else>
    					<s:property value="#list.title"/>
    					
    				</div>
    				<table>
  					
  					<tr>
  						<td>email:</td><td><s:property value="#list.email"/></td>
  					</tr>
  					<tr>
  						<td>phone:</td><td><s:property value="#list.mobile"/></td>
  					</tr>
  					<tr>
  						<td>qq:</td><td><s:property value="#list.qq"/></td>
  					</tr>
  					<tr>
  						<td>time:</td><td><s:property value="#list.upDate"/></td>
  					</tr>
  					<tr>
  						<td>detail:</td><td><s:property value="#list.detail"/></td>
  					</tr>
  				</table>
    		</s:iterator>
    	</div>	
    	<div id="commentList">
    	<div id="commentTitle">Comments</div>
    	<s:if test="#session.commentList==null">
    		<div id="nocomment"><p>→_→没人评论啊</p></div>
    	</s:if>
    	<s:else>
    	<table>
    		<s:iterator value="#session.commentList" id="comment">
    			<div id="commentItem">
    				
    					<tr>
    						<td style="width:25%"><s:property value="#comment.commenter"/></td>
    						<td style="width:75%"><s:property value="#comment.context"/></td>
    					</tr>    					
    					
    				
    			</div>
    		</s:iterator>
    		</table>
    	</s:else>
    	<div id="commentBox">
    		<s:form action="commentCreate" method="post">
    			<s:hidden name="comment.name" value="%{#session.name}"></s:hidden>
    			<s:hidden name="comment.commenter" value="%{#session.userName}"></s:hidden>
    			<s:textarea name="comment.context" ></s:textarea>
    			<s:submit value="submit"/>
    		</s:form>
    	</div>
    </div>
    </div>
    
  </body>
</html>

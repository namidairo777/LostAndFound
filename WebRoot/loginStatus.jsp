<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div id="navi">
    		<div id="navi-lostfind">
    		<s:a href="lostList.action">&nbsp;&nbsp;LOST&nbsp;</s:a>&nbsp;&&nbsp;
    		<s:a href="findList.action">FOUND</s:a>
    		</div>
    		<div id="navi-else"></div>
   		 </div>
  <div id="user_sidebar" style="float:right; position:relative;">
  
  <%if(session.getAttribute("userName")!=null) {%>
  	<div id="myLink-top">
  		<table>
  			<tr>
  				<td style="width:70%;color:#ddd;text-align:center;"><%=session.getAttribute("userName")%>
  				<%=session.getAttribute("userEmail")%></td>
  				<td id="homeLink" style="width:30%">
  					<a href="lostListMe.action">HOME</a>
  				</td>
  			</tr>
  		</table>
  				
 	</div>
 	<div id="myLink">
 		<table cellspacing="20">
 			<tr>
  				<td ><img src="./head.jpg"/></td>
  			</tr>
 			<tr>
 				<td class="info-box1"><a href="updateUser.jsp">My Information</a></td>
 			</tr>
 			<tr>
 				<td class="info-box2"><a href="newFind.jsp">I FOUND IT!</a></td>
 			</tr>
 			<tr>
 				<td class="info-box1"><a href="newLost.jsp">I LOST IT!</a></td>
 			</tr>
 			<tr>
 				<td class="info-box2"><a href="userLogout.action">LOGOUT</a></td>
 			</tr>
 			
 		</table>
  	</div>
 	
  </div>
  <%}else{ %>
  <span>
  <a href="login.jsp">登录</a></span>
  <a href="register.jsp">注册</a>
  </div>
<div  style="clear:both;position:relative;float:right;">note:请先登录</div>
  <%} %>
  <div style="clear:both;"></div>
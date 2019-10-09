<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userXinxi.jsp' starting page</title>
    
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
                           <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
								<tr>
									<td width="30%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										用户名：
									</td>
									<td width="70%" bgcolor="#FFFFFF">
										&nbsp;
										<input type="text" name="userName" id="userName" readonly="readonly" value="${requestScope.user.user_name }"/>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										密 码：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<input type="password" name="userPw" value="${requestScope.user.user_pw }"/>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										真实姓名：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<input type="text" name="userRealname" value="${requestScope.user.user_realname }"/>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										住址：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<input type="text" name="userAddress" value="${requestScope.user.user_address }"/>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										性别：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<c:choose>
											<c:when test="${requestScope.user.user_sex == '男'}" >
											&nbsp;
											<input type="radio" name="userSex" value="男" checked="checked"/>男
												&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="userSex" value="女"/>女
											</c:when>
											<c:when test="${requestScope.user.user_sex == '女'}" >
												&nbsp;
											<input type="radio" name="userSex" value="男"/>男
											&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="userSex" value="女" checked="checked"/>女
											</c:when>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										联系方式：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<input type="text" name="userTel" value="${requestScope.user.user_tel }"/>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										E-mail：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<input type="text" name="userEmail" value="${requestScope.user.user_email }"/>
									</td>
								</tr>
								<tr>
									<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
										QQ：
									</td>
									<td bgcolor="#FFFFFF">
										&nbsp;
										<input type="text" name="userQq" value="${requestScope.user.user_qq }"/>
									</td>
								</tr>
							</table>
  </body>
</html>

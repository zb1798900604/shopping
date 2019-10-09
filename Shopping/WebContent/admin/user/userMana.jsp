<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function userDel(user_id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/userDel.do?user_id="+user_id;
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/images/wbg.gif">&nbsp;会员管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">ID</td>
					<td width="10%">用户名</td>
					<td width="10%">密码</td>
					<td width="10%">真实姓名</td>
					<td width="10%">住址</td>
					<td width="10%">性别</td>
					<td width="10%">联系方式</td>
					<td width="10%">E-mail</td>
					<td width="10%">QQ</td>
					<td width="10%">操作</td>
		        </tr>
		        <c:forEach items="${userList}" var="user">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<c:out value="${user.user_id}" />
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.user_name}
						
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${user.user_pw}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.user_realname}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.user_address}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.user_sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.user_tel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${user.user_email}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${user.user_qq}
					</td>
					<td  bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="userDel(${ user.user_id})" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>	
			</table>
	</body>
</html>

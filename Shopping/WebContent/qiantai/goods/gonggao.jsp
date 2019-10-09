<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${gonggao }" var="gg">
			<tr>
				<td><img src="/Shopping/img/head-mark3.gif" align="middle"
					class="img-vm" border="0" /></td>
				<td>${gg.gonggao_title }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
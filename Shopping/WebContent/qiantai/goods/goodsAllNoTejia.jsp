<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
<script type="text/javascript">
	        function buy1()
	        {
	            <c:if test="${sessionScope.user==null}">
	                  alert("请先登录");
	            </c:if>
	            <c:if test="${sessionScope.user!=null}">
	           	 if(document.buy.quantity.value=="")
	         	   {
	             	   alert("请输入购买数量");
	          	      return false;
	       	    	 }
	          	  document.buy.submit();
	            </c:if>
	        }
 </script>
</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<!--左边的 -->
			<div class="page_main_msg left">		
		        <div class="left_row">
		            <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;所有商品</div>
						  	<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align="center" bgcolor="#FAFAF1" height="22">
					                  <td>商品名称</td>
					                  <td>市场价</td>
					                  <td>商品图片</td>
					                  <td>操作</td>
					              </tr>
					             <%--  <c:forEach items="${requestScope.goodsYesTejiaList}" var="goods">
					              		${goods.goods_name}
					              </c:forEach> --%>
								  <c:forEach items="${requestScope.goodsYesTejiaList}" var="goods">
								  <tr align='center' bgcolor="#FFFFFF" height="22">
									  <td>${goods.goods_name}</td>
									  <td>￥${goods.goods_shichangjia}<br/></td>
									  <td><a href="<%=path %>/goodsDetail.do?goods_id=${goods.goods_id}"> <img src="<%=path %>/${goods.goods_pic}" width="60" height="60" border="0"/> </a></td>
									  <td><a href="<%=path %>/goodsDetail.do?goods_id=${goods.goods_id}"><img alt="" src="<%=path %>/images/icon_buy.gif" border=0/></a></td>
								  </tr>
								</c:forEach>		        			
						</table>
		             </div>
		         </div>	
	        </div>
			<!--左边的 -->
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">
							用户登录
						</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
                <div class="left_row">
				    <div class="list">
				        <div class="list_bar">商品分类</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;">
							             <div id="roll-orig-1607838439">
										     <jsp:include  flush="true" page="fenglei.jsp"></jsp:include>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;">
							             <div id="roll-orig-1607838439">
										 	<jsp:include  flush="true" page="gonggao.jsp"></jsp:include>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
			</div>
			<div style="clear: both"></div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div>
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>

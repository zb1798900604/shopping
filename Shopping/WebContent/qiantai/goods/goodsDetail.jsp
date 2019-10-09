<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		  	                <div class="list_bar">&nbsp;详情</div>
						  	<form action="<%=path %>/addCart.do" method="post" name="buy">
                                  <table border="0" cellpadding="6">
                                      <tr><td width="30"></td><td style="font-size: 11px;">品名：</td><td style="font-size: 11px;">${goods.goods_name}</td></tr>
                                      <tr><td width="30"></td><td style="font-size: 11px;">简介：</td><td style="font-size: 11px;">${goods.goods_miaoshu}</td></tr>
                                      <tr><td width="30"></td><td style="font-size: 11px;">价格：</td><td style="font-size: 11px;">${goods.goods_shichangjia} </td></tr>
                                      <tr><td width="30"></td><td style="font-size: 11px;">图片：</td><td style="font-size: 11px;"><img width="300xp" height="300xp" src="<%=basePath %>/${goods.goods_pic}"/></td></tr>
                                      
                                     
                                     
                                      <tr><td width="30"></td><td style="font-size: 11px;">评价：</td><td style="font-size: 11px;">
                                       
                                        <hr style="border: 1px dashed #ccc; width: 100%; height: 1px;" />
                                        	<table>
                                        	
                                        	<c:forEach items="${tping}" var="ping">
                                      			<tr><td>
                                      				${ping.info}&nbsp;&nbsp;&nbsp;${ping.adddate} &nbsp;&nbsp;&nbsp; ${ping.loginname}
                                      			</td></tr>
                                     		</c:forEach> 
                                     		
                                     		</table>
                                        <hr style="border: 1px dashed #ccc; width: 100%; height: 1px;" />
                                      </td></tr>
                                       <tr><td width="30"></td><td style="font-size: 11px;">购买数量：</td><td style="font-size: 11px;"><input type="text" name="quantity" value="1" size="8" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></td></tr>
                                        <tr><td width="30"></td><td style="font-size: 11px;"><input type="hidden" name="goodsId" value="${goods.goods_id }"/><a href="#" onclick="buy1()"><img  src="<%=path %>/images/icon_buy.gif"/></a></td><td style="font-size: 11px;"></td></tr>
                                  </table>
                            </form>
                            
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
				                   <div style="overflow:hidden;height:150px;">
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
				                   <div style="overflow:hidden;height:150px;">
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

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
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
        <script language="javascript">
           function orderDel(orderId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/del.do?orderId="+orderId;
               }
           }
           
           function orderShouli(orderId)
           {
               if(confirm('您确定受理订单吗？'))
               {
                   window.location.href="<%=path %>/orderShouli.do?orderId="+orderId;
               }
           }
           
           
           function orderDetail(orderId)
           {
                 var url="<%=path %>/orderDetailmx.do?orderId="+orderId;
                 var n="";
                 var w="700px";
                 var h="700px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
                 window.open(url,n,w,h,s);
           }
           
           function userXinxi(userId)
           {
                 var url="<%=path %>/userXinxiAdmin.do?userId="+userId;
                 var n="";
                 var w="300px";
                 var h="400px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
                 window.open(url,n,w,h,s);
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/images/wbg.gif">&nbsp;订单查看&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="8%">用户ID</td>
					<td width="10%">订单编号</td>
					<td width="10%">金额</td>
					<td width="16%">下单日期</td>
					<td width="18%">送货地址</td>
					<td width="16%">付款方式</td>
					<td width="22%">操作</td>
		        </tr>	
				<c:forEach items="${orderList}" var="order">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="userXinxi(${order.order_user_id})" style="color:red" >${order.order_user_id}</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${order.order_bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${order.order_jine }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${order.order_date }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${order.order_songhuodizhi }
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${order.order_fukuangfangshi }
					</td>
					<td bgcolor="#FFFFFF" align="center">
					        <a href="#" onclick="orderDetail(${order.order_id })" class="pn-loperator">订单明细</a>
						    <c:if test="${order.order_zhuangtai=='no'}">
							    <a href="#" onclick="orderShouli(${order.order_id })" class="pn-loperator">受理订单</a>
						    </c:if>
						    <c:if test="${order.order_zhuangtai=='yes'}">
						         已受理
						    </c:if>
							<a href="#" onclick="orderDel(${order.order_id })" class="pn-loperator">删除订单</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>

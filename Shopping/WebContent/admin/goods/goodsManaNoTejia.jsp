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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function goodsNoTejiaDel(goodsId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/goodsNoTejiaDel.do?goodsId="+goodsId;
               }
           }
           
           function goodsNoTejiaAdd()
           {
                 var url="<%=path %>/admin/goods/goodsNoTejiaAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }
		   function xiangqin(goodsId)
	       {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:400});
	            pop.setContent("contentUrl","<%=path %>/goodsDetailHou.do?goodsId="+goodsId);
	            pop.setContent("title","商品详细介绍");
	            pop.build();
	            pop.show();
	       }		
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="18" background="<%=path %>/images/wbg.gif">&nbsp;商品管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="2%">ID</td>
					<td width="15%">商品名称</td>
					<td width="10%">商品描述</td>
					<td width="12%">分类</td>
					<td width="12%">编号</td>
					<!--<td width="12%">商品图片</td>-->
					<td width="5%">价格</td>
					<td width="5%">库存</td>
					<td width="12%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.goodsList }" var="goods">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${goods.goods_id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.goods_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="xiangqin(${goods.goods_id})">查看商品详情</a>
					</td>
					<td bgcolor="#FFFFFF" align="center" >
						
							${goods.goods_catelog_id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						    ${goods.goods_yanse}
					</td>
					<!--<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/<s:property value="#goods.goodsPic"/>')" onmouseout = "out()" style="cursor:hand;">
								查看图片
					   </div>
					</td>-->
					<td bgcolor="#FFFFFF" align="center">
					     ${goods.goods_shichangjia}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.goods_kucun}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					<a href="goodsEditPre.do?goodsId=${goods.goods_id}" class="pn-loperator">编辑</a>|
						<a href="#" onclick="goodsNoTejiaDel(${goods.goods_id})" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="goodsNoTejiaAdd()" />
			    </td>
			  </tr>
		    </table>
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="80" width="80"></TD>
				</TR>
			</TABLE>
		</div>
	</body>
</html>

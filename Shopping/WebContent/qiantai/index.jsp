<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<!-- saved from url=(0041)http://www.nbhmyq.com/7853-473/16167.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>网站首页</title>

<link href="<%=path%>/css/layout.css" type="text/css" rel="stylesheet" />

<script language="JavaScript" src="<%=path%>/js/public.js"
	type="text/javascript">
	
</script>
<script type="text/javascript">
	
</script>
<style rel="stylesheet" type="text/css" media="screen">
</style>
</head>
<body>
	<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
	<div class="page_row">
		<!--左边的 -->
		<div class="page_main_msg left">


			<!-- 新品上市 -->
			<div class="left_row">
				<div class="list pic_news">
					<div class="list_bar">
						<span style="float: left">新款上市</span> <span style="float: right"><a
							href="<%=path%>/goodAll.do">更多>></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
					</div>
					<div id="tw" class="list_content">
						<div style="width: 100%; overflow: hidden; white-space: nowrap;">
							<table width="100%" align="left" cellpadding="0" cellspacing="0"
								border="0">
								<tr>
									<c:forEach items="${goodsNoTejiaList}" var="goods">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0"
												border="0">
												<tr>
													<td sytle="height:60px;">
														<dl
															style="width: 100%; height: 200px; padding-right: 10px;">
															<dd style="margin-left: 0;">
																<a
																	href="<%=path%>/goodsDetail.do?goodsId=${goods.goods_id}">
																	<img width="105" height="110"
																	src="<%=path%>/${goods.goods_pic}" />
																</a>
															</dd>
															<dt style="margin-left: 0; width: 90%">
																<a
																	href="<%=path%>/goodsDetail.do?goodsId=${goods.goods_id}">
																	<font size="2">${goods.goods_name} </font>
																</a>
															</dt>
															<dt>
																<font size="2">￥: ${goods.goods_shichangjia}</font>
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
									</c:forEach>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- 新品上市 -->

			<!-- 排行榜 -->
			<div class="left_row">
				<div class="list pic_news">
					<div class="list_bar">
						<span style="float: left">销量排行</span>
					</div>
					<div id="tw" class="list_content">
						<div style="width: 100%; overflow: hidden; white-space: nowrap;">
							<table width="100%" align="left" cellpadding="0" cellspacing="0"
								border="0">
								<tr>
									<c:forEach items="${goodsList }" var="goods">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0"
												border="0">
												<tr>
													<td sytle="height:28px;">
														<dl
															style="width: 100%; height: 200px; padding-right: 10px;">
															<dd style="margin-left: 0;">
																<a
																	href="<%=path%>/goodsDetail.do?goodsId=${goods.goods_id}">
																	<img width="105" height="110"
																	src="<%=path%>/${goods.goods_pic }" />
																</a>
															</dd>
															<dt style="margin-left: 0; width: 90%">
																<a
																	href="<%=path%>/goodsDetail.do?goodsId=${goods.goods_id }">
																	<font size="2">${goods.goods_name } </font>
																</a>
															</dt>
															<dt>
																<font size="2">￥：${goods.goods_shichangjia }
																</font>
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
									</c:forEach>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- 排行榜 -->


		</div>
		<!--左边的 -->

		<!-- 右边的用户登录。留言。投票 -->
		<div class="page_other_msg right">
			<div class="left_row">
				<div class="list">
					<div class="list_bar">用户登录</div>
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
							<div style="overflow: hidden;">
								<div id="roll-orig-1607838439">
									<%-- <table>
										<c:forEach items="${feilei }" var="fl">
											<tr>
												<td><img src="/tyypsc/img/head-mark3.gif" align="middle" class="img-vm" border="0"/></td>
												<td class="gonggaoQian5">${fl.catelog_name }</td>
											</tr>
										</c:forEach>
									</table> --%>
									<jsp:include page="goods/fenglei.jsp"></jsp:include>
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
							<div style="overflow: hidden;">
								<div id="roll-orig-1607838439">
								<%-- <table>
										<c:forEach items="${gonggao }" var="gg">
											<tr>
												<td><img src="/tyypsc/img/head-mark3.gif" align="middle" class="img-vm" border="0"/></td>
												<td >${gg.gonggao_title }</td>
											</tr>
										</c:forEach>
									</table> --%>
									<jsp:include page="goods/gonggao.jsp"></jsp:include>
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





	<jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>




	<script language="javascript" type="text/javascript"
		src="qiantai/qimg/png.js">
		
	</script>

</body>
</html>
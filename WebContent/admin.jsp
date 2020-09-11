<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>管理员</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrapValidator.css" />
		<style>
			body{
				background:url('${pageContext.request.contextPath }/img/root_bg.jpeg')
			}
		</style>
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="#" class="navbar-brand">
							包租婆租赁平台&nbsp;&nbsp;&nbsp;
							<small>
								<span class="label label-warning">管理员</span>
							</small>
						</a>
						<p style="color: #FFFFFF;position: absolute;right: 40px;line-height: 50px;" class="pull-right"><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;管理员&nbsp;</p>	
					</div>
				</div>
			</nav>
			<div class="jumbotron">
				<div class="container">
					<table class="table table-striped table-bordered table-hover table-reponsive">
						<caption>归还订单</caption>
						<thead>
							<tr>
								<th class="text-center">用户</th>
								<th class="text-center">订单编号</th>
								<th class="text-center">商品编号</th>
								<th class="text-center">租赁天数</th>
								<th class="text-center">总价（￥）</th>
								<th class="text-center">审核</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${l}" var="lease">
							<tr align="center">
								<td>${lease.userName }</td>
								<td>${lease.orderId }</td>
								<td>${lease.goodsId }</td>
								<td>${lease.days }</td>
								<td>${lease.total }</td>
								<td>
									<button type="button" class="btn btn-success btn-sm" id="g_submit" onclick="location.href='${pageContext.request.contextPath }/examine?orderId=${lease.orderId }&goodsId=${lease.goodsId }' + '&state=5'">通过</button>&nbsp;
									<button type="button" class="btn btn-danger btn-sm" id="s_dismit" onclick="location.href='${pageContext.request.contextPath }/examine?orderId=${lease.orderId }&goodsId=${lease.goodsId }' + '&state=6'">不通过</button>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="jumbotron">
				<div class="container">
					<table class="table table-striped table-bordered table-hover table-reponsive">
						<caption>发布信息</caption>
						<tr>
							<th class="text-center">用户</th>
							<th class="text-center">商品编号</th>
							<th class="text-center">商品名称</th>
							<th class="text-center">功能描述</th>
							<th class="text-center">价格/天</th>
							<th class="text-center">审核</th>
						</tr>
						<c:forEach items="${g}" var="stock">
							<tr align="center">
								<td>${stock.userName }</td>
								<td>${stock.goodsId }</td>
								<td>${stock.name }</td>
								<td>${stock.function }</td>
								<td>${stock.price }</td>
							<td class="text-center">
								<button type="button" class="btn btn-success btn-sm" id="f_submit" onclick="location.href='${pageContext.request.contextPath }/examine?goodsId=${stock.goodsId }' + '&state=2'">通过</button>&nbsp;
								<button type="button" class="btn btn-danger btn-sm" id="f_dismit" onclick="location.href='${pageContext.request.contextPath }/examine?goodsId=${stock.goodsId }' + '&state=0'">不通过</button>
							</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			
		</div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	</body>
</html>

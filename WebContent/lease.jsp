<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>我要租赁</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrapValidator.css" />
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="#" class="navbar-brand">
							包租婆租赁平台&nbsp;&nbsp;&nbsp;
							<small>
								<span class="label label-success">租赁</span>
							</small>
						</a>
						<p style="color: #FFFFFF;position: absolute;right: 40px;line-height: 50px;" class="pull-right">欢迎&nbsp;<span>${userName }</span>&nbsp;登陆</p>	
					</div>
				</div>
			</nav>
			<div class="jumbotron">
				<div class="container">
					<div class="row" style="border-bottom: 1px solid #5E5E5E;">
						<ul class="nav nav-pills">
							<li class="active"><a href="#">想租赁就来包租婆</a></li>
						</ul>
					</div>
					<h2 class="pull-left">租赁</h2>
					<div class="pull-right" style="margin-top: 20px;margin-bottom: 10px;"><a href="${pageContext.request.contextPath }/myOrder" class="btn btn-danger btn-lg"><span>我的订单</span><i class="glyphicon glyphicon-shopping-cart"></i></a></div>
					<table class="table table-striped table-bordered table-hover table-reponsive">
						<caption>浏览商品信息</caption>
						<thead>
							<tr>
								<th class="text-center">商品编号</th>
								<th class="text-center">出租用户</th>
								<th class="text-center">商品</th>
								<th class="text-center">功能描述</th>
								<th class="text-center">价格/每天（￥）</th>
								<th class="text-center">租赁</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list}" var="stock">
							<tr align="center">
								<td>${stock.goodsId }</td>
								<td>${stock.userName }</td>
								<td><img width="100" height="100" src="${stock.path }" alt="图片显示失败" title="demo"/>
							<p style="font-size:16px;margin-top:10px;font-weight:bolder">${stock.name }</p></td>								
								<td>${stock.function }</td>
								<td>${stock.price }</td>
								<td>
									<button type="button" class="btn btn-info btn-sm" onclick="var input = prompt('请输入需要租赁的天数','');if(input){location.href='${pageContext.request.contextPath }/lease?goodsId=${stock.goodsId }&days=' + input}">确定租赁</button>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	</body>
</html>

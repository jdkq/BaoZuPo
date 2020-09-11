<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>我要租赁</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
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
							<li class="active"><a href="#">租赁订单详情</a></li>
						</ul>
					</div>
					<h2 class="pull-left">租赁订单</h2>
					<div class="pull-right" style="margin-top: 20px;margin-bottom: 10px;"><a href="${pageContext.request.contextPath }/showGoods" class="btn btn-warning btn-lg"><span>返回</span>&nbsp;<i class="glyphicon glyphicon-log-out"></i></a></div>
					<table class="table table-condensed table-bordered table-hover table-reponsive">
						<thead>
							<tr>
								<th class="text-center">订单编号</th>
								<th class="text-center">时间</th>
								<th class="text-center">商品名称</th>
								<th class="text-center">租赁天数</th>
								<th class="text-center">总价</th>
								<th class="text-center">租赁状态</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="lease">
							<tr align="center">
								<td>${lease.orderId }</td>
								<td>${lease.time }</td>
								<td>${lease.name }</td>
								<td>${lease.days }</td>
								<td>${lease.total }</td>
								<td>
									<c:choose>
										<c:when test="${lease.state == 3}">
									       	租赁中
									    </c:when>
									    <c:when test="${lease.state == 4}">
									       	归还中
									    </c:when>
									    <c:when test="${lease.state == 5}">
									      	已归还
									    </c:when>
									     <c:when test="${lease.state == 6}">
									      	归还失败
									    </c:when>
									</c:choose>
								</td>
								
								<td>
									<c:if test="${lease.state == 3}"><button type="button" class="btn btn-info btn-sm" onclick="location.href='${pageContext.request.contextPath }/return?goodsId=${lease.goodsId }' + '&orderId=${lease.orderId}'" >确定归还</button></c:if>
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

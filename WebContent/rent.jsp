<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>我要出租</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrapValidator.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrapValidator.css">
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="#" class="navbar-brand">
							包租婆租赁平台&nbsp;&nbsp;&nbsp;
							<small>
								<span class="label label-danger">出租</span>
							</small>
						</a>
						<p style="color: #FFFFFF;position: absolute;right: 40px;line-height: 50px;" class="pull-right">欢迎&nbsp;<span>${userName}</span>&nbsp;登陆</p>	
					</div>
				</div>
			</nav>
			<div class="jumbotron">
				<h2 class="pull-left">我的发布 </h2>
				<div class="pull-right" style="margin-top: 10px;margin-bottom: 10px;"><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#release">发布商品</button></div>
				<div class="modal fade" id="release" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">商品属性详情</h4>
							</div>
							<div class="modal-body">
								<form class="bs-example bs-example-form" id="releaseForm" action="${pageContext.request.contextPath }/addGoods" method="post" enctype="multipart/form-data">
									<div class="form-group">
										<label class="control-label">商品名称：</label>
										<input name="name" id="goodsname" class="form-control"  placeholder="请输入商品名称" />
									</div>
									<div class="form-group">
										<label>商品图片：</label>
										<input type="file" name="file" id="goodsimage" class="form-control" />
									</div>
									
									<div class="form-group">
										<label class="control-label">功能描述：</label>
										<textarea name="function" id="goodsDescript" class="form-control"  placeholder="请输入商品的功能描述" ></textarea>
										
									</div>
									<div class="form-group">
										<label class="control-label">价格/天：</label>
										<input name="price" id="goodsPrice" class="form-control"  placeholder="请输入价格" />
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-info btn-sm" onclick="Release()">发布</button>
								<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">取消</button>
							</div>
						</div>
					</div>
				</div>
				<hr style="clear: both;">
				<table class="table table-striped table-bordered table-hover table-reponsive">
					<tr>
						<th class="text-center">商品编号</th>
						<th class="text-center">商品</th>
						<th class="text-center">功能描述</th>
						<th class="text-center">价格/天</th>
						<th class="text-center">商品状态</th>
						<th class="text-center">操作</th>
					</tr>
					<c:forEach items="${list}" var="stock">
							<tr align="center">
								<td>${stock.goodsId }</td>
								<td><img width="100" height="100" src="${stock.path }" alt="图片显示失败" title="demo"/>
							<p style="font-size:16px;margin-top:10px;font-weight:bolder">${stock.name }</p></td>
								<td>${stock.function }</td>
								<td>${stock.price }</td>
								<td>
									<c:choose>
										<c:when test="${stock.state == 2}">
									       	发布中
									    </c:when>
									    <c:when test="${stock.state == 1}">
									       	审核中
									    </c:when>
										<c:when test="${stock.state == 3}">
									       	租赁中
									    </c:when>
									    <c:when test="${stock.state == 4}">
									       	归还中
									    </c:when>
									    <c:when test="${stock.state == 0}">
									       	发布审核失败
									    </c:when>
									    <c:when test="${stock.state == 6}">
									       	归还审核失败
									    </c:when>
									</c:choose>
								</td>
								<td>
										<c:if test="${stock.state == 2 || stock.state == 1 || stock.state == 0}"><button type="button" class="btn btn-info btn-sm" onclick="location.href='${pageContext.request.contextPath }/delete?goodsId=${stock.goodsId }'" >删除</button></c:if>
								</td>
							</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrapValidator.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/validator.js"></script>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">	
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrapValidator.css">
	<title>包租婆租赁平台</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a href="login.jsp" class="navbar-brand">
						包租婆租赁平台&nbsp;&nbsp;&nbsp;
						<small>
							<span class="label label-success">租赁</span>+<span class="label label-danger">出租</span>
						</small>
					</a>
					<button type="submit" class="btn btn-default btn-sm navbar-btn" 
					style="text-shadow: black 5px 3px 3px;color:#fff;background-color: #000000;" role="button" data-toggle="modal" data-target="#register">
						<span class="glyphicon glyphicon-user"></span> 注册
					</button>	
				</div>
			</div>
		</nav>
		<div class="jumbotron">
			<div class="container">
				<h1>“包租婆”</h1>
				<p>租赁平台是为广大租赁用户开发的，用于日常或工作中的租赁交易管理，包括出租与租赁。提供数字化的管理，提高租赁的安全与便利。</p>
				<p><button type="button" class="btn btn-primary btn-lg" role="button" data-toggle="modal" data-target="#login">点击登陆</button>
					<span id="al" title="提示信息" class="label label-success">${mes }</span></p>
				<!-- 创建登陆模态框 target => login -->
				<div class="modal fade" id="login" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">请进行登陆</h4>
							</div>
							<div class="modal-body">
								<form class="bs-example bs-example-form" id="loginForm" action="${pageContext.request.contextPath }/login" method="post">
									<div class="form-group">
										<label class="control-label">账号：</label>
										<input name="userName" class="form-control" id="username" placeholder="请输入账号" />
									</div>
									<div class="form-group">
										<label class="control-label">密码：</label>
										<input type="password" name="passwd" id="passwd" class="form-control"  placeholder="请输入密码" />
									</div>
									<div class="form-group">
											<label>性质：</label><br>
											<div class="radio-inline">
												<label><input type="radio" value="lease" name="ad">我要租赁</label>
											</div>
											<div class="radio-inline">
												<label><input type="radio" value="rent" name="ad">我要出租</label>
											</div>
											<div class="radio-inline">
												<label><input type="radio" value="root" name="ad">管理员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
											</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								
								<button type="submit" class="btn btn-success btn-sm" onclick="Login()">登陆</button>
								<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">取消</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="jumbotron">
			<div class="container">
				<h2>介绍：</h2>
				<p style="font-size: 16px;">
				这个世界，物质极其丰富，想要拥有全部想要的，那肯定是不现实的，有时候，我们可以试试租，比如豪车，可以租，租上几天，租上几周，等等，既省钱，又省心。
				众所周知，家具、电器等一经使用后，如果再流入二手市场，将贬值得很厉害。如何应对全新货品出租后的贬值问题?
				在很多一线城市，用于出租的物品将都是全新的，包括汽车都是使用了一年之内的。等到租赁期到消费者退还的时候，这些已经成为二手货品的商品将进入二线城市的实物租赁市场，这样也迎合了二线城市市民的消费能力。直到二手货品的使用到达-定期限后，将直接采用赠与的方式解决其出路问题。
				经营性租赁满足了客户对资产需求的灵活性，有助于提高其投资收益率。企业经营中除存在长期稳定的资产需求外，有很多根据市场需求而随时变化的需求。这种情况下，租期相对较短、并且可选择续租、退租、可撤销租约的经营租赁就能够满足客户高度灵活的需求，减少不必要的长期投资。
				</p>
			</div>
		</div>
		<!-- 创建模态框 -->
		<!-- 创建注册模态框 target => register -->
		<div class="modal fade" id="register" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">请先进行注册</h4>
					</div>
					<div class="modal-body">
						<form id="registForm" action="${pageContext.request.contextPath }/register" method="post">
							<div class="form-group">
								<label class="control-label">账号：</label>
								<input name="new_username" class="form-control" id="new-username" placeholder="请输入账号" />
							</div>
							<div class="form-group">
								<label class="control-label">密码：</label>
								<input name="new_passwd" id="new-passwd" type="password" class="form-control"  placeholder="请输入密码"  />
							</div>
							<div class="form-group">
								<label class="control-label">确认密码：</label>
								<input name="passwd_a" id="again-passwd" type="password" class="form-control"  placeholder="请再次确认密码"  />
							</div>
							<div class="form-group">
								<label class="control-label">真实姓名：</label>
								<input type="text" name="Name" id="Name" class="form-control" placeholder="请输入本人姓名">
							</div>
							<div class="form-group">
								<label class="control-label">家庭住址：</label>
								<input type="text" name="address" id="address" class="form-control" placeholder="请输入家庭住址">
							</div>
							<div class="form-group">
								<label class="control-label">注册性质：</label>
								<label class="radio-inline" style="margin-left: 10px;"><input type="radio" name="radio" value="1">租赁者</label>
								<label class="radio-inline" style="margin-left: 10px;"><input type="radio" name="radio" value="0">出租者</label>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info btn-sm" onclick="Resiter()">注册</button>
						<button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrapValidator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/validator.js"></script>
</body>
</html>
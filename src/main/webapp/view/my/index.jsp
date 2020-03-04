<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--??  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人中心</title>
<%-- <link href="<%=request.getContextPath()%>/css/index3.css" rel="stylesheet">  --%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"
	src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
</head>
<body>
	<div class="container-fulid">
		<div class="row">
			<div class="col-md-12" style="background-color: red; height: 60px">左侧菜单</div>
		</div>
		<div class="row">
			<div class="col-md-2" style="background-color:">
				<div class="list-group">
					<a href="#"
						class="list-group-item list-group-item-action list-group-item-primary">我的文章</a>
					<a href="#"
						class="list-group-item list-group-item-action list-group-item-secondary">发布文章</a>
					<a href="#"
						class="list-group-item list-group-item-action list-group-item-success">我的粉丝</a>
					<a href="#"
						class="list-group-item list-group-item-action list-group-item-danger">阅读历史</a>
					<a href="#"
						class="list-group-item list-group-item-action list-group-item-warning">我的收藏</a>
					<a href="#"
						class="list-group-item list-group-item-action list-group-item-info">编辑资料</a>
				</div>
			</div>
			<div class="col-md-10" style="background-color:"></div>
		</div>
	</div>
</body>
</html>
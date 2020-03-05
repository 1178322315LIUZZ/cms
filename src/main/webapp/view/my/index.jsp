<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头头条-个人中心</title>
<%-- <link href="<%=request.getContextPath()%>/css/index3.css" rel="stylesheet">  --%>
<script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
</head>
<body>
	<div class="container-fulid">
		<div class="row">
			<div class="col-md-12" style="background-color: #563D7C; height: 60px">
				<img alt="" src="/css/img/1.jpg" style="height: 60px;width: 60px">
				<span style="color: white">今日头条-个人中心</span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2" >
				<ul class="list-group">
					<li class="list-group-item list-group-item-action list-group-item-primary"><a href="#" data="/my/articles"style="text-decoration:none">我的文章</a></li>
					<li class="list-group-item list-group-item-action list-group-item-secondary"><a href="#" data="/my/public"style="text-decoration:none">发布文章</a></li>
					<li class="list-group-item list-group-item-action list-group-item-success"><a href="#" style="text-decoration:none">我的收藏</a></li>
					<li class="list-group-item list-group-item-action list-group-item-danger"><a href="#" style="text-decoration:none">我的评论</a></li>
					<li class="list-group-item list-group-item-action list-group-item-warning"><a href="#" style="text-decoration:none">个人信息</a></li>
				</ul>
			</div>
			<div class="col-md-10" id="center">
			<jsp:include page="/kindeditor1/jsp/demo.jsp"/>
			</div>
		</div>
	</div>
</body>
 <script type="text/javascript">
  	$("li").click(function() {
		var url=$(this).children().attr("data")
		 $("#center").load(url) 
	})
 </script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头头条管理员后台</title>
<%-- <link href="<%=request.getContextPath()%>/css/index3.css" rel="stylesheet">  --%>
<script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
</head>
<body>
	<div class="container-fluid" style="padding-top: 10px">
	<!-- 头 -->
		<div class="row rounded" style="background-color: #009FD9; height: 60px">
			<div class="col-md-12"><img alt="" src="/css/img/1.jpg" style="height: 60px;width: 60px"><font color="white">管理员后台系统</font>
				<div style="float: right;padding-top: 10px"> <a href=""><font style="color: white"> 注销</font></a></div>
				</div>
		  
		</div>
	<div class="container-fluid" style="padding-top: 5px;">
		
		
		<div class="row" style="padding-top: 10px ;height: 500px" >
			<div class="col-md-2 rounded" style="text-align: center;padding-top: 5px">
				<ul class="list-group">
					<li class="list-group-item list-group-item-action list-group-item-primary"><a href="#" data="/admin/articles"style="text-decoration:none">文章管理</a></li>
					<li class="list-group-item list-group-item-action list-group-item-secondary"><a href="#"  data="/admin/users"style="text-decoration:none">用户管理</a></li>
					<li class="list-group-item list-group-item-action list-group-item-success"><a href="#" style="text-decoration:none">友情链接</a></li>
					<li class="list-group-item list-group-item-action list-group-item-danger"><a href="#" style="text-decoration:none">系统设置</a></li>
				</ul>
			</div>
             <!-- 中间区域 -->
			<div class="col-md-10" id="center" style="padding-right: 0px" >
			
			</div>
		</div>
	</div>
<script type="text/javascript">
$("li").click(function() {
	var url=$(this).children().attr("data")
	 $("#center").load(url) 
})
</script>
</body>
</html>
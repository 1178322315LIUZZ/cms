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
<link rel="stylesheet" type="text/css" href="/view/common/index.css" />
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
		<!--头  -->
		<div class="row">
			<div class="col-md-12" style="background-color: #222222;height: 34px">
				&nbsp;&nbsp;<font color="white" size="3px">下载APP</font>
			</div>
		</div>
	</div>	
	<div class="row">
		<div class="col-md-2" style="padding-top: 10px">
			<ul>
				<li style="margin-bottom: 10px">
					<a class="channel">
					<img alt="" src="/view/common/logo-index.png" style="width: 108px;height: 27px">
					</a>
				</li>
				<c:forEach items="${channels }" var="channel" varStatus="i">
					<li><a href="/?channelId=${channel.id} " class="channel-item ${article.channelId==channel.id?'active':'' }">${channel.name }</a></li>	
				</c:forEach>
			</ul>
		
		
		</div>
		<div class="col-md-7">
			<div class="subchannel">
				<ul>		
					 <li class="sub-item ${article.categoryId==null?'sub-selected':'' }"><a href="/?channelId=${article.channelId }">全部</a></li>
			      	<c:forEach  items="${categorys}" var="category">
			        	<li class="sub-item ${article.categoryId==category.id?'sub-selected':'' }"><a href="/?channelId=${article.channelId}&categoryId=${category.id}">${category.name }</a></li>
			     	 </c:forEach>
				</ul>
			</div>
		</div>
		<div class="col-md-3">右侧</div>
	</div>
</body>
</html>
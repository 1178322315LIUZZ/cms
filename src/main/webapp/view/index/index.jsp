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
	<div class="container-fluid">
		<!--头  -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				&nbsp;&nbsp;<font color="white" size="3px">下载APP</font>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2" style="padding-top: 10px">
			<ul>
				<li style="margin-bottom: 10px"><a class="channel"> <img
						alt="" src="/view/common/logo-index.png"
						style="width: 108px; height: 27px">
				</a></li>
				<li><a href="/?hot=1 "class="channel-item ${article.channelId==channel.id?'active':'' }">热点</a></li>
				<c:forEach items="${channels }" var="channel" varStatus="i">
					<li><a href="/?channelId=${channel.id} "
						class="channel-item ${article.channelId==channel.id?'active':'' }">${channel.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-7">
			<c:if test="${article.channelId!=null }">
				<div class="subchannel">
				<ul>
					<li class="sub-item ${article.categoryId==null?'sub-selected':'' }"><a
						href="/?channelId=${article.channelId }">全部</a></li>
					<c:forEach items="${categorys}" var="category">
						<li
							class="sub-item ${article.categoryId==category.id?'sub-selected':'' }"><a
							href="/?channelId=${article.channelId}&categoryId=${category.id}">${category.name }</a></li>
					</c:forEach>
				</ul>
			</div>
			</c:if>
			<c:if test="${article.channelId==null }">
	<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" style="margin-top: 5px">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/view/common/jd1.png" class="d-block w-100" alt="" style="width: 175px; height: 400px">
      <div class="carousel-caption d-none d-md-block">
        <h5>京东1</h5>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/view/common/jd2.png" class="d-block w-100" alt="" style="width: 175px; height: 400px">
      <div class="carousel-caption d-none d-md-block">
        <h5>京东2</h5>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/view/common/jd3.png" class="d-block w-100" alt="" style="width: 175px; height: 400px">
      <div class="carousel-caption d-none d-md-block">
        <h5>京东3</h5>
      </div>
    </div>
     <div class="carousel-item">
      <img src="/view/common/jd4.png" class="d-block w-100" alt="" style="width: 175px; height: 400px">
      <div class="carousel-caption d-none d-md-block">
        <h5>京东4</h5>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
			</c:if>
			
			<div>
				<c:forEach items="${g }" var="c">
					<div class="media" style="margin-top: 5px">
						<img src="/pic/${c.picture }" class="mr-3" alt="..." width="100px"
							height="100px">
						<div class="media-body">
							<h5 class="mt-0"><a
						href="/show?id=${c.id }">${c.title }</a></h5>
							作者:${c.user.username }
							浏览量:${c.hits }
						</div>
					</div>
					<hr>
				</c:forEach>
				<jsp:include page="/view/common/pages.jsp"></jsp:include>
			</div>
		</div>
		<div class="col-md-3">右侧</div>
	</div>
	<script type="text/javascript">
	function goPage(page) {
		var channelId = '${article.channelId}';//栏目ID
		var categoryId = '${article.categoryId}';//分类ID
		var hot = '${article.hot}';//热点
		location="/?page="+page+"&channelId="+channelId+"&categoryId="+categoryId+"&hot="+hot
	}
	</script>
</body>
</html>
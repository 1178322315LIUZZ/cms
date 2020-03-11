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
<title>今日头条</title>
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
		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				<font color="white" size="2px" style="margin-left: 10px">下载APP</font>
				<div style="float: right">
					<button type="button" class="btn btn-link" onclick="reg()" data-toggle="modal" style="background-color: #222222; height: 34px"
						data-target="#exampleModal">注册</button>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2" style="padding-top: 10px">
				<ul>
					<li><a class="channel"> <img alt=""
							src="/view/common/logo-index.png"
							style="width: 108px; height: 27px; margin-bottom: 5px">

					</a></li>
					<li><a href="/?hot=1 "
						class="channel-item ${article.channelId==channel.id?'active':'' }">热点</a></li>
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
							<li
								class="sub-item ${article.categoryId==null?'sub-selected':'' }"><a
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
					<div id="carouselExampleCaptions" class="carousel slide"
						data-ride="carousel" style="margin-top: 5px">
						<ol class="carousel-indicators">
							<c:forEach items="${li }" var="li" varStatus="i">
								<li data-target="#carouselExampleCaptions"
									data-slide-to="${i.index }" class="active"></li>
							</c:forEach>
						</ol>
						<div class="carousel-inner">
							<c:forEach items="${li }" var="li" varStatus="i">
								<div class="carousel-item ${i.index==0?"active":"" }">
									<img src="/pic/${li.url }" class="d-block w-100" alt=""
										style="width: 175px; height: 400px">
									<div class="carousel-caption d-none d-md-block">
										<h5>${li.title }</h5>
									</div>
								</div>
							</c:forEach>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</c:if>
				<div>
					<c:forEach items="${g }" var="c">
						<div class="media" style="margin-top: 5px">
							<img src="/pic/${c.picture }" class="mr-3" alt="..."
								width="100px" height="100px">
							<div class="media-body">
								<h5 class="mt-0">
									<a href="/show?id=${c.id }">${c.title }</a>
								</h5>
								作者:${c.user.username }&nbsp;&nbsp; 浏览量:${c.hits }
							</div>
						</div>
						<hr>
					</c:forEach>
					<jsp:include page="/view/common/pages.jsp"></jsp:include>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card-header">最新文章</div>
				<div class="card" style="width: 18rem;">
					<c:forEach items="${ss }" var="ss">
						<img src="/pic/${ss.picture }" class="card-img-top" alt="..." style="width: 60px;height: 60px">
					<div class="card-body">
						<p class="card-text">${ss.title }</p>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">用户注册</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="reg">
					
					</div>
				
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function goPage(page) {
			var channelId = '${article.channelId}';//栏目ID
			var categoryId = '${article.categoryId}';//分类ID
			var hot = '${article.hot}';//热点
			location = "/?page=" + page + "&channelId=" + channelId
					+ "&categoryId=" + categoryId + "&hot=" + hot
		}
		function reg() {
			$("#reg").load("/passport/reg")
		}
		
	</script>
</body>
</html>
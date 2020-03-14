<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--??  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${g.title }</title>
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
	<div class="container-fluid">
		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				<font color="white" size="2px" style="margin-left: 10px">下载APP</font>
			</div>
			<div class="col-md-9">
			<div>
			<h1>标题:${g.title }</h1>
			<h6>作者:${g.user.username }</h6>
			${g.content }
			<hr>
			<c:if test="${sessionScope.user!=null }">
				<!-- 文章评论 -->
			<div>
				<h5>文章评论：</h5>
				<textarea rows="8" cols="20" style="width: 753px" name="content"></textarea>
				<br>
				<button type="button" onclick="addComment()" class="btn btn-info">提交评论</button>
			</div>
			</c:if>
			<div>
				<!-- 显示评论内容 -->
				<c:forEach items="${li}" var="comment">
					<h5>评论人:${comment.user.username} 评论时间:<fmt:formatDate value="${comment.created}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
				    
				    ${comment.content }
				  <hr>
				</c:forEach>
			</div>
		</div>
			</div>
			<div class="col-md-3">
			<h6>评论排行榜</h6>
			<div class="card" style="width: 18rem;">
					<c:forEach items="${ss }" var="ss" varStatus="i">
					<div class="card-body">
						<p class="card-text">${i.count }.${ss.title }</p>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
			function addComment() {
				var articleId='${article.id}';
				var content=$("[name='content']").val();
				$.post("/comment/insert",{articleId:articleId,content:content},function(as){
					if(as>0){
						alert("评论成功");
						window.location.reload();
					}else{
						alert("评论失败，需要登录后才能评论")
					}
				})
			}
		
		</script>
</body>
</html>
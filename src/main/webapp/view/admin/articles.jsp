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
<title>Insert title here</title>
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
<div class="form-group form-inline " >

 文章标题：
 <input type="text" name="title" class="form-control form-control-sm" value="${article.title }"> &nbsp;&nbsp;
审核状态：
 <select name="status" class="form-control form-control-sm col-sm-1">
  <option value="0" ${article.status=="0"?"selected":"" }>待审</option>
  <option value="1" ${article.status=="1"?"selected":"" }>已审</option>
  <option value="-1" ${article.status=="-1"?"selected":"" }>驳回</option>
 </div>
 </select>
 &nbsp;&nbsp;
 <button type="button" onclick="query()" class="btn btn-warning btn-sm">查询</button>
 <hr>
	<table class="table table-bordered table-hover table-sm">
		<tr>
			<td>序号</td>
			<td>标题</td>
			<td>作者</td>
			<td>发布时间</td>
			<td>所属栏目</td>
			<td>所属分类</td>
			<td>是否热门</td>
			<td>点击量</td>
			<td>其他</td>
		</tr>
		<c:forEach items="${g}" var="article" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td width="350px">${article.title }</td>
				<td>${article.user.username }</td>
				<td><fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>${article.channel.name }</td>
				<td>${article.category.name }</td>
				<td>
				  <c:if test="${article.hot==0}">
				   <button type="button" class="btn btn-info btn-sm">否</button>
				  </c:if>
				 <c:if test="${article.hot==1}">
				   <button type="button" class="btn btn-danger btn-sm">是</button>
				  </c:if>
				</td>
				<td>${article.hits }</td>
				<td><button type="button" class="btn btn-link">详情</button></td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
	function query(){
		  var status=$("[name='status']").val();
		  var title=$("[name='title']").val();
		  $("#center").load("/admin/articles?status="+status+"&title="+title);
	  }
	</script>
</body>
</html>
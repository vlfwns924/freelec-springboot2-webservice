<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 부트 웹서비스</title>
</head>
<body>
<jsp:include page="/WEB-INF/layout/header.jsp"></jsp:include>
	<h1>스프링 부트로 시작하는 웹 서비스 ver.2</h1>
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-6">
				<a href="/posts/save" role="button"
					class="btn btn-primary">글 등록</a>
			</div>
		</div>
		<br>
		<!-- 목록 출력 영역 -->
		<table class="table table-horizontal table-bordered">
			<thead class="thead-strong">
			<tr>
				<td>게시글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>최종수정일</td>
			</tr>
			</thead>
			<tbody id="tbody">
			<tr>
				<c:forEach items="${postsList}" var="posts">
					<td>${posts.id }</td>
					<td>${posts.title }</td>
					<td>${posts.author }</td>
					<td>${posts.modifiedDate }</td>
				</c:forEach>
			</tr>
			</tbody>
		</table>
	</div>
<jsp:include page="/WEB-INF/layout/footer.jsp"></jsp:include>
</body>
</html>


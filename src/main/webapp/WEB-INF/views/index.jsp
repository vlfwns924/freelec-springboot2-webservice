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
	<!-- 로그인 기능 영역 -->
	<div class="row">
		<div class="col-md-6">
			<a href="/posts/save" role="button" class="btn-btn-primary">글등록</a> 
			<c:if test="${!userName.empty}">
			Logged in as: <span id="user">${userName }</span>
			<a href="/logout" class="btn btn-info active" role="button">Logout</a>
			</c:if>
			<c:if test="${userName.empty}">			
			<a href="/oauth2/authorization/google" class="btn-btn-success active" role="button">Google Login</a>
			</c:if>
		</div>
	</div>
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
				<c:forEach items="${posts}" var="posts">
				<tr>
					<td>${posts.id }</td>
					<td><a href="/posts/update/${posts.id }">${posts.title }</a></td>
					<td>${posts.author }</td>
					<td>${posts.modifiedDate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<jsp:include page="/WEB-INF/layout/footer.jsp"></jsp:include>
</body>
</html>


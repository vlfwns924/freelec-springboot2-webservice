<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/layout/header.jsp"></jsp:include>
<h1>게시글 수정</h1>
<div class="col-md-12">
	<div class="col-md-4">
		<form>
			<div class="form-group">
				<label for="id">글 번호</label>
				<input type="text" class="form-control" id="id" value="${post.id}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" value="${post.title}">
			</div>
			<div class="form-group">
				<label for="author"> 작성자</label>
				<input type="text" class="form-control" id="author" value="${post.author}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="content"> 내용</label>
				<textarea class="form-control" id="content">${post.content }</textarea>
			</div>	
		</form>
		<a href="/" role="button" class="btn btn-secondary">취소</a>
		<button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>
		<button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
		
	</div>
</div>
<jsp:include page="/WEB-INF/layout/footer.jsp"></jsp:include>
</body>
</html>
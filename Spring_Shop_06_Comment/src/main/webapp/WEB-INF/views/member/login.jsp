<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<section class="py-5">
	<div class="container">
		<h1>회원 로그인</h1>
		<form action="/member/login" method="post">
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" placeholder="Enter email" name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pwd">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
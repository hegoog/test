<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<section class="py-5">
	<div class="container">
		<h1>회원 정보</h1>
		<table class="table table-hover">
      <tr >
        <th class="table-info">Email</th>
        <td>${mvo.email }</td>
      </tr>
      <tr >
        <th class="table-info">PWD</th>
        <td>${mvo.pwd }</td>
      </tr>
      <tr >
        <th class="table-info">NickName</th>
        <td>${mvo.nickname }</td>
      </tr>
      <tr >
        <th class="table-info">Register Date</th>
        <td>${mvo.regd8 }</td>
      </tr>
      <tr>
        <th colspan="2">
         <a href="/member/list?pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword}" class="btn btn-success">목록</a>
          <a href="/member/modify?email=${mvo.email }&pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword}" class="btn btn-warning">수정</a>
          <a href="/member/resign?email=${mvo.email }&pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword}" class="btn btn-outline-danger">탈퇴</a>
        </th>      
      </tr>
  </table>
	</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
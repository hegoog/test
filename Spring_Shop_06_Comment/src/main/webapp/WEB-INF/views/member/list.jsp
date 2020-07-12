<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<section class="py-5">
	<div class="container">
	<div class="float-right  form-group">
    <form action="/member/list" class="form-inline">
     <input type="hidden" name="pageNum" value="1"> 
     <input type="hidden" name="amount" value="${pgvo.cri.amount }"> 
    <div class="input-group">
      <div class="input-group-prepend">
        <select class="form-control" id="stype" name="type">
          <option value="e">이메일</option>
          <option value="n">닉네임</option>
          <option value="en">이메일+닉네임</option>
        </select>
      </div>
      <input type="text" class="form-control" name="keyword" placeholder="키워드를 입력하세요">
      <div class="input-group-append">
        <button class="btn btn-success" type="submit">검색</button>
      </div>
      </div>
    </form>
    </div>
		<h1>회원목록</h1>
		<table class="table table-hover">
    <thead>
      <tr class="table-info">
        <th>Email</th>
        <th>NickName</th>
        <th>Register Date</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${mList }" var="mvo">
      <tr>
        <td>${mvo.email }</td>
        <td><a href="/member/detail?email=${mvo.email }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">${mvo.nickname }</a></td>
        <td>${mvo.regd8 }</td>
        <c:if test="${sesInfo.email eq 'admin@admin.com'}">
        <td><a href="/member/modify?email=${mvo.email }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount}" class="btn btn-warning">수정</a>
          <a href="/member/resign?email=${mvo.email }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount}" class="btn btn-outline-danger">탈퇴</a></td>
         </c:if> 
      </tr>
      </c:forEach>

    </tbody>
  </table>
      <ul class="pagination">
      <c:if test="${pgvo.prev }">
        <li class="page-item"><a class="page-link"
          href="/member/list?pageNum=${pgvo.beginPagingNum-1 }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">Prev</a></li>
      </c:if>
      <c:forEach begin="${pgvo.beginPagingNum }"
        end="${pgvo.endPagingNum }" var="i">
        <li class="page-item ${pgvo.cri.pageNum==i? 'active':'' }"><a
          class="page-link"
          href="/member/list?pageNum=${i }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">
            ${i }</a></li>
      </c:forEach>
      <c:if test="${pgvo.next }">
        <li class="page-item"><a class="page-link"
          href="/member/list?pageNum=${pgvo.endPagingNum+1 }&amount=${pgvo.cri.amount}&type=${pgvo.cri.type}&keyword=${pgvo.cri.keyword}">Next</a></li>
      </c:if>
    </ul>
	</div>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
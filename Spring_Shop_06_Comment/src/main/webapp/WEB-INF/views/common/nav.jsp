<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--세션에서 정보가져오기  -->
<c:set var="sesInfo" value="${mInfo }" scope="session"/>   
   
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Solve the problem</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home  
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/product/list">상품목록</a>
          </li>
          <c:if test="${sesInfo eq'' || sesInfo eq null }">
          <li class="nav-item">
            <a class="nav-link" href="/member/join">회원가입</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/login">로그인</a>
          </li>
          </c:if>
          <c:if test="${sesInfo ne '' && sesInfo ne null }">
           <li class="nav-item">
            <a class="nav-link" href="#">${sesInfo.nickname } (${sesInfo.email })
            </a>&nbsp;&nbsp;
            <c:if test="${sesInfo.email eq 'admin@admin.com'}">
            <li class="nav-item">
            <a class="nav-link" href="/member/list">회원목록</a>
              </li>
            </c:if>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/logout">로그아웃</a>
          </li>	
          </c:if>
        </ul>
      </div>
    </div>
  </nav>
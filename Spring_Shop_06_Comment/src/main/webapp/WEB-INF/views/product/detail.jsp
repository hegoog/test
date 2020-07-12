<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>

<section class="py-5">
	<div class="container">
		<h1>상품 정보</h1>
		<table class="table table-hover">
      <tr >
        <th class="table-info">상품번호</th>
        <td>${pvo.pno }</td>
      </tr>
      <tr >
        <th class="table-info">조회수</th>
        <td>${pvo.readcount }</td>
      </tr>
      <tr >
        <th class="table-info">상품명</th>
        <td>${pvo.title }</td>
      </tr>
      <tr>
        <th class="table-info">상품내용</th>
        <td>${pvo.content }</td>
      </tr>
      <tr >
        <th class="table-info">작성자</th>
        <td>${pvo.writer }</td>
      </tr>
      <tr >
        <th class="table-info">가격</th>
        <td>${pvo.price }</td>
      </tr>
      <tr>
        <th class="table-info">등록일</th>
        <td>${pvo.regd8 }</td>
      </tr>
         <tr>
        <th class="table-info">최종 수정일</th>
        <td>${pvo.modd8 }</td>
      </tr>
        <tr>
        <th class="table-info">이미지 파일</th>
        <td><img src="/images/${pvo.imgfile }"></td>
      </tr>
      <tr>
        <th colspan="2">
        <a href="/product/list?pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword}" class="btn btn-success">목록</a>
       <c:if test="${sesInfo.email eq pvo.writer }">
          <a href="/product/modify?pno=${pvo.pno }&pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword}" class="btn btn-warning">수정</a>
          <a href="#" class="btn btn-outline-danger" id="delBtn">삭제</a>
      </c:if>
        </th>      
      </tr>
  </table>
  
  <form action="/product/remove" id="delForm" method="post">
  <input type="hidden" name="pno" value="${pvo.pno }">
  <input type="hidden" name="imgfile" value="${pvo.imgfile }">
  <input type="hidden" name="pageNum" value="${cri.pageNum }"> 
  <input type="hidden" name="amount" value="${cri.amount }">
  <input type="hidden" name="type" value="${cri.type}">
  <input type="hidden" name="keyword" value="${cri.keyword }">
  </form>
  <c:if test="${sesInfo.email ne '' }">
  <div class="input-group mt-3">
  <input type="text" id="cmtInput" class="form-control" placeholder="댓글을 입력하세요">
  <div class="input-group-append">
    <button class="btn btn-primary" type="button" id="cmtOkBtn">OK</button>
    <button class="btn btn-danger" type="button" id="cmtResetBtn">Cancel</button>
  </div>
  </div>
  </c:if>
<div id="cmtList">
  <ul class="nav nav-pills nav-justified">
    <li class="nav-item">작성자</li>
    <li class="nav-item">댓글내용</li>
    <li class="nav-item">작성일</li>
    <li class="nav-item">기능</li>
  </ul>
</div>
<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" id="modOkBtn" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>
	</div>
</section>




<script src="/resources/js/comment.js"></script>
<script>
$(function() {
	  
	  $("#delBtn").on("click",function(e){
		  e.preventDefault();
		  $("#delForm").submit();
	  });
	  /*Comment Part  */
	  let cmt_writer = '<c:out value="${sesInfo.nickname}"/>';  /*세션에서 닉네임값가져와서 넣기 */
	  let cmt_pno = '<c:out value="${pvo.pno}"/>';
	  listComment(cmt_pno);
	  $("#cmtOkBtn").on("click",function(){  /* 페이지로드할때가아닌 버튼을 누를때 값을 가져와야한다 */
		  let cmt_content = $("#cmtInput").val();
	   if(cmt_content == null || cmt_content ==''){
		   alert("댓글 내용을 입력해주세요");
		   return false;
	   }else{
		   let cmtData ={pno:cmt_pno,writer:cmt_writer,content:cmt_content};
		   /* json형태로 변환해서 텍스트로 한번에 보냄 . contentType 지정해줘야함 */
		   $.ajax({
               type: "post",
               url:"/comment/new",
               data: JSON.stringify(cmtData),
               contentType:"application/json; charset:utf-8"
            }).done(function(result){
            	  alert(result);
            	  listComment(cmt_pno);
            });
	   }
	  });
	   //동적으로 생성된 태그를찍고싶다 = document를찍는다
	    $(document).on("click",".modBtn",function(){
	      let parentsUl= $(this).closest("ul");   //수정버튼(this)에서 가장 가까운 ul
	      let writer = $(parentsUl).find("li:first-child").text(); //ul 밑 첫번째 li의 텍스트(작성자명) 가져오기
	      let content = $(parentsUl).find("li:nth-child(2)").text();
	      let cno =$(parentsUl).find("li:last-child button:first-child").data("cno"); //데이터 지정해논걸  data의 이름을 파라매터로 던지면뽑아올수있다
	      transferToModal(writer,content,cno);
	      });
	   
	    //모달 수정값 읽기
	     $(document).on("click","#modOkBtn",function(){
	    	 let content=$(document).find("#modInput").val();
	    	 let cno= $(document).find("#modInput").data("cno");
	    	 modifySubmit(cmt_pno,content,cno);
	    	 $(document).find(".close").click();
	     });
});
</script>

<jsp:include page="../common/footer.jsp"></jsp:include>



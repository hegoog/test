<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<jsp:include page="../common/nav.jsp"></jsp:include>
<section class="py-5">
  <div class="container">
    <h1>상품 등록</h1>

    <form action="/product/modify" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="title">상품번호:</label> 
        <input type="text" value=${pvo.pno } name="pno"  class="form-control" readonly>
      </div>
      <input type="hidden" name="pageNum" value="${cri.pageNum }"> 
      <input type="hidden" name="amount" value="${cri.amount }"> 
      <input type="hidden" name="type" value="${cri.type}">
       <input type="hidden" name="keyword" value="${cri.keyword }">
      
      <div class="form-group">
        <label for="title">등록자:</label> <input type="text"
          class="form-control" value="${sesInfo.email }" name="writer"
          readonly>
      </div>
      <div class="form-group">
        <label for="title">상품명:</label> <input type="text"
          class="form-control" placeholder="상품명을 입력하세요" name="title"
          value="${pvo.title }">
      </div>
      <div class="form-group">
        <label for="title">상세정보:</label>
        <textarea class="form-control" name="content" cols="5">${pvo.content }</textarea>
      </div>

      <div class="form-group">
        <label for="title">상품 가격:</label> <input type="number"
          class="form-control" placeholder="가격을 입력하세요" name="price"
          value="${pvo.price }">
      </div>
      <div class="form-group">
        <label for="title">기존 이미지:</label>  <!--기존에 있던 파일을 지우기 위해 기존 파일명이 필요하다  !-->
        <input type="text" 
          class="form-control" name="old_imgfile" value="${pvo.imgfile }" readonly>
      </div>
      <div class="form-group">
        <label for="title">이미지:</label> <input type="file"
          class="form-control" placeholder="이미지파일을 등록하세요" name="imgfile">
      </div>

      <button type="submit" class="btn btn-primary" id="modSubmit">수정하기</button>
    </form>
  </div>
</section>
<script>
$(function() {
  $("#modSubmit").on("click",function(e){
    e.preventDefault();
    let imgfileName= $("input[type=file]").val();
        let hiddenVal ='<input type="hidden" id="hidVal" name="delImg" value="">';
        $("form").prepend(hiddenVal).trigger("create");
    if (imgfileName ==''){
        let isOk =confirm("첨부된 파일이 삭제되어도 괜찮습니까?");  
        isOk== true ? $(document).find("#hidVal").val("1") : $(document).find("#hidVal").val("0"); 
    }else{
        $(document).find("#hidVal").val("2");
    }
    $("form").submit();
  });
});
</script>




<jsp:include page="../common/footer.jsp"></jsp:include>
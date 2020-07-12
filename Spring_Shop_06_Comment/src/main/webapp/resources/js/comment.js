//모달 수정정보 DB에 전송하고 리스트다시불러옴 
function modifySubmit(pno,content,cno){
	 let modData={content:content,cno:cno};
	 $.ajax({
		url:"/comment/"+cno,
		type:"put",
		data: JSON.stringify(modData),
	 	contentType:"application/json; charset=utf-8"
	 }).done(function(result){
		alert(result);
		listComment(pno);
	 });
 }




//모달에 댓글 기존 정보 읽어와서 출력하기
function transferToModal(writer,content,cno){
	$(document).find(".modal-title").text(writer);
	let modInput= '<input type="text" data-cno="'+cno+'" class="form-control" value="'+content+'" id="modInput">';
	$(document).find(".modal-body").html(modInput);
	return [writer,cno];
}





function printListComment(listArr) {
	$("#cmtList ul:first-child").nextAll().remove();
	for (let cvo of listArr) {
		let ulTag ='<ul class="nav nav-pills nav-justified">';
		ulTag += '<li class="nav-item">'+cvo.writer+'</li>';
		ulTag += '<li class="nav-item">'+cvo.content+'</li>';
		ulTag += '<li class="nav-item">'+cvo.modd8+'</li>';
		ulTag += '<li class="nav-item"><button data-toggle="modal" data-target="#myModal" data-cno="'+cvo.cno+'" class="btn btn-outline-warning modBtn">수정</button>';//버튼에 값을 등록해서 자바스크립트가 값을 읽을수있다
		ulTag += '<button data-toggle="modal" data-target="#myModal" data-cno="'+cvo.cno+'" class="btn btn-outline-danger">삭제</button></li></ul>'
		$("#cmtList").append(ulTag);
	}
}

function listComment(param_pno) {
	$.getJSON("/comment/list/"+param_pno+".json",function(cList){
		//json Data를 GET하겠다  pno값보낼테니json 파일만 줘라하고 컨트롤러에 요청 (잭슨 라이브러리 필요)
		//컨트롤러에서 스트링으로 JSON이 들어온다
		printListComment(cList);
		console.log(cList);
	}).fail(function() {
		alert("댓글 리스트 출력 실패")
	});
}
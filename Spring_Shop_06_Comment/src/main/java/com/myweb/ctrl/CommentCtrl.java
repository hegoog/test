package com.myweb.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.CommentVO;
import com.myweb.service.CommentService;

@RestController
@RequestMapping("/comment/*")
public class CommentCtrl {
	private static Logger log = LoggerFactory.getLogger(CommentCtrl.class);
	
	@Inject
	CommentService csv;
	
	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},  //put Patch방식 둘다받는다
			value="/{cno}", consumes = "application/json",
							produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> modify(@PathVariable("cno")int cno,@RequestBody CommentVO cvo){
		return csv.modify(cvo) ==1 ? new ResponseEntity<String> ("댓글이 수정되었습니다",HttpStatus.OK) 
				: new ResponseEntity<String> ("댓글수정 실패",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// 패스변수: 주소를 변수의 값으로 받겠다  내가 변수명을 직접지정할수있음 cosumes 받겠다 produces 수행하겠다
		@GetMapping(value="/list/{pno}",    
					produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})   //보낼 타입의 데이터 형식을맞춤
		public ResponseEntity<List<CommentVO>> list(@PathVariable("pno")int pno){
			//ArrayList<CommentVO> cList= (ArrayList<CommentVO>) csv.getList(pno);
			return new ResponseEntity<List<CommentVO>>(csv.getList(pno),HttpStatus.OK); //뽑아온 리스트를 json데이터타입으로 반환함
		}
		
	@PostMapping(value="/new",consumes="application/json", //데이터는 json타입으로 받고 text방식으로 처리하겟다
			produces="application/text; charset=UTF-8")
	public ResponseEntity<String> write(@RequestBody CommentVO cvo){ //requestbody에서 JSON 텍스트 값을 받아서 CVO형태에 넣겠다 (vo객체내용이랑 일치해야함) 
		int isOk=csv.write(cvo);
		return isOk==1 ? new ResponseEntity<>("댓들이 등록되었습니다",HttpStatus.OK): new ResponseEntity<>("댓들이 등록이 실패하였습니다",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}

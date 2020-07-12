package com.myweb.ctrl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.Criterion;
import com.myweb.domain.PagingVO;
import com.myweb.domain.ProductVO;
import com.myweb.service.ProductService;
import com.myweb.util.FileProcessor;

@Controller
@RequestMapping("/product/*")
public class ProductCtrl {
	private static Logger log = LoggerFactory.getLogger(ProductCtrl.class);
	
	@Inject 
	ProductService psv;
	
	@Inject
	FileProcessor fp;
	
	@GetMapping("/list")
	public void list(Model model,Criterion cri) { 
		model.addAttribute("pList", psv.getList(cri)); //cri에 등록한 1페이지,10개를보기위해 db에던짐
		int totalCount= psv.getTotalCount(cri);
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	}
	
	@GetMapping("/write")  //작성페이지로 이동
	public void write() {}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest multiReq,RedirectAttributes reAttr) {
		/*
		 * if(pvo.getImgfile() ==null) { pvo.setImgfile("NONE"); } psv.register(pvo);
		 */
		int isIn=psv.register(fp.fileSave(multiReq));   //filesave의 리턴값이 pvo다
		if(isIn >0) {
			reAttr.addAttribute("pSign", "상품입력이 완료되었습니다");
		}
		
		return "redirect:/product/list";
	}
	
	@GetMapping({"/detail", "/modify" })  
	public void detail(@RequestParam("pno")int pno,Model model,
			@ModelAttribute ("cri")Criterion cri) { //anotation : cri라는 이름으로 cri객체를 보내겠다 
		model.addAttribute("pvo",psv.getProduct(pno));
		//model.addAttribute("cri", cri);
	}
	
	@PostMapping("/modify")
	public String modify(MultipartHttpServletRequest multiReq,Criterion cri,RedirectAttributes reAttr) {
		psv.modify(fp.fileModify(multiReq));
		reAttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/product/detail?pno="
		+multiReq.getParameter("pno")
		+"&pageNum="+cri.getPageNum()
		+"&amount="+cri.getAmount()
		+"&type="+cri.getType();
		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno")int pno,@RequestParam("imgfile")String imgfile,RedirectAttributes reAttr,
			Criterion cri){
		int isRm=fp.removeFile(imgfile);
			isRm=psv.remove(pno);
		if(isRm>0) {
			reAttr.addFlashAttribute("msg","삭제되었습니다");
		}
		//reAttr.addAttribute("keyword", cri.getKeyword());
		String encodedKeyword=null;
		try {
			encodedKeyword=URLEncoder.encode(cri.getKeyword(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/product/list?pageNum="+cri.getPageNum()
				+"&amount="+cri.getAmount()
				+"&type="+cri.getType();		
	}
	
	
}

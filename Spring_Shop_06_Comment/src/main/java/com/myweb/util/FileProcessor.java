package com.myweb.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myweb.domain.ProductVO;

@Component
public class FileProcessor {
   private static Logger log = LoggerFactory.getLogger(FileProcessor.class);
   private static final String filePath = "C:/_web/_spring/upimg/";

   public ProductVO fileModify(MultipartHttpServletRequest multiReq) {
      int modSign = Integer.parseInt(multiReq.getParameter("delImg"));
      String title = multiReq.getParameter("title");
      String content = multiReq.getParameter("content");
      String writer = multiReq.getParameter("writer");
      int price = Integer.parseInt(multiReq.getParameter("price"));
      String old_imgfileName = multiReq.getParameter("old_imgfile");
      int pno = Integer.parseInt(multiReq.getParameter("pno"));
      String imgfileName = "";
      if(modSign == 0) {
         imgfileName = old_imgfileName;
      }else if(modSign == 1) {         
         new File(filePath+old_imgfileName).delete();
         imgfileName = "NONE";         
      }else if(modSign==2) {         
         MultipartFile imgfileObj = multiReq.getFile("imgfile");         
         if (imgfileObj.getSize() == 0) {
            imgfileName = "NONE";
         } else {
            String orgFileName = imgfileObj.getOriginalFilename();
            String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName;
            File fileObj = new File(filePath + saveFileName);
            try {
               imgfileObj.transferTo(fileObj);
               
               if (!old_imgfileName.equals("NONE")) { // 기존 이미지 파일 있을경우
                  new File(filePath+old_imgfileName).delete();               
               }
               imgfileName = saveFileName;
            } catch (IllegalStateException | IOException e) {
               log.info(">>> File Save Fail");
               e.printStackTrace();
            }
         }         
      }      
      ProductVO pvo = new ProductVO(title, content, writer, price, imgfileName, pno);
      return pvo;
   }

   public ProductVO fileSave(MultipartHttpServletRequest multiReq) {
      String title = multiReq.getParameter("title");
      String content = multiReq.getParameter("content");
      String writer = multiReq.getParameter("writer");
      int price = Integer.parseInt(multiReq.getParameter("price"));
      MultipartFile imgfileObj = multiReq.getFile("imgfile");
      String imgfileName = "";

      if (imgfileObj.getSize() == 0) {
         imgfileName = "NONE";
      } else {
         String orgFileName = imgfileObj.getOriginalFilename();
         String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName;
         File fileObj = new File(filePath + saveFileName);
         try {
            imgfileObj.transferTo(fileObj);
            imgfileName = saveFileName;
         } catch (IllegalStateException | IOException e) {
            log.info(">>> File Save Fail");
            e.printStackTrace();
         }
      }
      ProductVO pvo = new ProductVO(title, content, writer, price, imgfileName);
      return pvo;
   }

public int removeFile(String imgfile) {
	boolean isRm=new File(filePath+imgfile).delete();
	return isRm==true? 1:0;
}

}
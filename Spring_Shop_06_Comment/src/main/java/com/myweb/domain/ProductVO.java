package com.myweb.domain;

import java.sql.Date;

public class ProductVO {

			private int pno;
			private String title;
			private String content;
			private String writer; 
			private int price;
			private int readcount;
			private Date regd8;
			private Date modd8;
			private String imgfile;
			
			public ProductVO() {}

			//등록
			public ProductVO(String title, String content, String writer, int price, String imgfile) {
				this.title = title;
				this.content = content;
				this.writer = writer;
				this.price = price;
				this.imgfile = imgfile;
			}
			
			//수정용 (등록에 pno 추가)
			public ProductVO(String title, String content, String writer, int price, String imgfile,int pno) {
				this(title,content,writer,price,imgfile);
				this.pno = pno;
			}

			
			public int getPno() {
				return pno;
			}

			public void setPno(int pno) {
				this.pno = pno;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public String getWriter() {
				return writer;
			}

			public void setWriter(String writer) {
				this.writer = writer;
			}

			public int getPrice() {
				return price;
			}

			public void setPrice(int price) {
				this.price = price;
			}

			public int getReadcount() {
				return readcount;
			}

			public void setReadcount(int readcount) {
				this.readcount = readcount;
			}

			public Date getregd8() {
				return regd8;
			}

			public void setregd8(Date regd8) {
				this.regd8 = regd8;
			}

			public Date getModd8() {
				return modd8;
			}

			public void setModd8(Date modd8) {
				this.modd8 = modd8;
			}

			public String getImgfile() {
				return imgfile;
			}

			public void setImgfile(String imgfile) {
				this.imgfile = imgfile;
			}
			
			
			
			
	
			
}

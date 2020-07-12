package com.myweb.domain;


public class Criterion {
	private int amount; //한 페이지에 보여줄 글의 수
	private int pageNum; //몇번째 페이지인가?
	private String type;
	private String keyword;
	
	public Criterion() { //페이지를 처음요청하는 순간 (new로 호출할때)
		this(10,1); //1번 페이지에 10개보여줘라
	}

	public Criterion(int amount, int pageNum) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}

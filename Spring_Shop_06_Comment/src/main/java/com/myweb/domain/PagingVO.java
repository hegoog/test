package com.myweb.domain;


public class PagingVO {
	private int totalCount; //총 게시글 수
	private int beginPagingNum; //페이징라인의 가장 앞 번호  (첫 페이지, 마지막 페이지에 대한 구별이 필요함)
	private int endPagingNum; //페이징라인의 가장 뒷 번호
	private boolean prev,next; //앞으로, 다음으로 버튼 생성 여부
	private Criterion cri; //페이징 구현을 위한 기준 객체
	
	public PagingVO() {}

	public PagingVO(int totalCount,Criterion cri){
		this.totalCount=totalCount;
		this.cri=cri;
		this.endPagingNum =(int)(Math.ceil(cri.getPageNum()/(double)(cri.getAmount())))*cri.getAmount(); //ceil 올림
		this.beginPagingNum= this.endPagingNum-(cri.getAmount()-1);
		//DB에서 가져온 실제 글 갯수를 기준으로 만든 마지막페이지
		int realEndPagingNum = (int)(Math.ceil(totalCount*1.0/cri.getAmount()));
		
		//계산된 마지막 페이징번호가 실제보다 많으면  실제 존재할수있는 페이징번호로 출력
		if(this.endPagingNum >=realEndPagingNum) { 
			this.endPagingNum=realEndPagingNum;
		}
		this.prev = beginPagingNum >1; 
		this.next = this.endPagingNum < realEndPagingNum; //미리 계산해서 표시되는 10단위수 < 실제 페이지수일때 다음버튼
		
	}
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBeginPagingNum() {
		return beginPagingNum;
	}

	public void setBeginPagingNum(int beginPagingNum) {
		this.beginPagingNum = beginPagingNum;
	}

	public int getEndPagingNum() {
		return endPagingNum;
	}

	public void setEndPagingNum(int endPagingNum) {
		this.endPagingNum = endPagingNum;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criterion getCri() {
		return cri;
	}

	public void setCri(Criterion cri) {
		this.cri = cri;
	}
	
	
	
}

package com.myweb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

public interface ProductService {
	public int register(ProductVO pvo);
	public List<ProductVO> getList(Criterion cri);
	public ProductVO getProduct(int pno);
	public int modify(ProductVO pvo);
	public int remove(int pno);
	public int getTotalCount(Criterion cri);
}

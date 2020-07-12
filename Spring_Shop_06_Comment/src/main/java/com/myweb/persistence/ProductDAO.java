package com.myweb.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

public interface ProductDAO {
	public int insertProduct(ProductVO pvo);
	public List<ProductVO> selectList(Criterion cri);
	public ProductVO selectProduct(int pno);
	public int updateProduct(ProductVO pvo);
	public int deleteProduct(int pno);
	public int hit(int pno);
	public int selectTotalCount(Criterion cri);
}

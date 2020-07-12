package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criterion;
import com.myweb.domain.ProductVO;

@Repository //root-context에서 component하는데 DAO는 기능이 많아서 Repository로 이름붙여서씀
public class ProductDAOImpl implements ProductDAO{
	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	private static String ns="ProductMapper.";
	
	@Inject   //root-context에서 가져온다
	SqlSession sql;
	
	@Override
	public int insertProduct(ProductVO pvo) {
		return sql.insert(ns+"add", pvo);
	}

	@Override
	public List<ProductVO> selectList(Criterion cri) {
		return sql.selectList(ns+"list",cri);
	}

	@Override
	public ProductVO selectProduct(int pno) {
		return sql.selectOne(ns+"detail", pno);
	}

	@Override
	public int updateProduct(ProductVO pvo) {
		return sql.update(ns+"modify", pvo);
	}

	@Override
	public int deleteProduct(int pno) {
		return sql.delete(ns+"remove", pno);
	}

	@Override
	public int hit(int pno) {
		return sql.update(ns+"hit",pno);
	}

	@Override
	public int selectTotalCount(Criterion cri) {
		return sql.selectOne(ns+"totalCount",cri);
	}
	

}

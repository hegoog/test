package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO {
	private static Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private static String ns="CommentMapper.";
	@Inject
	SqlSession sql;

	@Override
	public int insertComment(CommentVO cvo) {
		return sql.insert(ns+"add", cvo);
	}

	@Override
	public List<CommentVO> selectList(int pno) {
		return sql.selectList(ns+"list", pno);
	}

	@Override
	public int updateComment(CommentVO cvo) {
		return sql.update(ns+"modify", cvo);
	}

	@Override
	public int deleteComment(int cno) {
		return sql.delete(ns+"remove", cno);
	}
}

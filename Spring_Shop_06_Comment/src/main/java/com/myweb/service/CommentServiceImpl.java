package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.CommentVO;
import com.myweb.persistence.CommentDAO;
@Service
public class CommentServiceImpl implements CommentService {
	private static Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Inject
	CommentDAO cdao;

	@Override
	public int write(CommentVO cvo) {
		return cdao.insertComment(cvo);
	}

	@Override
	public List<CommentVO> getList(int pno) {
		return cdao.selectList(pno);
	}

	@Override
	public int modify(CommentVO cvo) {
		return cdao.updateComment(cvo);
	}

	@Override
	public int remove(int cno) {
		return cdao.deleteComment(cno);
	}
}

package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.CommentVO;

public interface CommentDAO {
	public int insertComment(CommentVO cvo);
	public List<CommentVO> selectList(int pno);
	public int updateComment(CommentVO cvo);
	public int deleteComment(int cno);
}

package com.myweb.service;

import java.util.List;

import com.myweb.domain.CommentVO;

public interface CommentService {
	public int write(CommentVO cvo);
	public List<CommentVO> getList(int pno);
	public int modify(CommentVO cvo);
	public int remove(int cno);
}

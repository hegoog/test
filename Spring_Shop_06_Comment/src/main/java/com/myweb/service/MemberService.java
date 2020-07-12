package com.myweb.service;

import java.util.List;

import com.myweb.domain.Criterion;
import com.myweb.domain.MemberVO;

public interface MemberService {
	public int register(MemberVO mvo);
	public int checkDuple(String email);
	public MemberVO login(MemberVO mvo);
	public List<MemberVO> getList(Criterion cri);
	public MemberVO getInfo(String email);
	public int modify(MemberVO mvo);
	public int resign(String email);
	public int getTotalCount(Criterion cri);
}

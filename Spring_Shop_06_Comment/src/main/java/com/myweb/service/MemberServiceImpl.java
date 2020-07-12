package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.Criterion;
import com.myweb.domain.MemberVO;
import com.myweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	private static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	MemberDAO mdao;
	
	@Override
	public int register(MemberVO mvo) {
		
		return mdao.insertMember(mvo);
	}

	@Override
	public int checkDuple(String email) {
		return mdao.selectEmail(email);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectMember(mvo);
	}

	@Override
	public List<MemberVO> getList(Criterion cri) {
		return mdao.selectList(cri);
	}

	@Override
	public MemberVO getInfo(String email) {
		return mdao.selectInfo(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		return mdao.updateMember(mvo);
	}

	@Override
	public int resign(String email) {
		return mdao.deleteMember(email);
	}

	@Override
	public int getTotalCount(Criterion cri) {
		return mdao.totalcount(cri);
	}
}

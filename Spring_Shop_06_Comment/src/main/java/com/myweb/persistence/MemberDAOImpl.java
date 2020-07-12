package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criterion;
import com.myweb.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static String ns = "MemberMapper.";

	@Inject
	SqlSession sql;

	@Override
	public int insertMember(MemberVO mvo) {
		return sql.insert(ns + "join", mvo);
	}

	@Override
	public int selectEmail(String email) {
		return sql.selectOne(ns + "check", email);
	}

	@Override
	public MemberVO selectMember(MemberVO mvo) {
		return sql.selectOne(ns + "login", mvo);
	}

	@Override
	public List<MemberVO> selectList(Criterion cri) {
		return sql.selectList(ns + "mlist",cri);
	}

	@Override
	public MemberVO selectInfo(String email) {
		return sql.selectOne(ns + "mInfo", email);
	}

	@Override
	public int updateMember(MemberVO mvo) {
		return sql.update(ns + "modify", mvo);
	}

	@Override
	public int deleteMember(String email) {
		return sql.delete(ns + "resign", email);

	}

	@Override
	public int totalcount(Criterion cri) {
		return sql.selectOne(ns+"total", cri);
	}

}

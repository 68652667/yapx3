package com.kh.yapx3.user.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.user.model.dao.MemberDao;
import com.kh.yapx3.user.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao;

	@Override
	public Member selectOneMember(String memberId) {
		return mDao.selectOneMember( memberId );
	}

	@Override
	public int insertMember(Member member) {
		return mDao.insertMember( member );
	}

	@Override
	public int updateMember(Member member) {
		return mDao.updateMember( member );
	}

	@Override
	public List<Member> selectMemberList(int cPage) {
		return mDao.selectMemberList( cPage );
	}

	@Override
	public int selectMemberTotal() {
		return mDao.selectMemberTotal();
	}
}

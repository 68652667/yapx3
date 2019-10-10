package com.kh.yapx3.user.model.service;

import java.util.List;

import com.kh.yapx3.user.model.vo.Member;

public interface MemberService {

	int NUM_PER_PAGE = 10;

	Member selectOneMember(String memberId);

	int insertMember(Member member);

	int updateMember(Member member);

	List<Member> selectMemberList(int cPage);

	int selectMemberTotal();

}

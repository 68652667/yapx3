package com.kh.yapx3.user.model.service;

import com.kh.yapx3.user.model.vo.Member;

public interface MemberService {

	Member selectOneMember(String memberId);

	int insertMember(Member member);

	int updateMember(Member member);

}

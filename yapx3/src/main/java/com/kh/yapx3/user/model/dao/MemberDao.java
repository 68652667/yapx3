package com.kh.yapx3.user.model.dao;

import com.kh.yapx3.user.model.vo.Member;

public interface MemberDao {

	Member selectOneMember(String memberId);

	int insertMember(Member member);

	int updateMember(Member member);

}

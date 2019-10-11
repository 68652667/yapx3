package com.kh.yapx3.user.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.board.free.model.service.FreeService;
import com.kh.yapx3.user.model.service.MemberService;
import com.kh.yapx3.user.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlS;

	Logger logger = LoggerFactory.getLogger( getClass() );
	
	@Override
	public Member selectOneMember(String memberId) {
		return sqlS.selectOne( "user.selectOneMember", memberId);
	}

	@Override
	public int insertMember(Member member) {
		//logger.info( "member={}", member );
		return sqlS.insert( "user.insertMember", member);
	}

	@Override
	public int updateMember(Member member) {
		return sqlS.update( "user.updateMember", member);
	}

	@Override
	public List<Member> selectMemberList(int cPage) {
		int offset = (cPage-1)*MemberService.NUM_PER_PAGE;
		int limit = MemberService.NUM_PER_PAGE;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return sqlS.selectList("user.selectMemberList",null,rowBounds);

	}

	@Override
	public int selectMemberTotal() {
		return sqlS.selectOne( "user.selectMemberTotal");
	}
}


package com.kh.yapx3.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.yapx3.user.model.vo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Autowired
	SqlSessionTemplate sqlS;

	Logger logger = LoggerFactory.getLogger( getClass() );
	
	@Override
	public int selectCount(String memberId) {
		return sqlS.selectOne( "message.selectCount", memberId );
	}

	@Override
	public List<Message> selectMessage(String memberId) {
		return sqlS.selectList( "message.selectMessage", memberId );
	}

	@Override
	public Message selectOnebyNo(int msgNo) {
		return sqlS.selectOne( "message.selectOnebyNo", msgNo );
	}

}

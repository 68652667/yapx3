package com.kh.yapx3.user.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.yapx3.user.model.dao.MemberDao;
import com.kh.yapx3.user.model.dao.MessageDao;
import com.kh.yapx3.user.model.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao mDao;
	
	@Override
	public int selectCount(String memberId) {
		return mDao.selectCount( memberId );
	}

	@Override
	public List<Message> selectMessage(String memberId) {
		return mDao.selectMessage( memberId );
	}

	@Override
	public Message selectOnebyNo(int msgNo) {
		return mDao.selectOnebyNo( msgNo );
	}

	@Override
	public int updateMessage(Message msg) {
		return mDao.updateMessage( msg );
	}

}

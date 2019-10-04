package com.kh.yapx3.user.model.dao;

import java.util.List;

import com.kh.yapx3.user.model.vo.Message;

public interface MessageDao {

	int selectCount(String memberId);

	List<Message> selectMessage(String memberId);

	Message selectOnebyNo(int msgNo);

	int updateMessage(Message msg);

	int insertMessage(Message msg);

}

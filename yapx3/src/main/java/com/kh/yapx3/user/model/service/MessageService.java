package com.kh.yapx3.user.model.service;

import java.util.List;

import com.kh.yapx3.user.model.vo.Message;

public interface MessageService {

	int selectCount(String memberId);

	List<Message> selectMessage(String memberId);

	Message selectOnebyNo(int msgNo);

}

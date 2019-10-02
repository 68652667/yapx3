package com.kh.yapx3.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.yapx3.user.model.service.MessageService;
import com.kh.yapx3.user.model.vo.Message;

@RequestMapping( "/message" )
@Controller
public class MessageController {

	@Autowired
	MessageService ms;
	Logger logger = LoggerFactory.getLogger( getClass() );
	
	@ResponseBody
	@RequestMapping( "/messageCount.do" )
	public int activeCheck( @RequestParam String memberId ) {
		
		logger.info( "memberId={}", memberId );
		int count = ms.selectCount( memberId );
		
		return count;
	}
	
	@ResponseBody
	@RequestMapping( "/getMsg.do" )
	public Message getMsg( @RequestParam int msgNo ) {
		logger.info( "getMsg msgNo={}", msgNo );
		Message msg = ms.selectOnebyNo( msgNo );
		
		return msg;
	}
	
	@RequestMapping( "/message" )
	public void messagePopup( @RequestParam String memberId,
							  Model m ) {
		
		List<Message> list = ms.selectMessage( memberId );
		m.addAttribute( "list", list );
	}
}

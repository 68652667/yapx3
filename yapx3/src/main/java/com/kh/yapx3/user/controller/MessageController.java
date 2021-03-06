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
		
		//logger.info( "memberId={}", memberId );
		int count = ms.selectCount( memberId );
		
		return count;
	}
	
	/**
	 * 
	 * @param msgNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping( "/getMsg.do" )
	public Message getMsg( @RequestParam int msgNo ) {
		//logger.info( "getMsg msgNo={}", msgNo );
		Message msg = ms.selectOnebyNo( msgNo );
		
		msg.setMessageRead( "Y" );
		
		int result = ms.updateMessage( msg );
		
		return msg;
	}
	
	@RequestMapping( "/message" )
	public void messagePopup( @RequestParam String memberId,
							  Model m ) {
		
		List<Message> list = ms.selectMessage( memberId );
		m.addAttribute( "list", list );
	}
	
	@RequestMapping( "/messageSned" )
	public String messagePopup( @RequestParam String memberId,
			@RequestParam String sendEmail,
			@RequestParam String sendNickName,
			Model m ) {
		
		List<Message> list = ms.selectMessage( memberId );
		m.addAttribute( "list", list );
		m.addAttribute( "sendEmail", sendEmail );
		m.addAttribute( "sendNickName", sendNickName );
		
		return "message/message";
	}
	
	@RequestMapping( "/sendMsg.do" )
	public String sendMsg( Message msg, Model m ) {
		
		//logger.info( "send msg = {}", msg);
		int result = ms.insertMessage( msg );
		
		//logger.info( "설마 또!? 1 이 아니라 -21어찌고?? ={}", result );
		
		//2.view단처리
		if( result == 1 ) {
			m.addAttribute( "msg", "쪽지 보내기 성공!" );
		}else if( result == -2147482646 ) {
			m.addAttribute( "msg", "쪽지 보내기 성공!" );
		}else {
			m.addAttribute( "msg", "쪽지 보내기 실패!" );
		}
		m.addAttribute( "loc", "/message/message?memberId=" + msg.getSendUserEmail() );
		return "common/msg";
	}
}

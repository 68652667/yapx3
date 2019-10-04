package com.kh.yapx3.board.summonerJobs.util;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	
	private Map<String, WebSocketSession> sessions = new HashMap<String, WebSocketSession>();
	
	Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	
	// 소환사 입장 입장확인하기
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		//맵을 쓸때 방법
		sessions.put(session.getId(), session);
		//세션값을 불러온
		//0번째 중괄호에 session.getId()을 넣으라는 것
		logger.info("{} 연결됨", session.getId());
		
		//세션값을 가지고 데이터베이스등의 작업을 하면 채팅 참여 사용자 정보 리스트를 구현할 수 있다.
		// 유저가 입장을 할때 입장했다고 알릴수 있는 메소드
		System.out.println("채팅방 입장자 : " + session.getPrincipal().getName());
	}
	// 메세지를 주고 받을 메소드
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		//0번째 중괄호에 session.getId()을 넣고 1번째 중괄호에는 message.gerPayload()를 넣음
		logger.info("{}로 부터 {}를 받았습니다.", session.getId(), message.getPayload());
		//logger.info("{}로 부터 {}를 받았습니다.", new String[]{session.getId(), message.getPayload()});
		
		//연결된 모든 클라이언트에게 메세지 전송 : 리스트 방법
		//getPrincipal()를 이용해서 세션에 물려있는 유저의 정보를 불러온다. 세션의 정보는 User를 이용한것과 동일하다.
		//for(WebSocketSession sess : sessionList) {
		//	sess.sendMessage(new TextMessage(session.getPrincipal().getName() + "|" + message.getPayload()));
		//}
		
		//맵 방법
		//나는 이걸 이용해야 할듯하다
		Iterator<String> sessionIds = sessions.keySet().iterator();
		String sessionId = "";
		while(sessionIds.hasNext()) {
			sessions.get(sessionId).sendMessage(new TextMessage("echo : " + message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		//List 삭제
		//sessionList.remove(session);
		
		//Map 삭제
		sessions.remove(session.getId());
		
		logger.info("{} 연결 끊김", session.getId());
		
		System.out.println("채팅방 퇴장자 : " + session.getPrincipal().getName());
	}
	
	
	
}

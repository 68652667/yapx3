package com.kh.yapx3.board.summonerJobs.ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/robi")
public class ChatSocket {
	private Set<Session> clients = Collections.synchronizedSet( new HashSet<Session>( ) );
	
	Logger logger = LoggerFactory.getLogger( getClass( ) );
	
	@OnMessage
	public void onMessage( String message, Session session ) throws IOException {
		//logger.info( "message1={}", message );
		
		synchronized( clients ) {
			//logger.info( "message2={}", message );
			for( Session client : clients ) {
				
				//logger.info( "message3={}", message );
				
				//logger.info( "session={}", session );
				
				client.getBasicRemote().sendText( message );
			
			}
		}
	}
	
	@OnOpen
	public void opOpen( Session session ) {
		//logger.info( "session={}", session );
		clients.add( session );
	}
	
	@OnClose
	public void onClose( Session session ) {
		clients.remove( session );
	}
	
}

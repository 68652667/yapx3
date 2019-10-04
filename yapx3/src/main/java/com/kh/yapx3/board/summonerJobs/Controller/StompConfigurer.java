package com.kh.yapx3.board.summonerJobs.Controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class StompConfigurer extends AbstractWebSocketMessageBrokerConfigurer {

	@Autowired
	private ServletContext servletContext;
	
	@Override
	public void registerStompEndpoints( StompEndpointRegistry registry ) {
		registry.addEndpoint("/robi").withSockJS().setInterceptors( new HttpSessionHandshakeInterceptor() );
	}
	
	@Override
	public void configureMessageBroker( MessageBrokerRegistry registry ) {
		registry.enableSimpleBroker("/hello", "/chat", "/lastCheck");
		
		registry.setApplicationDestinationPrefixes( servletContext.getContextPath() );
	}
}

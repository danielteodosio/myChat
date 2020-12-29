package com.mychat.mychat.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class ChatMessageListener {
	@EventListener
	public void handleOnConnect(final SessionConnectEvent session) {
		System.out.println("alguem tentou conectar!");
		System.out.println(session.toString());
	}
	
	@EventListener
	public void handleOnDisconnect(final SessionDisconnectEvent session) {
		System.out.println("alguem desconectou");
	}
}

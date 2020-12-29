package com.mychat.mychat.websocket;

import java.util.Map;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {
	@MessageMapping("/test/{id}")
	String sendMessage(@DestinationVariable Long id, @Payload String message, @Headers Map<Object, Object> headers) {
		System.out.println(headers.toString());
		return message;
	}
}

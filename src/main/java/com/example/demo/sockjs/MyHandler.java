package com.example.demo.sockjs;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

@Component
public class MyHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("MyHandler.afterConnectionEstablished()...");
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        String s = (String) webSocketMessage.getPayload();
        String res = "server has received:" + s;
        System.out.println(res);
        webSocketSession.getAttributes();
        TextMessage textMessage = new TextMessage(res);
        webSocketSession.sendMessage(textMessage);
        System.out.println("MyHandler.handleMessage()...");
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.out.println("MyHandler.handleTransportError()...");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("MyHandler.afterConnectionClosed()...");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

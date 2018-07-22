package com.example.demo.sockjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
public class SocketConfig implements WebSocketConfigurer {
    @Autowired
    private MyHandler myHandler;
    @Autowired
    private MyHandshakeInterceptor myHandshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //注册websocket实现类，指定参数访问地址;allowed-origins="*" 允许跨域
        webSocketHandlerRegistry.addHandler(myHandler, "/jf").addInterceptors(myHandshakeInterceptor).setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(myHandler,"/sockjs/jf").withSockJS();
    }
}

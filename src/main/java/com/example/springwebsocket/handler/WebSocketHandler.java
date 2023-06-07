//package com.example.springwebsocket.handler;
//
//import com.example.springwebsocket.dto.ChatMessage;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
///**
// * socket -> 서버와 클라이언트 1:N으로 관계를 맺음
// * 한 서버에 여러 클라이언트 접속 O
// * 서버에는 여러 클라이언트가 발송한 메세지를 받아 처리해줄 handler 필요
// * 클라이언트로부터 받은 메시지 console 출력, client로 메세지 보내는 역할
// */
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class WebSocketHandler extends TextWebSocketHandler {
//
//    private final ObjectMapper objectMapper;
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
////        TextMessage textMessage = new TextMessage("Welcome Chat Server");
////        session.sendMessage(textMessage);
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//
//    }
//}

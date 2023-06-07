package com.example.springwebsocket.controller;

import com.example.springwebsocket.dto.ChatMessage;
import com.example.springwebsocket.dto.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * handler 대체
 * 클라이언트 prefix /pub/chat/message로 발행요청 -> Controller가 받아서 처리
 * 메시지 발행 -> /sub/chat/room/{roomId}로 메시지 send
 * 클라이언트는 해당주소(/sub/chat/room/{roomId}) 구독 -> 메시지 전달시 화면 출력
 */
@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage chatMessage) {
        if (ChatMessage.MessageType.JOIN.equals(chatMessage.getType())) {
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장하셨습니다.");
        }

        messagingTemplate.convertAndSend("/sub/chat/room/" + chatMessage.getRoomId(), chatMessage);

    }

}

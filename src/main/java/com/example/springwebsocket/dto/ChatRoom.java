package com.example.springwebsocket.dto;

import com.example.springwebsocket.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 채팅방
 */
@Getter
@Setter
public class ChatRoom {

    private String roomId; // 채팅방 id
    private String name; // 채팅방 이름

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }

}

package com.example.springwebsocket.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 채팅 메세지
 */
@Getter
@Setter
public class ChatMessage {
    // 메세지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK, JOIN
    }

    private MessageType type; // 메세지 타입

    private String roomId; // 방번호

    private String sender; // 메세지 보낸사람

    private String message; // 메세지

}

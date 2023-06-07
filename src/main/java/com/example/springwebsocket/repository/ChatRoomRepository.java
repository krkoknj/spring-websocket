package com.example.springwebsocket.repository;

import com.example.springwebsocket.dto.ChatRoom;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRoomMap;

    /**
     * 의존성 주입이 끝나고 실행됨이 보장되므로 빈의 초기화에 대해서 걱정할 필요 X
     * 참고 : https://zorba91.tistory.com/223, https://stackoverflow.com/questions/3406555/why-use-postconstruct
     */
    @PostConstruct
    public void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        List chatRooms = new ArrayList(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoom findRoomById (String id) {
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
}

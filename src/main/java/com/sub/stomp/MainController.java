package com.sub.stomp;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final SimpMessagingTemplate template;

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatDTO message) {
        message.setMessage(message.getUserId() + "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatDTO message) {
        template.convertAndSend("/sub/chat/" + message.getRoomId(), message);
    }
}

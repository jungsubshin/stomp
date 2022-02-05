package com.sub.stomp;

import lombok.Data;

@Data
public class ChatDTO {

    private String roomId;
    private String userId;
    private String message;
}

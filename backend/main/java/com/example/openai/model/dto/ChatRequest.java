package com.example.openai.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ChatRequest {
    private String model;
    private final List<ChatMes> messages = new ArrayList<>();
    public ChatRequest(String model, String prompt){
        this.model = model;
        messages.add(new ChatMes("user", prompt));
    }
}

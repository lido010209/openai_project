package com.example.openai.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChatResponse {
    private List<Choice> choices;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice{
        private Integer index;
        private ChatMes message;
        public Choice(Integer index, String content){
            this.index = index;
            this.message = new ChatMes("assistant", content);
        }
    }
}

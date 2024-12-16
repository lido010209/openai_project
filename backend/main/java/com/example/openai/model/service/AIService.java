package com.example.openai.model.service;

import com.example.openai.model.dto.ChatRequest;
import com.example.openai.model.dto.ChatResponse;
import com.example.openai.model.template.AITemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AIService {
    private final AITemplate aiTemplate;
    @Value("${openapi.url}")
    private String uri;
    public List<String> chatResponse(String prompt){
        ChatRequest request = new ChatRequest("gpt-3.5-turbo", prompt);
        ChatResponse response = aiTemplate.restTemplate().postForObject(
              uri, request, ChatResponse.class
        );
        List<String> mesResponse = new ArrayList<>();
        for (ChatResponse.Choice r: response.getChoices()){
            mesResponse.add(r.getMessage().getContent());
        }
        return mesResponse;
    }
}

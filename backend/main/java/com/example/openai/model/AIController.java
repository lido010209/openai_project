package com.example.openai.model;

import com.example.openai.model.dto.ChatResponse;
import com.example.openai.model.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("openai")
public class AIController {
    private final AIService aiService;
    @PostMapping
    public List<String> aiResponse(@RequestBody String prompt){
        return aiService.chatResponse(prompt);
    }
}

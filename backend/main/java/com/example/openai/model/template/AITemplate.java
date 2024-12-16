package com.example.openai.model.template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AITemplate {
    @Value("${openapi.key}")
    private String apiKey;

    public RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add((request, body, execution)->{
            request.getHeaders().add("Authorization", "Bearer "+ this.apiKey);
            return execution.execute(request, body);
        });
        return template;
    }
}

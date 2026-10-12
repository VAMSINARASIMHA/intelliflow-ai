package com.example.intelliflow.ai;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/v1/ai")
public class AiController {
 private final AiAssistantService service;
 public AiController(AiAssistantService service){this.service=service;}
 @PostMapping("/chat") public ChatResponse chat(@Valid @RequestBody ChatRequest r){return service.answer(r.message());}
}

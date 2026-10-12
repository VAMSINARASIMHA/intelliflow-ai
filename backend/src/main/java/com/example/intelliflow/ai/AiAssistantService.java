package com.example.intelliflow.ai;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
@Service
public class AiAssistantService {
 private final ChatClient client;
 public AiAssistantService(ChatClient.Builder builder){
  client=builder.defaultSystem("You are IntelliFlow AI, an enterprise project assistant. Be concise, distinguish facts from suggestions, and never claim access to project data unless supplied in context.").build();
 }
 public ChatResponse answer(String message){
  String answer=client.prompt().user(message).call().content();
  return new ChatResponse(answer==null?"":answer);
 }
}

package com.example.intelliflow.task;
import java.time.LocalDateTime;
public record TaskResponse(String id,String title,String description,TaskStatus status,
 TaskPriority priority,LocalDateTime dueAt,LocalDateTime createdAt,LocalDateTime updatedAt,long version) {
 public static TaskResponse from(Task t){return new TaskResponse(t.getId(),t.getTitle(),t.getDescription(),
  t.getStatus(),t.getPriority(),t.getDueAt(),t.getCreatedAt(),t.getUpdatedAt(),t.getVersion());}
}

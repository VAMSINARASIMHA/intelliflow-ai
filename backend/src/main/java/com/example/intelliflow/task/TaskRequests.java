package com.example.intelliflow.task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
public final class TaskRequests {
  private TaskRequests(){}
  public record CreateTaskRequest(@NotBlank @Size(max=250) String title,
      @Size(max=10000) String description, TaskPriority priority, LocalDateTime dueAt) {}
  public record TransitionTaskRequest(TaskStatus status) {}
}

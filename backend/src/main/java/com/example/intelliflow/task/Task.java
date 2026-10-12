package com.example.intelliflow.task;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
  @Id
  @Column(length = 36, nullable = false, columnDefinition = "CHAR(36)")
  private String id;
  @Column(nullable = false, length = 250)
  private String title;
  @Column(columnDefinition = "TEXT")
  private String description;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 30)
  private TaskStatus status = TaskStatus.TODO;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private TaskPriority priority = TaskPriority.MEDIUM;
  @Column(name = "due_at")
  private LocalDateTime dueAt;
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;
  @Version
  private long version;

  protected Task() {
  }

  public Task(String title, String description, TaskPriority priority, LocalDateTime dueAt) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
    this.description = description;
    this.priority = priority == null ? TaskPriority.MEDIUM : priority;
    this.dueAt = dueAt;
  }

  @PrePersist
  void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = createdAt;
  }

  @PreUpdate
  void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  public void transitionTo(TaskStatus next) {
    boolean allowed = switch (status) {
      case TODO -> next == TaskStatus.IN_PROGRESS || next == TaskStatus.CANCELLED;
      case IN_PROGRESS -> next == TaskStatus.BLOCKED || next == TaskStatus.DONE || next == TaskStatus.TODO;
      case BLOCKED -> next == TaskStatus.IN_PROGRESS || next == TaskStatus.CANCELLED;
      case DONE, CANCELLED -> false;
    };
    if (!allowed)
      throw new IllegalStateException("Invalid task transition: " + status + " -> " + next);
    status = next;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public TaskPriority getPriority() {
    return priority;
  }

  public LocalDateTime getDueAt() {
    return dueAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public long getVersion() {
    return version;
  }
}

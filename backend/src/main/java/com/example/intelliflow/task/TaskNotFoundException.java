package com.example.intelliflow.task;
public class TaskNotFoundException extends RuntimeException {
 public TaskNotFoundException(String id){super("Task not found: "+id);}
}

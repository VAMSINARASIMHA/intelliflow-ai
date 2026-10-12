package com.example.intelliflow.task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TaskServiceTest {
 @Test void completedTaskCannotReturnToTodo(){
  Task task=new Task("Test",null,TaskPriority.HIGH,null);
  task.transitionTo(TaskStatus.IN_PROGRESS); task.transitionTo(TaskStatus.DONE);
  assertThrows(IllegalStateException.class,()->task.transitionTo(TaskStatus.TODO));
 }
 @Test void blockedTaskCanResume(){
  Task task=new Task("Test",null,TaskPriority.MEDIUM,null);
  task.transitionTo(TaskStatus.IN_PROGRESS); task.transitionTo(TaskStatus.BLOCKED);
  task.transitionTo(TaskStatus.IN_PROGRESS);
  assertEquals(TaskStatus.IN_PROGRESS,task.getStatus());
 }
}

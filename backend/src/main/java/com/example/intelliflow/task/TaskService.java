package com.example.intelliflow.task;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TaskService {
 private final TaskRepository repository;
 public TaskService(TaskRepository repository){this.repository=repository;}
 @Transactional public TaskResponse create(TaskRequests.CreateTaskRequest r){
  return TaskResponse.from(repository.save(new Task(r.title(),r.description(),r.priority(),r.dueAt())));
 }
 @Transactional(readOnly=true) public Page<TaskResponse> list(int page,int size){
  Pageable p=PageRequest.of(Math.max(0,page),Math.max(1,Math.min(size,100)),Sort.by(Sort.Direction.DESC,"createdAt"));
  return repository.findAll(p).map(TaskResponse::from);
 }
 @Transactional(readOnly=true) public TaskResponse get(String id){
  return repository.findById(id).map(TaskResponse::from).orElseThrow(()->new TaskNotFoundException(id));
 }
 @Transactional public TaskResponse transition(String id,TaskRequests.TransitionTaskRequest r){
  if(r.status()==null) throw new IllegalArgumentException("status is required");
  Task t=repository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
  t.transitionTo(r.status()); return TaskResponse.from(t);
 }
 @Transactional public void delete(String id){
  Task t=repository.findById(id).orElseThrow(()->new TaskNotFoundException(id)); repository.delete(t);
 }
}

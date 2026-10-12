package com.example.intelliflow.task;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/v1/tasks")
public class TaskController {
 private final TaskService service;
 public TaskController(TaskService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)
 public TaskResponse create(@Valid @RequestBody TaskRequests.CreateTaskRequest r){return service.create(r);}
 @GetMapping public Page<TaskResponse> list(@RequestParam(defaultValue="0") int page,
  @RequestParam(defaultValue="20") int size){return service.list(page,size);}
 @GetMapping("/{id}") public TaskResponse get(@PathVariable String id){return service.get(id);}
 @PatchMapping("/{id}/status") public TaskResponse transition(@PathVariable String id,
  @RequestBody TaskRequests.TransitionTaskRequest r){return service.transition(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable String id){service.delete(id);}
}

package com.example.intelliflow.shared;
import com.example.intelliflow.task.TaskNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Map;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(TaskNotFoundException.class)
 ResponseEntity<Map<String,String>> notFound(TaskNotFoundException e){
  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error","NOT_FOUND","message",e.getMessage()));
 }
 @ExceptionHandler(IllegalStateException.class)
 ResponseEntity<Map<String,String>> conflict(IllegalStateException e){
  return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error","INVALID_STATE","message",e.getMessage()));
 }
 @ExceptionHandler(IllegalArgumentException.class)
 ResponseEntity<Map<String,String>> badRequest(IllegalArgumentException e){
  return ResponseEntity.badRequest().body(Map.of("error","BAD_REQUEST","message",e.getMessage()));
 }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException e){
  return ResponseEntity.badRequest().body(Map.of("error","VALIDATION_FAILED","message","Request validation failed"));
 }
}

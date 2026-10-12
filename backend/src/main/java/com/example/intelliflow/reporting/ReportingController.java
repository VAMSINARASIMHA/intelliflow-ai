package com.example.intelliflow.reporting;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
@RestController @RequestMapping("/api/v1/reports")
public class ReportingController {
 private final TaskReportingRepository repository;
 public ReportingController(TaskReportingRepository repository){this.repository=repository;}
 @GetMapping("/overdue") public OverdueTaskSummary overdue(){return repository.getOverdueSummary(LocalDateTime.now());}
}

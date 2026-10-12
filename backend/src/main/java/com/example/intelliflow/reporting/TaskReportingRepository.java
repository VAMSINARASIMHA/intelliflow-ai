package com.example.intelliflow.reporting;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Repository
public class TaskReportingRepository {
 private final NamedParameterJdbcTemplate jdbc;
 public TaskReportingRepository(NamedParameterJdbcTemplate jdbc){this.jdbc=jdbc;}
 public OverdueTaskSummary getOverdueSummary(LocalDateTime now){
  String sql="SELECT COALESCE(SUM(CASE WHEN due_at < :now AND status NOT IN ('DONE','CANCELLED') THEN 1 ELSE 0 END),0) AS overdue_count, "+
   "COALESCE(SUM(CASE WHEN status NOT IN ('DONE','CANCELLED') THEN 1 ELSE 0 END),0) AS open_count FROM tasks";
  var p=new MapSqlParameterSource().addValue("now",Timestamp.valueOf(now));
  return jdbc.queryForObject(sql,p,(rs,row)->new OverdueTaskSummary(rs.getLong("overdue_count"),rs.getLong("open_count")));
 }
}

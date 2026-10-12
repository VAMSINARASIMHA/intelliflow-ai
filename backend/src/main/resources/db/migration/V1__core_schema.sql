CREATE TABLE tasks (
  id CHAR(36) PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  description TEXT NULL,
  status VARCHAR(30) NOT NULL DEFAULT 'TODO',
  priority VARCHAR(20) NOT NULL DEFAULT 'MEDIUM',
  due_at DATETIME(6) NULL,
  created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  version BIGINT NOT NULL DEFAULT 0,
  INDEX idx_tasks_status_due (status, due_at),
  INDEX idx_tasks_created_at (created_at)
);
CREATE TABLE audit_logs (
  id CHAR(36) PRIMARY KEY,
  actor_id VARCHAR(200) NULL,
  action VARCHAR(100) NOT NULL,
  entity_type VARCHAR(100) NOT NULL,
  entity_id VARCHAR(36) NULL,
  details JSON NULL,
  created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  INDEX idx_audit_created_at (created_at)
);

-- DDL
CREATE TABLE login_user(
	id VARCHAR(64) PRIMARY KEY,
	group_id BIGINT NOT NULL,
	info JSONB NOT NULL
);
USE c_cs108_

DROP TABLE IF EXISTS quiz_log_db;

CREATE TABLE quiz_log_db {
	start_time TIMESTAMP
	username CHAR(128)
	quizid CHAR(128)
	score DECIMAL(5, 2)
	total_time TIME /*hours, minutes, seconds*/
};

INSERT INTO quiz_log_db VALUES
	('2015-01-01 00:00:01', "kjohnson", "Multi-question quiz", 75, '00:08:15')
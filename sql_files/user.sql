USE c_cs108_

DROP TABLE IF EXISTS user_db;

CREATE TABLE user_db {
	username CHAR(128)
	password VARCHAR(255)
	is_admin CHAR(32)
	quizzes_created INTEGER
	quizzes_taken INTEGER
};

	
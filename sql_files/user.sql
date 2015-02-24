USE c_cs108_stsai612

DROP TABLE IF EXISTS user_db;

CREATE TABLE user_db {
	username CHAR(128),
	password VARCHAR(255),
	creation_date TIMESTAMP, /*maybe for some "oldest members" feature or something?*/
	is_admin CHAR(32),
	quizzes_created INTEGER,
	quizzes_taken INTEGER
};

	
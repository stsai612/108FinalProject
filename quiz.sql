USE c_cs108_

DROP TABLE IF EXISTS quiz_db;

CREATE TABLE quiz_db {
	quizid CHAR(128) UNIQUE,
	creation_date TIMESTAMP,
	username CHAR(128),
	num_questions INTEGER,
	category CHAR(128),
	tags VARCHAR(255), /*this is something we parse*/
	highest_score DECIMAL(5, 2), /*initialized to 0*/
	times_taken INTEGER,
	is_practice CHAR(32), /*store true or false*/
	is_random CHAR(32),
	is_multi_page CHAR(32),
	is_immediate_scoring CHAR(32) /*only relevant for multiple page quizzes*/
};

INSERT INTO quiz_db VALUES
	("Fun Response Quiz", '2008-01-01 00:00:01', "stsai", 1, "", "", 0, 0, "true", "false", "false", "false"),
	("Multi-question quiz", '2012-01-01 00:00:01', "stsai", 4, "", "", 75, 1, "true", "true", "false", "false"),
	("Blank quiz", '2014-01-01 00:00:01', "stsai", 1, "", "", 0, 0, "true", "false", "false", "false"),
	("Multiple choice quiz", '2015-01-01 00:00:01', 1, "", "", 0, 0, "true", "false", "false", "false"),
	("Picture quiz", '2015-09-01 00:06:01', 1, "", "", 0, 0, "false", "false", "false", "false")
	
USE c_cs108_

DROP TABLE IF EXISTS question_response;

CREATE TABLE question_response {
	quizid CHAR(128)
	question VARCHAR(255)
	answer VARCHAR(255)
}
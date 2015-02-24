USE c_cs108_

DROP TABLE IF EXISTS question_response_db;

CREATE TABLE question_response_db {
	quizid CHAR(128) references quiz_db(quizid), 
	question VARCHAR(255),
	answer VARCHAR(255),
	max_score INTEGER,
};

INSERT INTO question_response_db VALUES
	("Fun Response Quiz", "What is 2+2?", "4", 1),
	("Multi-question quiz", "What color is a banana?", "yellow", 1)



DROP TABLE IF EXISTS fill_in_the_blank_db;

CREATE TABLE fill_in_the_blank_db {
	quizid CHAR(128)
	question VARCHAR(255) /*put certain characters around blank space*/
	answer VARCHAR(255) /*the stuff in the blank -- will also be in the question text but this will make things easier*/
	max_score INTEGER
}

INSERT INTO fill_in_the_blank_db VALUES
	("Blank quiz", "Abraham Lincoln was a ~president~", "president", 1),
	("Multi-question quiz", "To be, or ~not to be~- that is the question", "not to be", 1)



DROP TABLE IF EXISTS multiple_choice_db;

CREATE TABLE multiple_choice_db {
	quizid CHAR(128)
	question VARCHAR(255)
	all_choices VARCHAR(255) /*when inserting, need to insert special characters between answers*/
	answer VARCHAR(255) 
	max_score INTEGER
}

INSERT INTO multiple_choice_db VALUES
	("Multiple choice quiz", "How many fingers do we have?", "6|5|8|10", "5", 1),
	("Multi-question quiz", "What is the opposite of cold?", "freezing|hot|icy|nice", 1)



DROP TABLE IF EXISTS picture_response_db;

CREATE TABLE picture_response_db {
	quizid CHAR(128)
	question VARCHAR(255) /*this is a url to a picture*/
	answer VARCHAR(255) 
	max_score INTEGER
}	

INSERT INTO picture_response_db VALUES
	("Picture quiz", "http://events.stanford.edu/events/252/25201/Memchu_small.jpg", "Memorial Church", 1),
	("Multi-question quiz", "http://upload.wikimedia.org/wikipedia/commons/c/c8/Taj_Mahal_in_March_2004.jpg", "Taj Mahal", 1)


USE c_cs108_

DROP TABLE IF EXISTS friends_db;

CREATE TABLE friends_db {
	username_one CHAR(128)
	username_two CHAR(128)
	friend_date TIMESTAMP
	num_interactions INTEGER /*could be cool to have some "top friends" feature or something*/
};

INSERT INTO friends_db VALUES
	("stsai", "kjohnson", '2015-01-01 00:00:01', 0)
	
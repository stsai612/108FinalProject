USE c_cs108_stsai612

DROP TABLE IF EXISTS friends_db;

CREATE TABLE friends_db {
	username_one CHAR(128) references user_db(username), 
	username_two CHAR(128) references user_db(username),
	friend_date TIMESTAMP,
	num_interactions INTEGER /*could be cool to have some "top friends" feature or something*/
};

INSERT INTO friends_db VALUES
	("stsai", "kjohnson", '2015-02-01 00:00:01', 0)
	
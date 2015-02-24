USE c_cs108_

DROP TABLE IF EXISTS inbox_db;

CREATE TABLE inbox_db {
	sender CHAR(128) references user_db(username), 
	receiver CHAR(128) references user_db(username),
	creation_date TIMESTAMP,
	message CHAR(255) ,
	message_type CHAR(32), /*note, challenege, friend request*/
	is_done CHAR(32)
};

INSERT INTO inbox_db VALUES
	("stsai", "kjohnson", '2015-01-01 00:00:01', "", "Friend request", "true")
	("stsai", "kjohnson", '2015-03-01 00:00:01', "Hello", "note", "false")
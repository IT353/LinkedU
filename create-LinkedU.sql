CREATE TABLE LinkedU.LoginInfo (
	UserEmail		VARCHAR(25) ,
	Password		VARCHAR(25) NOT NULL,
	AccountType		CHAR(1) NOT NULL,
	CONSTRAINT LinkedU.LoginInfo_UserID_pk PRIMARY KEY(UserEmail)
)

CREATE TABLE LinkedU.Students (
	UserEmail		VARCHAR(25),
	FirstName		VARCHAR(25),
	LastName		VARCHAR(25),
	City			VARCHAR(25),
	State			CHAR(2),
	GPA			DOUBLE,
	SAT			INT,
	ACT			INT,
	HighSchool		VARCHAR(50),
	UniChoices		VARCHAR(100),
	MajChoices		VARCHAR(100),
	About			LONG VARCHAR,
	Interests		LONG VARCHAR,
	Picture			BLOB,
	Essay			BLOB,
	Video			BLOB
)

CREATE TABLE LinkedU.Universities (
	UserEmail		VARCHAR(25),
	Uname			VARCHAR(25),
	Address			VARCHAR(50),
	City			VARCHAR(25),
	State			CHAR(2),
	Phone			VARCHAR(15),
	UType			VARCHAR(50),
	PaidStatus		CHAR(1),
	About			LONG VARCHAR,
	ApplyExtra		LONG VARCHAR,
	Picture			BLOB,
	Video			BLOB
)


CREATE TABLE LinkedU.Messages(
	SenderEmail		VARCHAR(25),
	ReceiverEmail	VARCHAR(25),
	Message			LONG VARCHAR,
	TimeSent		TIMESTAMP,
	ReadStatus		CHAR(1)
)
	
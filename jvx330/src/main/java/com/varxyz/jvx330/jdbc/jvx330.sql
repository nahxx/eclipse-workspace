CREATE TABLE Customer(
	cid		BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId	VARCHAR(20)		NOT NULL,
	passwd	VARCHAR(20)		NOT NULL,
	name	VARCHAR(20)		NOT NULL,
	ssn		VARCHAR(14)		NOT NULL, -- 123456-7890123
	phone 	VARCHAR(13)		NOT NULL, -- 010-1234-5678
	regDate	TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;

UPDATE Customer SET name="관우" WHERE cid=1003;

SELECT count(*) FROM Customer;

DELETE FROM Customer WHERE cid=1020;

DROP TABLE Customer;
DROP TABLE ACcount;

CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	customerId		BIGINT			NOT NULL,
	accountNum		CHAR(11)		NOT NULL, -- 000-00-0000
	accType			CHAR(1)			NOT NULL DEFAULT 'S',
	balance			DOUBLE			NOT NULL DEFAULT 0,
	interestRate	DOUBLE			NOT NULL DEFAULT 0.0,
	overAmount		DOUBLE			NOT NULL DEFAULT 0.0,
	regDate	TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT	Account_customerId_FK
		FOREIGN KEY(customerId)	REFERENCES	Customer(cid)
)AUTO_INCREMENT = 3001;

SELECT * FROM Account;

DELETE FROM Account;


INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) 
VALUES ('111-11-1111', 'S', 10000, 0.1, 0.0, 1001);

INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) 
VALUES ('222-22-2222', 'S', 20000, 0.2, 0.0, 1002);

INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) 
VALUES ('333-33-3333', 'S', 30000, 0.3, 0.0, 1003);

INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) 
VALUES ('444-44-4444', 'C', 40000, 0.0, 40000, 1001);

INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) 
VALUES ('555-55-5555', 'C', 50000, 0.0, 50000, 1002);

INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) 
VALUES ('666-66-6666', 'C', 60000, 0.0, 60000, 1003);
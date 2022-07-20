DROP TABLE Account;
CREATE TABLE Account (
	aid			 	BIGINT			PRIMARY KEY AUTO_INCREMENT,
	accountNum	 	VARCHAR(11)		NOT NULL, -- 111-11-1111 형태로 계좌번호 지정
	balance		 	DOUBLE			NOT NULL	DEFAULT 0.0,
	interestRate	DOUBLE			NOT NULL	DEFAULT 0.0, -- SavingsAccount에서만 사용하는 속성이지만, NULL로 해놓을 경우 혹시나 값이 안들어올 경우가 생길 수 있으므로 NOT NULL로 함
	overdraft		DOUBLE			NOT NULL	DEFAULT 0.0,
	accountType		CHAR(1)			NOT NULL 	DEFAULT 'S',
	customerId		BIGINT			NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid) -- Account 테이블의 customerId은 Customer 테이블의 cid에서 가져온 것으로 Foreign key로 지정한다는 의미
)AUTO_INCREMENT = 3001;

SELECT * FROM Account;

INSERT INTO Account (accountNum, balance, interestRate, accountType, customerId)
VALUES ('111-11-1111', 1000, 0.01, 'S', 1001);

INSERT INTO Account (accountNum, balance, overdraft, accountType, customerId)
VALUES ('222-22-2222', 2000, 20000, 'C', 1002);

INSERT INTO Account (accountNum, balance, overdraft, accountType, customerId)
VALUES ('333-33-3333', 3000, 30000, 'C', 1001);

SELECT * FROM Customer;

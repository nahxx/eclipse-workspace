-- 2022/06/21 수업내용

-- DROP TABLE (테이블 삭제)
DROP TABLE Sample10;

-- CREATE TABLE (테이블 생성)
CREATE TABLE Sample10 (
	no			INT(11)		DEFAULT NULL,
	name		VARCHAR(20) DEFAULT NULL,
	birthday 	DATE		DEFAULT NULL,
	address 	VARCHAR(40)	DEFAULT NULL
);

SELECT * FROM Sample10;

INSERT INTO Sample10 VALUES (1, '유비', '1996-10-25', '대구 중구 반월당');

INSERT INTO Sample10 VALUES (2, '관우', '1997-10-26', '대구 달서구 상인동');

INSERT INTO Sample10 VALUES (3, '장비', '1998-10-27', '대구 수성구 황금동');

/*
 * DATE 타입에 데이터를 담을 때는 문자로 담기(DATE 타입에는 날짜만 담을 수 있음)
 * TIME 타입이 따로 있음. 만약 DATE랑 TIME을 한번에 넣고 싶다면 TIMESTAMP 사용
 * 문자로 입력할 때는 꼭 홑따옴표(') 사용
 * 이스케이프 문자를 사용할 때는 사용하려는 이스케이프 문자를 앞에 한번 더 붙이기
 * 만약 '를 입력하고 싶다면 '''' 로 입력해야 함('는 두번입력해야해서 '' -> 문자이므로 ''로 감싸줘야하니까 총 '''' 4개로 입력)
 */

-- CREATE TABLE (테이블 생성)
CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT, -- PRIMARY KEY는 자동으로 NOT NULL임, AUTO_INCREMENT는 INSERT 될 때마다 자동으로 증가해주는 키워드
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	phone		VARCHAR(14)		NOT NULL,
	userID		VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(60)		NOT NULL, -- 보안을 위해 내부에서 인코딩해서 알수없는 코드 60자리 형태로 변경하도록 만들기 때문에 60으로 지정
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP -- 데이터가 들어온 날짜를 입력하기 위해 만듬(값이 안들어갔을 대 현재의 TIMESTAMP값을 넣겠다는 의미)
) AUTO_INCREMENT = 1001; -- 1001번부터 시작한다는 의미(초기 셋팅값)

ALTER TABLE Customer CHANGE customerId userId VARCHAR(16) NOT NULL;

-- SELECT ~ FROM (보기)
SELECT * FROM Customer;

-- INSERT INTO (삽입)
INSERT INTO Customer (name, ssn, phone, customerID, passwd) 
VALUES ('유비', '961025-1234567', '010-1111-1111', 'java', '1111'); -- 일부 column 값만 넣을 때는 이런식으로 작성

INSERT INTO Customer (name, ssn, phone, customerID, passwd)
VALUES ('관우', '951026-2222222', '010-2222-2222', 'sql', '2222');

INSERT INTO Customer (name, ssn, phone, customerID, passwd)
VALUES ('장비', '961027-1111111', '010-3333-3333', 'html', '3333');

-- UPDATE ~ SET ~ WHERE (업데이트)
UPDATE Customer SET ssn='901212-1234567', phone='010-4444-4444' WHERE cid=1001; -- 반드시 값을 변경할 column을 선택하기 위한 조건을 정해야함

/*
 * 보통은 삭제한다고 해도 DB에서 삭제하지 않음
 * 대신 column 하나에 가입 중이면 true, 탈퇴했으면 false 처럼 표기해두는 편
 * 정책에 따라 일정 기간이 지나면 삭제되게끔 만들어 놓기도 함
*/

-- DELETE FROM ~ WHERE (삭제)
DELETE FROM Customer WHERE cid=1003;

UPDATE Account SET balance = ?, overdraft = ? WHERE accountNum = ?;

DELETE FROM Account WHERE aid=3024;
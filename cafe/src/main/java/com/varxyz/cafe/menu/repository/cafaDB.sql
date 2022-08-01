-- 테이블 삭제
DROP TABLE Category;
DROP TABLE MenuItem;

-- Category 테이블 생성
CREATE TABLE Category (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	cateName	VARCHAR(10)		NOT NULL,
	cateType	VARCHAR(10)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

-- MenuItem 테이블 생성
CREATE TABLE MenuItem (
	mid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	price		DOUBLE			NOT NULL DEFAULT 0.0,
	imageUrl	VARCHAR(100)	NOT NULL,
	cid			BIGINT			NOT NULL, -- 외래키
	regDate		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT	MenuItem_cid_FK	FOREIGN KEY(cid)	REFERENCES	Category(cid)
)AUTO_INCREMENT = 1001;

-- 임시 데이터
INSERT INTO Category (cateName, cateType) values ('커피', '음료');
INSERT INTO Category (cateName, cateType) values ('차', '음료');
INSERT INTO Category (cateName, cateType) values ('프라푸치노', '음료');
INSERT INTO Category (cateName, cateType) values ('딸기케익', '디저트');
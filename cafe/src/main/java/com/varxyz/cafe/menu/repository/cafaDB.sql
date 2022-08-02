-- 테이블 삭제
DROP TABLE Category;
DROP TABLE MenuItem;

-- Category 테이블 생성
CREATE TABLE Category (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	cateType	VARCHAR(10)		NOT NULL,
	cateName	VARCHAR(10)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

-- MenuItem 테이블 생성
CREATE TABLE MenuItem (
	mid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(20)		NOT NULL,
	price		DOUBLE			NOT NULL DEFAULT 0.0,
	imageUrl	VARCHAR(100)		NULL DEFAULT '',
	cid			BIGINT			NOT NULL, -- 외래키
	regDate		TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT	MenuItem_cid_FK	FOREIGN KEY(cid)	REFERENCES	Category(cid)
)AUTO_INCREMENT = 1001;

-- 임시 데이터
INSERT INTO Category (cateType, cateName) values ('커피', '카페인');
INSERT INTO Category (cateType, cateName) values ('커피', '디카페인');
INSERT INTO Category (cateType, cateName) values ('차', '차');
INSERT INTO Category (cateType, cateName) values ('차', 'ONLY ICE');
INSERT INTO Category (cateType, cateName) values ('프라푸치노', '프라푸치노');
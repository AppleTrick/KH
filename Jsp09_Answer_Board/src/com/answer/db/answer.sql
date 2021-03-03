DROP SEQUENCE BOARDNOSEQ;
DROP SEQUENCE GROUPNOSEQ;
DROP TABLE ANSWERBOARD;

CREATE SEQUENCE BOARDNOSEQ;
CREATE SEQUENCE GROUPNOSEQ;

CREATE TABLE ANSWERBOARD(
	BOARDNO NUMBER PRIMARY KEY,
	GROUPNO NUMBER NOT NULL,
	GROUPSEQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WRITER VARCHAR2(100) NOT NULL,
	REGDATE DATE NOT NULL
)

-- 1번글 작성

INSERT INTO ANSWERBOARD
VALUES(BOARDNOSEQ.NEXTVAL,GROUPNOSEQ.NEXTVAL,1,0,
	'1번글 입니다.','1번 글을 썻는데 답변 싫다','강사',SYSDATE);
	

-- 1번글에 답변 작성
-- UPDATE

UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ + 1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?)
-- GROUPNO 가 선택된 거 이면서
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?)
-- GROUPSEQ 가 GROUPNO에거서 선택된 SEQ 보다 큰것들을 GROUPSEQ + 1 해준다.

-- INSERT

INSERT INTO ANSWERBOARD
VALUES(
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1),
	(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1) + 1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = 1) + 1,
	'RE:1 번글에 답변',
	'답변',
	'무플 방지',
	SYSDATE
);

-- 2번글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSEQ.NEXTVAL,GROUPNOSEQ.NEXTVAL,1,0,
	'2번글 입니다.','2번원글','반장',SYSDATE);
	
	
-- 2번글 답변
-- UPDATE
-- INSERT
-- 그룹번호 : 답변을 달려고 하는 부모글의 그룹번호
-- 그룹 순서 : 답변을 달려고 하는 부모글의 그룹 순서 +1
-- 제목 공백 : 답변을 달려고 하느 부모글의 제목 공백 +1

INSERT INTO ANSWERBOARD
VALUES (
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3),
	(SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO = 3),
	(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 3),
	'RE:2번글 입니다',
	'아이고',
	'강사',
	SYSDATE
)

INSERT INTO ANSWERBOARD
VALUES(
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 4),
	(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 4) + 1,
	(SELECT TITLETAB + 1  FROM ANSWERBOARD WHERE BOARDNO = 4),
	'RE: RE: 2번글 입니다',
	'진짜 어렵다',
	'학생',
	SYSDATE
)

--2번글에 답변 다시 하기
-- UPDATE
-- 부모와 같은 그룹인 글들을 찾아서 부모의 순서보다 큰 순서대로 정렬
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ +1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3)
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 3 )


-- INSERT
INSERT INTO ANSWERBOARD
VALUES (
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3),
	(SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO = 3),
	(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 3),
	'RE:2번글 입니다',
	'이제 쉽네',
	'학생',
	SYSDATE
)
	

-- 2번글 다시 답변에 답변하기
-- UPDATE

UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ + 1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 6)
AND GROUPSEQ > (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 6);

-- INSERT
INSERT INTO ANSWERBOARD
VALUES(
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 6),
	(SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO = 6),
	(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 6),
	'RE: RE: 이젠 좀 쉽죠?',
	'아',
	'강사',
	SYSDATE
)



-- 출력
SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE
FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSEQ;




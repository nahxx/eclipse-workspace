INSERT INTO CustomerTable(name, ssn) VALUES ('James Bond', '900101-1234567');

INSERT INTO AccountTable(accType, balance, interestRate, customerId) VALUES ('C', 2000.0, 0.03, 1001);

UPDATE CustomerTable SET name='Jason Bourne' WHERE cid=1002;

DROP FROM CustomerTable WHERE cid=1002;

SELECT accType, balance FROM AccountTable WHERE aid=3001;
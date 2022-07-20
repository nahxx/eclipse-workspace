use jv250;

show tables;

SELECT * FROM Customer;

CREATE INDEX CustomerIndex ON Customer(ssn);

SELECT a.aid, a.accountNum, a.accountType, a.balance FROM AccountTable a INNER JOIN CustomerTable c ON a.customerId = c.cid WHERE c.ssn = '840104-1234567';
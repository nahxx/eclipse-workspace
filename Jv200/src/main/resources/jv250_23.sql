-- 220623 수업내용

-- 방법 1
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid AND Customer.ssn = '901212-1234567';

-- 방법 2 (이런식으로 할 것)
SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '901212-1234567';

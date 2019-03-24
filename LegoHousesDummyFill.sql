USE LegoHouses;

INSERT INTO Customers(adminId, username, email, pass)
VALUES(1, 'Dennis', 'test@test.dk', '1234');

INSERT INTO Customers(username, email, pass)
VALUES('test', 'cus@test.dk','1234');

INSERT INTO Orders(customerId)VALUES(2);
INSERT INTO HouseInfo(length, width, height, price, orderId)
VALUES (11, 5, 5, 100.00,1); 
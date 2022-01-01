CREATE TABLE goods (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  title varchar(45) DEFAULT NULL,
  amount INTEGER DEFAULT NULL,
  price INTEGER DEFAULT NULL,
  orderDate date DEFAULT NULL,
  deliveryDate date DEFAULT NULL
);

CREATE TABLE workers (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  login varchar(45) DEFAULT NULL,
  pass varchar(45) DEFAULT NULL,
  accType varchar(45) DEFAULT NULL
);

SELECT * FROM workers;
DROP TABLE  IF EXISTS employee;
CREATE TABLE employee
(
  id      INT(11) NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  first_name VARCHAR(255) NULL,
  last_name    VARCHAR(255) NULL,
  description    VARCHAR(255) NULL
);

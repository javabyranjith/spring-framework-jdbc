open sql workbench editor
File->Connect Window
Name: JBR
Driver: H2 Database Engine
URL: jdbc:h2:/H:/Installed/db/h2db/database/db
username: ranjith
password: sekar

CREATE TABLE users (
  user_id INTEGER NOT NULL CONSTRAINT EMP_NO_PK PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  email VARCHAR(40),
  phone INTEGER
);

INSERT INTO users VALUES(1,'Ranjith','Sekar','ranjith@gmail.com',96000);
INSERT INTO users VALUES(2,'Manoj','Kumar','manoj@gmail.com',88000);
INSERT INTO users VALUES(3,'Sachin','Tendulkar','sachin@gmail.com',77000);
CREATE DATABASE IF NOT EXISTS springjdbc;
USE springjdbc;
DROP TABLE IF EXISTS `springjdbc`.`product`;
CREATE TABLE product(
	id varchar(10), 
	name varchar(20), 
	category varchar(20), 
	description varchar(50), 
	price varchar(10)
);
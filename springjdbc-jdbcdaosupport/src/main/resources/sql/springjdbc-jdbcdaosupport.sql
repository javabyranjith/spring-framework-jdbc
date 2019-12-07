CREATE DATABASE IF NOT EXISTS spring_jdbc;

USE spring_jdbc;

DROP TABLE products;

CREATE TABLE spring_jdbc.products ( 
  id VARCHAR(30) NOT NULL,
  name VARCHAR(30) NOT NULL,
  category VARCHAR(20) NOT NULL,
  price INTEGER,
  quantity INTEGER
);
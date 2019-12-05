CREATE DATABASE IF NOT EXISTS spring_jdbc;
USE spring_jdbc;
DROP TABLE IF EXISTS `spring_jdbc`.`users`;
CREATE TABLE `spring_jdbc`.`users` (
  `user_id` VARCHAR(45) NOT NULL,
  `user_type` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` INT NULL,
  PRIMARY KEY (`user_id`));
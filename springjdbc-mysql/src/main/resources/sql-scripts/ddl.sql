CREATE DATABASE IF NOT EXISTS library;
USE library;
DROP TABLE IF EXISTS `library`.`users`;
CREATE TABLE `library`.`users` (
  `user_id` VARCHAR(45) NOT NULL,
  `user_type` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` INT NULL,
  PRIMARY KEY (`user_id`));

  

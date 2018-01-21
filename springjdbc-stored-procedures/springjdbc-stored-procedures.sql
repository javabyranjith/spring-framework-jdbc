CREATE TABLE animals ( 
name VARCHAR(30) NOT NULL,
food VARCHAR(20) NOT NULL,
color VARCHAR(30) NOT NULL
);

CREATE PROCEDURE getAnimal (IN in_name VARCHAR(20), OUT out_food VARCHAR(20), OUT out_color VARCHAR(20))
BEGIN
   SELECT food, color
   INTO out_food, out_color
   FROM animals where name = in_name;
END
CREATE DATABASE HW8;
USE HW8;

CREATE TABLE producers (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL UNIQUE,
  PRIMARY KEY (id));

CREATE TABLE products (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price decimal NOT NULL,
  producer_id int NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE users (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL UNIQUE,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role varchar(10) DEFAULT NULL,
  PRIMARY KEY (id));

INSERT INTO producers VALUES
 (1,'Coca-Cola Beverage'),
 (2,'Pepsico');

INSERT INTO products VALUES
 (1,'Coca-Cola',20,1),
 (2,'Fanta',15,1),
 (3,'Sprite',15,1),
 (4,'Pepsi',17,2),
 (5,'Mirinda',15,2),
 (6,'7UP',15,2);

INSERT INTO users VALUES
 (1,'user1@gmail.com','Ivan','Kozlov','123','USER'),
 (2,'user2@gmail.com','Petro','Bulba','234','USER'),
 (3,'admin@gmail.com','admin','admin','admin','ADMIN');
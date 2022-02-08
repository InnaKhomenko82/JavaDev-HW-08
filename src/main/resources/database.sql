CREATE DATABASE HW8;
USE hw8;

CREATE TABLE producers (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (id));

INSERT INTO producers VALUES
(1,"Coca-Cola Beverage"),
(2,"Pepsico");

CREATE TABLE products (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL UNIQUE,
  price decimal(10,2) NOT NULL,
  producer_id bigint DEFAULT NULL,
  PRIMARY KEY (id),  
  FOREIGN KEY (producer_id) REFERENCES producers (id));

INSERT INTO products VALUES
(1,"Coca-Cola",16.32,1),
(2,"Fanta",14.88,1),
(3,"Sprite",14.88,1),
(4,"Pepsi",17.46,2),
(5,"Mirinda",15.24,2),
(6,"7UP",15.24,2);

CREATE TABLE users (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL UNIQUE,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  role varchar(255) DEFAULT NULL,
  PRIMARY KEY (id));

INSERT INTO users VALUES
(1,"user1@gmail.com","Ivan","Kozlov","123","USER"),
(2,"user2@gmail.com","Petro","Bulba","234","USER"),
(3,"admin@gmail.com","admin","admin","admin","ADMIN");
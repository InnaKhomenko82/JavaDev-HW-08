CREATE DATABASE HW8;
USE hw8;

CREATE TABLE producers (
  id varchar(36) NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id));

INSERT INTO producers VALUES
("b4ee99f6-0713-4d2d-b2d3-b71017823a33","Coca-Cola Beverage"),
("c15fe5ae-02c6-4e4e-a324-f2c87a68190c","Pepsico");

CREATE TABLE products (
  id varchar(36) NOT NULL,
  name varchar(255) NOT NULL,
  price decimal(10,2) NOT NULL,
  producer_id varchar(36) DEFAULT NULL,
  PRIMARY KEY (id),  
  FOREIGN KEY (producer_id) REFERENCES producers (id));

INSERT INTO products VALUES
("00676620-3be0-4aaa-93d6-deac81e2b16d","Fanta",14.88,"b4ee99f6-0713-4d2d-b2d3-b71017823a33"),
("0d72c87e-9865-40a5-8504-f44868009cd3","Coca-Cola",16.32,"b4ee99f6-0713-4d2d-b2d3-b71017823a33"),
("2dcb622a-009a-45e5-b575-3f5783afd054","Pepsi",17.46,"c15fe5ae-02c6-4e4e-a324-f2c87a68190c"),
("4f6b55e5-b1bc-414f-91e4-68a85892c70a","Mirinda",15.24,"c15fe5ae-02c6-4e4e-a324-f2c87a68190c"),
("5d3bf274-03a6-44bc-aaab-c852bc97dadd","Sprite",14.88,"b4ee99f6-0713-4d2d-b2d3-b71017823a33"),
("fc45756a-f204-41da-99ae-f190f7e24bda","7UP",15.24,"c15fe5ae-02c6-4e4e-a324-f2c87a68190c");

CREATE TABLE users (
  id varchar(36) NOT NULL,
  email varchar(255) NOT NULL UNIQUE,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  role varchar(255) DEFAULT NULL,
  PRIMARY KEY (id));

INSERT INTO users VALUES
("59510ba4-04e6-4975-b746-8dc9e1c12ccb","admin@gmail.com","admin","admin","admin","ADMIN"),
("7e8f804b-2ea4-4438-9b3f-bc4248752950","user2@gmail.com","Petro","Bulba","234","USER"),
("8c12ce69-1f18-4949-9ca4-8155a4e543f6","user1@gmail.com","Ivan","Kozlov","123","USER");
CREATE DATABASE products_td;
create table products (
                 id SERIAL PRIMARY KEY,
                 name VARCHAR(255) NOT NULL,
                 price_per_unit float NOT NULL,
                 active_for_sell BOOLEAN NOT NULL
);



SELECT *FROM products;




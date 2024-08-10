-- Delete if exist
DROP DATABASE IF EXISTS crud_jdbc_postgres;

-- Create database
CREATE DATABASE crud_jdbc_postgres
	ENCODING = 'UTF8'
	LOCALE_PROVIDER = 'libc'
	CONNECTION LIMIT = -1
	IS_TEMPLATE = False;

-- Table <product>
CREATE TABLE IF NOT EXISTS product (
    product_id UUID DEFAULT GEN_RANDOM_UUID(),
    product_name VARCHAR(30) NOT NULL,
	price DECIMAL DEFAULT 0,
	stock SMALLINT DEFAULT 0,
    CONSTRAINT uk_product_name UNIQUE (product_name),
    CONSTRAINT pk_product PRIMARY KEY (product_id)
);

INSERT INTO product (product_name, price, stock)
VALUES 
	('Leche Gloria', 5.50, 20),
	('Aceite', 6.20, 15);

SELECT * FROM product;

-- Stored procedure
CREATE OR REPLACE FUNCTION get_product (_productId VARCHAR)
RETURNS SETOF product
LANGUAGE plpgsql AS $$
BEGIN
	RETURN QUERY
	SELECT product_id, product_name, price, stock
	FROM product
	WHERE product_id = CAST(_productId AS UUID);
END $$;

SELECT product_id, product_name, price, stock FROM get_product('aafa617d-94d8-405d-9ea1-7f7dc1905a73');

DELETE FROM product WHERE product_id = 'aafa617d-94d8-405d-9ea1-7f7dc1905a73';












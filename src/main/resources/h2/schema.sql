drop table if exists prices;
drop table if exists brands;
drop table if exists products;

-- Crear tabla de productos (products)
CREATE TABLE products
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY
);

-- Crear tabla de marcas (brands)
CREATE TABLE brands
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

-- Crear tabla de precios (prices)
CREATE TABLE prices
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT         NOT NULL,
    brand_id   BIGINT         NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    currency   VARCHAR(10)    NOT NULL,
    price_list INTEGER        NOT NULL,
    priority   INTEGER        NOT NULL,
    start_date TIMESTAMP      NOT NULL,
    end_date   TIMESTAMP      NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (brand_id) REFERENCES brands (id)
);

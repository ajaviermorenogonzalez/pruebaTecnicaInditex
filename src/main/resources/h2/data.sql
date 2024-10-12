-- Insertar productos de prueba
INSERT INTO products (id) VALUES (35455);

-- Insertar marcas de prueba
INSERT INTO brands (id, name) VALUES (1, 'ZARA');

-- Insertar precios de prueba con price_list y priority
INSERT INTO prices (product_id, brand_id, price, currency, start_date, end_date, price_list, priority)
VALUES (35455, 1, 35.50, 'EUR', '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 0);

INSERT INTO prices (product_id, brand_id, price, currency, start_date, end_date, price_list, priority)
VALUES (35455, 1, 25.45, 'EUR', '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 1);

INSERT INTO prices (product_id, brand_id, price, currency, start_date, end_date, price_list, priority)
VALUES (35455, 1, 30.50, 'EUR', '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 1);

INSERT INTO prices (product_id, brand_id, price, currency, start_date, end_date, price_list, priority)
VALUES (35455, 1, 38.95, 'EUR', '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 1);

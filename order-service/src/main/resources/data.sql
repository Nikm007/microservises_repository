-- Orders
INSERT INTO orders (total_price, status) VALUES (1599.98, 'PENDING');
INSERT INTO orders (total_price, status) VALUES (899.99, 'CONFIRMED');
INSERT INTO orders (total_price, status) VALUES (1299.99, 'DELIVERED');
INSERT INTO orders (total_price, status) VALUES (499.99, 'CANCELLED');
INSERT INTO orders (total_price, status) VALUES (2299.99, 'CONFIRMED');
INSERT INTO orders (total_price, status) VALUES (349.99, 'PENDING');
INSERT INTO orders (total_price, status) VALUES (799.99, 'DELIVERED');
INSERT INTO orders (total_price, status) VALUES (1199.99, 'CONFIRMED');
INSERT INTO orders (total_price, status) VALUES (2599.99, 'PENDING');
INSERT INTO orders (total_price, status) VALUES (699.99, 'DELIVERED');

-- Order Items
INSERT INTO order_item (quantity, product_id, order_id) VALUES (2, 101, 1);
INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 102, 1);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 103, 2);
INSERT INTO order_item (quantity, product_id, order_id) VALUES (2, 104, 2);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 105, 3);
INSERT INTO order_item (quantity, product_id, order_id) VALUES (3, 106, 3);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 107, 4);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (2, 108, 5);
INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 109, 5);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (4, 110, 6);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (2, 111, 7);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 112, 8);
INSERT INTO order_item (quantity, product_id, order_id) VALUES (2, 113, 8);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (3, 114, 9);

INSERT INTO order_item (quantity, product_id, order_id) VALUES (1, 115, 10);
USE exam_exercise;

INSERT INTO product (name, price, weight_in_grams)
VALUES
    ('Mælk', 10.99, 1000),
    ('Brød', 3.99, 500),
    ('Æg', 2.99, 400),
    ('Pasta', 1.49, 500),
    ('Ris', 4.99, 1000),
    ('Kyllingebryst', 7.99, 800),
    ('Bananer', 2.49, 600),
    ('Kartofler', 3.29, 1000),
    ('Tomater', 4.79, 400),
    ('Yoghurt', 1.99, 200),
    ('Gigantisk Tung Computer', 10000, 1000000);



INSERT INTO product_order (product_id, quantity, order_date)
VALUES
    (1, 2, '2022-03-01'),
    (2, 3, '2021-01-01'),
    (3, 1, '2021-01-01'),
    (4, 2, '2019-10-01'),
    (5, 1, '2020-01-01'),
    (6, 1, '2023-02-01'),
    (7, 2, '2021-05-01'),
    (8, 1, '2024-01-01'),
    (9, 1, '2021-07-01'),
    (10, 2, '2021-05-01'),
    (11, 1, '2021-05-01');

INSERT INTO van (brand, model, capacity_in_kg)
VALUES
    ('Mercedes', 'Sprinter', 1000),
    ('Ford', 'Transit', 800),
    ('Volkswagen', 'Crafter', 1200),
    ('Iveco', 'Daily', 1500),
    ('Renault', 'Master', 900);
USE exam_exercise;

INSERT INTO product (name, price, weight_in_grams)
VALUES
    ('Milk', 10.99, 1000),
    ('Bread', 3.99, 500),
    ('Eggs', 2.99, 400),
    ('Pasta', 1.49, 500),
    ('Rice', 4.99, 1000),
    ('Chicken breast', 7.99, 800),
    ('Bananas', 2.49, 600),
    ('Potatoes', 3.29, 1000),
    ('Tomatoes', 4.79, 400),
    ('Yogurt', 1.99, 200),
    ('Gigantic Heavy Computer', 10000, 1000000),
    ('Pear', 2.99, 200),
    ('Orange', 3.49, 300),
    ('Coffee', 5.99, 500),
    ('Tea', 4.99, 400),
    ('Chocolate milk', 6.99, 1000),
    ('Chicken leg', 5.99, 700),
    ('Chicken fillet', 8.99, 900),
    ('Chicken meat', 6.99, 800),
    ('Chicken', 7.99, 1000),
    ('Cheese', 4.99, 500),
    ('Ham', 3.49, 300),
    ('Sausage', 2.99, 200),
    ('Salad', 1.99, 100),
    ('Tomato sauce', 2.49, 400),
    ('Pizza dough', 1.99, 500),
    ('Sugar', 1.49, 1000),
    ('Flour', 1.99, 1000),
    ('Salt', 0.99, 1000),
    ('Pepper', 1.49, 100),
    ('Curry', 2.99, 100),
    ('Paprika', 2.49, 100),
    ('Chili', 2.99, 50),
    ('Garlic', 1.99, 100),
    ('Onions', 0.99, 200),
    ('Carrots', 1.49, 500),
    ('Bell pepper', 2.99, 200),
    ('Squash', 1.99, 300),
    ('Eggplant', 2.49, 400),
    ('Courgette', 2.99, 300),
    ('Broccoli', 2.49, 400);




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
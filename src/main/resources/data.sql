-- 브랜드 테이블 데이터 삽입
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('A', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('B', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('C', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('D', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('E', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('F', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('G', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('H', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at) VALUES ('I', FALSE, now(), now());

-- 상품 테이블 데이터 삽입 (브랜드별 8개 카테고리)
-- Brand A (id=1)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'TOP_A',       'TOP',       11200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'OUTER_A',     'OUTER',     5500,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'PANTS_A',     'PANTS',     4200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'SNEAKERS_A',  'SNEAKERS',  9000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'BAG_A',       'BAG',       2000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'HAT_A',       'HAT',       1700,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'SOCKS_A',     'SOCKS',     1800,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (1, 'ACCESSORY_A', 'ACCESSORY', 2300,  FALSE, now(), now());

-- Brand B (id=2)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'TOP_B',       'TOP',       10500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'OUTER_B',     'OUTER',     5900,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'PANTS_B',     'PANTS',     3800,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'SNEAKERS_B',  'SNEAKERS',  9100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'BAG_B',       'BAG',       2100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'HAT_B',       'HAT',       2000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'SOCKS_B',     'SOCKS',     2000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (2, 'ACCESSORY_B', 'ACCESSORY', 2200,  FALSE, now(), now());

-- Brand C (id=3)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'TOP_C',       'TOP',       10000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'OUTER_C',     'OUTER',     6200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'PANTS_C',     'PANTS',     3300,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'SNEAKERS_C',  'SNEAKERS',  9200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'BAG_C',       'BAG',       2200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'HAT_C',       'HAT',       1900,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'SOCKS_C',     'SOCKS',     2200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (3, 'ACCESSORY_C', 'ACCESSORY', 2100,  FALSE, now(), now());

-- Brand D (id=4)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'TOP_D',       'TOP',       10100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'OUTER_D',     'OUTER',     5100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'PANTS_D',     'PANTS',     3000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'SNEAKERS_D',  'SNEAKERS',  9500,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'BAG_D',       'BAG',       2500,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'HAT_D',       'HAT',       1500,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'SOCKS_D',     'SOCKS',     2400,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (4, 'ACCESSORY_D', 'ACCESSORY', 2000,  FALSE, now(), now());

-- Brand E (id=5)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'TOP_E',       'TOP',       10700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'OUTER_E',     'OUTER',     5000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'PANTS_E',     'PANTS',     3800,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'SNEAKERS_E',  'SNEAKERS',  9900,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'BAG_E',       'BAG',       2300,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'HAT_E',       'HAT',       1800,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'SOCKS_E',     'SOCKS',     2100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (5, 'ACCESSORY_E', 'ACCESSORY', 2100,  FALSE, now(), now());

-- Brand F (id=6)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'TOP_F',       'TOP',       11200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'OUTER_F',     'OUTER',     7200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'PANTS_F',     'PANTS',     4000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'SNEAKERS_F',  'SNEAKERS',  9300,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'BAG_F',       'BAG',       2100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'HAT_F',       'HAT',       1600,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'SOCKS_F',     'SOCKS',     2300,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (6, 'ACCESSORY_F', 'ACCESSORY', 1900,  FALSE, now(), now());

-- Brand G (id=7)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'TOP_G',       'TOP',       10500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'OUTER_G',     'OUTER',     5800,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'PANTS_G',     'PANTS',     3900,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'SNEAKERS_G',  'SNEAKERS',  9000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'BAG_G',       'BAG',       2200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'HAT_G',       'HAT',       1700,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'SOCKS_G',     'SOCKS',     2100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (7, 'ACCESSORY_G', 'ACCESSORY', 2000,  FALSE, now(), now());

-- Brand H (id=8)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'TOP_H',       'TOP',       10800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'OUTER_H',     'OUTER',     6300,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'PANTS_H',     'PANTS',     3100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'SNEAKERS_H',  'SNEAKERS',  9700,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'BAG_H',       'BAG',       2100,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'HAT_H',       'HAT',       1600,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'SOCKS_H',     'SOCKS',     2000,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (8, 'ACCESSORY_H', 'ACCESSORY', 2000,  FALSE, now(), now());

-- Brand I (id=9)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'TOP_I',       'TOP',       11400, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'OUTER_I',     'OUTER',     6700,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'PANTS_I',     'PANTS',     3200,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'SNEAKERS_I',  'SNEAKERS',  9500,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'BAG_I',       'BAG',       2400,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'HAT_I',       'HAT',       1700,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'SOCKS_I',     'SOCKS',     1700,  FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at) VALUES (9, 'ACCESSORY_I', 'ACCESSORY', 2400,  FALSE, now(), now());

-- 브랜드 테이블 데이터 삽입
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('A', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('B', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('C', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('D', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('E', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('F', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('G', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('H', FALSE, now(), now());
INSERT INTO brand (name, deleted, created_at, updated_at)
VALUES ('I', FALSE, now(), now());

-- 상품 테이블 데이터 삽입 (브랜드별 8개 카테고리)
-- Brand A (id=1)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'TOP_A', 'TOP', 11200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'OUTER_A', 'OUTER', 5500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'PANTS_A', 'PANTS', 4200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'SNEAKERS_A', 'SNEAKERS', 9000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'BAG_A', 'BAG', 2000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'HAT_A', 'HAT', 1700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'SOCKS_A', 'SOCKS', 1800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (1, 'ACCESSORY_A', 'ACCESSORY', 2300, FALSE, now(), now());

-- Brand B (id=2)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'TOP_B', 'TOP', 10500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'OUTER_B', 'OUTER', 5900, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'PANTS_B', 'PANTS', 3800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'SNEAKERS_B', 'SNEAKERS', 9100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'BAG_B', 'BAG', 2100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'HAT_B', 'HAT', 2000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'SOCKS_B', 'SOCKS', 2000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (2, 'ACCESSORY_B', 'ACCESSORY', 2200, FALSE, now(), now());

-- Brand C (id=3)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'TOP_C', 'TOP', 10000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'OUTER_C', 'OUTER', 6200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'PANTS_C', 'PANTS', 3300, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'SNEAKERS_C', 'SNEAKERS', 9200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'BAG_C', 'BAG', 2200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'HAT_C', 'HAT', 1900, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'SOCKS_C', 'SOCKS', 2200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (3, 'ACCESSORY_C', 'ACCESSORY', 2100, FALSE, now(), now());

-- Brand D (id=4)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'TOP_D', 'TOP', 10100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'OUTER_D', 'OUTER', 5100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'PANTS_D', 'PANTS', 3000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'SNEAKERS_D', 'SNEAKERS', 9500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'BAG_D', 'BAG', 2500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'HAT_D', 'HAT', 1500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'SOCKS_D', 'SOCKS', 2400, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (4, 'ACCESSORY_D', 'ACCESSORY', 2000, FALSE, now(), now());

-- Brand E (id=5)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'TOP_E', 'TOP', 10700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'OUTER_E', 'OUTER', 5000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'PANTS_E', 'PANTS', 3800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'SNEAKERS_E', 'SNEAKERS', 9900, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'BAG_E', 'BAG', 2300, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'HAT_E', 'HAT', 1800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'SOCKS_E', 'SOCKS', 2100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (5, 'ACCESSORY_E', 'ACCESSORY', 2100, FALSE, now(), now());

-- Brand F (id=6)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'TOP_F', 'TOP', 11200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'OUTER_F', 'OUTER', 7200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'PANTS_F', 'PANTS', 4000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'SNEAKERS_F', 'SNEAKERS', 9300, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'BAG_F', 'BAG', 2100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'HAT_F', 'HAT', 1600, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'SOCKS_F', 'SOCKS', 2300, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (6, 'ACCESSORY_F', 'ACCESSORY', 1900, FALSE, now(), now());

-- Brand G (id=7)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'TOP_G', 'TOP', 10500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'OUTER_G', 'OUTER', 5800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'PANTS_G', 'PANTS', 3900, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'SNEAKERS_G', 'SNEAKERS', 9000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'BAG_G', 'BAG', 2200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'HAT_G', 'HAT', 1700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'SOCKS_G', 'SOCKS', 2100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (7, 'ACCESSORY_G', 'ACCESSORY', 2000, FALSE, now(), now());

-- Brand H (id=8)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'TOP_H', 'TOP', 10800, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'OUTER_H', 'OUTER', 6300, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'PANTS_H', 'PANTS', 3100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'SNEAKERS_H', 'SNEAKERS', 9700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'BAG_H', 'BAG', 2100, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'HAT_H', 'HAT', 1600, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'SOCKS_H', 'SOCKS', 2000, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (8, 'ACCESSORY_H', 'ACCESSORY', 2000, FALSE, now(), now());

-- Brand I (id=9)
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'TOP_I', 'TOP', 11400, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'OUTER_I', 'OUTER', 6700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'PANTS_I', 'PANTS', 3200, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'SNEAKERS_I', 'SNEAKERS', 9500, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'BAG_I', 'BAG', 2400, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'HAT_I', 'HAT', 1700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'SOCKS_I', 'SOCKS', 1700, FALSE, now(), now());
INSERT INTO product (brand_id, name, category, price, deleted, created_at, updated_at)
VALUES (9, 'ACCESSORY_I', 'ACCESSORY', 2400, FALSE, now(), now());

-- brand_category_min_price_summary
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'ACCESSORY', '2025-05-23 22:45:35.28667', '2025-05-23 22:45:35.28667', 2300, 8, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'BAG', '2025-05-23 22:45:35.287436', '2025-05-23 22:45:35.287436', 2000, 5, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'HAT', '2025-05-23 22:45:35.287518', '2025-05-23 22:45:35.287518', 1700, 6, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'OUTER', '2025-05-23 22:45:35.28761', '2025-05-23 22:45:35.28761', 5500, 2, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'PANTS', '2025-05-23 22:45:35.287704', '2025-05-23 22:45:35.287704', 4200, 3, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'SNEAKERS', '2025-05-23 22:45:35.287783', '2025-05-23 22:45:35.287783', 9000, 4, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'SOCKS', '2025-05-23 22:45:35.287881', '2025-05-23 22:45:35.287881', 1800, 7, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (1, 'TOP', '2025-05-23 22:45:35.288039', '2025-05-23 22:45:35.288039', 11200, 1, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'ACCESSORY', '2025-05-23 22:45:35.288176', '2025-05-23 22:45:35.288176', 2200, 16, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'BAG', '2025-05-23 22:45:35.288281', '2025-05-23 22:45:35.288281', 2100, 13, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'HAT', '2025-05-23 22:45:35.288348', '2025-05-23 22:45:35.288348', 2000, 14, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'OUTER', '2025-05-23 22:45:35.288409', '2025-05-23 22:45:35.288409', 5900, 10, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'PANTS', '2025-05-23 22:45:35.288471', '2025-05-23 22:45:35.288471', 3800, 11, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'SNEAKERS', '2025-05-23 22:45:35.288536', '2025-05-23 22:45:35.288536', 9100, 12, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'SOCKS', '2025-05-23 22:45:35.288628', '2025-05-23 22:45:35.288628', 2000, 15, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (2, 'TOP', '2025-05-23 22:45:35.288748', '2025-05-23 22:45:35.288748', 10500, 9, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'ACCESSORY', '2025-05-23 22:45:35.288819', '2025-05-23 22:45:35.288819', 2100, 24, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'BAG', '2025-05-23 22:45:35.288897', '2025-05-23 22:45:35.288897', 2200, 21, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'HAT', '2025-05-23 22:45:35.288977', '2025-05-23 22:45:35.288977', 1900, 22, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'OUTER', '2025-05-23 22:45:35.289046', '2025-05-23 22:45:35.289046', 6200, 18, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'PANTS', '2025-05-23 22:45:35.289125', '2025-05-23 22:45:35.289125', 3300, 19, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'SNEAKERS', '2025-05-23 22:45:35.289228', '2025-05-23 22:45:35.289228', 9200, 20, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'SOCKS', '2025-05-23 22:45:35.289314', '2025-05-23 22:45:35.289314', 2200, 23, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (3, 'TOP', '2025-05-23 22:45:35.289384', '2025-05-23 22:45:35.289384', 10000, 17, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'ACCESSORY', '2025-05-23 22:45:35.289469', '2025-05-23 22:45:35.289469', 2000, 32, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'BAG', '2025-05-23 22:45:35.289539', '2025-05-23 22:45:35.289539', 2500, 29, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'HAT', '2025-05-23 22:45:35.289614', '2025-05-23 22:45:35.289614', 1500, 30, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'OUTER', '2025-05-23 22:45:35.289678', '2025-05-23 22:45:35.289678', 5100, 26, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'PANTS', '2025-05-23 22:45:35.289749', '2025-05-23 22:45:35.289749', 3000, 27, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'SNEAKERS', '2025-05-23 22:45:35.289836', '2025-05-23 22:45:35.289836', 9500, 28, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'SOCKS', '2025-05-23 22:45:35.289898', '2025-05-23 22:45:35.289898', 2400, 31, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (4, 'TOP', '2025-05-23 22:45:35.289973', '2025-05-23 22:45:35.289973', 10100, 25, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'ACCESSORY', '2025-05-23 22:45:35.290046', '2025-05-23 22:45:35.290046', 2100, 40, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'BAG', '2025-05-23 22:45:35.290119', '2025-05-23 22:45:35.290119', 2300, 37, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'HAT', '2025-05-23 22:45:35.290193', '2025-05-23 22:45:35.290193', 1800, 38, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'OUTER', '2025-05-23 22:45:35.290266', '2025-05-23 22:45:35.290266', 5000, 34, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'PANTS', '2025-05-23 22:45:35.290394', '2025-05-23 22:45:35.290394', 3800, 35, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'SNEAKERS', '2025-05-23 22:45:35.290478', '2025-05-23 22:45:35.290478', 9900, 36, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'SOCKS', '2025-05-23 22:45:35.290548', '2025-05-23 22:45:35.290548', 2100, 39, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (5, 'TOP', '2025-05-23 22:45:35.290619', '2025-05-23 22:45:35.290619', 10700, 33, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'ACCESSORY', '2025-05-23 22:45:35.290694', '2025-05-23 22:45:35.290694', 1900, 48, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'BAG', '2025-05-23 22:45:35.290766', '2025-05-23 22:45:35.290766', 2100, 45, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'HAT', '2025-05-23 22:45:35.290838', '2025-05-23 22:45:35.290838', 1600, 46, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'OUTER', '2025-05-23 22:45:35.290924', '2025-05-23 22:45:35.290924', 7200, 42, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'PANTS', '2025-05-23 22:45:35.291006', '2025-05-23 22:45:35.291006', 4000, 43, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'SNEAKERS', '2025-05-23 22:45:35.291076', '2025-05-23 22:45:35.291076', 9300, 44, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'SOCKS', '2025-05-23 22:45:35.291152', '2025-05-23 22:45:35.291152', 2300, 47, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (6, 'TOP', '2025-05-23 22:45:35.291226', '2025-05-23 22:45:35.291226', 11200, 41, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'ACCESSORY', '2025-05-23 22:45:35.291295', '2025-05-23 22:45:35.291295', 2000, 56, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'BAG', '2025-05-23 22:45:35.291364', '2025-05-23 22:45:35.291364', 2200, 53, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'HAT', '2025-05-23 22:45:35.291435', '2025-05-23 22:45:35.291435', 1700, 54, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'OUTER', '2025-05-23 22:45:35.291495', '2025-05-23 22:45:35.291495', 5800, 50, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'PANTS', '2025-05-23 22:45:35.291557', '2025-05-23 22:45:35.291557', 3900, 51, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'SNEAKERS', '2025-05-23 22:45:35.291625', '2025-05-23 22:45:35.291625', 9000, 52, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'SOCKS', '2025-05-23 22:45:35.291692', '2025-05-23 22:45:35.291692', 2100, 55, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (7, 'TOP', '2025-05-23 22:45:35.291759', '2025-05-23 22:45:35.291759', 10500, 49, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'ACCESSORY', '2025-05-23 22:45:35.291838', '2025-05-23 22:45:35.291838', 2000, 64, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'BAG', '2025-05-23 22:45:35.291897', '2025-05-23 22:45:35.291897', 2100, 61, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'HAT', '2025-05-23 22:45:35.291982', '2025-05-23 22:45:35.291982', 1600, 62, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'OUTER', '2025-05-23 22:45:35.292048', '2025-05-23 22:45:35.292048', 6300, 58, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'PANTS', '2025-05-23 22:45:35.292108', '2025-05-23 22:45:35.292108', 3100, 59, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'SNEAKERS', '2025-05-23 22:45:35.292167', '2025-05-23 22:45:35.292167', 9700, 60, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'SOCKS', '2025-05-23 22:45:35.292227', '2025-05-23 22:45:35.292227', 2000, 63, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (8, 'TOP', '2025-05-23 22:45:35.292295', '2025-05-23 22:45:35.292295', 10800, 57, 0);

INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'ACCESSORY', '2025-05-23 22:45:35.292354', '2025-05-23 22:45:35.292354', 2400, 72, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'BAG', '2025-05-23 22:45:35.292419', '2025-05-23 22:45:35.292419', 2400, 69, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'HAT', '2025-05-23 22:45:35.292475', '2025-05-23 22:45:35.292475', 1700, 70, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'OUTER', '2025-05-23 22:45:35.292537', '2025-05-23 22:45:35.292537', 6700, 66, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'PANTS', '2025-05-23 22:45:35.292598', '2025-05-23 22:45:35.292598', 3200, 67, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'SNEAKERS', '2025-05-23 22:45:35.292651', '2025-05-23 22:45:35.292651', 9500, 68, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'SOCKS', '2025-05-23 22:45:35.292739', '2025-05-23 22:45:35.292739', 1700, 71, 0);
INSERT INTO brand_category_min_price_summary
    (brand_id, category, created_at, updated_at, min_price, min_product_id, version)
VALUES (9, 'TOP', '2025-05-23 22:45:35.292832', '2025-05-23 22:45:35.292832', 11400, 65, 0);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('TOP', now(), now(), 9, 11400, 65, 3, 10000, 17);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('OUTER', now(), now(), 6, 7200, 42, 5, 5000, 34);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('PANTS', now(), now(), 1, 4200, 3, 4, 3000, 27);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('SNEAKERS', now(), now(), 5, 9900, 36, 1, 9000, 4);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('BAG', now(), now(), 4, 2500, 29, 1, 2000, 5);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('HAT', now(), now(), 2, 2000, 14, 4, 1500, 30);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('SOCKS', now(), now(), 4, 2400, 31, 9, 1700, 71);

INSERT INTO category_price_summary
    (category, created_at, updated_at, max_brand_id, max_price, max_product_id, min_brand_id, min_price, min_product_id)
VALUES ('ACCESSORY', now(), now(), 9, 2400, 72, 6, 1900, 48);

INSERT INTO brand_total_summary
    (id, min_brand_id, created_at, updated_at, total_price)
VALUES (1, 4, now(), now(), 36100);
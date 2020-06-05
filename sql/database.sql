CREATE DATABASE exam_store;


CREATE TABLE `commodity_category` (
                                      `category_id` int(10) NOT NULL AUTO_INCREMENT,
                                      `category_name` varchar(10) DEFAULT NULL,
                                      PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `commodity_info` (
                                  `commodity_id` int(11) NOT NULL AUTO_INCREMENT,
                                  `commodity_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
                                  `commodity_price` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品单价',
                                  `commodity_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
                                  `commodity_stock` int(11) NOT NULL COMMENT '库存',
                                  `commodity_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
                                  `commodity_category` int(11) NOT NULL COMMENT '类目编号',
                                  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品表'


CREATE TABLE `commodity_order` (
                                   `order_id` int(10) NOT NULL AUTO_INCREMENT,
                                   `order_price` varchar(10) DEFAULT NULL,
                                   `order_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                   PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `commodity_specs` (
                                   `specs_id` int(11) NOT NULL AUTO_INCREMENT,
                                   `commodity_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                   `specs_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
                                   `specs_stock` int(11) NOT NULL COMMENT '库存',
                                   `specs_price` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '单价',
                                   `specs_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
                                   PRIMARY KEY (`specs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品规格表'


CREATE TABLE `user` (
                        `uid` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(100) NOT NULL,
                        `password` varchar(32) NOT NULL,
                        `name` varchar(100) DEFAULT NULL,
                        `birthday` date DEFAULT NULL,
                        `sex` char(1) DEFAULT NULL,
                        `telephone` varchar(11) DEFAULT NULL,
                        `email` varchar(100) DEFAULT NULL,
                        `status` char(1) DEFAULT NULL,
                        `code` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`uid`),
                        UNIQUE KEY `AK_nq_username` (`username`),
                        UNIQUE KEY `AK_nq_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


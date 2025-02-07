/*
 Navicat Premium Dump SQL

 Source Server         : localhot
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44)
 Source Host           : localhost:3306
 Source Schema         : express

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44)
 File Encoding         : 65001

 Date: 06/02/2025 19:04:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for express_order
-- ----------------------------
DROP TABLE IF EXISTS `express_order`;
CREATE TABLE `express_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send_id` int(11) NOT NULL COMMENT '寄建人id',
  `receive_id` int(11) NOT NULL COMMENT '收件人id',
  `type` int(11) NOT NULL COMMENT '寄件类型',
  `expect_time` datetime NOT NULL COMMENT '期待上门时间',
  `item_id` int(11) NOT NULL COMMENT '物品信息id',
  `pay_method` int(11) NOT NULL COMMENT '付款方式 0寄付 1到付',
  `estimated_total_price` decimal(10, 2) NOT NULL COMMENT '预估总价',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express_order
-- ----------------------------
INSERT INTO `express_order` VALUES (1, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (2, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (3, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (4, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (5, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (6, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (7, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (8, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (9, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (10, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (11, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (12, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (13, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (14, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (15, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (16, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (17, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (18, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (19, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (20, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (21, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (22, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (23, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (24, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (25, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (26, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (27, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (28, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (29, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (30, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (31, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (32, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');
INSERT INTO `express_order` VALUES (33, 101, 202, 1, '2025-02-06 15:00:00', 303, 0, 123.45, '2025-02-06 14:00:00', '2025-02-06 15:00:00');

SET FOREIGN_KEY_CHECKS = 1;

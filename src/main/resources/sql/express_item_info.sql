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

 Date: 06/02/2025 19:04:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for express_item_info
-- ----------------------------
DROP TABLE IF EXISTS `express_item_info`;
CREATE TABLE `express_item_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '物品名称',
  `estimated_weight` double NOT NULL COMMENT '\r\n预估重量',
  `total_volume` double NOT NULL COMMENT '总体积',
  `type` int(11) NOT NULL COMMENT '物品分类',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express_item_info
-- ----------------------------
INSERT INTO `express_item_info` VALUES (1, 'Sample Express Itemchange', 2.5, 1.2, 1, '2025-02-06 16:04:34', '2025-02-06 16:09:24');
INSERT INTO `express_item_info` VALUES (2, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:36', '2025-02-06 16:04:36');
INSERT INTO `express_item_info` VALUES (3, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:36', '2025-02-06 16:04:36');
INSERT INTO `express_item_info` VALUES (4, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:36', '2025-02-06 16:04:36');
INSERT INTO `express_item_info` VALUES (5, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:36', '2025-02-06 16:04:36');
INSERT INTO `express_item_info` VALUES (6, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:36', '2025-02-06 16:04:36');
INSERT INTO `express_item_info` VALUES (7, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:37', '2025-02-06 16:04:37');
INSERT INTO `express_item_info` VALUES (8, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:37', '2025-02-06 16:04:37');
INSERT INTO `express_item_info` VALUES (9, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:37', '2025-02-06 16:04:37');
INSERT INTO `express_item_info` VALUES (10, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:37', '2025-02-06 16:04:37');
INSERT INTO `express_item_info` VALUES (11, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:37', '2025-02-06 16:04:37');
INSERT INTO `express_item_info` VALUES (12, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (13, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (14, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (15, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (16, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (17, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (18, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (19, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:38', '2025-02-06 16:04:38');
INSERT INTO `express_item_info` VALUES (20, 'Sample Express Item', 2.5, 1.2, 1, '2025-02-06 16:04:39', '2025-02-06 16:04:39');

SET FOREIGN_KEY_CHECKS = 1;

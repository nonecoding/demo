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

 Date: 06/02/2025 19:03:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for express_address
-- ----------------------------
DROP TABLE IF EXISTS `express_address`;
CREATE TABLE `express_address`  (
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_default` int(11) NOT NULL COMMENT '是否是默认寄件地址',
  `detail_address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '详细地址',
  `city_area` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '城市/地区',
  `phone_number` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '联系人电话',
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '联系人名称',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express_address
-- ----------------------------
INSERT INTO `express_address` VALUES ('2025-02-05 18:48:29', '2025-02-05 18:48:29', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 12);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:23', '2025-02-05 18:55:23', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 13);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:24', '2025-02-05 18:55:24', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 14);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:24', '2025-02-05 18:55:24', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 15);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:25', '2025-02-05 18:55:25', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 16);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:25', '2025-02-05 18:55:25', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 17);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:26', '2025-02-05 18:55:26', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 18);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:26', '2025-02-05 18:55:26', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 19);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:27', '2025-02-05 18:55:27', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 20);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:27', '2025-02-05 18:55:27', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 21);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:28', '2025-02-05 18:55:28', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 22);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:29', '2025-02-05 18:55:29', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 23);
INSERT INTO `express_address` VALUES ('2025-02-05 18:55:29', '2025-02-05 18:55:29', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 24);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:07', '2025-02-05 18:59:07', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 25);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:09', '2025-02-05 18:59:09', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 26);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:34', '2025-02-05 18:59:34', 1, '123 Main St, Apt 4B', 'Springfield', '01044447765', 'John Doe', 27);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:35', '2025-02-05 18:59:35', 1, '123 Main St, Apt 4B', 'Springfield', '01044447765', 'John Doe', 28);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:35', '2025-02-05 18:59:35', 1, '123 Main St, Apt 4B', 'Springfield', '01044447765', 'John Doe', 29);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:36', '2025-02-05 18:59:36', 1, '123 Main St, Apt 4B', 'Springfield', '01044447765', 'John Doe', 30);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:39', '2025-02-05 18:59:39', 1, '123 Main St, Apt 4B', 'Springfield', '0104444776', 'John Doe', 31);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:47', '2025-02-05 18:59:47', 1, '123 Main St, Apt 4B', 'Springfield', '01044447769', 'John Doe', 32);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:47', '2025-02-05 18:59:47', 1, '123 Main St, Apt 4B', 'Springfield', '01044447769', 'John Doe', 33);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:48', '2025-02-05 18:59:48', 1, '123 Main St, Apt 4B', 'Springfield', '01044447769', 'John Doe', 34);
INSERT INTO `express_address` VALUES ('2025-02-05 18:59:48', '2025-02-05 18:59:48', 1, '123 Main St, Apt 4B', 'Springfield', '01044447769', 'John Doe', 35);
INSERT INTO `express_address` VALUES ('2025-02-05 19:08:58', '2025-02-05 19:08:58', 1, '123 Main St, Apt 4B', 'Springfield', '01044447769', 'John Doe', 36);
INSERT INTO `express_address` VALUES ('2025-02-05 19:08:59', '2025-02-05 19:08:59', 1, '123 Main St, Apt 4B', 'Springfield', '01044447769', 'John Doe', 37);
INSERT INTO `express_address` VALUES ('2025-02-05 19:09:15', '2025-02-05 19:09:15', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 38);
INSERT INTO `express_address` VALUES ('2025-02-05 19:09:16', '2025-02-05 19:09:16', 1, '123 Main St, Apt 4B', 'Springfield', '13567899999', 'John Doe', 39);
INSERT INTO `express_address` VALUES ('2025-02-05 19:11:07', '2025-02-05 19:11:07', 1, '123 Main St, Apt 4B', 'Springfield', '02066667765', 'John Doe', 40);
INSERT INTO `express_address` VALUES ('2025-02-05 19:11:27', '2025-02-05 19:11:27', 1, '123 Main St, Apt 4B', 'Springfield', '01066667765', 'John Doe', 41);
INSERT INTO `express_address` VALUES ('2025-02-05 20:30:45', '2025-02-05 20:30:45', 1, '123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, ', 'Springfield', '01066667765', 'John Doe', 42);
INSERT INTO `express_address` VALUES ('2025-02-05 20:32:18', '2025-02-05 20:32:18', 1, '123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, Apt 4B123 Main St, ', 'Springfield', '01066667765', 'John Doe', 43);

SET FOREIGN_KEY_CHECKS = 1;

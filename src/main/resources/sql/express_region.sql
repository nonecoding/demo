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

 Date: 06/02/2025 19:04:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for express_region
-- ----------------------------
DROP TABLE IF EXISTS `express_region`;
CREATE TABLE `express_region`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '区域名称',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '上级区域 id，如果为空表示顶层省份',
  `level` int(11) NOT NULL COMMENT '区域级别，如 1 省, 2 市, 3 区',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of express_region
-- ----------------------------
INSERT INTO `express_region` VALUES (1, '北京市', NULL, 1, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (2, '北京市', 1, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (3, '东城区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (4, '西城区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (5, '朝阳区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (6, '丰台区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (7, '石景山区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (8, '海淀区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (9, '门头沟区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (10, '房山区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (11, '通州区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (12, '顺义区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (13, '昌平区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (14, '大兴区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (15, '怀柔区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (16, '平谷区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (17, '密云区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (18, '延庆区', 2, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (19, '上海市', NULL, 1, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (20, '上海市', 19, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (21, '黄浦区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (22, '徐汇区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (23, '长宁区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (24, '静安区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (25, '普陀区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (26, '虹口区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (27, '杨浦区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (28, '闵行区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (29, '宝山区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (30, '嘉定区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (31, '浦东新区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (32, '金山区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (33, '松江区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (34, '青浦区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (35, '奉贤区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (36, '崇明区', 20, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (37, '天津市', NULL, 1, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (38, '天津市', 37, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (39, '和平区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (40, '河东区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (41, '河西区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (42, '南开区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (43, '河北区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (44, '红桥区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (45, '塘沽区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (46, '汉沽区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (47, '大港区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (48, '东丽区', 38, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (49, '广东省', NULL, 1, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (50, '广州市', 49, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (51, '荔湾区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (52, '越秀区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (53, '海珠区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (54, '天河区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (55, '白云区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (56, '黄埔区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (57, '番禺区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (58, '花都区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (59, '南沙区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (60, '萝岗区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (61, '增城区', 50, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (62, '深圳市', 49, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (63, '罗湖区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (64, '福田区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (65, '南山区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (66, '宝安区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (67, '龙岗区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (68, '盐田区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (69, '光明新区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (70, '坪山新区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (71, '大鹏新区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (72, '龙华新区', 62, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (73, '江苏省', NULL, 1, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (74, '南京市', 73, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (75, '玄武区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (76, '秦淮区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (77, '建邺区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (78, '鼓楼区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (79, '浦口区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (80, '栖霞区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (81, '雨花台区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (82, '江宁区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (83, '溧水区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (84, '高淳区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (85, '六合区', 74, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (86, '苏州市', 73, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (87, '姑苏区', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (88, '相城区', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (89, '吴中区', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (90, '虎丘区', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (91, '吴江区', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (92, '常熟市', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (93, '张家港市', 86, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (94, '浙江省', NULL, 1, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (95, '杭州市', 94, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (96, '上城区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (97, '下城区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (98, '江干区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (99, '拱墅区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (100, '西湖区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (101, '滨江区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (102, '萧山区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (103, '余杭区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (104, '富阳区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (105, '临安区', 95, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (106, '宁波市', 94, 2, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (107, '海曙区', 106, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (108, '江东区', 106, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (109, '江北区', 106, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (110, '镇海区', 106, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (111, '北仑区', 106, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');
INSERT INTO `express_region` VALUES (112, '鄞州区', 106, 3, '2025-02-06 18:37:33', '2025-02-06 18:37:33');

SET FOREIGN_KEY_CHECKS = 1;

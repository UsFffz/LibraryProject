/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100518
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 100518
 File Encoding         : 65001

 Date: 08/06/2023 11:01:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍名称',
  `num` int NULL DEFAULT NULL COMMENT '书籍售量',
  `message` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书籍信息',
  `inventory` int NULL DEFAULT NULL COMMENT '书籍库存',
  `sale` decimal(11, 2) NULL DEFAULT NULL COMMENT '书籍售价',
  `integral` bigint NULL DEFAULT NULL COMMENT '购买书籍后所增积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'java', 63, 'aaass', 11, 30.00, 10);
INSERT INTO `book` VALUES (2, 'mysql', 65, '从删库到跑路', 0, 30.00, 10);
INSERT INTO `book` VALUES (3, 'linux', 74, '从进门到坐牢', 9, 30.00, 10);
INSERT INTO `book` VALUES (4, 'c++', 62, '从基础到入门', 23, 30.00, 10);
INSERT INTO `book` VALUES (5, 'javaweb', 89, '从简单到复杂', 85, 30.00, 10);
INSERT INTO `book` VALUES (6, 'c#', 65, '难难难', 18, 30.00, 10);
INSERT INTO `book` VALUES (11, '1', 44, '1', 57, 30.00, 10);
INSERT INTO `book` VALUES (12, '周大漂亮是如何成为大漂亮的', 95, '这本书完美诠释了周大漂亮是如何一步一步变为大漂亮的,一共好几十部,一部限量一百本', 5, 39.00, 520);
INSERT INTO `book` VALUES (105, '周巧双是如何成为大漂亮的26', 56, '这本书主要描述周巧双是怎么变漂亮的,有续集好几十部,每部限量100本,售完即止.', 44, 150.00, 520);
INSERT INTO `book` VALUES (106, '周巧双是如何成为大漂亮的26', 19, '这本书主要描述周巧双是怎么变漂亮的,有续集好几十部,每部限量100本,售完即止.', 81, 39.00, 520);
INSERT INTO `book` VALUES (107, '周巧双是如何成为大漂亮的26', 5, '这本书主要描述周巧双是怎么变漂亮的,有续集好几十部,每部限量100本,售完即止.', 95, 39.00, 520);
INSERT INTO `book` VALUES (108, '周巧双是如何成为大漂亮的26', 9, '这本书主要描述周巧双是怎么变漂亮的,有续集好几十部,每部限量100本,售完即止.', 91, 39.00, NULL);
INSERT INTO `book` VALUES (109, '周巧双是如何成为大漂亮的26', 0, '这本书主要描述周巧双是怎么变漂亮的,有续集好几十部,每部限量100本,售完即止.', 100, 17.00, NULL);

SET FOREIGN_KEY_CHECKS = 1;

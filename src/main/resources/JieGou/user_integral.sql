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

 Date: 08/06/2023 11:02:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_integral
-- ----------------------------
DROP TABLE IF EXISTS `user_integral`;
CREATE TABLE `user_integral`  (
  `userid` int NOT NULL COMMENT '用户id',
  `integral` bigint NULL DEFAULT NULL COMMENT '所拥有积分数量',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_integral
-- ----------------------------
INSERT INTO `user_integral` VALUES (2, 0);
INSERT INTO `user_integral` VALUES (1017, 10405);

SET FOREIGN_KEY_CHECKS = 1;

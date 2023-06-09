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

 Date: 08/06/2023 11:02:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userwallet
-- ----------------------------
DROP TABLE IF EXISTS `userwallet`;
CREATE TABLE `userwallet`  (
  `userid` int NOT NULL COMMENT '用户id',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '用户所拥余额',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userwallet
-- ----------------------------
INSERT INTO `userwallet` VALUES (2, 10000.00);
INSERT INTO `userwallet` VALUES (1017, 0.00);

SET FOREIGN_KEY_CHECKS = 1;

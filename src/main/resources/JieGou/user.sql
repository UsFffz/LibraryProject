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

 Date: 08/06/2023 11:02:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` int NULL DEFAULT NULL COMMENT '状态 0为冻结 1为正常使用',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1018 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'user', '$2a$10$qhTqjzAqDTj0/MuB4BAu8uZ.IXpfoaszhUB6mvXrNEhFC9phdVyDi', 1);
INSERT INTO `user` VALUES (1017, 'admin', '$2a$10$yTuzKguBqRB/U2heDp.3UOq59/NaQKgSDBc.xs9draBP7shnDMQPC', 1);

SET FOREIGN_KEY_CHECKS = 1;

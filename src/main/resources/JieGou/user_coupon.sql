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

 Date: 08/06/2023 11:02:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `user_coupon`;
CREATE TABLE `user_coupon`  (
  `userid` int NOT NULL COMMENT '用户id',
  `coupon_id` int NULL DEFAULT NULL COMMENT '优惠卷id',
  `num` int NULL DEFAULT NULL COMMENT '所拥有优惠卷数量'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_coupon
-- ----------------------------
INSERT INTO `user_coupon` VALUES (1017, 1, 100);
INSERT INTO `user_coupon` VALUES (1017, 2, 99);
INSERT INTO `user_coupon` VALUES (1017, 3, 100);
INSERT INTO `user_coupon` VALUES (1017, 4, 97);

SET FOREIGN_KEY_CHECKS = 1;

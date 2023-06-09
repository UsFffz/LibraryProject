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

 Date: 08/06/2023 11:02:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for couponeffect
-- ----------------------------
DROP TABLE IF EXISTS `couponeffect`;
CREATE TABLE `couponeffect`  (
  `coupon_id` int NOT NULL COMMENT '优惠卷id',
  `coupon_effect` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠卷效果 a-b a为满减所需金额 b为优惠金额 a% a为现价格比例 a a为任意消费金额优惠金额',
  PRIMARY KEY (`coupon_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of couponeffect
-- ----------------------------
INSERT INTO `couponeffect` VALUES (1, '100-30');
INSERT INTO `couponeffect` VALUES (2, '70%');
INSERT INTO `couponeffect` VALUES (3, '50-20');
INSERT INTO `couponeffect` VALUES (4, '10');

SET FOREIGN_KEY_CHECKS = 1;

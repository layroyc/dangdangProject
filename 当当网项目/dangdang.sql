/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : dangdang

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-12-18 09:48:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `d_item`
-- ----------------------------
DROP TABLE IF EXISTS `d_item`;
CREATE TABLE `d_item` (
  `id` varchar(40) NOT NULL,
  `book_name` varchar(40) DEFAULT NULL,
  `discount_price` double DEFAULT NULL,
  `count` double DEFAULT NULL,
  `priceTotal` double DEFAULT NULL,
  `book_id` varchar(40) DEFAULT NULL,
  `order_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_item
-- ----------------------------
INSERT INTO `d_item` VALUES ('1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `d_order`
-- ----------------------------
DROP TABLE IF EXISTS `d_order`;
CREATE TABLE `d_order` (
  `id` varchar(40) NOT NULL,
  `order_number` varchar(30) DEFAULT NULL,
  `order_times` date DEFAULT NULL,
  `total_price` decimal(12,2) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `user_id` varchar(40) DEFAULT NULL,
  `addr_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_order
-- ----------------------------
INSERT INTO `d_order` VALUES ('1', '1', '2020-12-09', '1.00', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `m_book`
-- ----------------------------
DROP TABLE IF EXISTS `m_book`;
CREATE TABLE `m_book` (
  `id` varchar(40) NOT NULL,
  `cate_id` varchar(40) DEFAULT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `page_number` int(11) DEFAULT NULL,
  `word_number` int(11) DEFAULT NULL,
  `original_price` int(11) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `discount_price` double DEFAULT NULL,
  `repertory` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `edit_recommend` varchar(255) DEFAULT NULL,
  `publish_company` varchar(255) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `prospectus` varchar(255) DEFAULT NULL,
  `edition` varchar(100) DEFAULT NULL,
  `print_time` date DEFAULT NULL,
  `author_intro` varchar(255) DEFAULT NULL,
  `print_number` varchar(100) DEFAULT NULL,
  `isbn` int(11) DEFAULT NULL,
  `catalog` varchar(255) DEFAULT NULL,
  `book_size` varchar(50) DEFAULT NULL,
  `paper_type` varchar(50) DEFAULT NULL,
  `media_comment` varchar(255) DEFAULT NULL,
  `pack_type` varchar(50) DEFAULT NULL,
  `sales_volume` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_book
-- ----------------------------
INSERT INTO `m_book` VALUES ('1', '10', '1', '1', '1', '1', '1.jpg', '1', '1', '1', '1', '11', '2020-12-09', '1', '1', '2020-12-09', '1', '1', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `m_category`
-- ----------------------------
DROP TABLE IF EXISTS `m_category`;
CREATE TABLE `m_category` (
  `id` varchar(40) NOT NULL,
  `category` varchar(30) DEFAULT NULL,
  `levels` int(11) DEFAULT NULL,
  `parent_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_category
-- ----------------------------
INSERT INTO `m_category` VALUES ('1', '小说', '1', 'null');
INSERT INTO `m_category` VALUES ('10', '重生小说', '2', '1');
INSERT INTO `m_category` VALUES ('11', '校园小说', '2', '1');
INSERT INTO `m_category` VALUES ('12', '西游记', '2', '2');
INSERT INTO `m_category` VALUES ('12384162-fd86-44ce-af61-6aca3d053422', '', '2', '1');
INSERT INTO `m_category` VALUES ('13', '水浒传', '2', '2');
INSERT INTO `m_category` VALUES ('14', '红楼梦', '2', '2');
INSERT INTO `m_category` VALUES ('15', '三国演义', '2', '2');
INSERT INTO `m_category` VALUES ('16', '养生篇', '2', '3');
INSERT INTO `m_category` VALUES ('17', '瑜伽篇', '2', '3');
INSERT INTO `m_category` VALUES ('18', '健身游泳了解一下', '2', '3');
INSERT INTO `m_category` VALUES ('19', '爱情三十六计', '2', '4');
INSERT INTO `m_category` VALUES ('2', '名著', '1', 'null');
INSERT INTO `m_category` VALUES ('20', '线数', '2', '5');
INSERT INTO `m_category` VALUES ('21', '高数', '2', '5');
INSERT INTO `m_category` VALUES ('22', '三年高考五年模拟数学', '2', '5');
INSERT INTO `m_category` VALUES ('23', '专四考题', '2', '6');
INSERT INTO `m_category` VALUES ('24', '专八考题', '2', '6');
INSERT INTO `m_category` VALUES ('3', '保健', '1', 'null');
INSERT INTO `m_category` VALUES ('4', '爱情', '1', 'null');
INSERT INTO `m_category` VALUES ('5', '数学', '1', 'null');
INSERT INTO `m_category` VALUES ('6', '英语', '1', 'null');
INSERT INTO `m_category` VALUES ('7', '言情小说', '2', '1');
INSERT INTO `m_category` VALUES ('8', '玄幻小说', '2', '1');
INSERT INTO `m_category` VALUES ('9', '穿越小说', '2', '1');
INSERT INTO `m_category` VALUES ('eb6fc5df-59f3-4ab4-86e4-92e09cf0c3a1', '22', '1', 'null');

-- ----------------------------
-- Table structure for `q_address`
-- ----------------------------
DROP TABLE IF EXISTS `q_address`;
CREATE TABLE `q_address` (
  `id` varchar(50) NOT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `u_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_address
-- ----------------------------
INSERT INTO `q_address` VALUES ('2', '472500', '哈哈ghh', 'aaaaaaaa', '17896541233', 'a042cd5d-08b0-4ae3-969f-bf15a070037b');

-- ----------------------------
-- Table structure for `q_users`
-- ----------------------------
DROP TABLE IF EXISTS `q_users`;
CREATE TABLE `q_users` (
  `id` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `CDK` varchar(20) DEFAULT NULL,
  `regdate` date DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_users
-- ----------------------------
INSERT INTO `q_users` VALUES ('1', '1', '1', '1', '??', '1', '2020-12-09', '1');
INSERT INTO `q_users` VALUES ('915cb2d0-960e-4a96-8a49-06b0e71fa75e', '785560121@qq.com', 'xxzzyy', '40c24801d4bc620f341d22138200ed74', '??', 'i9vkJM', '2020-12-17', 'FNinFN');
INSERT INTO `q_users` VALUES ('ee5dc9d9-1ac5-4804-be3e-3431277e9cf0', '785560121@qq.com', 'xxzzyy', 'e5aafcb12a295e1fef1eb5bffe6d74a4', '??', 'd4vldV', '2020-12-11', '5Nu2Pa');

-- ----------------------------
-- Table structure for `u_manage`
-- ----------------------------
DROP TABLE IF EXISTS `u_manage`;
CREATE TABLE `u_manage` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_manage
-- ----------------------------
INSERT INTO `u_manage` VALUES ('1', 'admin', '123456');

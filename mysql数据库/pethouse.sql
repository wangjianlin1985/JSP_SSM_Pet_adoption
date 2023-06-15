/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : pethouse

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-04-07 17:37:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_adopt
-- ----------------------------
DROP TABLE IF EXISTS `t_adopt`;
CREATE TABLE `t_adopt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pet_id` varchar(128) NOT NULL COMMENT '需领养宠物',
  `user_id` int(11) NOT NULL COMMENT '领养账号',
  `contacts` varchar(64) NOT NULL COMMENT '联系人',
  `phone` varchar(64) NOT NULL COMMENT '联系电话',
  `id_card` varchar(32) DEFAULT NULL,
  `address` varchar(256) NOT NULL COMMENT '收货地址',
  `work` varchar(128) DEFAULT NULL,
  `statue` int(255) DEFAULT NULL COMMENT '1.待处理 2 申请通过 3 申请未通过',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='领养记录表';

-- ----------------------------
-- Records of t_adopt
-- ----------------------------
INSERT INTO `t_adopt` VALUES ('1', '1', '2', '孙先生', '13512545124', '321548454845414', '中国', '工程师', '2', '2017-03-24 10:56:24');
INSERT INTO `t_adopt` VALUES ('2', '3', '2', '何先生', '13812548454', '315412451545215412', '中国', '工程师', '2', '2017-03-28 16:21:22');
INSERT INTO `t_adopt` VALUES ('3', '5', '2', '李先生', '13912545654', '321541254125125621', '中国', '工程师', '2', '2017-03-28 16:24:05');

-- ----------------------------
-- Table structure for t_back
-- ----------------------------
DROP TABLE IF EXISTS `t_back`;
CREATE TABLE `t_back` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maid_id` int(11) NOT NULL COMMENT '救助账号',
  `staff_id` varchar(64) NOT NULL COMMENT '医护人员',
  `statue` int(255) DEFAULT NULL COMMENT '1.待处理 2 申请通过 3 申请未通过',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='领养记录表';

-- ----------------------------
-- Records of t_back
-- ----------------------------
INSERT INTO `t_back` VALUES ('5', '2', '4', '1', '2017-03-27 18:29:35');
INSERT INTO `t_back` VALUES ('6', '2', '4', '1', '2017-03-27 18:31:15');
INSERT INTO `t_back` VALUES ('7', '2', '4', '2', '2017-03-27 18:31:38');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_account` varchar(256) DEFAULT NULL COMMENT '用户帐号',
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户姓名',
  `client_ip` varchar(16) DEFAULT NULL COMMENT '客户端ip',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1,操作日志；2其他日志',
  `idx` int(11) DEFAULT NULL COMMENT '1,新增；2,修改；3,删除；4,查看；5,发布；6,导入；7,导出',
  `verb` varchar(16) DEFAULT NULL COMMENT '日志动词',
  `noun` varchar(64) DEFAULT NULL COMMENT '描述信息',
  `log_time` datetime DEFAULT NULL COMMENT '日志时间：Y-m-d H:i:S',
  `db_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间：Y-m-d H:i:S',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6108 DEFAULT CHARSET=utf8 COMMENT='日志';

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('6060', '1', 'admin', '2124512@126.com', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-23 20:13:50', '2017-03-23 20:13:52');
INSERT INTO `t_log` VALUES ('6061', '1', 'admin', '2124512@126.com', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-23 20:14:46', '2017-03-23 20:14:49');
INSERT INTO `t_log` VALUES ('6062', '1', 'admin', '2124512@126.com', '127.0.0.1', '1', '1', '新增', '新增用户', '2017-03-23 20:14:46', '2017-03-23 20:14:52');
INSERT INTO `t_log` VALUES ('6063', '1', 'admin', '2124512@126.com', '127.0.0.1', '1', '1', '新增', '新增宠物', '2017-03-23 20:31:57', '2017-03-23 20:31:58');
INSERT INTO `t_log` VALUES ('6064', '1', 'admin', '2124512@126.com', '127.0.0.1', '1', '2', '修改', '修改宠物信息', '2017-03-23 20:36:37', '2017-03-23 20:36:37');
INSERT INTO `t_log` VALUES ('6065', '1', 'admin', '2124512@126.com', '127.0.0.1', '1', '2', '修改', '医治宠物信息', '2017-03-24 15:43:34', '2017-03-24 15:43:36');
INSERT INTO `t_log` VALUES ('6066', '4', 'staff1', 'staff1@126.com', '127.0.0.1', '1', '2', '修改', '医治宠物信息', '2017-03-27 16:52:36', '2017-03-27 16:52:38');
INSERT INTO `t_log` VALUES ('6067', '4', 'staff1', 'staff1@126.com', '127.0.0.1', '1', '2', '修改', '医治宠物信息', '2017-03-27 18:21:54', '2017-03-27 18:21:56');
INSERT INTO `t_log` VALUES ('6068', '4', 'staff1', 'staff1@126.com', '127.0.0.1', '1', '1', '新增', '新增宠物领回申请', '2017-03-27 18:29:35', '2017-03-27 18:29:37');
INSERT INTO `t_log` VALUES ('6069', '4', 'staff1', 'staff1@126.com', '127.0.0.1', '1', '1', '新增', '新增宠物领回申请', '2017-03-27 18:31:15', '2017-03-27 18:31:16');
INSERT INTO `t_log` VALUES ('6070', '4', 'staff1', 'staff1@126.com', '127.0.0.1', '1', '1', '新增', '新增宠物领回申请', '2017-03-27 18:31:38', '2017-03-27 18:31:40');
INSERT INTO `t_log` VALUES ('6071', '0', '', '', '127.0.0.1', '1', '1', '新增', '新增宠物', '2017-03-28 16:21:22', '2017-03-28 16:21:24');
INSERT INTO `t_log` VALUES ('6072', '0', '', '', '127.0.0.1', '1', '1', '新增', '新增宠物', '2017-03-28 16:24:05', '2017-03-28 16:24:06');
INSERT INTO `t_log` VALUES ('6073', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:17', '2017-03-28 16:44:17');
INSERT INTO `t_log` VALUES ('6074', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:19', '2017-03-28 16:44:20');
INSERT INTO `t_log` VALUES ('6075', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:23', '2017-03-28 16:44:23');
INSERT INTO `t_log` VALUES ('6076', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:23', '2017-03-28 16:44:26');
INSERT INTO `t_log` VALUES ('6077', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:24', '2017-03-28 16:44:30');
INSERT INTO `t_log` VALUES ('6078', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:24', '2017-03-28 16:44:33');
INSERT INTO `t_log` VALUES ('6079', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:24', '2017-03-28 16:44:36');
INSERT INTO `t_log` VALUES ('6080', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:25', '2017-03-28 16:44:39');
INSERT INTO `t_log` VALUES ('6081', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:26', '2017-03-28 16:44:42');
INSERT INTO `t_log` VALUES ('6082', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:30', '2017-03-28 16:44:45');
INSERT INTO `t_log` VALUES ('6083', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:35', '2017-03-28 16:44:48');
INSERT INTO `t_log` VALUES ('6084', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:35', '2017-03-28 16:44:51');
INSERT INTO `t_log` VALUES ('6085', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:53', '2017-03-28 16:44:54');
INSERT INTO `t_log` VALUES ('6086', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:54', '2017-03-28 16:44:57');
INSERT INTO `t_log` VALUES ('6087', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:57', '2017-03-28 16:45:00');
INSERT INTO `t_log` VALUES ('6088', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:57', '2017-03-28 16:45:03');
INSERT INTO `t_log` VALUES ('6089', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:58', '2017-03-28 16:45:06');
INSERT INTO `t_log` VALUES ('6090', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:58', '2017-03-28 16:45:09');
INSERT INTO `t_log` VALUES ('6091', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:59', '2017-03-28 16:45:12');
INSERT INTO `t_log` VALUES ('6092', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:59', '2017-03-28 16:45:15');
INSERT INTO `t_log` VALUES ('6093', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:44:59', '2017-03-28 16:45:18');
INSERT INTO `t_log` VALUES ('6094', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:45:00', '2017-03-28 16:45:21');
INSERT INTO `t_log` VALUES ('6095', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:45:01', '2017-03-28 16:45:24');
INSERT INTO `t_log` VALUES ('6096', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:46:15', '2017-03-28 16:46:15');
INSERT INTO `t_log` VALUES ('6097', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:46:31', '2017-03-28 16:46:33');
INSERT INTO `t_log` VALUES ('6098', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:04', '2017-03-28 16:52:07');
INSERT INTO `t_log` VALUES ('6099', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:04', '2017-03-28 16:52:10');
INSERT INTO `t_log` VALUES ('6100', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:05', '2017-03-28 16:52:13');
INSERT INTO `t_log` VALUES ('6101', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:05', '2017-03-28 16:52:16');
INSERT INTO `t_log` VALUES ('6102', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:05', '2017-03-28 16:52:19');
INSERT INTO `t_log` VALUES ('6103', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:05', '2017-03-28 16:52:22');
INSERT INTO `t_log` VALUES ('6104', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:05', '2017-03-28 16:52:25');
INSERT INTO `t_log` VALUES ('6105', '0', '', '', '127.0.0.1', '1', '2', '修改', '校验账号是否唯一', '2017-03-28 16:52:08', '2017-03-28 16:52:28');
INSERT INTO `t_log` VALUES ('6106', '0', '', '', '127.0.0.1', '1', '1', '新增', '新增用户', '2017-03-28 16:52:14', '2017-03-28 16:52:31');
INSERT INTO `t_log` VALUES ('6107', '0', '', '', '127.0.0.1', '1', '1', '新增', '新增救助申请', '2017-03-28 18:12:55', '2017-03-28 18:12:56');

-- ----------------------------
-- Table structure for t_medicalaid
-- ----------------------------
DROP TABLE IF EXISTS `t_medicalaid`;
CREATE TABLE `t_medicalaid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pet_id` varchar(128) NOT NULL COMMENT '需救助宠物',
  `user_id` int(11) NOT NULL COMMENT '救助账号',
  `contacts` varchar(64) NOT NULL COMMENT '联系人',
  `phone` varchar(64) NOT NULL COMMENT '联系电话',
  `address` varchar(256) NOT NULL COMMENT '联系地址',
  `statue` int(255) DEFAULT NULL COMMENT '1.待处理 2 申请通过 3 申请未通过',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='领养记录表';

-- ----------------------------
-- Records of t_medicalaid
-- ----------------------------
INSERT INTO `t_medicalaid` VALUES ('2', '1', '2', '孙先生', '1391248454', '中国', '2', '2017-03-24 15:30:32');
INSERT INTO `t_medicalaid` VALUES ('3', '3', '2', '王先生', '13912156372', '中国', '1', '2017-03-28 18:12:55');

-- ----------------------------
-- Table structure for t_pet
-- ----------------------------
DROP TABLE IF EXISTS `t_pet`;
CREATE TABLE `t_pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(64) NOT NULL COMMENT '类型',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `other_name` varchar(128) DEFAULT NULL COMMENT '别名',
  `en_name` varchar(128) DEFAULT NULL COMMENT '英文名',
  `weight` varchar(128) DEFAULT NULL COMMENT '体重（公）',
  `size` varchar(128) DEFAULT NULL COMMENT '大小（母）',
  `hair_color` varchar(128) DEFAULT NULL COMMENT '毛色',
  `image` varchar(255) DEFAULT NULL,
  `statue` int(11) DEFAULT NULL COMMENT '状态：1 新进宠物 2未领养 3已领养 4待医治  5正在医治 6已医好 7已领回',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff_id` int(11) DEFAULT NULL COMMENT '医疗人员',
  `b_cure_time` datetime DEFAULT NULL COMMENT '开始医治时间',
  `cure_time` datetime DEFAULT NULL COMMENT '痊愈时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='宠物信息';

-- ----------------------------
-- Records of t_pet
-- ----------------------------
INSERT INTO `t_pet` VALUES ('1', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '7', '123124124', '2017-03-27 18:38:33', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');
INSERT INTO `t_pet` VALUES ('2', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '7', '123124124', '2017-03-27 18:38:33', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');
INSERT INTO `t_pet` VALUES ('3', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '3', '123124124', '2017-03-28 17:47:26', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');
INSERT INTO `t_pet` VALUES ('4', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '7', '123124124', '2017-03-27 18:38:33', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');
INSERT INTO `t_pet` VALUES ('5', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '3', '123124124', '2017-03-28 17:47:22', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');
INSERT INTO `t_pet` VALUES ('6', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '7', '123124124', '2017-03-27 18:38:33', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');
INSERT INTO `t_pet` VALUES ('7', '2', '猫咪', '猫咪', '猫咪', '123', '123', '红色', 'resources/pet/file/dbf96221-73d2-4357-bb6a-5fe92ff80b53.jpg', '7', '123124124', '2017-03-27 18:38:33', '4', '2017-03-27 18:21:54', '2017-03-27 18:21:54');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `sex` int(11) DEFAULT '1' COMMENT '性别',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `id_card` varchar(64) DEFAULT NULL,
  `role` int(11) NOT NULL COMMENT '用户角色：1管理员 2医护人员 3普通用户 ',
  `email` varchar(128) DEFAULT NULL,
  `status` int(11) NOT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'dc483e80a7a0bd9ef71d8cf973673924', '1', null, null, '1', '2124512@126.com', '1', '2017-03-24 15:56:31');
INSERT INTO `t_user` VALUES ('2', 'hqsunc', 'dc483e80a7a0bd9ef71d8cf973673924', '1', '', null, '3', 'hqsunc@126.com', '1', '2017-03-24 15:56:28');
INSERT INTO `t_user` VALUES ('3', 'staff', 'dc483e80a7a0bd9ef71d8cf973673924', '1', '孙医生', '315484564545454', '2', 'staff@126.com', '1', '2017-03-24 15:56:26');
INSERT INTO `t_user` VALUES ('4', 'staff1', 'dc483e80a7a0bd9ef71d8cf973673924', '1', '李医生', '1324165412313', '2', 'staff1@126.com', '1', '2017-03-23 20:14:46');
INSERT INTO `t_user` VALUES ('5', 'hqsunc1', 'dc483e80a7a0bd9ef71d8cf973673924', '1', null, null, '3', null, '1', '2017-03-28 16:52:40');

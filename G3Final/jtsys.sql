/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MariaDB
 Source Server Version : 100311
 Source Host           : localhost:3306
 Source Schema         : jtsys

 Target Server Type    : MariaDB
 Target Server Version : 100311
 File Encoding         : 65001

 Date: 14/03/2020 13:59:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_brands
-- ----------------------------
DROP TABLE IF EXISTS `sys_brands`;
CREATE TABLE `sys_brands`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corporatename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdTime` datetime(0) NOT NULL,
  `endTime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_brands
-- ----------------------------
INSERT INTO `sys_brands` VALUES (1, '达内', '湖北武汉', '120', '2020-01-18 00:00:00', '2020-12-31 00:00:00');
INSERT INTO `sys_brands` VALUES (4, '达内', '北京', '456', '2020-01-20 18:08:19', '2020-01-20 18:08:19');
INSERT INTO `sys_brands` VALUES (6, '蓝翔', '河南', '110', '2020-01-20 17:47:09', '2020-01-20 17:47:09');
INSERT INTO `sys_brands` VALUES (8, '达内', '武汉', '1202200', '2020-01-20 00:00:00', '2020-01-20 00:00:00');

-- ----------------------------
-- Table structure for sys_categories
-- ----------------------------
DROP TABLE IF EXISTS `sys_categories`;
CREATE TABLE `sys_categories`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '境内/境外/周边',
  `createdTime` date NOT NULL,
  `modifiedTime` date NOT NULL,
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_categories
-- ----------------------------
INSERT INTO `sys_categories` VALUES (1, '国内游', '2020-01-26', '2020-01-26', 'admin', 'admin', NULL);
INSERT INTO `sys_categories` VALUES (2, '东南亚旅游', '2020-01-26', '2020-01-26', 'admin', 'admin', NULL);
INSERT INTO `sys_categories` VALUES (3, '欧洲游', '2020-01-26', '2020-01-26', 'admin', 'admin', NULL);
INSERT INTO `sys_categories` VALUES (4, '日韩游', '2020-01-26', '2020-01-26', 'admin', 'admin', NULL);
INSERT INTO `sys_categories` VALUES (5, '大阪', '2020-01-26', '2020-01-26', 'admin', 'admin', 4);
INSERT INTO `sys_categories` VALUES (6, '英法德', '2020-02-01', '2020-02-01', 'admin', 'admin', 3);
INSERT INTO `sys_categories` VALUES (8, '新马泰', '2020-02-01', '2020-02-01', 'admin', 'admin', 2);
INSERT INTO `sys_categories` VALUES (9, '美洲游', '2020-02-01', '2020-02-01', 'admin', 'admin', NULL);
INSERT INTO `sys_categories` VALUES (10, '北美', '2020-02-01', '2020-02-01', 'admin', 'admin', 9);
INSERT INTO `sys_categories` VALUES (11, '南极洲', '2020-02-05', '2020-02-05', 'admin', 'admin', NULL);
INSERT INTO `sys_categories` VALUES (12, '南极', '2020-02-05', '2020-02-05', 'admin', 'admin', 11);

-- ----------------------------
-- Table structure for sys_configs
-- ----------------------------
DROP TABLE IF EXISTS `sys_configs`;
CREATE TABLE `sys_configs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数名',
  `value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参数值',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_configs
-- ----------------------------
INSERT INTO `sys_configs` VALUES (4, 'uploadPath', '/upload/images', '上传路径', '2018-04-22 17:39:55', '2018-04-22 17:39:55', NULL, NULL);
INSERT INTO `sys_configs` VALUES (5, 'downloadPath', '/downloads/', '文件下载路径', '2018-04-22 17:40:41', '2018-04-22 17:40:41', NULL, NULL);

-- ----------------------------
-- Table structure for sys_depts
-- ----------------------------
DROP TABLE IF EXISTS `sys_depts`;
CREATE TABLE `sys_depts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_depts
-- ----------------------------
INSERT INTO `sys_depts` VALUES (2, '集团教研部', NULL, 1, '集团教学和研发', '2018-04-19 18:59:09', '2020-01-12 14:13:22', 'admin', NULL);
INSERT INTO `sys_depts` VALUES (4, '课程研发部', 2, 22, '负责课程研发', '2018-04-22 18:10:58', '2020-01-12 14:13:56', NULL, NULL);
INSERT INTO `sys_depts` VALUES (5, '集团MIS部', NULL, 13, '负责集团网络环境运维', '2020-01-12 14:14:26', '2020-01-12 14:14:26', NULL, NULL);
INSERT INTO `sys_depts` VALUES (6, '软件事业部', NULL, 1, '11', '2020-01-19 15:56:29', '2020-01-19 15:56:29', NULL, NULL);

-- ----------------------------
-- Table structure for sys_dicts
-- ----------------------------
DROP TABLE IF EXISTS `sys_dicts`;
CREATE TABLE `sys_dicts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名字',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字典码',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '字典值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `valid` tinyint(4) DEFAULT 1 COMMENT '有效',
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_groups
-- ----------------------------
DROP TABLE IF EXISTS `sys_groups`;
CREATE TABLE `sys_groups`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '团队id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '团队名称',
  `groupNumber` int(20) DEFAULT NULL COMMENT '团队人数',
  `departure` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出发地',
  `destination` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目的地',
  `principal` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '负责人',
  `fund` double(10, 0) DEFAULT NULL COMMENT '资金',
  `projectId` int(20) DEFAULT NULL COMMENT '项目id',
  `schedule` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '进度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_groups
-- ----------------------------
INSERT INTO `sys_groups` VALUES (1, '冬季2小队', 6, '北京国际机场', '加拿大温哥华', '高力', 72462, 2, '落基山脉小镇');
INSERT INTO `sys_groups` VALUES (3, '111', 111, '2123', '11', '111', 11, 1, '111');

-- ----------------------------
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'IP地址',
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 187 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logs
-- ----------------------------
INSERT INTO `sys_logs` VALUES (9, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 3, '0:0:0:0:0:0:0:1', '2018-04-17 19:53:38');
INSERT INTO `sys_logs` VALUES (10, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 2, '0:0:0:0:0:0:0:1', '2018-04-17 19:54:05');
INSERT INTO `sys_logs` VALUES (11, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 1, '0:0:0:0:0:0:0:1', '2018-04-17 19:54:36');
INSERT INTO `sys_logs` VALUES (12, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 155, '0:0:0:0:0:0:0:1', '2018-04-18 15:14:44');
INSERT INTO `sys_logs` VALUES (13, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 165, '0:0:0:0:0:0:0:1', '2018-04-19 18:52:35');
INSERT INTO `sys_logs` VALUES (14, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 75, '0:0:0:0:0:0:0:1', '2018-04-19 19:10:36');
INSERT INTO `sys_logs` VALUES (15, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 69, '0:0:0:0:0:0:0:1', '2018-04-19 19:12:46');
INSERT INTO `sys_logs` VALUES (16, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 187, '0:0:0:0:0:0:0:1', '2018-04-19 23:27:14');
INSERT INTO `sys_logs` VALUES (17, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 103, '0:0:0:0:0:0:0:1', '2018-04-20 13:11:37');
INSERT INTO `sys_logs` VALUES (18, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 85, '0:0:0:0:0:0:0:1', '2018-04-20 13:55:04');
INSERT INTO `sys_logs` VALUES (19, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 89, '0:0:0:0:0:0:0:1', '2018-04-20 13:57:12');
INSERT INTO `sys_logs` VALUES (20, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 69, '0:0:0:0:0:0:0:1', '2018-04-20 13:58:32');
INSERT INTO `sys_logs` VALUES (21, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 291, '0:0:0:0:0:0:0:1', '2018-04-20 15:22:55');
INSERT INTO `sys_logs` VALUES (22, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 158, '0:0:0:0:0:0:0:1', '2018-04-22 16:20:56');
INSERT INTO `sys_logs` VALUES (23, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 94, '0:0:0:0:0:0:0:1', '2018-04-22 17:05:34');
INSERT INTO `sys_logs` VALUES (24, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 138, '0:0:0:0:0:0:0:1', '2018-04-22 17:20:32');
INSERT INTO `sys_logs` VALUES (25, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 124, '0:0:0:0:0:0:0:1', '2018-04-22 17:24:12');
INSERT INTO `sys_logs` VALUES (26, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 75, '0:0:0:0:0:0:0:1', '2018-04-22 17:31:51');
INSERT INTO `sys_logs` VALUES (27, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 148, '0:0:0:0:0:0:0:1', '2018-04-22 17:33:25');
INSERT INTO `sys_logs` VALUES (28, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 69, '0:0:0:0:0:0:0:1', '2018-04-22 17:39:26');
INSERT INTO `sys_logs` VALUES (29, 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', 120, '0:0:0:0:0:0:0:1', '2018-04-22 19:10:28');
INSERT INTO `sys_logs` VALUES (39, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 13, '0:0:0:0:0:0:0:1', '2020-01-12 08:54:53');
INSERT INTO `sys_logs` VALUES (40, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 9, '0:0:0:0:0:0:0:1', '2020-01-12 09:29:59');
INSERT INTO `sys_logs` VALUES (41, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 6, '0:0:0:0:0:0:0:1', '2020-01-12 09:35:25');
INSERT INTO `sys_logs` VALUES (42, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"admin\",1]', 5, '0:0:0:0:0:0:0:1', '2020-01-12 09:35:30');
INSERT INTO `sys_logs` VALUES (43, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 7, '0:0:0:0:0:0:0:1', '2020-01-12 09:35:44');
INSERT INTO `sys_logs` VALUES (44, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 5, '0:0:0:0:0:0:0:1', '2020-01-12 09:35:46');
INSERT INTO `sys_logs` VALUES (45, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 5, '0:0:0:0:0:0:0:1', '2020-01-12 09:36:07');
INSERT INTO `sys_logs` VALUES (46, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,0,\"admin\"]', 1, '0:0:0:0:0:0:0:1', '2020-01-12 09:36:19');
INSERT INTO `sys_logs` VALUES (47, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,1,\"admin\"]', 1, '0:0:0:0:0:0:0:1', '2020-01-12 09:36:55');
INSERT INTO `sys_logs` VALUES (48, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,0,\"admin\"]', 1, '0:0:0:0:0:0:0:1', '2020-01-12 09:37:05');
INSERT INTO `sys_logs` VALUES (49, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 25, '0:0:0:0:0:0:0:1', '2020-01-12 09:42:35');
INSERT INTO `sys_logs` VALUES (50, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,1,\"admin\"]', 2, '0:0:0:0:0:0:0:1', '2020-01-12 09:42:38');
INSERT INTO `sys_logs` VALUES (51, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,0,\"admin\"]', 4, '0:0:0:0:0:0:0:1', '2020-01-12 09:43:23');
INSERT INTO `sys_logs` VALUES (52, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[15,0,\"admin\"]', 1, '0:0:0:0:0:0:0:1', '2020-01-12 09:45:04');
INSERT INTO `sys_logs` VALUES (53, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 25, '0:0:0:0:0:0:0:1', '2020-01-12 09:53:54');
INSERT INTO `sys_logs` VALUES (54, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,1,\"admin\"]', 2, '0:0:0:0:0:0:0:1', '2020-01-12 09:53:55');
INSERT INTO `sys_logs` VALUES (55, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,0,\"admin\"]', 1, '0:0:0:0:0:0:0:1', '2020-01-12 09:54:18');
INSERT INTO `sys_logs` VALUES (56, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 6, '0:0:0:0:0:0:0:1', '2020-01-12 09:55:00');
INSERT INTO `sys_logs` VALUES (57, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,1,\"admin\"]', 4, '0:0:0:0:0:0:0:1', '2020-01-12 09:55:01');
INSERT INTO `sys_logs` VALUES (58, 'admin', '禁用启用', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16,0,\"admin\"]', 2, '0:0:0:0:0:0:0:1', '2020-01-12 09:55:04');
INSERT INTO `sys_logs` VALUES (59, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 10, '0:0:0:0:0:0:0:1', '2020-01-12 09:55:23');
INSERT INTO `sys_logs` VALUES (60, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 10, '0:0:0:0:0:0:0:1', '2020-01-12 10:37:24');
INSERT INTO `sys_logs` VALUES (61, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 9, '0:0:0:0:0:0:0:1', '2020-01-12 10:37:49');
INSERT INTO `sys_logs` VALUES (62, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 27, '0:0:0:0:0:0:0:1', '2020-01-12 11:04:16');
INSERT INTO `sys_logs` VALUES (63, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 9, '0:0:0:0:0:0:0:1', '2020-01-12 11:05:58');
INSERT INTO `sys_logs` VALUES (64, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 9, '0:0:0:0:0:0:0:1', '2020-01-12 11:07:22');
INSERT INTO `sys_logs` VALUES (65, 'xiaoli', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 6, '0:0:0:0:0:0:0:1', '2020-01-12 11:07:51');
INSERT INTO `sys_logs` VALUES (66, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 32, '0:0:0:0:0:0:0:1', '2020-01-12 13:34:57');
INSERT INTO `sys_logs` VALUES (67, 'admin', '用户查询', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[\"\",1]', 22, '0:0:0:0:0:0:0:1', '2020-01-12 14:14:38');
INSERT INTO `sys_logs` VALUES (68, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 11, '192.168.175.1', '2020-01-17 15:02:49');
INSERT INTO `sys_logs` VALUES (69, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 10, '192.168.175.1', '2020-01-17 15:06:28');
INSERT INTO `sys_logs` VALUES (70, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 10, '192.168.175.1', '2020-01-17 15:40:49');
INSERT INTO `sys_logs` VALUES (71, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 5, '192.168.175.1', '2020-01-17 15:40:50');
INSERT INTO `sys_logs` VALUES (72, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 76, '192.168.175.1', '2020-01-17 16:06:57');
INSERT INTO `sys_logs` VALUES (73, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 9, '192.168.175.1', '2020-01-17 16:07:21');
INSERT INTO `sys_logs` VALUES (74, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 12, '192.168.175.1', '2020-01-17 16:07:44');
INSERT INTO `sys_logs` VALUES (75, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-17 16:08:13');
INSERT INTO `sys_logs` VALUES (76, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 12, '192.168.175.1', '2020-01-17 16:11:09');
INSERT INTO `sys_logs` VALUES (77, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-17 16:11:28');
INSERT INTO `sys_logs` VALUES (78, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 86, '192.168.175.1', '2020-01-17 16:13:14');
INSERT INTO `sys_logs` VALUES (79, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 8, '192.168.175.1', '2020-01-17 16:22:13');
INSERT INTO `sys_logs` VALUES (80, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 8, '192.168.175.1', '2020-01-17 16:22:16');
INSERT INTO `sys_logs` VALUES (81, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-17 16:23:42');
INSERT INTO `sys_logs` VALUES (82, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 7, '192.168.175.1', '2020-01-17 16:23:44');
INSERT INTO `sys_logs` VALUES (83, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-17 16:25:56');
INSERT INTO `sys_logs` VALUES (84, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (85, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 5, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (86, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (87, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 5, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (88, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 8, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (89, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 3, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (90, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 4, '192.168.175.1', '2020-01-17 16:27:28');
INSERT INTO `sys_logs` VALUES (91, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 3, '192.168.175.1', '2020-01-17 16:27:54');
INSERT INTO `sys_logs` VALUES (92, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 3, '192.168.175.1', '2020-01-17 16:27:54');
INSERT INTO `sys_logs` VALUES (93, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 4, '192.168.175.1', '2020-01-17 16:27:54');
INSERT INTO `sys_logs` VALUES (94, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 4, '192.168.175.1', '2020-01-17 16:27:54');
INSERT INTO `sys_logs` VALUES (95, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 3, '192.168.175.1', '2020-01-17 16:27:54');
INSERT INTO `sys_logs` VALUES (96, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 3, '192.168.175.1', '2020-01-17 16:28:03');
INSERT INTO `sys_logs` VALUES (97, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[null, 1]', 86, '192.168.175.1', '2020-01-18 09:04:32');
INSERT INTO `sys_logs` VALUES (98, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 46, '192.168.175.1', '2020-01-18 17:00:58');
INSERT INTO `sys_logs` VALUES (99, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[17, 0]', 3, '192.168.175.1', '2020-01-18 17:01:03');
INSERT INTO `sys_logs` VALUES (100, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 10, '192.168.175.1', '2020-01-18 17:08:12');
INSERT INTO `sys_logs` VALUES (101, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[17, 1]', 4, '192.168.175.1', '2020-01-18 17:08:20');
INSERT INTO `sys_logs` VALUES (102, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-18 17:08:34');
INSERT INTO `sys_logs` VALUES (103, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 26, '192.168.175.1', '2020-01-19 09:17:06');
INSERT INTO `sys_logs` VALUES (104, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 9, '192.168.175.1', '2020-01-19 10:38:50');
INSERT INTO `sys_logs` VALUES (105, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 11, '192.168.175.1', '2020-01-19 10:39:55');
INSERT INTO `sys_logs` VALUES (106, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16, 1]', 2, '192.168.175.1', '2020-01-19 10:39:57');
INSERT INTO `sys_logs` VALUES (107, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 4, '192.168.175.1', '2020-01-19 10:40:16');
INSERT INTO `sys_logs` VALUES (108, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 28, '192.168.175.1', '2020-01-19 11:10:55');
INSERT INTO `sys_logs` VALUES (109, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16, 0]', 3, '192.168.175.1', '2020-01-19 11:17:47');
INSERT INTO `sys_logs` VALUES (110, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 9, '192.168.175.1', '2020-01-19 11:18:30');
INSERT INTO `sys_logs` VALUES (111, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16, 1]', 2, '192.168.175.1', '2020-01-19 11:18:32');
INSERT INTO `sys_logs` VALUES (112, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16, 0]', 1, '192.168.175.1', '2020-01-19 11:18:58');
INSERT INTO `sys_logs` VALUES (113, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 22, '192.168.175.1', '2020-01-19 11:28:22');
INSERT INTO `sys_logs` VALUES (114, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16, 1]', 2, '192.168.175.1', '2020-01-19 11:28:26');
INSERT INTO `sys_logs` VALUES (115, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.validById', '[16, 0]', 4, '192.168.175.1', '2020-01-19 11:28:42');
INSERT INTO `sys_logs` VALUES (116, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 9, '192.168.175.1', '2020-01-19 15:11:05');
INSERT INTO `sys_logs` VALUES (117, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 5, '192.168.175.1', '2020-01-19 15:52:24');
INSERT INTO `sys_logs` VALUES (118, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 5, '192.168.175.1', '2020-01-19 15:55:25');
INSERT INTO `sys_logs` VALUES (119, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 7, '192.168.175.1', '2020-01-19 15:55:39');
INSERT INTO `sys_logs` VALUES (120, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 14, '192.168.175.1', '2020-01-19 15:55:45');
INSERT INTO `sys_logs` VALUES (121, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 4, '192.168.175.1', '2020-01-19 15:55:55');
INSERT INTO `sys_logs` VALUES (122, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 2]', 4, '192.168.175.1', '2020-01-19 15:55:57');
INSERT INTO `sys_logs` VALUES (123, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 4, '192.168.175.1', '2020-01-19 15:56:10');
INSERT INTO `sys_logs` VALUES (124, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 8, '192.168.175.1', '2020-01-19 15:57:01');
INSERT INTO `sys_logs` VALUES (125, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 2]', 6, '192.168.175.1', '2020-01-19 15:57:02');
INSERT INTO `sys_logs` VALUES (126, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 11, '192.168.175.1', '2020-01-19 15:57:12');
INSERT INTO `sys_logs` VALUES (127, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 2]', 5, '192.168.175.1', '2020-01-19 15:57:14');
INSERT INTO `sys_logs` VALUES (128, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 6, '192.168.175.1', '2020-01-19 15:57:24');
INSERT INTO `sys_logs` VALUES (129, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 2]', 5, '192.168.175.1', '2020-01-19 15:57:25');
INSERT INTO `sys_logs` VALUES (130, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 3]', 4, '192.168.175.1', '2020-01-19 15:57:27');
INSERT INTO `sys_logs` VALUES (131, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 1]', 5, '192.168.175.1', '2020-01-19 15:57:35');
INSERT INTO `sys_logs` VALUES (132, 'cgb1910', 'operation', 'com.cy.pj.sys.service.impl.SysUserServiceImpl.findPageObjects', '[, 3]', 3, '192.168.175.1', '2020-01-19 15:57:38');
INSERT INTO `sys_logs` VALUES (162, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 27, '127.0.0.1', '2020-02-04 09:29:48');
INSERT INTO `sys_logs` VALUES (163, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 28, '127.0.0.1', '2020-02-04 20:49:26');
INSERT INTO `sys_logs` VALUES (164, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 14, '127.0.0.1', '2020-02-04 20:49:36');
INSERT INTO `sys_logs` VALUES (165, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 11, '127.0.0.1', '2020-02-04 20:53:12');
INSERT INTO `sys_logs` VALUES (166, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 2]', 5, '127.0.0.1', '2020-02-04 20:53:15');
INSERT INTO `sys_logs` VALUES (167, 'admin', '指定查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findObjectById', '[1]', 4, '127.0.0.1', '2020-02-04 20:53:22');
INSERT INTO `sys_logs` VALUES (168, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 10, '127.0.0.1', '2020-02-04 20:53:25');
INSERT INTO `sys_logs` VALUES (169, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 6, '127.0.0.1', '2020-02-04 20:56:52');
INSERT INTO `sys_logs` VALUES (170, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 5, '127.0.0.1', '2020-02-04 20:57:39');
INSERT INTO `sys_logs` VALUES (171, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 6, '127.0.0.1', '2020-02-04 20:57:51');
INSERT INTO `sys_logs` VALUES (172, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 15, '127.0.0.1', '2020-02-05 08:44:19');
INSERT INTO `sys_logs` VALUES (173, 'admin', '指定查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findObjectById', NULL, 4, '4', '2020-02-04 20:53:22');
INSERT INTO `sys_logs` VALUES (174, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', NULL, 10, '10', '2020-02-04 20:53:25');
INSERT INTO `sys_logs` VALUES (175, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', NULL, 6, '6', '2020-02-04 20:56:52');
INSERT INTO `sys_logs` VALUES (176, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', NULL, 5, '5', '2020-02-04 20:57:39');
INSERT INTO `sys_logs` VALUES (177, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', NULL, 6, '6', '2020-02-04 20:57:51');
INSERT INTO `sys_logs` VALUES (178, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', NULL, 15, '15', '2020-02-05 08:44:19');
INSERT INTO `sys_logs` VALUES (179, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 42, '127.0.0.1', '2020-02-05 20:18:37');
INSERT INTO `sys_logs` VALUES (180, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 15, '127.0.0.1', '2020-02-05 20:18:38');
INSERT INTO `sys_logs` VALUES (181, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 40, '127.0.0.1', '2020-02-05 20:21:03');
INSERT INTO `sys_logs` VALUES (182, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 17, '127.0.0.1', '2020-02-05 20:21:06');
INSERT INTO `sys_logs` VALUES (183, 'admin', '修改用户权限', 'com.cy.pj.sys.service.SysUserServiceImpl.validById', '[18, 0, admin]', 4, '127.0.0.1', '2020-02-05 20:21:07');
INSERT INTO `sys_logs` VALUES (184, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 38, '127.0.0.1', '2020-02-05 20:33:38');
INSERT INTO `sys_logs` VALUES (185, 'admin', '查找用户', 'com.cy.pj.sys.service.SysUserServiceImpl.findPageObjects', '[null, 1]', 18, '127.0.0.1', '2020-02-05 20:33:41');
INSERT INTO `sys_logs` VALUES (186, 'admin', '修改用户权限', 'com.cy.pj.sys.service.SysUserServiceImpl.validById', '[18, 1, admin]', 2, '127.0.0.1', '2020-02-05 20:33:43');

-- ----------------------------
-- Table structure for sys_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_menus`;
CREATE TABLE `sys_menus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 154 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menus
-- ----------------------------
INSERT INTO `sys_menus` VALUES (8, '系统管理', '请求路径', 1, 8, NULL, NULL, '', '2017-07-12 15:15:59', '2020-01-12 14:11:15', 'admin', NULL);
INSERT INTO `sys_menus` VALUES (25, '日志管理', 'log/log_list', 1, 25, NULL, 8, 'sys:log:view', '2017-07-12 15:15:59', '2020-01-12 14:09:44', 'admin', NULL);
INSERT INTO `sys_menus` VALUES (45, '用户管理', 'user/user_list', 1, 45, NULL, 8, 'sys:user:view', '2017-07-12 15:15:59', '2020-01-12 14:10:10', 'admin', NULL);
INSERT INTO `sys_menus` VALUES (46, '菜单管理', 'menu/menu_list', 1, 46, NULL, 8, 'sys:menu:view', '2017-07-12 15:15:59', '2020-01-12 14:10:28', 'admin', NULL);
INSERT INTO `sys_menus` VALUES (47, '角色管理', 'role/role_list', 1, 47, NULL, 8, 'sys:role:view', '2017-07-12 15:15:59', '2020-01-12 14:10:48', 'admin', NULL);
INSERT INTO `sys_menus` VALUES (115, '查询', 'menu/doFindObjects', 2, 1, NULL, 46, 'sys:menu:view', '2017-07-13 16:33:41', '2020-01-12 14:21:29', NULL, NULL);
INSERT INTO `sys_menus` VALUES (116, '添加', 'menu/doSaveObject', 2, 2, NULL, 46, 'sys:menu:add', '2017-07-13 16:34:02', '2020-01-12 14:21:56', NULL, NULL);
INSERT INTO `sys_menus` VALUES (117, '修改', 'menu/doUpdateObject', 2, 3, NULL, 46, 'sys:menu:update', '2017-07-13 16:34:25', '2020-01-12 14:22:12', NULL, NULL);
INSERT INTO `sys_menus` VALUES (118, '删除', 'role/doDeleteObject', 2, 4, NULL, 46, 'sys:menu:delete', '2017-07-13 16:34:46', '2020-01-12 14:22:41', NULL, NULL);
INSERT INTO `sys_menus` VALUES (119, '查询', 'user/doFindPageObjects', 2, 1, NULL, 45, 'sys:user:view', '2017-07-13 16:35:05', '2020-01-12 14:20:28', NULL, NULL);
INSERT INTO `sys_menus` VALUES (120, '查询', 'role/doFindPageObjects', 2, 1, NULL, 47, 'sys:role:view', '2017-07-13 16:35:26', '2020-01-12 14:23:05', NULL, NULL);
INSERT INTO `sys_menus` VALUES (126, '新增', 'user/doSaveObject', 2, 2, NULL, 45, 'sys:user:add', '2017-07-21 11:11:34', '2020-01-12 14:20:45', NULL, NULL);
INSERT INTO `sys_menus` VALUES (127, '修改', 'user/doUpdateObject', 2, 3, NULL, 45, 'sys:user:update', '2017-07-21 11:11:56', '2020-01-12 14:21:05', NULL, NULL);
INSERT INTO `sys_menus` VALUES (128, '添加', 'role/doSaveObject', 2, 2, NULL, 47, 'sys:role:add', '2017-07-21 11:14:24', '2020-01-12 14:23:29', NULL, NULL);
INSERT INTO `sys_menus` VALUES (129, '修改', 'role/doUpdateObject', 2, 3, NULL, 47, 'sys:role:update', '2017-07-21 11:14:48', '2020-01-12 14:23:44', NULL, NULL);
INSERT INTO `sys_menus` VALUES (130, '删除', 'role/doDeleteObject', 2, 4, NULL, 47, 'sys:role:delete', '2017-07-21 11:15:09', '2020-01-12 14:24:05', NULL, NULL);
INSERT INTO `sys_menus` VALUES (131, '删除', 'log/doDeleteObjects', 2, 27, NULL, 25, 'sys:log:delete', '2020-01-10 17:34:31', '2020-01-10 17:34:31', NULL, NULL);
INSERT INTO `sys_menus` VALUES (137, '禁用启用', 'user/doValidById', 2, 123, NULL, 45, 'sys:user:update', '2020-01-12 09:34:58', '2020-01-12 09:34:58', NULL, NULL);
INSERT INTO `sys_menus` VALUES (138, '部门管理', 'dept/dept_list', 1, 100, NULL, 8, 'sys:dept:view', '2020-01-12 14:15:45', '2020-01-12 14:15:59', NULL, NULL);
INSERT INTO `sys_menus` VALUES (139, '添加', 'dept/doSaveObject', 2, 123, NULL, 138, 'sys:dept:add', '2020-01-12 14:16:33', '2020-01-12 14:16:33', NULL, NULL);
INSERT INTO `sys_menus` VALUES (140, '修改', 'dept/dept_edit', 1, 121, NULL, 138, 'sys:dept:update', '2020-01-12 14:17:14', '2020-01-12 14:17:14', NULL, NULL);
INSERT INTO `sys_menus` VALUES (141, '删除', 'dept/doDeleteObject', 1, 120, NULL, 138, 'sys:dept:delete', '2020-01-12 14:18:20', '2020-01-12 14:18:20', NULL, NULL);
INSERT INTO `sys_menus` VALUES (142, '查询', 'dept/doFindObjects', 1, 126, NULL, 138, 'sys:dept:view', '2020-01-12 14:19:01', '2020-01-17 15:22:55', NULL, NULL);
INSERT INTO `sys_menus` VALUES (143, '查询', 'log/doFindPageObjects', 2, 210, NULL, 25, 'sys:log:view', '2020-01-12 14:20:02', '2020-01-12 14:20:02', NULL, NULL);
INSERT INTO `sys_menus` VALUES (144, '修改密码', 'user/pwd_edit', 1, 15, NULL, 8, 'sys:user:update', '2020-01-19 15:54:30', '2020-01-19 15:54:30', NULL, NULL);
INSERT INTO `sys_menus` VALUES (145, '商品管理', '', 1, 9, NULL, NULL, '', '2020-02-01 20:44:47', '2020-02-01 20:44:47', NULL, NULL);
INSERT INTO `sys_menus` VALUES (146, '类目管理', 'category/category_list', 1, NULL, NULL, 145, 'sys:category:view', '2020-02-01 20:46:35', '2020-02-01 20:46:35', NULL, NULL);
INSERT INTO `sys_menus` VALUES (147, '项目管理', 'project/project_list', 1, NULL, NULL, 145, 'sys:project:view', '2020-02-01 20:47:23', '2020-02-01 20:47:23', NULL, NULL);
INSERT INTO `sys_menus` VALUES (148, '团目管理', 'trip/trip_list', 1, NULL, NULL, 145, 'sys:trip:view', '2020-02-01 20:48:41', '2020-02-01 20:48:41', NULL, NULL);
INSERT INTO `sys_menus` VALUES (149, '品牌管理', 'brand/brand_list', 1, NULL, NULL, 145, 'sys:brand:view', '2020-02-01 20:49:25', '2020-02-01 20:49:25', NULL, NULL);
INSERT INTO `sys_menus` VALUES (150, '查询', 'project/doFindProjects', 1, NULL, NULL, 147, 'sys:project:view', '2020-02-01 23:42:16', '2020-02-01 23:42:16', NULL, NULL);
INSERT INTO `sys_menus` VALUES (151, '删除', 'project/doDeleteProject', 1, NULL, NULL, 147, 'sys:project:delete', '2020-02-01 23:42:51', '2020-02-01 23:42:51', NULL, NULL);
INSERT INTO `sys_menus` VALUES (152, '修改', 'project/doUpdateProject', 1, NULL, NULL, 147, 'sys:project:update', '2020-02-01 23:43:25', '2020-02-01 23:43:25', NULL, NULL);
INSERT INTO `sys_menus` VALUES (153, '添加', 'project/doSaveObject', 1, NULL, NULL, 147, 'sys:project:add', '2020-02-01 23:44:18', '2020-02-01 23:44:18', NULL, NULL);

-- ----------------------------
-- Table structure for sys_projects
-- ----------------------------
DROP TABLE IF EXISTS `sys_projects`;
CREATE TABLE `sys_projects`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目名称',
  `parentId` int(11) DEFAULT NULL COMMENT '所属类目',
  `price` int(11) DEFAULT NULL COMMENT '价格',
  `minMembers` int(11) DEFAULT NULL COMMENT '最小组团人数',
  `maxMembers` int(11) DEFAULT NULL COMMENT '最大组团人数',
  `createdDate` datetime(0) DEFAULT NULL COMMENT '项目创建日期',
  `updatedDate` datetime(0) DEFAULT NULL COMMENT '项目更新日期',
  `resume` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '项目简述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_projects
-- ----------------------------
INSERT INTO `sys_projects` VALUES (1, '日本大阪5晚6日自由行', 5, 2988, 2, 9, '2020-02-01 20:35:49', '2020-02-01 20:35:49', '宿核心商圈酒店，逸之彩+微笑+萨拉萨酒店，指定和服体验套餐299元买一送一，品神户牛肉逛环球影城，邂逅禅意京都');
INSERT INTO `sys_projects` VALUES (2, '加拿大东西全景+班芙12日游', 10, 20699, 25, 25, '2020-02-01 20:41:13', '2020-02-01 20:41:13', '自营,无购物,25人小团,预售立减1000/人,加航直飞,四大国家公园,冰原雪车,班夫缆车,6顿特色餐,奥莱,4D电影,2人WiFi');
INSERT INTO `sys_projects` VALUES (4, '日本大阪-京都-奈良-富士山-东京7日游', 5, 7899, 8, 20, '2020-02-04 20:58:45', '2020-02-04 20:58:45', '早樱预售,国航/全日空直飞,4/5星住宿,3晚温泉,AB1晚伊豆海边别墅温泉,C1晚和歌山万豪,白川乡,镰仓,wifi ');
INSERT INTO `sys_projects` VALUES (5, '新加坡4晚5或6日自由行', 6, 2495, 10, 18, '2020-02-04 20:59:42', '2020-02-04 20:59:42', '逛吃区酒店胡姬，圣淘沙入口酒店海湾，地标酒店金沙，名胜世界邻居酒店悦乐，可选19选5通票');

-- ----------------------------
-- Table structure for sys_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menus`;
CREATE TABLE `sys_role_menus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1626 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menus
-- ----------------------------
INSERT INTO `sys_role_menus` VALUES (1364, 46, 8);
INSERT INTO `sys_role_menus` VALUES (1365, 46, 47);
INSERT INTO `sys_role_menus` VALUES (1366, 46, 120);
INSERT INTO `sys_role_menus` VALUES (1367, 46, 128);
INSERT INTO `sys_role_menus` VALUES (1368, 46, 129);
INSERT INTO `sys_role_menus` VALUES (1369, 46, 130);
INSERT INTO `sys_role_menus` VALUES (1370, 46, 144);
INSERT INTO `sys_role_menus` VALUES (1595, 1, 8);
INSERT INTO `sys_role_menus` VALUES (1596, 1, 25);
INSERT INTO `sys_role_menus` VALUES (1597, 1, 131);
INSERT INTO `sys_role_menus` VALUES (1598, 1, 143);
INSERT INTO `sys_role_menus` VALUES (1599, 1, 45);
INSERT INTO `sys_role_menus` VALUES (1600, 1, 119);
INSERT INTO `sys_role_menus` VALUES (1601, 1, 126);
INSERT INTO `sys_role_menus` VALUES (1602, 1, 127);
INSERT INTO `sys_role_menus` VALUES (1603, 1, 137);
INSERT INTO `sys_role_menus` VALUES (1604, 1, 46);
INSERT INTO `sys_role_menus` VALUES (1605, 1, 115);
INSERT INTO `sys_role_menus` VALUES (1606, 1, 116);
INSERT INTO `sys_role_menus` VALUES (1607, 1, 117);
INSERT INTO `sys_role_menus` VALUES (1608, 1, 118);
INSERT INTO `sys_role_menus` VALUES (1609, 1, 47);
INSERT INTO `sys_role_menus` VALUES (1610, 1, 120);
INSERT INTO `sys_role_menus` VALUES (1611, 1, 128);
INSERT INTO `sys_role_menus` VALUES (1612, 1, 129);
INSERT INTO `sys_role_menus` VALUES (1613, 1, 130);
INSERT INTO `sys_role_menus` VALUES (1614, 1, 138);
INSERT INTO `sys_role_menus` VALUES (1615, 1, 139);
INSERT INTO `sys_role_menus` VALUES (1616, 1, 140);
INSERT INTO `sys_role_menus` VALUES (1617, 1, 141);
INSERT INTO `sys_role_menus` VALUES (1618, 1, 142);
INSERT INTO `sys_role_menus` VALUES (1619, 1, 144);
INSERT INTO `sys_role_menus` VALUES (1620, 1, 145);
INSERT INTO `sys_role_menus` VALUES (1621, 1, 146);
INSERT INTO `sys_role_menus` VALUES (1622, 1, 147);
INSERT INTO `sys_role_menus` VALUES (1623, 1, 150);
INSERT INTO `sys_role_menus` VALUES (1624, 1, 152);
INSERT INTO `sys_role_menus` VALUES (1625, 1, 153);

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES (1, '系统管理员', '系统管理员', '2017-07-13 17:44:11', '2020-02-05 08:45:24', 'admin', NULL);
INSERT INTO `sys_roles` VALUES (46, '软件工程师', '负责软件设计及研发', '2020-01-11 15:52:00', '2020-02-01 20:33:33', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES (71, 15, 46);
INSERT INTO `sys_user_roles` VALUES (84, 17, 46);
INSERT INTO `sys_user_roles` VALUES (85, 13, 46);
INSERT INTO `sys_user_roles` VALUES (87, 12, 46);
INSERT INTO `sys_user_roles` VALUES (88, 9, 46);
INSERT INTO `sys_user_roles` VALUES (89, 7, 46);
INSERT INTO `sys_user_roles` VALUES (90, 5, 46);
INSERT INTO `sys_user_roles` VALUES (91, 3, 46);
INSERT INTO `sys_user_roles` VALUES (92, 2, 46);
INSERT INTO `sys_user_roles` VALUES (93, 1, 1);
INSERT INTO `sys_user_roles` VALUES (94, 18, 46);

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES (1, 'admin', 'c4c33035c5d8e840616c128db9f87b25', '016a0948-b581-43aa-8a5f-9bb76a80e737', 'admin@t.cn', '13624356789', 1, 6, NULL, '2020-01-19 15:57:56', NULL, NULL);
INSERT INTO `sys_users` VALUES (2, 'zhangli', 'bdcf69375bdb532e50279b91eb00940d', '5e7cbd36-e897-4951-b42b-19809caf3caa', 'zhangli@t.cn', '13678909876', 0, 6, '2017-07-18 10:01:51', '2020-01-19 15:57:45', NULL, NULL);
INSERT INTO `sys_users` VALUES (3, 'wangke', 'c5dc32ec66041aeddf432b3146bd2257', '5e3e1475-1ea9-4a6a-976e-b07545827139', 'wangke@t.cn', '18678900987', 1, 6, '2017-07-18 11:40:53', '2020-01-19 15:57:34', NULL, NULL);
INSERT INTO `sys_users` VALUES (4, 'zhangql', '+HBpqtPuj9KLBIpneR5X0A==', 'ed487fac-9952-45c9-acaa-21dab9c689cc', 'zhangql@t.cn', '13678909876', 1, 2, '2017-07-18 12:17:30', '2018-04-22 20:48:04', NULL, NULL);
INSERT INTO `sys_users` VALUES (5, 'fanwei', '1acab7425d6dfae670f26bd160518902', '34fbedb2-e135-4f8d-b595-24360edc348d', 'fanwei@t.cn', '13876545678', 1, 6, '2017-07-20 17:03:22', '2020-01-19 15:57:23', NULL, NULL);
INSERT INTO `sys_users` VALUES (6, 'wumei', '431ebdcccf3404787a144f9ba669a8e2', '8a14f46f-7a17-4dfe-85ab-08e63cb618ce', 'wumei@t.cn', '13567898765', 1, 2, '2017-07-21 10:57:40', '2018-04-22 20:46:49', NULL, NULL);
INSERT INTO `sys_users` VALUES (7, 'user-003', '689c673a0d8bda7ee795dd45a126ae96', '3faa1d2b-a99f-4ffb-9d29-0e71563258af', 't@t.com', '123', 1, 6, '2018-01-12 23:19:58', '2020-01-19 15:57:11', NULL, NULL);
INSERT INTO `sys_users` VALUES (9, 'user-002', 'e10adc3949ba59abbe56e057f20f883e', NULL, 't@t.com', '123', 1, 5, '2018-01-12 23:20:31', '2020-01-19 15:56:09', NULL, NULL);
INSERT INTO `sys_users` VALUES (12, 'user-001', '5bf6593afd106aa544000d559f0c2241', '9528e727-2901-4746-8558-9010d9607da2', 't@t.com', '123', 1, 5, '2018-01-13 01:48:32', '2020-01-19 15:55:54', NULL, NULL);
INSERT INTO `sys_users` VALUES (13, 'user-c', '2630d8bd50c76abf001a9daceeae97e6', '30fff766-e245-4a93-9f5e-6eb2c2cec494', 't@t.com', '123456', 0, 5, '2018-01-13 02:01:56', '2020-01-19 15:55:38', NULL, NULL);
INSERT INTO `sys_users` VALUES (15, 'user-b', '2ce586af95c6431112092f653659c85f', 'eaedbaee-d760-40e4-b71e-ccecf01b6187', 't@t.com', '123456', 0, 2, '2018-01-13 02:02:06', '2020-01-17 16:11:27', NULL, NULL);
INSERT INTO `sys_users` VALUES (16, 'user-a', '710058cf374a38d76510d009f63bf28d', 'e8e35b96-bbdd-4090-81ee-b71a36141760', '1@t.com', '121212', 0, 2, '2018-04-22 19:43:11', '2020-01-19 11:28:42', NULL, 'admin');
INSERT INTO `sys_users` VALUES (17, 'xiaoli', 'dd93e70c79e12b5c734080fb9ee91229', 'e0036733-1378-4ff0-a5c3-8ddc5f8e0db2', 'xl@t.com', '1111111111', 1, 5, '2020-01-12 10:37:47', '2020-01-18 17:08:20', NULL, 'admin');
INSERT INTO `sys_users` VALUES (18, 'Test', 'd07de7a69c63926565a609b3b9d114a5', '7623dd1d-2fbd-486b-8e66-1336f25aeb9d', '111', '11111', 1, 6, '2020-02-01 20:32:56', '2020-02-05 20:33:43', NULL, 'admin');

SET FOREIGN_KEY_CHECKS = 1;

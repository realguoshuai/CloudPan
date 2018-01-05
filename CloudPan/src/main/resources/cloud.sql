-- 两个短横线表示注释 
-- 这里是对数据库创建语句的备份

-- 创建数据库 先删除后创建,便于我们多次执行
DROP DATABASE IF EXISTS `cloud_pan`;
CREATE DATABASE IF NOT EXISTS `cloud_pan`;

-- 使用数据库
USE `cloud_pan`;
-- 创建表
DROP TABLE  IF EXISTS`account`;
CREATE TABLE IF NOT EXISTS `account`(
	`id` bigint unsigned  PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`email` varchar(30) NOT NULL COMMENT '邮箱',
	`password` varchar(20) NOT NULL COMMENT '密码',
	`active` int unsigned DEFAULT 0 COMMENT '激活状态:1 激活,0 未激活',
	`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` timestamp  NULL  DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

USE `cloud_pan`;

DROP TABLE IF EXISTS `directory`;
CREATE TABLE IF NOT EXISTS `directory`(
`id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
`name` varchar(20) NOT NULL COMMENT '文件夹名称',
`is_file` tinyint NOT NULL COMMENT '1 文件,0文件夹',
`account_id` tinyint NOT NULL COMMENT '文件夹所属用户',
`parent_id` tinyint  default 0 COMMENT '上一级文件夹id',
`file_id` tinyint NOT NULL COMMENT '文件id',
`gmt_create` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

USE `cloud_pan`;
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` bigint unsigned PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  `path` varchar(20) NOT NULL COMMENT '文件在服务器上的存储路径',
  `size` int(200) not null comment '文件的大小',
  `type` int(200) not null comment '文件的类型',
  `md5` char(32) NOT NULL COMMENT '文件的 md5',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

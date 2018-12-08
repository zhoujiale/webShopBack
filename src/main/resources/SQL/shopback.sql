-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_back
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auth_role_permission`
--

DROP TABLE IF EXISTS `auth_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色编号',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`),
  KEY `fk_role_permission_id_idx` (`role_id`),
  KEY `fk_permission_role_id_idx` (`permission_id`),
  CONSTRAINT `fk_permission_role_id` FOREIGN KEY (`permission_id`) REFERENCES `user_permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_role_permission`
--

LOCK TABLES `auth_role_permission` WRITE;
/*!40000 ALTER TABLE `auth_role_permission` DISABLE KEYS */;
INSERT INTO `auth_role_permission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,7);
/*!40000 ALTER TABLE `auth_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_user_role`
--

DROP TABLE IF EXISTS `auth_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `fk_role_user_id_idx` (`role_id`),
  KEY `fk_user_role_id_idx` (`user_id`),
  CONSTRAINT `fk_role_user_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user_role`
--

LOCK TABLES `auth_user_role` WRITE;
/*!40000 ALTER TABLE `auth_user_role` DISABLE KEYS */;
INSERT INTO `auth_user_role` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `auth_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classify`
--

DROP TABLE IF EXISTS `classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify_name` varchar(45) DEFAULT NULL COMMENT '商品类目名称',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品类目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classify`
--

LOCK TABLES `classify` WRITE;
/*!40000 ALTER TABLE `classify` DISABLE KEYS */;
INSERT INTO `classify` VALUES (1,'数码',1);
/*!40000 ALTER TABLE `classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(45) DEFAULT NULL COMMENT '昵称',
  `password` varchar(45) DEFAULT NULL COMMENT '密码\n',
  `salt` varchar(45) DEFAULT NULL COMMENT '加盐',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(45) DEFAULT NULL COMMENT '地址',
  `state` tinyint(1) DEFAULT '1' COMMENT '状态  1 为正常 0 为拉黑',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `permission` varchar(45) DEFAULT NULL COMMENT '权限',
  `role` varchar(45) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `production`
--

DROP TABLE IF EXISTS `production`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `production` (
  `production_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `classify` int(11) DEFAULT NULL COMMENT '类目编号',
  `production_name` varchar(45) DEFAULT NULL COMMENT '商品名称',
  `title` varchar(45) DEFAULT NULL COMMENT '商品标题',
  `main_imgurl` varchar(500) DEFAULT NULL COMMENT '主图地址',
  `old_price` decimal(7,2) DEFAULT NULL COMMENT '原价',
  `new_price` decimal(7,2) DEFAULT NULL COMMENT '现价',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态',
  `stack` int(11) DEFAULT NULL COMMENT '库存',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`production_id`),
  KEY `fk_classify_idx` (`classify`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `production`
--

LOCK TABLES `production` WRITE;
/*!40000 ALTER TABLE `production` DISABLE KEYS */;
INSERT INTO `production` VALUES (1,1,'三星手机','最新三星手机','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544071085796&di=37f82ed81ce6092153c201691c0dd5fa&imgtype=0&src=http%3A%2F%2Fcms-bucket.nosdn.127.net%2F2018%2F10%2F22%2Ff18d611010124eebba53819b41cbcd64.png%3FimageView%26thumbnail%3D550x0',2000.00,2000.00,1,500,'2018-12-06 10:27:37','2018-12-06 10:27:37'),(2,1,'魅族16X','最新魅族手机','https://gss0.baidu.com/7LsWdDW5_xN3otqbppnN2DJv/space/pic/item/472309f790529822e3abaca5daca7bcb0a46d438.jpg',2000.00,2000.00,1,500,'2018-12-06 10:42:56','2018-12-06 10:42:56');
/*!40000 ALTER TABLE `production` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_classify`
--

DROP TABLE IF EXISTS `sub_classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子类目id',
  `sub_classify_name` varchar(45) DEFAULT NULL COMMENT '子类目名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `main_classify_id` int(11) DEFAULT NULL COMMENT '父类目',
  PRIMARY KEY (`id`),
  KEY `fk_main_classify_idx` (`main_classify_id`),
  CONSTRAINT `fk_main_classify` FOREIGN KEY (`main_classify_id`) REFERENCES `classify` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sub_classify` FOREIGN KEY (`id`) REFERENCES `production` (`classify`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='子类目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_classify`
--

LOCK TABLES `sub_classify` WRITE;
/*!40000 ALTER TABLE `sub_classify` DISABLE KEYS */;
INSERT INTO `sub_classify` VALUES (1,'手机',1,1);
/*!40000 ALTER TABLE `sub_classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(80) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT '加盐',
  `state` int(11) DEFAULT NULL COMMENT '状态 0为正常，1为锁定',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'zhou','d296d6df2ec0c0dcd854a2bd7e0f6e27','2d27f7d8-6ed5-4b9c-977f-9cf0de1b60e0',0,'2018-11-09 18:10:00'),(2,'jia','d8015ba86ccf8bdda307efab6d7c21e5','4e87fb98-e189-4bfe-8f29-94b24d775f25',0,'2018-11-14 16:59:54');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permission`
--

DROP TABLE IF EXISTS `user_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `permission_name` varchar(45) DEFAULT NULL COMMENT '权限名称',
  `permission_description` varchar(45) DEFAULT NULL COMMENT '权限描述',
  `available` tinyint(4) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permission`
--

LOCK TABLES `user_permission` WRITE;
/*!40000 ALTER TABLE `user_permission` DISABLE KEYS */;
INSERT INTO `user_permission` VALUES (1,'addUser','添加用户',1),(2,'addRole','添加角色',1),(3,'lockedUser','禁用/启用用户',1),(4,'addPermissionByRole','对角色添加权限',1),(5,'lockedRole','禁用/启用角色',1),(6,'customer','顾客操作',1),(7,'addProduction','添加商品',1);
/*!40000 ALTER TABLE `user_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `role_description` varchar(45) DEFAULT NULL COMMENT '角色描述',
  `available` tinyint(4) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'管理员','管理员操作',1),(2,'测试','测试BUG',1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shop_back'
--

--
-- Dumping routines for database 'shop_back'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-08 18:03:55

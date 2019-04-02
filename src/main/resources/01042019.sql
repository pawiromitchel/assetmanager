CREATE DATABASE  IF NOT EXISTS `asset_registration` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `asset_registration`;
-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: asset_registration
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.34-MariaDB

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
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset` (
  `asset_id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_description` varchar(45) NOT NULL,
  `mac_address` varchar(45) NOT NULL,
  `serial_number` varchar(45) NOT NULL,
  `estimated_lifespan` varchar(45) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`asset_id`),
  UNIQUE KEY `mac_address_UNIQUE` (`mac_address`),
  UNIQUE KEY `serial_number_UNIQUE` (`serial_number`),
  KEY `fk_asset_status_id_idx` (`status_id`),
  KEY `fk_asset_category_id_idx` (`category_id`),
  KEY `fk_asset_created_by_idx` (`created_by`),
  KEY `fk_asset_updated_by_idx` (`updated_by`),
  CONSTRAINT `fk_asset_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asset_created_by` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asset_status_id` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_asset_updated_by` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (17,'Lenovo Thinkpad E560','bc:a8:a6:bb:ec:34','18201232131','2019-03-20',NULL,NULL,2,NULL,1,2),(19,'Lenovo Carbon X','bc:a8:a6:bb:ec:35','12654112','2019-03-16',NULL,NULL,NULL,NULL,1,3),(20,'Lenovo Carbon X3','bc:a8:a6:bd:ef:36','123213123213123','2019-03-29',NULL,NULL,NULL,NULL,1,1),(21,'Lenovo Carbon X4','bc:a9:a6:bd:ef:36','1232131232131231964','2019-03-12',2,NULL,NULL,NULL,1,1),(22,'Lenovo Carbon X6','bc:a9:a6:bd:ef:39','123213176431231964','2019-03-12',2,'2019-03-31 17:15:37',NULL,NULL,1,1),(23,'ASUS 79182G','ac:a8:a6:bb:ec:36','897281','2019-05-18',NULL,'2019-03-31 19:23:30',2,NULL,1,2),(24,'DELL XPS 13','ac:c8:a6:bb:ec:36','897281kjso1021','2019-12-31',2,'2019-04-01 20:28:18',NULL,NULL,1,1);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Laptop'),(3,'Mobile Phone'),(2,'PC');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	\n',
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `role_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  KEY `fk_employee_role_id_idx` (`role_id`),
  CONSTRAINT `fk_employee_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'Mitchel','Pawirodinomo','8781953',1,'mpawirodinomo','12345'),(5,'Jonathan','Oldenstam','8971921',1,'',''),(6,'Akash','Mathoera','',1,'','');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ICT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Registered'),(2,'Written-Off');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'asset_registration'
--

--
-- Dumping routines for database 'asset_registration'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-01 22:07:15

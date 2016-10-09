# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.14)
# Database: suggestApp
# Generation Time: 2016-09-03 16:38:56 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table customer
# ------------------------------------------------------------

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`id`, `emailId`, `end_time`, `is_active`, `last_visited_time`, `name`)
VALUES
	(1,'abc@gmail.com','2016-08-27 12:20:10',b'1','2016-08-27 12:20:10','nikhil'),
	(2,'agrawal@gmail.com','2016-08-27 12:24:58',b'1','2016-08-27 12:24:58','Ritu'),
	(3,'srk@gmail.com','2016-08-31 10:01:05',b'1','2016-08-31 10:01:05','srk'),
	(4,'hrithik@gmail.com','2016-08-31 10:02:49',b'1','2016-08-31 10:02:49','hrithik'),
	(5,'ram@gmail.com','2016-09-02 13:23:21',b'1','2016-09-02 13:23:21','Ram'),
	(6,'meenakshi@gmail.com','2016-09-02 14:15:05',b'1','2016-09-02 14:15:05','Meenakshi'),
	(7,'vaibhav@gmail.com','2016-09-02 14:15:37',b'1','2016-09-02 14:15:37','Vaibhav'),
	(8,'v@gmail.com','2016-09-02 15:29:35',b'1','2016-09-02 15:29:35','V'),
	(9,'v1@gmail.com','2016-09-02 15:31:42',b'1','2016-09-02 15:31:42','V1'),
	(10,'v2@gmail.com','2016-09-02 15:33:01',b'1','2016-09-02 15:33:01','V2');

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table customerFollower
# ------------------------------------------------------------

LOCK TABLES `customerFollower` WRITE;
/*!40000 ALTER TABLE `customerFollower` DISABLE KEYS */;

INSERT INTO `customerFollower` (`id`, `end_time`, `is_active`, `last_visited_time`, `photo_id`, `photo_name`, `from_customer_id`, `to_customer_id`)
VALUES
	(1,'2016-08-31 10:06:26',b'1','2016-08-31 10:06:26',1,'def',2,4),
	(2,'2016-09-02 16:54:20',b'1','2016-09-02 16:54:20',1,'def',8,4),
	(3,'2016-09-02 16:54:38',b'1','2016-09-02 16:54:38',1,'def',8,3);

/*!40000 ALTER TABLE `customerFollower` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tweets
# ------------------------------------------------------------

LOCK TABLES `tweets` WRITE;
/*!40000 ALTER TABLE `tweets` DISABLE KEYS */;

INSERT INTO `tweets` (`id`, `tweet`, `tweet_time`, `customer_id`)
VALUES
	(1,'today is awesome','2016-08-26 12:40:03',2);

/*!40000 ALTER TABLE `tweets` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

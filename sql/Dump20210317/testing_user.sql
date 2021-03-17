-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testing
-- ------------------------------------------------------
-- Server version	8.0.23-commercial

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `blocked` tinyint(1) DEFAULT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_user_role1_idx` (`role_id`),
  CONSTRAINT `fk_user_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','test2','test','test@test.com','test','2021-02-15 13:14:40',1,1),(2,'admin','admin','admin','admin@test.com','admin','2021-02-15 13:14:40',0,2),(3,'test2','test','test','test@test.com','test','2021-02-17 18:19:48',0,1),(6,'test4','qweqweq','qweqweqwe','sqverful@gmail.com','qweqweqweqweqwe','2021-02-17 18:26:33',0,1),(9,'admin2','admin2','admin','sQverful@ukr.net','asdasdasdasd','2021-02-17 18:34:56',1,2),(13,'test7','testAdmin','testNewAdmin','test@test.com','test','2021-02-17 18:40:54',1,2),(21,'test13','Test','werwerewr','test13@gmail.com','test','2021-02-20 10:39:59',1,1),(22,'test10','test10','test10','test10@gmail.com','test10','2021-02-20 10:45:11',0,1),(23,'test11','test10changed','test10','sqverful@gmail.com','test10','2021-02-20 10:45:27',1,1),(24,'asdasdsd','asdasdas','asdasdasd','sqverful@casasdasd.com','asdasdasd','2021-02-21 13:09:49',0,1),(25,'testnumber2','Volodymyr','testnumber2','sqverful@gmail.com','testnumber2','2021-02-23 15:43:58',0,1),(26,'user','John','Abraham','user@test.com','user','2021-02-24 16:53:58',0,1),(27,'tttttttttttttttt','Volodymyr Dorosh','Dorosh','sqverful@gmail.com','Dorosh','2021-02-24 16:57:39',0,1),(28,'Юзер','Юзерій','Юзеренко','user@rwa.com','Юзер','2021-02-25 11:43:10',1,1),(29,'sQverful','Volodymyr Dorosh','qwerqwerqewr','sQverful@ukr.net','123','2021-02-25 13:01:58',0,1),(30,'user2','Bill','Nogates','user@test.com','user2','2021-03-01 17:29:26',0,1),(31,'user3','user3','user3','user3@test.com','user3','2021-03-01 17:35:17',0,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 14:43:38

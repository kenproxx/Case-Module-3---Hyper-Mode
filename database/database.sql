CREATE DATABASE
use
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
-- Table structure for table `attachment`
--

drop table IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `attachment` (
  `id` int NOT NULL,
  `product_id` int NOT NULL,
  `image_link` text NOT NULL,
  `status` int NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `attachment_product_fk` (`product_id`),
  CONSTRAINT `attachment_product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

lock TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

drop table IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `amount` double NOT NULL,
  `message` text,
  `discount` double DEFAULT NULL,
  `shipping_fee` double DEFAULT NULL,
  `payment` varchar(255) NOT NULL,
  `date_of_payment` datetime NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_shopping_user_fk` (`user_id`),
  CONSTRAINT `cart_shopping_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

lock TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_details`


drop table IF EXISTS `bill_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `bill_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bill_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_details_cart_shopping_fk` (`bill_id`),
  KEY `cart_details_product_fk` (`product_id`),
  CONSTRAINT `cart_details_cart_shopping_fk` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  CONSTRAINT `cart_details_product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_details`
--

lock TABLES `bill_details` WRITE;
/*!40000 ALTER TABLE `bill_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

drop table IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `catalog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `catalog_code` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text,
  `status` int NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

lock TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import`
--

drop table IF EXISTS `import`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `import` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `bid` double NOT NULL,
  `import_date` datetime NOT NULL,
  `export_date` datetime DEFAULT NULL,
  `status` int NOT NULL,
  `created_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `import_product_fk` (`product_id`),
  CONSTRAINT `import_product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import`
--

lock TABLES `import` WRITE;
/*!40000 ALTER TABLE `import` DISABLE KEYS */;
/*!40000 ALTER TABLE `import` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

drop table IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `catalog_id` int NOT NULL,
  `product_code` int NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `size` float NOT NULL,
  `image_link` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `status` int NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_catalog_fk` (`catalog_id`),
  CONSTRAINT `product_catalog_fk` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

lock TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

drop table IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `status` int NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

lock TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

drop table IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `sale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `price` double NOT NULL,
  `status` int NOT NULL,
  `created_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `export_product_fk` (`product_id`),
  CONSTRAINT `export_product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

lock TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

drop table IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `user` (
id` int NOT NULL AUTO_INCREMENT,
`role_id` int ,
`first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci ,
`last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci ,
`gender` bit(1) ,
`date_of_birth` date,
`phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci ,
`address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci ,
`email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`username` varchar(255) NOT NULL,
`password` varchar(50) NOT NULL,
`status` int ,
`created_date` datetime ,
`update_date` datetime ,
PRIMARY KEY (`id`),
KEY `user_role_fk` (`role_id`),
CONSTRAINT `user_role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

lock TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2020-05-16 17:56:40

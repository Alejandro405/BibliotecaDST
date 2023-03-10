-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.32-0buntu0.22.10.1

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `summary` varchar(1000) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (59,'Eddie Jaku','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.9WzQYRlKB2tEPSZM0E4fMQAAAA%26pid%3DApi&f=1&ipt=3b29a4bde894c8c2b75e86b8001e4d9db900367873659cbece8b303a687daa89&ipo=images','Eddie Jaku always considered himself a German first, a Jew second. He was proud of his country. But all of that changed in November 1938, when he was beaten, arrested and taken to a concentration camp.','The Happiest Man on Earth'),(60,'Max Fisher','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.mGRlYJtbzevzEgMgIjneWAAAAA%26pid%3DApi&f=1&ipt=07996454adfdf6f045f86047cd9ca0b8a5558acb7c60f105b9ca612d7b2ea7f5&ipo=images','From a New York Times investigative reporter and Pulitzer Prize finalist, ???an essential book for our times??? (Ezra Klein), tracking the high-stakes inside story of how Big Tech???s breakneck race to drive engagement???and profits???at all costs fractured the world','The Chaos Machine: The Inside Story of How Social Media Rewired Our Minds and Our World'),(58,'Antoine de Saint-Exup??ry, Richard Howard (Translator)','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.NXy__tPr2YhXWRZV6mv24QHaK6%26pid%3DApi&f=1&ipt=61ac7228ad86bd4da58dc27aa509af9609ce509ec411674d9907a9682929ef5f&ipo=images','A pilot stranded in the desert awakes one morning to see, standing before him, the most extraordinary little fellow. \"Please,\" asks the stranger, \"draw me a sheep.\" And the pilot realizes that when life\'s events are too difficult to understand, there is no choice but to succumb to their mysteries. He pulls out pencil and paper... And thus begins this wise and enchanting fable that, in teaching the secret of what is really important in life, has changed forever the world for its readers.','The Little Prince'),(57,'Elton John','https://m.media-amazon.com/images/I/81Ndo4grdVL.jpg','In his only official autobiography, music icon Elton John writes about his extraordinary life, which is also the subject of the film Rocketman.','Me'),(56,'Lev A.C. Rosen','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.1tGwu2jMK-kzoas70AVsIQAAAA%26pid%3DApi&f=1&ipt=f1725426764602ed03584cda760f8ecae650dfc5693e7749bd4b8b34314900d6&ipo=images','A delicious story from a new voice in suspense, Lev AC Rosen\'s Lavender House is Knives Out with a queer historical twist.','Lavender House'),(54,'Bram Stoker','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.nthtCOkOtpAG_Mritseh7QHaLH%26pid%3DApi&f=1&ipt=a7bed81cd06f07d01ccf44cbb4611a534d473332062962f4787cc91d48c13627&ipo=images','When Jonathan Harker visits Transylvania to help Count Dracula with the purchase of a London house, he makes a series of horrific discoveries about his client. Soon afterwards, various bizarre incidents unfold in England: an apparently unmanned ship is wrecked off the coast of Whitby; a young woman discovers strange puncture marks on her neck; and the inmate of a lunatic asylum raves about the \'Master\' and his imminent arrival.','Dracula'),(55,'Brian Cox, Jeffrey R. Forshaw','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.KtzNb6jPG_bFq2N82zcNiAAAAA%26pid%3DApi&f=1&ipt=d8a90fd562990daea4c3326a45ba6afbe35679d1294156ce28ddd3d25d4da200&ipo=images','A brilliant exploration of the most exotic objects in the universe by Professor Brian Cox and Professor Jeff Forshaw.','Black Holes: The Key to Understanding Everything'),(53,'Alan Rickman, Emma Thompson','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.E97pWsui0HiJjSlzaP7gyAAAAA%26pid%3DApi&f=1&ipt=1ae9e1f35ed63022ef76a7995699de031177431cec13d15e24346aca437ec625&ipo=images','Madly Deeply is a rare invitation into the mind of Alan Rickman???one of the most magnetic, beloved performers of our time.','Madly, Deeply The Diaries of Alan Rickman'),(52,'Siddhartha Mukherjee','https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.tCbD6oTAkJ4Y7FnlPtxeigAAAA%26pid%3DApi&f=1&ipt=bfd5cbdd51462d8e5ba849c5da9a0cbe422d769697f1d89c772b9b7b32795601&ipo=images','From the author of The Emperor of All Maladies, winner of the Pulitzer Prize, and The Gene, a #1 New York Times bestseller, comes his most spectacular book yet, an exploration of medicine and our radical new ability to manipulate cells. Rich with Mukherjee???s revelatory and exhilarating stories of scientists, doctors, and the patients whose lives may be saved by their work, The Song of the Cell is the third book in this extraordinary writer???s exploration of what it means to be human.','The Song of the Cell An Exploration of Medicine and the New Human');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-25 19:54:16

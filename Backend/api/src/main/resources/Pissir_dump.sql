-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: progetto_pissir
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actuator`
--

DROP TABLE IF EXISTS `actuator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actuator` (
  `id_actuator` binary(16) NOT NULL,
  `mode` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `type` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `id_greenhouse` binary(16) NOT NULL,
  PRIMARY KEY (`id_actuator`),
  KEY `FKhy78008sr8f8abbb4ys5qmdi6` (`id_greenhouse`),
  CONSTRAINT `FKhy78008sr8f8abbb4ys5qmdi6` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouse` (`id_greenhouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actuator`
--

LOCK TABLES `actuator` WRITE;
/*!40000 ALTER TABLE `actuator` DISABLE KEYS */;
INSERT INTO `actuator` VALUES (_binary 'hSH{�\�DF�\�\�\�r�n','AUTOMATICO','ATTIVO','RISCALDAMENTO',_binary 'Z%�iWO6�i&�$H��'),(_binary '�\Z\�A*�\�dSZ\�','AUTOMATICO','ATTIVO','IRRIGAZIONE',_binary 'Z%�iWO6�i&�$H��'),(_binary '\�\�\�pֻM�G�\ny\�<\�','AUTOMATICO','ATTIVO','ILLUMINAZIONE',_binary 'Z%�iWO6�i&�$H��');
/*!40000 ALTER TABLE `actuator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agricultural_holding`
--

DROP TABLE IF EXISTS `agricultural_holding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agricultural_holding` (
  `id_agricultural_holding` binary(16) NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id_agricultural_holding`),
  UNIQUE KEY `UK313511hn71eitt3air7r16rhh` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agricultural_holding`
--

LOCK TABLES `agricultural_holding` WRITE;
/*!40000 ALTER TABLE `agricultural_holding` DISABLE KEYS */;
INSERT INTO `agricultural_holding` VALUES (_binary '\�9u�G}�i�w:�','default azienda with jeremie Agricoltore and Jhon Collaborator','Our First azienda');
/*!40000 ALTER TABLE `agricultural_holding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agricultural_holding_utente_entities`
--

DROP TABLE IF EXISTS `agricultural_holding_utente_entities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agricultural_holding_utente_entities` (
  `azienda_agricola_entity_id_agricultural_holding` binary(16) NOT NULL,
  `utente_entities_id_user` binary(16) NOT NULL,
  UNIQUE KEY `UK_e5tleah6c8she3hbgdsbadlnv` (`utente_entities_id_user`),
  KEY `FK4bs6k2r5f377cqka2h7o6yd84` (`azienda_agricola_entity_id_agricultural_holding`),
  CONSTRAINT `FK4bs6k2r5f377cqka2h7o6yd84` FOREIGN KEY (`azienda_agricola_entity_id_agricultural_holding`) REFERENCES `agricultural_holding` (`id_agricultural_holding`),
  CONSTRAINT `FK64brails2e34fp5xjllo475l2` FOREIGN KEY (`utente_entities_id_user`) REFERENCES `person` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agricultural_holding_utente_entities`
--

LOCK TABLES `agricultural_holding_utente_entities` WRITE;
/*!40000 ALTER TABLE `agricultural_holding_utente_entities` DISABLE KEYS */;
INSERT INTO `agricultural_holding_utente_entities` VALUES (_binary '\�9u�G}�i�w:�',_binary '�a�Ho��D�ɇ\�'),(_binary '\�9u�G}�i�w:�',_binary '��1\��[Hw��\r�\�I�%');
/*!40000 ALTER TABLE `agricultural_holding_utente_entities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `greenhouse`
--

DROP TABLE IF EXISTS `greenhouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `greenhouse` (
  `id_greenhouse` binary(16) NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `id_agricultural_holding` binary(16) NOT NULL,
  PRIMARY KEY (`id_greenhouse`),
  KEY `FK3jqthy6k404haovglisnh6bt8` (`id_agricultural_holding`),
  CONSTRAINT `FK3jqthy6k404haovglisnh6bt8` FOREIGN KEY (`id_agricultural_holding`) REFERENCES `agricultural_holding` (`id_agricultural_holding`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `greenhouse`
--

LOCK TABLES `greenhouse` WRITE;
/*!40000 ALTER TABLE `greenhouse` DISABLE KEYS */;
INSERT INTO `greenhouse` VALUES (_binary 'Z%�iWO6�i&�$H��','Hola amigos, it is, the second serra of \'Our First azienda\' ',_binary '\�9u�G}�i�w:�');
/*!40000 ALTER TABLE `greenhouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irrigation_scheduler`
--

DROP TABLE IF EXISTS `irrigation_scheduler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `irrigation_scheduler` (
  `id_irrigation_scheduler` binary(16) NOT NULL,
  `description` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `execution_date` date NOT NULL,
  `end_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `id_agricultural_holding` binary(16) NOT NULL,
  `id_greenhouse` binary(16) NOT NULL,
  PRIMARY KEY (`id_irrigation_scheduler`),
  KEY `FKe6gyp53man1gj4ip79th0t92d` (`id_agricultural_holding`),
  KEY `FKcwc35s2d88a2jmynxnorl1dts` (`id_greenhouse`),
  CONSTRAINT `FKcwc35s2d88a2jmynxnorl1dts` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouse` (`id_greenhouse`),
  CONSTRAINT `FKe6gyp53man1gj4ip79th0t92d` FOREIGN KEY (`id_agricultural_holding`) REFERENCES `agricultural_holding` (`id_agricultural_holding`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irrigation_scheduler`
--

LOCK TABLES `irrigation_scheduler` WRITE;
/*!40000 ALTER TABLE `irrigation_scheduler` DISABLE KEYS */;
INSERT INTO `irrigation_scheduler` VALUES (_binary '?��馫M���K\�\�\�5','test for creation of planificatore','2023-05-13','16:00:00','15:00:00',_binary '\�9u�G}�i�w:�',_binary 'Z%�iWO6�i&�$H��');
/*!40000 ALTER TABLE `irrigation_scheduler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measure`
--

DROP TABLE IF EXISTS `measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `measure` (
  `id_measure` binary(16) NOT NULL,
  `measures` decimal(2,0) NOT NULL,
  `id_sensor` binary(16) NOT NULL,
  PRIMARY KEY (`id_measure`),
  KEY `FKrihxgq74ktenagsymhuyvikwu` (`id_sensor`),
  CONSTRAINT `FKrihxgq74ktenagsymhuyvikwu` FOREIGN KEY (`id_sensor`) REFERENCES `sensor` (`id_sensor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measure`
--

LOCK TABLES `measure` WRITE;
/*!40000 ALTER TABLE `measure` DISABLE KEYS */;
INSERT INTO `measure` VALUES (_binary '\�\���A<�3\�H��X',60,_binary '\�\�D����\0\ZGO'),(_binary 'Z�\�\�H��:u��0',57,_binary '\��ӝI4�\�@Ww'),(_binary '˥_�\�I9�|P\�\�]',28,_binary '\�\�D����\0\ZGO'),(_binary '\�\��\"KJ��&\�y��\�',25,_binary '\�\�D����\0\ZGO'),(_binary '}!+O��y^h\�r',59,_binary '\��ӝI4�\�@Ww'),(_binary 'D+/��No�G`��',16,_binary '\�\�D����\0\ZGO'),(_binary 'OI4�yI�\�r��a?\�',68,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '	wm�-jK��1�¬',47,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\nIF\'�@��F�H\nU��',44,_binary '\��ӝI4�\�@Ww'),(_binary '�\�9Dd�I\�dF',4,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '��\�E��*\�O7�\�',53,_binary '\��ӝI4�\�@Ww'),(_binary '\�wKM|H_��y\�\�B\�',5,_binary '\�\�D����\0\ZGO'),(_binary '�\�;K���T\��b�',84,_binary '\��ӝI4�\�@Ww'),(_binary '����7B\�\�뢈K}',4,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�U|\�B�szZ���4',0,_binary '\�\�D����\0\ZGO'),(_binary '����RO2�4{�\�C',9,_binary '\�\�D����\0\ZGO'),(_binary '\ZT34\�G]�v\�b)*',43,_binary '\�\�D����\0\ZGO'),(_binary '\Z7\rS]�E�#�\�.���',68,_binary '\�\�D����\0\ZGO'),(_binary '~�\�\�O���\�\�C�8',49,_binary '\�\�D����\0\ZGO'),(_binary '\���O2�\�\�5p*֊',59,_binary '\�\�D����\0\ZGO'),(_binary '#Bg��A�$\0�1�6�',61,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '#\�0e�}@\��Ub\�2',43,_binary '\�\�D����\0\ZGO'),(_binary '(�\�V�O��_S-`6\'',24,_binary '\�\�D����\0\ZGO'),(_binary ')yc,\�NٹP7F�N�X',73,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary ')��\�N��?\�\�s\��',16,_binary '\�\�D����\0\ZGO'),(_binary '*j\�\� e@��cu.\�J��',28,_binary '\��ӝI4�\�@Ww'),(_binary '*\�gc�Js��`\����',53,_binary '\��ӝI4�\�@Ww'),(_binary ',71�\�G����5ٙ�\�',63,_binary '\��ӝI4�\�@Ww'),(_binary ',�&\�BԽ�I~\�l�',61,_binary '\�\�D����\0\ZGO'),(_binary ',\�`b�\�E��J\"\�\�18',15,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '.@(ǔ\�Dǹ��Ê).\�',4,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '3�F\�W�LF���?\�=\�',42,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '3��6�\"F\��`陷�\�',80,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '4m�Y@n��\�\�~��\�',55,_binary '\�\�D����\0\ZGO'),(_binary '7\�\�\�NA��\�T\�\�',5,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '8sw\�uM&��\�A\�l@',52,_binary '\�\�D����\0\ZGO'),(_binary '9@\�@�H��\�gu\�\�л',15,_binary '\�\�D����\0\ZGO'),(_binary ';\�I<FK\'���\�] v',61,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '?Fu\�}M��\�\�)eΚ\�',43,_binary '\�\�D����\0\ZGO'),(_binary '?�@J\�t,xߤ�',53,_binary '\�\�D����\0\ZGO'),(_binary 'AX\Z�\�Ed��A���\nW',85,_binary '\�\�D����\0\ZGO'),(_binary 'G���!aE�3u�\�M\�',33,_binary '\�\�D����\0\ZGO'),(_binary 'G\���G5閶\�',72,_binary '\�\�D����\0\ZGO'),(_binary 'I����DK�1d�\�\r\�',84,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary 'I\�\�\�!rMؑ\�\���5\�',9,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary 'P(>�4@��|�\���\�',61,_binary '\�\�D����\0\ZGO'),(_binary 'U��\�\�Ho�6�2�l\�',61,_binary '\�\�D����\0\ZGO'),(_binary 'WeŪ\�B���\�x\�\�v',6,_binary '\�\�D����\0\ZGO'),(_binary 'X\\\�p��A����(\0�\�',63,_binary '\��ӝI4�\�@Ww'),(_binary 'X\�p>\�\�IǼ�4�c',13,_binary '\��ӝI4�\�@Ww'),(_binary '\\\�k2\�Hw��Я�.',48,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\\SQvKEd�A@r�;��',92,_binary '\�\�D����\0\ZGO'),(_binary 'b��\�\�J	�O\��i�',19,_binary '\��ӝI4�\�@Ww'),(_binary 'd\�5q̎NJ�bէ\�:��',71,_binary '\�\�D����\0\ZGO'),(_binary 'g呶N��]x5:<�\�',85,_binary '\��ӝI4�\�@Ww'),(_binary 'if�y\�L\�#\'��K\�0',26,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary 'i��ϭ\�M��J[ ]\�u',53,_binary '\��ӝI4�\�@Ww'),(_binary 'lvE�!F��\�{>n>\�',50,_binary '\�\�D����\0\ZGO'),(_binary 'm�\�\�G/�͛`\�\�U)',8,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary 's\��NV�e1׎Z�o',6,_binary '\�\�D����\0\ZGO'),(_binary '{4*&\�\�Ds���\�T�37',68,_binary '\�\�D����\0\ZGO'),(_binary '|�\�\�\�\�N6�-\�H�T�',43,_binary '\�\�D����\0\ZGO'),(_binary '}\�-\�kI��\�\�\�B�\�',53,_binary '\��ӝI4�\�@Ww'),(_binary '}�\�$\�N��\�͉\�\�',28,_binary '\�\�D����\0\ZGO'),(_binary '~\�;s6AF�\�}\�9F��',58,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '���_\�O4�*gܨ��_',40,_binary '\�\�D����\0\ZGO'),(_binary '�C#�\"O$�\�-�0/�',48,_binary '\��ӝI4�\�@Ww'),(_binary '�T����J���N���\�',53,_binary '\��ӝI4�\�@Ww'),(_binary '�)2\�L<�i{jr�B(',33,_binary '\�\�D����\0\ZGO'),(_binary '�REb3J��\�i�d8',82,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�\�atGL4�?�\\B\�S',36,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�Z�\�r$B(�=4�M�X�',50,_binary '\�\�D����\0\ZGO'),(_binary '���Z\�FQ�\��I\�',8,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�Wm�W�IW�XwL�=�r',5,_binary '\��ӝI4�\�@Ww'),(_binary '��K7�GL{�H�\���Yw',71,_binary '\�\�D����\0\ZGO'),(_binary '�\�%ӮD��R|u�\�>�',93,_binary '\�\�D����\0\ZGO'),(_binary '�O}P�G�\�f5l��',61,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�ǖRÎL���&\��U#',49,_binary '\�\�D����\0\ZGO'),(_binary '�!��M������s˼',25,_binary '\�\�D����\0\ZGO'),(_binary '��e>XB��SB:6\�',67,_binary '\��ӝI4�\�@Ww'),(_binary '�t\��H&E��|����D�',64,_binary '\�\�D����\0\ZGO'),(_binary '�*o�<J�˙afL�',59,_binary '\�\�D����\0\ZGO'),(_binary '�VD\�R�@\�L#�\�/�',6,_binary '\�\�D����\0\ZGO'),(_binary '�V��\�LT��\"\�lX\�',43,_binary '\�\�D����\0\ZGO'),(_binary '��eqgxKU�Q�V6O',53,_binary '\�\�D����\0\ZGO'),(_binary '�ى�/Gn�B�\�+�',18,_binary '\��ӝI4�\�@Ww'),(_binary '�@M.\�LU�j\��Ap\�',40,_binary '\�\�D����\0\ZGO'),(_binary '�FkN{PL��ҕ��\�\�',2,_binary '\�\�D����\0\ZGO'),(_binary '�\�\�\�˒O�_�\��\�*:',95,_binary '\��ӝI4�\�@Ww'),(_binary '�\'	._DJ���\�߁',46,_binary '\�\�D����\0\ZGO'),(_binary '�t�|��HƘ\�U�d',40,_binary '\�\�D����\0\ZGO'),(_binary '��O��5NȬ^�~)7\�A',18,_binary '\�\�D����\0\ZGO'),(_binary '����\�G�\�o\rj�',71,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '��\�FK\�N���<�Щl�',94,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�体�I*��/^���\�',61,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '�\�\�H\�E?�9��\r\�',30,_binary '\�\�D����\0\ZGO'),(_binary '���1FF�,J^n\'',93,_binary '\��ӝI4�\�@Ww'),(_binary '�>-M\�\�G��!Ș�⎹',49,_binary '\�\�D����\0\ZGO'),(_binary '�4~\r$L�m\�Zp\�',9,_binary '\�\�D����\0\ZGO'),(_binary '�/�G�Cڌ\�\�\�et�',52,_binary '\�\�D����\0\ZGO'),(_binary '\������D�f\�\n,�5',30,_binary '\��ӝI4�\�@Ww'),(_binary 'ȔA��\�N\�lT��)T',9,_binary '\�\�D����\0\ZGO'),(_binary 'ȴ\�D\�sE\�\�Bu�z�x',43,_binary '\�\�D����\0\ZGO'),(_binary '\�\�S�^KA��S\�c�\�\�',6,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\����mL\\�1|\�\r�\�\�',95,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�8\�QC��G��b��',90,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�\�ƽa�@��\�<\��\�5-',26,_binary '\��ӝI4�\�@Ww'),(_binary '\���hmO��\r\�U\�\\p',40,_binary '\�\�D����\0\ZGO'),(_binary '\�8ow\�ID�Q�\�\�B',50,_binary '\�\�D����\0\ZGO'),(_binary '\�2Р>C�15\�WvM\r',95,_binary '\�\�D����\0\ZGO'),(_binary 'Ճ\Z�DE��\��%*�X\�',46,_binary '\�\�D����\0\ZGO'),(_binary '\�\�	�;\�C^�\�\�]f�!',6,_binary '\�\�D����\0\ZGO'),(_binary '\�\0�G\��H��m��0��',99,_binary '\�\�D����\0\ZGO'),(_binary '\�im!M\�9\Z\�',63,_binary '\��ӝI4�\�@Ww'),(_binary '\�\�}ޱ_H��_�2',72,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary 'ۺ4{\�G��Bߍ�w\�\�',18,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�x#V�O��H\\�3��',61,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�M!1øNw��Iz饏\�',50,_binary '\�\�D����\0\ZGO'),(_binary '\�X-e\�WH@�u�l3\'\�h',61,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�\�{\�|C$�zd4�\�3x',23,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�s��aF5��\�9��\�',5,_binary '\�\�D����\0\ZGO'),(_binary '\�\Z7 �/N,��A\�|p�',55,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�jeC�Dɰ�\�M�V',92,_binary '\�\�D����\0\ZGO'),(_binary '\�/\�u\�JA͜yV3�\n\�',6,_binary '\�\�D����\0\ZGO'),(_binary '\�4#��I��~m\�\�\n=',53,_binary '\��ӝI4�\�@Ww'),(_binary '\�۪$\�K#�2\�a',25,_binary '\�\�b?\�vJX�\n\�۪r'),(_binary '\�\0\�j��H��j}Z3�',34,_binary '\��ӝI4�\�@Ww'),(_binary '�\�\�\�\�KϩeX��3b',53,_binary '\�\�D����\0\ZGO');
/*!40000 ALTER TABLE `measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id_user` binary(16) NOT NULL,
  `first_name` varchar(40) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(25) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(55) COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UKjnmhkxs5tdukd3cpw93aop3vr` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (_binary '�a�Ho��D�ɇ\�','Doe','doe@mail.com','Jhon','5555','COLLABORATORE'),(_binary '��1\��[Hw��\r�\�I�%','Prince','prince@mail.com','Jeremie','5555','AGRICOLTORE');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor` (
  `id_sensor` binary(16) NOT NULL,
  `types` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `id_greenhouse` binary(16) NOT NULL,
  PRIMARY KEY (`id_sensor`),
  KEY `FK9heuqxwe2gh4ue98oakn3e5kx` (`id_greenhouse`),
  CONSTRAINT `FK9heuqxwe2gh4ue98oakn3e5kx` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouse` (`id_greenhouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (_binary '\��ӝI4�\�@Ww','LUCE',_binary 'Z%�iWO6�i&�$H��'),(_binary '\�\�D����\0\ZGO','TEMPERATURA',_binary 'Z%�iWO6�i&�$H��'),(_binary '\�\�b?\�vJX�\n\�۪r','UMIDITA',_binary 'Z%�iWO6�i&�$H��');
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-24 19:43:14

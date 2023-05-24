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
INSERT INTO `actuator` VALUES (_binary 'hSH{—\ÜDF\Ç\á\Ãr‚n','AUTOMATICO','ATTIVO','RISCALDAMENTO',_binary 'Z%¹iWO6—i&¾$H°—'),(_binary '¢\Z\õA*©\ådSZ\È','AUTOMATICO','ATTIVO','IRRIGAZIONE',_binary 'Z%¹iWO6—i&¾$H°—'),(_binary '\Ç\ñ\ËpÖ»M³G‰\ny\Í<\Ï','AUTOMATICO','ATTIVO','ILLUMINAZIONE',_binary 'Z%¹iWO6—i&¾$H°—');
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
INSERT INTO `agricultural_holding` VALUES (_binary '\å9u§G}£i‡w:ş','default azienda with jeremie Agricoltore and Jhon Collaborator','Our First azienda');
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
INSERT INTO `agricultural_holding_utente_entities` VALUES (_binary '\å9u§G}£i‡w:ş',_binary 'ºaŠHo’D´É‡\Í'),(_binary '\å9u§G}£i‡w:ş',_binary '–´1\õ[Hw€ı\r\ÔI´%');
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
INSERT INTO `greenhouse` VALUES (_binary 'Z%¹iWO6—i&¾$H°—','Hola amigos, it is, the second serra of \'Our First azienda\' ',_binary '\å9u§G}£i‡w:ş');
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
INSERT INTO `irrigation_scheduler` VALUES (_binary '?ˆ¸é¦«M‹±K\î\ä´\Ï5','test for creation of planificatore','2023-05-13','16:00:00','15:00:00',_binary '\å9u§G}£i‡w:ş',_binary 'Z%¹iWO6—i&¾$H°—');
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
INSERT INTO `measure` VALUES (_binary '\í\à—šA<µ3\İH”¶X',60,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'Z‹\İ\ëHš¬:u³·0',57,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'Ë¥_‰\ğI9ª|P\â®\Ä]',28,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\â\Åÿ\"KJş¶&\Ïyü•\ó',25,_binary '\ß\í¶D³·\0\ZGO'),(_binary '}!+O†‰y^h\Ìr',59,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'D+/µûNo¦G`”£',16,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'OI4yI\Ûr a?\Ü',68,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '	wm–-jK¨¢1¨Â¬',47,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\nIF\'º@ÿ˜FøH\nU½€',44,_binary '\á»ÓI4†\é‘@Ww'),(_binary '’\í9Dd—I\ÎdF',4,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '‡œ\ğªE©‘*\×O7™\Î',53,_binary '\á»ÓI4†\é‘@Ww'),(_binary '\ÏwKM|H_º‘y\×\ŞB\í¼',5,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'À\ã;K›¤T\Î‡b',84,_binary '\á»ÓI4†\é‘@Ww'),(_binary '—ø˜7B\í°€\çë¢ˆK}',4,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '‰U|\æ´B¥szZ«¡“4',0,_binary '\ß\í¶D³·\0\ZGO'),(_binary '™” œRO2¼4{‘\íC',9,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\ZT34\ÂG]¢v\ìb)*',43,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Z7\rS]ÀE#À\È.¬£®',68,_binary '\ß\í¶D³·\0\ZGO'),(_binary '~À\ç¨\ÈO¢™ø\Ô\ÄC¼8',49,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Ïı™O2‰\Ê\Â5p*ÖŠ',59,_binary '\ß\í¶D³·\0\ZGO'),(_binary '#Bg™½Aº$\0û1ª6š',61,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '#\ï0e}@\ğ–†ÁUb\í2',43,_binary '\ß\í¶D³·\0\ZGO'),(_binary '(™\ÇV¼O©˜_S-`6\'',24,_binary '\ß\í¶D³·\0\ZGO'),(_binary ')yc,\éNÙ¹P7F¾NºX',73,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary ')€û\î›N·¼?\Ü\İs\Úÿ',16,_binary '\ß\í¶D³·\0\ZGO'),(_binary '*j\ì\Ç e@‹cu.\ÅJ’Œ',28,_binary '\á»ÓI4†\é‘@Ww'),(_binary '*\égcJs¡”`\÷»ø±',53,_binary '\á»ÓI4†\é‘@Ww'),(_binary ',71•\êG³“­5Ù™¿\Ø',63,_binary '\á»ÓI4†\é‘@Ww'),(_binary ',¸&\ñªBÔ½ºI~\îlú',61,_binary '\ß\í¶D³·\0\ZGO'),(_binary ',\Ã`bŠ\ÊE“J\"\â\Ş18',15,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '.@(Ç”\ÅDÇ¹À¾ÃŠ).\â',4,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '3ƒF\çWLF¼‚£?\Î=\Ê',42,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '3¡‹6Á\"F\à`é™·ı\ê',80,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '4møY@n•\Ï\Æ~½¦\Ò',55,_binary '\ß\í¶D³·\0\ZGO'),(_binary '7\Õ\í\áNA¯\ßT\Ï\Ã',5,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '8sw\ØuM&² \ÚA\÷l@',52,_binary '\ß\í¶D³·\0\ZGO'),(_binary '9@\È@üH¥¡\égu\Ñ\õĞ»',15,_binary '\ß\í¶D³·\0\ZGO'),(_binary ';\ÛI<FK\'º¿ÿ\æ] v',61,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '?Fu\Ç}M’¶\ã\Ú)eÎš\ö',43,_binary '\ß\í¶D³·\0\ZGO'),(_binary '?¨@J\ìt,xß¤º',53,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'AX\Z¹\ó•Ed½A¿®\nW',85,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'GÁ!aE…3u¡\ŞM\Å',33,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'G\İª›Gî¯¾5é–¶\Ù',72,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'I„»DK‰1d \Ş\r\à',84,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'I\í\æ\Ë!rMØ‘\ë\åş²5\Ù',9,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'P(>©4@‚˜|\Æı™\é',61,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'Uıû\Ï\×Hoº6´2œl\Ù',61,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'WeÅª\ÓB—‰\é†x\Ü\Ñv',6,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'X\\\ãpş‰A¡˜ü(\0†\Â',63,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'X\Øp>\÷\ãIÇ¼ 4ˆc',13,_binary '\á»ÓI4†\é‘@Ww'),(_binary '\\\êk2\ÓHw–ŸĞ¯‹.',48,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\\SQvKEd˜A@rü;»®',92,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'bš’\È\ğJ	²O\ò£i‹',19,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'd\ì5qÌNJ³bÕ§\ã:°“',71,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'gå‘¶N‹Œ]x5:<Ÿ\Ò',85,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'ifÁy\ŞL\è³#\'ø»K\Õ0',26,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'i­›Ï­\÷M«¼J[ ]\öu',53,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'lvE³!Fû¿\æ{>n>\Ö',50,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'm¡\Ë\éG/¥Í›`\Â\èU)',8,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 's\ëøNVše1×Z’o',6,_binary '\ß\í¶D³·\0\ZGO'),(_binary '{4*&\Í\óDs›§°\ÓT½37',68,_binary '\ß\í¶D³·\0\ZGO'),(_binary '|¥\ì\ê\ì\éN6Ÿ-\ÈH»T',43,_binary '\ß\í¶D³·\0\ZGO'),(_binary '}\ó-\ÎkI”\Û\Ù\àB¡\ó',53,_binary '\á»ÓI4†\é‘@Ww'),(_binary '}£\æ–$\õN–»\æ„Í‰\É\Ö',28,_binary '\ß\í¶D³·\0\ZGO'),(_binary '~\Ø;s6AF¹\ß}\Ó9F“½',58,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'À¸•_\ÇO4*gÜ¨›½_',40,_binary '\ß\í¶D³·\0\ZGO'),(_binary '€C#\"O$˜\Ô-¾0/',48,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'T„ª¿Jı˜N¼Ÿ\Ó',53,_binary '\á»ÓI4†\é‘@Ww'),(_binary '…)2\ÎL<¢i{jr³B(',33,_binary '\ß\í¶D³·\0\ZGO'),(_binary '‰REb3J\æºiûd8',82,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '‘\ÛatGL4˜?Ÿ\\B\î©S',36,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '–Z¾\Îr$B(¿=4¿MŸX',50,_binary '\ß\í¶D³·\0\ZGO'),(_binary '—±’Z\ãFQ”\é´™I\ò',8,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '—WmWºIWŸXwLû=Àr',5,_binary '\á»ÓI4†\é‘@Ww'),(_binary '—·K7®GL{H\Ùø£Yw',71,_binary '\ß\í¶D³·\0\ZGO'),(_binary '™\ï%Ó®D¦¿R|uµ\î>ÿ',93,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'šO}P¾G‘\Åf5l”',61,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'Ç–RÃL …„&\ğÁU#',49,_binary '\ß\í¶D³·\0\ZGO'),(_binary ' !¾Mª‰ŠÿŒsË¼',25,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¢«e>XBû”SB:6\Ñ',67,_binary '\á»ÓI4†\é‘@Ww'),(_binary '¤t\ÈøH&E¥‘|ÀºùDÿ',64,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¥*o¦<JƒË™afL',59,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¥VD\ßR™@\í¢ºL#Š\Ğ/',6,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¨V‰ü\ÈLTšº\"\ŞlX\Ç',43,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¨ÁeqgxKU¦Q¦V6O',53,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¨Ù‰Š/Gn±B‰\ï¨+±',18,_binary '\á»ÓI4†\é‘@Ww'),(_binary '©@M.\ğLUj\ğüAp\ò',40,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¬FkN{PLÒ•³¢\Å\ë',2,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¬\Ò\È\ÌË’O–_‚\Ôø\à*:',95,_binary '\á»ÓI4†\é‘@Ww'),(_binary '¯\'	._DJ”²\æß',46,_binary '\ß\í¶D³·\0\ZGO'),(_binary '±t€|–½HÆ˜\âUd',40,_binary '\ß\í¶D³·\0\ZGO'),(_binary '±»OŠ¯5NÈ¬^¨~)7\ÒA',18,_binary '\ß\í¶D³·\0\ZGO'),(_binary '³¦»ÿ\ÄG\ño\rj¯',71,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'µ†\àFK\ëNü­§<©Ğ©l‰',94,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '·ä½“I*¸š/^ ÿ\È',61,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '¸\Ë\ìH\ñE?°9¿†\r\à',30,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'º¾ª1FF¬,J^n\'',93,_binary '\á»ÓI4†\é‘@Ww'),(_binary '»>-M\Î\ĞGŸ‡!È˜‚â¹',49,_binary '\ß\í¶D³·\0\ZGO'),(_binary '¾4~\r$Lm\ÏZp\ë',9,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'Á/G¸CÚŒ\ğ\Ë\àet„',52,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Çû¿†¸½DŒf\Ú\n,•5',30,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'È”Aˆ\ÍN\ó—lTˆ›)T',9,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'È´\ÕD\ìsE\ò¸\êBuƒz´x',43,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Ì\ôS^KA°¦S\íc\Í\Ã',6,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\Íš·‡mL\\ª1|\É\r«\î\ö',95,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\Ï8\ÓQC²G»›b£„',90,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\Ï\çÆ½a¯@€Š\É<\õ½\Õ5-',26,_binary '\á»ÓI4†\é‘@Ww'),(_binary '\Ò‹úhmO¤­\r\ŞU\È\\p',40,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Ó8ow\êID¹Q½\È\ÚB',50,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Õ2Ğ >C‚15\ÔWvM\r',95,_binary '\ß\í¶D³·\0\ZGO'),(_binary 'Õƒ\Z¢DE¥’\ÎÀ%*·X\å',46,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Ø\Ã	¬;\ëC^¤\õ\Ä]fü!',6,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Ù\0ŒG\ÚúH‹¹m¬¦0­›',99,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\Ùim!M\äŸ9\Z\ò¤‹',63,_binary '\á»ÓI4†\é‘@Ww'),(_binary '\Ù\Ê}Ş±_H„_ 2',72,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary 'Ûº4{\èG°´Bß’w\Å\á',18,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\Şx#V“O­½H\\‹3Ÿ¥',61,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\çM!1Ã¸Nw±¤Izé¥\Ğ',50,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\éX-e\×WH@ul3\'\Èh',61,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\é‹\Ï{\Ô|C$²zd4ù\Ê3x',23,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\ësªÁaF5†\Ü9¡¯\é',5,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\í\Z7 ©/N,ˆ¯A\×|pÀ',55,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\î€jeC°DÉ°³\é¯MûV',92,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\õ/\âu\ØJAÍœyV3˜\n\Ü',6,_binary '\ß\í¶D³·\0\ZGO'),(_binary '\õ4#¾I“°~m\ç\×\n=',53,_binary '\á»ÓI4†\é‘@Ww'),(_binary '\õÛª$\çK#³2\Ãa',25,_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr'),(_binary '\÷\0\İj”‹H”©j}Z3±',34,_binary '\á»ÓI4†\é‘@Ww'),(_binary 'ú\Ù\ğ\Õ\ÓKÏ©eX®“3b',53,_binary '\ß\í¶D³·\0\ZGO');
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
INSERT INTO `person` VALUES (_binary 'ºaŠHo’D´É‡\Í','Doe','doe@mail.com','Jhon','5555','COLLABORATORE'),(_binary '–´1\õ[Hw€ı\r\ÔI´%','Prince','prince@mail.com','Jeremie','5555','AGRICOLTORE');
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
INSERT INTO `sensor` VALUES (_binary '\á»ÓI4†\é‘@Ww','LUCE',_binary 'Z%¹iWO6—i&¾$H°—'),(_binary '\ß\í¶D³·\0\ZGO','TEMPERATURA',_binary 'Z%¹iWO6—i&¾$H°—'),(_binary '\í\Ñb?\ïvJX¼\n\ğ¼Ûªr','UMIDITA',_binary 'Z%¹iWO6—i&¾$H°—');
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

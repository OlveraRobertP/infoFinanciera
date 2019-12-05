CREATE DATABASE  IF NOT EXISTS `infin` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `infin`;
-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: infin
-- ------------------------------------------------------
-- Server version	5.7.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `seg_bitacora`
--

DROP TABLE IF EXISTS `seg_bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seg_bitacora` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EVENTO` int(11) NOT NULL,
  `DESCRIPCION` varchar(1000) DEFAULT NULL,
  `F_ALTA` datetime NOT NULL,
  `ID_USUARIO_ALTA` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_bita_bitaeven_idx` (`EVENTO`),
  KEY `FK_BIT_USU_ADD_idx` (`ID_USUARIO_ALTA`),
  CONSTRAINT `FK_BIT_USU_ADD` FOREIGN KEY (`ID_USUARIO_ALTA`) REFERENCES `seg_usuarios` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bita_bitaeven` FOREIGN KEY (`EVENTO`) REFERENCES `seg_bitacora_eventos` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=498 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_bitacora`
--

LOCK TABLES `seg_bitacora` WRITE;
/*!40000 ALTER TABLE `seg_bitacora` DISABLE KEYS */;
INSERT INTO `seg_bitacora` VALUES (423,4,NULL,'2019-10-29 04:26:30',1),(424,5,NULL,'2019-10-29 04:26:36',1),(425,4,NULL,'2019-10-29 04:26:46',1),(426,4,NULL,'2019-10-29 15:51:33',1),(427,2,'Rol [clave=1, nombre=ADMINISTRADOR]','2019-10-29 15:53:25',1),(428,2,'Usuario [clave=ADMIN, nombre=Jose Roberto, paterno=Olvera, materno=Perez, email=jr_robert@live.com.mx, rol=Rol [clave=1, nombre=ADMINISTRADOR], ultimoAcceso=2019-10-29 09:51:33.0, resetPassword=true, activo=true]','2019-10-29 15:54:10',1),(429,5,NULL,'2019-10-29 15:54:18',1),(430,4,NULL,'2019-10-29 15:54:24',1),(431,4,NULL,'2019-10-29 19:26:36',1),(432,4,NULL,'2019-11-04 19:35:02',1),(433,4,NULL,'2019-11-04 19:36:10',1),(434,4,NULL,'2019-11-04 19:43:07',1),(435,4,NULL,'2019-11-04 19:51:43',1),(436,4,NULL,'2019-11-04 19:57:58',1),(437,4,NULL,'2019-11-04 20:00:46',1),(438,4,NULL,'2019-11-07 16:26:09',1),(439,4,NULL,'2019-11-07 17:26:37',1),(440,4,NULL,'2019-11-07 17:28:58',1),(441,4,NULL,'2019-11-07 17:39:05',1),(442,4,NULL,'2019-11-07 18:35:54',1),(443,12,'EstadoFinanciero [id=1, clave=BAL_BANCOS, nombre=BALANCE GENERAL DE BANCOS, descripcion=null]','2019-11-07 18:46:56',1),(444,12,'EstadoFinanciero [id=1, clave=BAL_BANCOS, nombre=BALANCE GENERAL DE BANCOS, descripcion=null]','2019-11-07 18:48:18',1),(445,12,'EstadoFinanciero [id=1, clave=BAL_BANCOS, nombre=BALANCE GENERAL DE BANCOS, descripcion=null]','2019-11-07 18:49:13',1),(446,12,'EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS, descripcion=]','2019-11-07 18:57:17',1),(448,12,'EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]','2019-11-07 18:59:49',1),(449,13,'Cuenta [id=null, clave=cuenta1, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-07 18:59:58',1),(450,14,'Cuenta [id=1, clave=cuenta1, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-07 19:01:07',1),(451,14,'Cuenta [id=1, clave=cuenta1, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-07 19:01:30',1),(452,13,'Cuenta [id=null, clave=cuenta2, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-07 19:04:04',1),(453,13,'Cuenta [id=null, clave=ceunta 3, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-07 19:05:38',1),(454,4,NULL,'2019-11-07 19:07:54',1),(455,4,NULL,'2019-11-07 19:20:54',1),(456,4,NULL,'2019-11-07 19:29:13',1),(457,4,NULL,'2019-11-07 19:32:26',1),(458,4,NULL,'2019-11-07 19:33:33',1),(459,4,NULL,'2019-11-07 20:08:43',1),(460,4,NULL,'2019-11-07 20:13:50',1),(461,4,NULL,'2019-11-08 16:59:54',1),(462,13,'Cuenta [id=null, clave=prueba4, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-08 17:35:28',1),(463,15,'Cuenta [id=3, clave=ceunta 3, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-08 17:43:39',1),(464,14,'Cuenta [id=2, clave=cuenta2, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-08 17:47:26',1),(465,15,'Cuenta [id=2, clave=cuenta2, edoFinanciero=EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BANCOS prueba, descripcion=prueba descipcion]]','2019-11-08 17:47:28',1),(466,12,'EstadoFinanciero [id=1, clave=BAL_BAN, nombre=BALANCE GENERAL DE BAN, descripcion=prueba descipcion]','2019-11-08 17:47:59',1),(467,4,NULL,'2019-11-08 17:52:19',1),(468,4,NULL,'2019-11-08 18:55:46',1),(469,4,NULL,'2019-11-08 19:06:18',1),(470,13,'Cuenta [id=null, clave=pruea5 , nombre=dsadas, esFormula=true, formula=formula]','2019-11-08 19:07:08',1),(471,4,NULL,'2019-11-08 20:27:35',1),(472,4,NULL,'2019-11-08 20:42:00',1),(473,4,NULL,'2019-11-08 20:52:10',1),(474,4,NULL,'2019-11-08 20:54:00',1),(475,4,NULL,'2019-11-08 20:58:41',1),(476,4,NULL,'2019-11-08 21:05:48',1),(477,4,NULL,'2019-11-12 21:33:01',1),(478,4,NULL,'2019-11-12 21:35:20',1),(479,4,NULL,'2019-11-12 21:40:16',1),(480,17,'InformacionFinanciera [id=null, monto=1, cuenta=Cuenta [id=1, clave=cuenta1, nombre=prueba de cuenta 1222, esFormula=false, formula=null], fecha=Thu Jan 31 00:00:00 CST 2019]','2019-11-12 22:06:54',1),(481,17,'InformacionFinanciera [id=null, monto=33, cuenta=Cuenta [id=4, clave=prueba4, nombre=pdjkad, esFormula=false, formula=null], fecha=Thu Jan 31 00:00:00 CST 2019]','2019-11-12 22:06:54',1),(482,17,'InformacionFinanciera [id=null, monto=442, cuenta=Cuenta [id=5, clave=pruea5 , nombre=dsadas, esFormula=true, formula=formula], fecha=Thu Jan 31 00:00:00 CST 2019]','2019-11-12 22:06:54',1),(483,4,NULL,'2019-11-12 22:09:55',1),(484,4,NULL,'2019-11-13 20:24:04',1),(485,13,'Cuenta [id=null, clave=activo, nombre=acitvo totoal, esFormula=false, formula=null]','2019-11-13 20:25:25',1),(486,14,'Cuenta [id=6, clave=activo, nombre=acitvo totoal, esFormula=true, formula=cuenta1 + prueba4]','2019-11-13 20:26:13',1),(487,17,'InformacionFinanciera [id=null, monto=34, cuenta=Cuenta [id=1, clave=cuenta1, nombre=prueba de cuenta 1222, esFormula=false, formula=null], fecha=Sun Mar 31 00:00:00 CST 2019]','2019-11-13 20:29:36',1),(488,17,'InformacionFinanciera [id=null, monto=454, cuenta=Cuenta [id=4, clave=prueba4, nombre=pdjkad, esFormula=false, formula=null], fecha=Sun Mar 31 00:00:00 CST 2019]','2019-11-13 20:29:36',1),(489,17,'InformacionFinanciera [id=null, monto=null, cuenta=Cuenta [id=5, clave=pruea5 , nombre=dsadas, esFormula=true, formula=formula], fecha=Sun Mar 31 00:00:00 CST 2019]','2019-11-13 20:29:36',1),(490,17,'InformacionFinanciera [id=null, monto=null, cuenta=Cuenta [id=6, clave=activo, nombre=acitvo totoal, esFormula=true, formula=cuenta1 + prueba4], fecha=Sun Mar 31 00:00:00 CST 2019]','2019-11-13 20:29:36',1),(491,4,NULL,'2019-11-15 01:21:47',1),(492,4,NULL,'2019-11-15 14:41:56',1),(493,4,NULL,'2019-11-15 15:17:06',1),(494,4,NULL,'2019-11-15 15:37:03',1),(495,4,NULL,'2019-11-15 17:05:44',1),(496,19,'TipoEmpresa [id=null, clave=GAS, nombre=Gasolineras]','2019-11-15 17:08:21',1),(497,20,'TipoEmpresa [id=1, clave=GASW, nombre=Gasolineras]','2019-11-15 17:10:42',1);
/*!40000 ALTER TABLE `seg_bitacora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-04 20:37:59

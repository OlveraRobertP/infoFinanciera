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
-- Table structure for table `seg_funciones`
--

DROP TABLE IF EXISTS `seg_funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seg_funciones` (
  `CVE_MODULO` varchar(6) NOT NULL,
  `CVE_FUNCION` varchar(6) NOT NULL,
  `NOMBRE` varchar(45) NOT NULL,
  `F_ALTA` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `F_MODIF` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID_USUARIO_ALTA` int(11) NOT NULL,
  `ID_USUARIO_MODIF` int(11) NOT NULL,
  `ETIQUETA` varchar(45) DEFAULT NULL,
  `ICONO` varchar(15) DEFAULT NULL,
  `ORDEN` int(11) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CVE_FUNCION`),
  KEY `fk_table1_MODULOS1_idx` (`CVE_MODULO`),
  KEY `fk_funciones_usuarios_idx` (`ID_USUARIO_ALTA`),
  KEY `fk_func_usu_mod_idx` (`ID_USUARIO_MODIF`),
  CONSTRAINT `FK_FUN_USU_ADD` FOREIGN KEY (`ID_USUARIO_ALTA`) REFERENCES `seg_usuarios` (`ID_USUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_MODULOS1` FOREIGN KEY (`CVE_MODULO`) REFERENCES `seg_modulos` (`CVE_MODULO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seg_funciones`
--

LOCK TABLES `seg_funciones` WRITE;
/*!40000 ALTER TABLE `seg_funciones` DISABLE KEYS */;
INSERT INTO `seg_funciones` VALUES ('ADM','A_1','TIPOS DE EMPRESAS','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.A_1.name','func.A_1.icon',100,'/admon/tipoEmp'),('ADM','A_2','EMPRESAS','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.A_2.name','func.A_2.icon',110,'/admon/empresa'),('INF','I_1','ESTADOS FINANCIEROS','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.I_1.name','func.I_1.icon',100,'/info/edoFin'),('INF','I_2','CARGA INFO FINANCIERA','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.I_2.name','func.I_2.icon',110,'/info/cargaInfo'),('SEG','S_1','USUARIOS','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_1.name','func.S_1.icon',140,'/security/usuarios'),('SEG','S_2','ROLES','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_2.name','func.S_2.icon',150,'/security/roles'),('SEG','S_3','FUNCIONES','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_3.name','func.S_3.icon',160,'/security/funciones'),('SEG','S_4','MODULOS','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_4.name','func.S_4.icon',170,'/security/modulos'),('SEG','S_5','ASIGNA FUNCIONES A ROLES','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_5.name','func.S_5.icon',180,'/security/funcionRol'),('SEG','S_7','PARAMETROS DEL SISTEMA','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_6.name','func.S_6.icon',190,'/security/parametros'),('SEG','S_8','BITACORA','2019-05-23 20:04:07','2019-05-23 20:04:07',1,1,'func.S_8.name','func.S_8.icon',200,'/security/bitacora');
/*!40000 ALTER TABLE `seg_funciones` ENABLE KEYS */;
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

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para ejercicio1
CREATE DATABASE IF NOT EXISTS `ejercicio1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `ejercicio1`;

-- Volcando estructura para tabla ejercicio1.estación
CREATE TABLE IF NOT EXISTS `estación` (
  `Identificador` int(11) NOT NULL,
  `Latitud` float DEFAULT NULL,
  `Longitud` float DEFAULT NULL,
  `Altitud` float DEFAULT NULL,
  PRIMARY KEY (`Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla ejercicio1.muestra
CREATE TABLE IF NOT EXISTS `muestra` (
  `IdentificadorEstacion` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Temperatura_min` float DEFAULT NULL,
  `Temperatura_max` float DEFAULT NULL,
  `Precipitaciones` float DEFAULT NULL,
  `Humedad_min` float DEFAULT NULL,
  `Humedad_max` float DEFAULT NULL,
  `Velocidad_viento_min` float DEFAULT NULL,
  `Velocidad_viento_max` float DEFAULT NULL,
  KEY `IdentificadorEstacion` (`IdentificadorEstacion`),
  CONSTRAINT `muestra_ibfk_1` FOREIGN KEY (`IdentificadorEstacion`) REFERENCES `estación` (`Identificador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

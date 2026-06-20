-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2026 a las 09:12:56
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_cola`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cola_impresion`
--

CREATE TABLE `cola_impresion` (
  `id` bigint(20) NOT NULL,
  `estado_cola` varchar(255) DEFAULT NULL,
  `impresion_id` bigint(20) DEFAULT NULL,
  `prioridad` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cola_impresion`
--

INSERT INTO `cola_impresion` (`id`, `estado_cola`, `impresion_id`, `prioridad`) VALUES
(1, 'LISTA', 3, 'MEDIA'),
(2, 'EnCola', 4, 'Urgente'),
(3, 'LISTA', 3, 'urgente'),
(4, 'LISTA', 3, 'urgente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cola_impresion`
--
ALTER TABLE `cola_impresion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cola_impresion`
--
ALTER TABLE `cola_impresion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

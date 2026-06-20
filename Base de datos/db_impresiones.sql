-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2026 a las 09:13:03
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
-- Base de datos: `db_impresiones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impresion`
--

CREATE TABLE `impresion` (
  `id` bigint(20) NOT NULL,
  `asignatura_id` bigint(20) DEFAULT NULL,
  `cantidad_copias` int(11) DEFAULT NULL,
  `curso_id` bigint(20) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_solicitud` datetime(6) DEFAULT NULL,
  `notas_adicionales` varchar(255) DEFAULT NULL,
  `profesor_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `impresion`
--

INSERT INTO `impresion` (`id`, `asignatura_id`, `cantidad_copias`, `curso_id`, `estado`, `fecha_solicitud`, `notas_adicionales`, `profesor_id`) VALUES
(1, 1, 50, 1, 'LISTO', '2026-05-17 00:48:38.000000', 'Test numero 1', 1),
(2, 1, 50, 1, 'LISTO', '2026-05-17 00:48:53.000000', 'Test numero 2', 1),
(3, 1, 50, 1, 'LISTO', '2026-05-17 00:49:04.000000', 'Test numero 3', 1),
(4, 1, 50, 1, 'PENDIENTE', '2026-05-17 01:56:17.000000', 'Prueba de que funciona historial', 1),
(5, NULL, 50, 2, 'PENDIENTE', '2026-05-20 16:21:03.000000', 'Guias por inasistencia de profe', 4),
(6, NULL, 55, 2, 'LISTO', '2026-05-20 16:22:05.000000', 'Guias por inasistencia de profe', 3),
(7, NULL, 55, 2, 'PENDIENTE', '2026-05-20 16:22:20.000000', 'Guias por inasistencia de profe', 3),
(8, NULL, 55, 3, 'LISTO', '2026-05-20 16:22:26.000000', 'Guias por inasistencia de profe', 1),
(9, NULL, 55, 3, 'PENDIENTE', '2026-06-05 22:36:22.000000', 'Guias por inasistencia de profe', 1),
(10, NULL, 55, 3, 'LISTO', '2026-06-05 22:59:34.000000', 'Guias por inasistencia de profe', 1),
(11, 1, 55, 3, 'LISTO', '2026-06-05 23:04:52.000000', 'Guias por inasistencia de profe', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `impresion`
--
ALTER TABLE `impresion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `impresion`
--
ALTER TABLE `impresion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

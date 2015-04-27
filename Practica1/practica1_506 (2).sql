-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2015 a las 15:24:09
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `practica1_506`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crucigrama`
--

CREATE TABLE IF NOT EXISTS `crucigrama` (
  `Titulo` varchar(50) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `c_contiene_p`
--

CREATE TABLE IF NOT EXISTS `c_contiene_p` (
  `C_titulo` varchar(50) NOT NULL,
  `P_id` int(11) NOT NULL,
  `Fila` smallint(6) NOT NULL,
  `Columna` smallint(6) NOT NULL,
  `Orientacion` enum('Vertical','Horizontal') NOT NULL,
  `Puntuacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiqueta`
--

CREATE TABLE IF NOT EXISTS `etiqueta` (
  `id` int(11) NOT NULL,
  `Titulo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etique_contiene_pala`
--

CREATE TABLE IF NOT EXISTS `etique_contiene_pala` (
  `E_id` int(11) NOT NULL,
  `P_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE IF NOT EXISTS `historial` (
  `C_titulo` varchar(50) NOT NULL,
  `P_id` int(11) NOT NULL,
  `U_link` varchar(20) NOT NULL,
  `U_link_response` varchar(20) NOT NULL,
  `Respuesta` varchar(50) NOT NULL,
  `Fecha_R` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Correcta` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `palabra`
--

CREATE TABLE IF NOT EXISTS `palabra` (
  `id` int(11) NOT NULL,
  `Enunciado` varchar(50) NOT NULL,
  `Contenido` varchar(50) NOT NULL,
  `Pista` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `u1_amigo_u2`
--

CREATE TABLE IF NOT EXISTS `u1_amigo_u2` (
  `U1_nick` varchar(20) NOT NULL,
  `U2_nick` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `u1_c_pidayu_u2`
--

CREATE TABLE IF NOT EXISTS `u1_c_pidayu_u2` (
  `C1_titulo` varchar(50) NOT NULL,
  `U1_nick` varchar(20) NOT NULL,
  `U2_nick` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nick` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `Imagen` blob NOT NULL,
  `Fecha_naci` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `u_activo_c`
--

CREATE TABLE IF NOT EXISTS `u_activo_c` (
  `C_titulo` varchar(50) NOT NULL,
  `U_nick` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `crucigrama`
--
ALTER TABLE `crucigrama`
 ADD PRIMARY KEY (`Titulo`);

--
-- Indices de la tabla `c_contiene_p`
--
ALTER TABLE `c_contiene_p`
 ADD PRIMARY KEY (`C_titulo`,`P_id`), ADD KEY `C_titulo` (`C_titulo`), ADD KEY `P_id` (`P_id`);

--
-- Indices de la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `etique_contiene_pala`
--
ALTER TABLE `etique_contiene_pala`
 ADD PRIMARY KEY (`E_id`,`P_id`), ADD KEY `E_id` (`E_id`), ADD KEY `P_id` (`P_id`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
 ADD PRIMARY KEY (`C_titulo`,`P_id`,`U_link`,`Respuesta`,`Fecha_R`), ADD KEY `C_titulo` (`C_titulo`,`U_link`), ADD KEY `U_link` (`U_link`), ADD KEY `P_id` (`P_id`), ADD KEY `historial_ibfk_4` (`U_link`,`C_titulo`), ADD KEY `U_link_response` (`U_link_response`);

--
-- Indices de la tabla `palabra`
--
ALTER TABLE `palabra`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `u1_amigo_u2`
--
ALTER TABLE `u1_amigo_u2`
 ADD PRIMARY KEY (`U1_nick`,`U2_nick`), ADD KEY `U1_nick` (`U1_nick`,`U2_nick`), ADD KEY `U2_nick` (`U2_nick`);

--
-- Indices de la tabla `u1_c_pidayu_u2`
--
ALTER TABLE `u1_c_pidayu_u2`
 ADD PRIMARY KEY (`C1_titulo`,`U1_nick`,`U2_nick`), ADD KEY `C1_titulo` (`C1_titulo`,`U1_nick`,`U2_nick`), ADD KEY `U1_nick` (`U1_nick`), ADD KEY `U2_nick` (`U2_nick`), ADD KEY `U1_nick_2` (`U1_nick`,`U2_nick`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`nick`);

--
-- Indices de la tabla `u_activo_c`
--
ALTER TABLE `u_activo_c`
 ADD PRIMARY KEY (`C_titulo`,`U_nick`), ADD KEY `C_titulo` (`C_titulo`,`U_nick`), ADD KEY `U_nick` (`U_nick`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `c_contiene_p`
--
ALTER TABLE `c_contiene_p`
ADD CONSTRAINT `c_contiene_p_ibfk_1` FOREIGN KEY (`C_titulo`) REFERENCES `crucigrama` (`Titulo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `c_contiene_p_ibfk_2` FOREIGN KEY (`P_id`) REFERENCES `palabra` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `etique_contiene_pala`
--
ALTER TABLE `etique_contiene_pala`
ADD CONSTRAINT `etique_contiene_pala_ibfk_2` FOREIGN KEY (`P_id`) REFERENCES `palabra` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `etique_contiene_pala_ibfk_3` FOREIGN KEY (`E_id`) REFERENCES `etiqueta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
ADD CONSTRAINT `historial_ibfk_3` FOREIGN KEY (`P_id`) REFERENCES `c_contiene_p` (`P_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `historial_ibfk_4` FOREIGN KEY (`U_link`, `C_titulo`) REFERENCES `u_activo_c` (`C_titulo`, `U_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `historial_ibfk_5` FOREIGN KEY (`U_link_response`) REFERENCES `usuario` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `u1_amigo_u2`
--
ALTER TABLE `u1_amigo_u2`
ADD CONSTRAINT `u1_amigo_u2_ibfk_1` FOREIGN KEY (`U1_nick`) REFERENCES `usuario` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `u1_amigo_u2_ibfk_2` FOREIGN KEY (`U2_nick`) REFERENCES `usuario` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `u1_c_pidayu_u2`
--
ALTER TABLE `u1_c_pidayu_u2`
ADD CONSTRAINT `u1_c_pidayu_u2_ibfk_5` FOREIGN KEY (`U1_nick`, `U2_nick`) REFERENCES `u1_amigo_u2` (`U1_nick`, `U2_nick`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `u1_c_pidayu_u2_ibfk_6` FOREIGN KEY (`C1_titulo`) REFERENCES `u_activo_c` (`C_titulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `u_activo_c`
--
ALTER TABLE `u_activo_c`
ADD CONSTRAINT `u_activo_c_ibfk_1` FOREIGN KEY (`C_titulo`) REFERENCES `crucigrama` (`Titulo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `u_activo_c_ibfk_2` FOREIGN KEY (`U_nick`) REFERENCES `usuario` (`nick`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

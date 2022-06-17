-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2022 a las 22:09:55
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_polideportivo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID_EMPLEADO` int(11) NOT NULL,
  `NOMBRE1` varchar(45) DEFAULT NULL,
  `NOMBRE2` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `CORREO` varchar(60) DEFAULT NULL,
  `ID_TIPO_PUESTO` int(11) NOT NULL,
  `DIRECCION` varchar(100) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `NIT` varchar(30) DEFAULT NULL,
  `DPI` varchar(20) DEFAULT NULL,
  `ID_USUARIO_FK` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `ID_ENTRENADOR` int(11) NOT NULL,
  `NOMBRE1` varchar(45) DEFAULT NULL,
  `NOMBRE2` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `ID_USUARIO_FK` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `usuid` int(11) NOT NULL,
  `usunombre` varchar(45) NOT NULL,
  `usucontrasena` varchar(25) NOT NULL,
  `usuultimasesion` date DEFAULT NULL,
  `usuestatus` varchar(1) NOT NULL,
  `usunombrereal` varchar(60) DEFAULT NULL,
  `usucorreoe` varchar(60) DEFAULT NULL,
  `usutelefono` varchar(25) DEFAULT NULL,
  `usudireccion` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`usuid`, `usunombre`, `usucontrasena`, `usuultimasesion`, `usuestatus`, `usunombrereal`, `usucorreoe`, `usutelefono`, `usudireccion`) VALUES
(1, 'josue', '123456', '0003-04-22', 'T', 'josue', '07123nasdnsd', '55663322', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono`
--

CREATE TABLE `telefono` (
  `ID_TELEFONO` int(11) NOT NULL,
  `ID_EMPLEADO_FK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_puesto`
--

CREATE TABLE `tipo_puesto` (
  `ID_TIPO_PUESTO` int(11) NOT NULL,
  `NOMBRE_PUESTO` varchar(60) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`usuid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `usuid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

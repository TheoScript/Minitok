-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05-Dez-2025 às 02:08
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `minitok`
--
CREATE DATABASE IF NOT EXISTS `minitok` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `minitok`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curtidas`
--

DROP TABLE IF EXISTS `curtidas`;
CREATE TABLE IF NOT EXISTS `curtidas` (
  `id_cutida` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_postagem` int(11) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL,
  `data_curtida` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_cutida`),
  KEY `fk_id_postagem` (`fk_id_postagem`),
  KEY `fk_id_usuario` (`fk_id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `direct`
--

DROP TABLE IF EXISTS `direct`;
CREATE TABLE IF NOT EXISTS `direct` (
  `id_direct` int(11) NOT NULL AUTO_INCREMENT,
  `id_remetente` int(11) NOT NULL,
  `id_destinatario` int(11) NOT NULL,
  `mensagem` text NOT NULL,
  `data_envio` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_direct`),
  KEY `direct_ibfk_1` (`id_destinatario`),
  KEY `id_remetente` (`id_remetente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `postagem`
--

DROP TABLE IF EXISTS `postagem`;
CREATE TABLE IF NOT EXISTS `postagem` (
  `id_postagem` int(11) NOT NULL AUTO_INCREMENT,
  `fk_id_usuario` int(11) NOT NULL,
  `conteudo` text NOT NULL,
  `data_postagem` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_postagem`),
  KEY `fk_id_usuario` (`fk_id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `data_cadastro` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `curtidas`
--
ALTER TABLE `curtidas`
  ADD CONSTRAINT `curtidas_ibfk_1` FOREIGN KEY (`fk_id_postagem`) REFERENCES `postagem` (`id_postagem`),
  ADD CONSTRAINT `curtidas_ibfk_2` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `direct`
--
ALTER TABLE `direct`
  ADD CONSTRAINT `direct_ibfk_1` FOREIGN KEY (`id_destinatario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `direct_ibfk_2` FOREIGN KEY (`id_remetente`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `postagem`
--
ALTER TABLE `postagem`
  ADD CONSTRAINT `postagem_ibfk_1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

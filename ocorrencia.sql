-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Out-2016 às 21:08
-- Versão do servidor: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ocorrencia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_coordenacao`
--

CREATE TABLE IF NOT EXISTS `tbl_coordenacao` (
`id` int(10) NOT NULL,
  `nome` varchar(300) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_estudante`
--

CREATE TABLE IF NOT EXISTS `tbl_estudante` (
`id` int(10) NOT NULL,
  `nome` varchar(300) COLLATE utf8_bin NOT NULL,
  `anoCursoAtual` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_materia`
--

CREATE TABLE IF NOT EXISTS `tbl_materia` (
`id` int(10) NOT NULL,
  `serie` varchar(300) COLLATE utf8_bin NOT NULL,
  `nome` varchar(300) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_ocorrencia`
--

CREATE TABLE IF NOT EXISTS `tbl_ocorrencia` (
`id` int(10) NOT NULL,
  `data` varchar(300) COLLATE utf8_bin NOT NULL,
  `horario` varchar(300) COLLATE utf8_bin NOT NULL,
  `descricao` longtext COLLATE utf8_bin NOT NULL,
  `professor` int(10) NOT NULL,
  `estudante` int(10) NOT NULL,
  `materia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_professor`
--

CREATE TABLE IF NOT EXISTS `tbl_professor` (
`id` int(10) NOT NULL,
  `nome` varchar(300) COLLATE utf8_bin NOT NULL,
  `formacao` varchar(300) COLLATE utf8_bin NOT NULL,
  `siape` int(10) NOT NULL,
  `senha` varchar(300) COLLATE utf8_bin NOT NULL,
  `coordenacao` varchar(300) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id` int(10) NOT NULL,
  `nome` varchar(300) COLLATE utf8_bin NOT NULL,
  `email` varchar(300) COLLATE utf8_bin NOT NULL,
  `senha` varchar(300) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`) VALUES
(1, 'Diego Cavalcanti', 'diego@agenciamoob.com.br', '1234'),
(2, 'Anderson Pinheiro', 'anderson@agenciamoob.com.br', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_coordenacao`
--
ALTER TABLE `tbl_coordenacao`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_estudante`
--
ALTER TABLE `tbl_estudante`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_materia`
--
ALTER TABLE `tbl_materia`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_ocorrencia`
--
ALTER TABLE `tbl_ocorrencia`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_professor`
--
ALTER TABLE `tbl_professor`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_coordenacao`
--
ALTER TABLE `tbl_coordenacao`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_estudante`
--
ALTER TABLE `tbl_estudante`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_materia`
--
ALTER TABLE `tbl_materia`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_ocorrencia`
--
ALTER TABLE `tbl_ocorrencia`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_professor`
--
ALTER TABLE `tbl_professor`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

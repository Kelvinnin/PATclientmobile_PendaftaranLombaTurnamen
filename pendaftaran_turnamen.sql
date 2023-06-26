-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2023 at 05:48 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pendaftaran_turnamen`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('kelvin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `bracket_individu`
--

CREATE TABLE `bracket_individu` (
  `idpeserta` int(11) DEFAULT NULL,
  `idpeserta1` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `komentar` varchar(45) DEFAULT NULL,
  `idbracketIndiv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `bracket_individu`
--

INSERT INTO `bracket_individu` (`idpeserta`, `idpeserta1`, `date`, `komentar`, `idbracketIndiv`) VALUES
(6, 7, '2023-06-08', 'keren', 1);

-- --------------------------------------------------------

--
-- Table structure for table `bracket_team`
--

CREATE TABLE `bracket_team` (
  `team_idteam` int(11) DEFAULT NULL,
  `team_idteam1` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `komentar` varchar(45) DEFAULT NULL,
  `idBracketTeam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `bracket_team`
--

INSERT INTO `bracket_team` (`team_idteam`, `team_idteam1`, `date`, `komentar`, `idBracketTeam`) VALUES
(6, 5, '2023-06-14', 'team komen', 1);

-- --------------------------------------------------------

--
-- Table structure for table `game_individu`
--

CREATE TABLE `game_individu` (
  `idgame` int(11) NOT NULL,
  `nama_game` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `game_individu`
--

INSERT INTO `game_individu` (`idgame`, `nama_game`) VALUES
(18, 'pubg'),
(19, 'mobile legends');

-- --------------------------------------------------------

--
-- Table structure for table `game_kelompok`
--

CREATE TABLE `game_kelompok` (
  `idgame` int(11) NOT NULL,
  `nama_game` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `game_kelompok`
--

INSERT INTO `game_kelompok` (`idgame`, `nama_game`) VALUES
(8, 'tekken'),
(9, 'dota');

-- --------------------------------------------------------

--
-- Table structure for table `peserta_individu`
--

CREATE TABLE `peserta_individu` (
  `idpeserta` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `alamat` varchar(45) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `no_handphone` varchar(45) DEFAULT NULL,
  `nrp` varchar(45) DEFAULT NULL,
  `program_studi` varchar(45) DEFAULT NULL,
  `angkatan` varchar(45) DEFAULT NULL,
  `foto_formal` varchar(45) DEFAULT NULL,
  `win` int(11) DEFAULT NULL,
  `lose` int(11) DEFAULT NULL,
  `game_individu_idgame` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `peserta_individu`
--

INSERT INTO `peserta_individu` (`idpeserta`, `nama`, `alamat`, `tanggal_lahir`, `no_handphone`, `nrp`, `program_studi`, `angkatan`, `foto_formal`, `win`, `lose`, `game_individu_idgame`, `status`) VALUES
(6, 'kelvin', 'kelvinalamat', '2023-06-08', '123', '123', 'elektro', '2020', NULL, 0, 0, 19, 0),
(7, 'justin', 'alamat justin', '2023-06-14', '123', '123', 'sib', '2020', '12', 0, 0, 18, 0);

-- --------------------------------------------------------

--
-- Table structure for table `peserta_kelompok`
--

CREATE TABLE `peserta_kelompok` (
  `idpeserta` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `alamat` varchar(45) DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `no_handphone` varchar(45) DEFAULT NULL,
  `nrp` varchar(45) DEFAULT NULL,
  `program_studi` varchar(45) DEFAULT NULL,
  `angkatan` varchar(45) DEFAULT NULL,
  `foto_formal` varchar(45) DEFAULT NULL,
  `team_idteam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `peserta_kelompok`
--

INSERT INTO `peserta_kelompok` (`idpeserta`, `nama`, `alamat`, `tanggal_lahir`, `no_handphone`, `nrp`, `program_studi`, `angkatan`, `foto_formal`, `team_idteam`) VALUES
(7, 'peserta 1', '123', '2023-06-14', '123', '123', '123', '123', '132', 5),
(8, 'peserta 2', '213', '2023-06-09', '123', '123', '132', '123', '123', 6);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `idteam` int(11) NOT NULL,
  `nama_team` varchar(45) DEFAULT NULL,
  `win` int(11) DEFAULT NULL,
  `lose` int(11) DEFAULT NULL,
  `game_kelompok_idgame` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`idteam`, `nama_team`, `win`, `lose`, `game_kelompok_idgame`, `status`) VALUES
(5, 'team1', 0, 0, 9, 1),
(6, 'team2', 0, 0, 8, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `bracket_individu`
--
ALTER TABLE `bracket_individu`
  ADD PRIMARY KEY (`idbracketIndiv`),
  ADD KEY `fk_peserta_individu_has_peserta_individu_peserta_individu2_idx` (`idpeserta1`),
  ADD KEY `fk_peserta_individu_has_peserta_individu_peserta_individu1_idx` (`idpeserta`);

--
-- Indexes for table `bracket_team`
--
ALTER TABLE `bracket_team`
  ADD PRIMARY KEY (`idBracketTeam`),
  ADD KEY `fk_team_has_team_team2_idx` (`team_idteam1`),
  ADD KEY `fk_team_has_team_team1_idx` (`team_idteam`);

--
-- Indexes for table `game_individu`
--
ALTER TABLE `game_individu`
  ADD PRIMARY KEY (`idgame`);

--
-- Indexes for table `game_kelompok`
--
ALTER TABLE `game_kelompok`
  ADD PRIMARY KEY (`idgame`);

--
-- Indexes for table `peserta_individu`
--
ALTER TABLE `peserta_individu`
  ADD PRIMARY KEY (`idpeserta`),
  ADD KEY `fk_peserta_individu_game_individu1_idx` (`game_individu_idgame`);

--
-- Indexes for table `peserta_kelompok`
--
ALTER TABLE `peserta_kelompok`
  ADD PRIMARY KEY (`idpeserta`),
  ADD KEY `fk_peserta_kelompok_team_idx` (`team_idteam`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`idteam`),
  ADD KEY `fk_team_game_kelompok1_idx` (`game_kelompok_idgame`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bracket_individu`
--
ALTER TABLE `bracket_individu`
  MODIFY `idbracketIndiv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `bracket_team`
--
ALTER TABLE `bracket_team`
  MODIFY `idBracketTeam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `game_individu`
--
ALTER TABLE `game_individu`
  MODIFY `idgame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `game_kelompok`
--
ALTER TABLE `game_kelompok`
  MODIFY `idgame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `peserta_individu`
--
ALTER TABLE `peserta_individu`
  MODIFY `idpeserta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `peserta_kelompok`
--
ALTER TABLE `peserta_kelompok`
  MODIFY `idpeserta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `idteam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bracket_individu`
--
ALTER TABLE `bracket_individu`
  ADD CONSTRAINT `fk_peserta_individu_has_peserta_individu_peserta_individu1` FOREIGN KEY (`idpeserta`) REFERENCES `peserta_individu` (`idpeserta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_peserta_individu_has_peserta_individu_peserta_individu2` FOREIGN KEY (`idpeserta1`) REFERENCES `peserta_individu` (`idpeserta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `bracket_team`
--
ALTER TABLE `bracket_team`
  ADD CONSTRAINT `fk_team_has_team_team1` FOREIGN KEY (`team_idteam`) REFERENCES `team` (`idteam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_team_has_team_team2` FOREIGN KEY (`team_idteam1`) REFERENCES `team` (`idteam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `peserta_individu`
--
ALTER TABLE `peserta_individu`
  ADD CONSTRAINT `fk_peserta_individu_game_individu1` FOREIGN KEY (`game_individu_idgame`) REFERENCES `game_individu` (`idgame`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `peserta_kelompok`
--
ALTER TABLE `peserta_kelompok`
  ADD CONSTRAINT `fk_peserta_kelompok_team` FOREIGN KEY (`team_idteam`) REFERENCES `team` (`idteam`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `fk_team_game_kelompok1` FOREIGN KEY (`game_kelompok_idgame`) REFERENCES `game_kelompok` (`idgame`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

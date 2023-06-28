-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2023 at 10:01 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

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
('Albert', '412'),
('Bobby', 'Bola'),
('Derick', '456'),
('Kelvin', '123');

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
(1, 2, '2022-06-28', NULL, 2),
(2, 1, '2023-06-28', NULL, 3),
(2, 1, '2023-06-28', NULL, 4);

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
(1, 2, '2022-01-11', NULL, 4),
(1, 2, '2023-06-27', NULL, 5),
(1, 2, '2023-06-27', NULL, 6),
(1, 2, '2022-06-28', NULL, 8);

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
(1, 'Clash Royale'),
(2, 'Tekken'),
(3, 'Survival.io'),
(4, 'Genshin Impact'),
(5, 'NBA 2k20'),
(6, 'God Of War'),
(7, 'DOTA'),
(29, 'Qubika');

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
(1, 'PUBG'),
(2, 'Valorant'),
(3, 'Mobile Legends'),
(4, 'Overwatch'),
(5, 'Fifa'),
(6, 'Homura');

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
(1, 'Justin', 'Gianyar V C6/27', '2002-04-28', '08101010101', 'c11200012', 'Teknik Elektro', '2020', NULL, 7, 1, 1, 1),
(2, 'Juan F', 'Sidoarjo 01', '2002-05-15', '0820202202', 'c11200013', 'Teknik Elektro', '2020', NULL, 3, 0, 1, 1),
(3, 'Jeremy', 'Tanjung Priok 02', '2001-09-09', '08103030303', 'c11200001', 'Teknik Elektro', '2021', NULL, 0, 0, 1, 2),
(4, 'Anthony', 'Tanjung  03', '2001-09-10', '08040404040', 'c11200025', 'Teknik Elektro', '2022', NULL, 0, 0, 1, 0),
(5, 'Gorila', 'Gianyar C6/27', '2002-04-26', '081929292', 'c11200050', 'Teknik Elektro', '2020', NULL, 0, 0, 1, 0);

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
(1, 'Jacquelyn', 'Juresh 01', '2003-06-26', '087802301929', 'c11200001', 'Teknik Elektro', '2020', NULL, 1),
(2, 'Jeremy', 'Dukuh 02', '2002-06-12', '087802301929', 'c11200006', 'Teknik Informatika', '2020', NULL, 1),
(3, 'Christian', 'Citraland 05', '2001-06-22', '087802301929', 'c11200007', 'Industri', '2020', NULL, 1),
(4, 'Kelvin SH', 'Siwalan 03', '2002-05-14', '087802301929', 'c11200018', 'DKV', '2020', NULL, 2),
(5, 'Glenn', 'Siwalan 80', '2002-03-13', '087802301929', 'c11200019', 'Teknik Informatika', '2020', NULL, 2),
(6, 'Julius', 'Dangsir 26', '2002-07-19', '087802301929', 'c11200020', 'DKV', '2020', NULL, 3),
(7, 'Albert', 'Kencana 27', '2002-09-13', '087802301929', 'c11200035', 'DFT', '2020', NULL, 3),
(8, 'Derick', 'Dangsir 55', '2002-11-01', '087802301929', 'c11200036', 'Teknik Informatika', '2020', NULL, 4),
(9, 'Yegia', 'Kutisari 08', '2002-03-06', '087802301929', 'c11200037', 'Mesin', '2020', NULL, 4),
(10, 'Sakura', 'Jepang 27', '2004-05-26', '081929292', 'c11200057', 'DSA', '2021', NULL, 2);

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
  `status` int(11) DEFAULT NULL,
  `password` varchar(455) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`idteam`, `nama_team`, `win`, `lose`, `game_kelompok_idgame`, `status`, `password`) VALUES
(1, 'GABIMARU', 3, 0, 1, 1, '123'),
(2, 'KECAMBAH', 0, 0, 1, 1, '123'),
(3, 'ULET', 0, 0, 1, 2, '123'),
(4, 'SEMANGAT', 0, 0, 1, 0, '123'),
(5, 'Nihonjin', 0, 0, 2, 0, 'Nippon11');

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
  MODIFY `idbracketIndiv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bracket_team`
--
ALTER TABLE `bracket_team`
  MODIFY `idBracketTeam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `game_individu`
--
ALTER TABLE `game_individu`
  MODIFY `idgame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `game_kelompok`
--
ALTER TABLE `game_kelompok`
  MODIFY `idgame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `peserta_individu`
--
ALTER TABLE `peserta_individu`
  MODIFY `idpeserta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `peserta_kelompok`
--
ALTER TABLE `peserta_kelompok`
  MODIFY `idpeserta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `idteam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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

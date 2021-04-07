-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2021 at 04:27 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grade_csit`
--

-- --------------------------------------------------------

--
-- Table structure for table `table_grade`
--

CREATE TABLE `table_grade` (
  `id_sub` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `id_student` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `year` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `term` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `grade` varchar(2) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `table_student`
--

CREATE TABLE `table_student` (
  `id_student` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `fname_student` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `lname_student` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `id_teacher` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_student`
--

INSERT INTO `table_student` (`id_student`, `fname_student`, `lname_student`, `id_teacher`) VALUES
('59000000000-0', 'AAA', 'BBB', NULL),
('60502100067-0', 'Witthawin', 'Takona', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `table_sub`
--

CREATE TABLE `table_sub` (
  `id_sub` varchar(7) COLLATE utf8_unicode_ci NOT NULL,
  `sname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `credit` int(1) NOT NULL,
  `category` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='ตารางวิชา';

--
-- Dumping data for table `table_sub`
--

INSERT INTO `table_sub` (`id_sub`, `sname`, `credit`, `category`) VALUES
('1110101', 'Thai Usage', 3, 'Thai Language'),
('1130001', 'Library and Information for Education', 3, 'social science or humanities'),
('1211001', 'General English', 3, 'International language'),
('1211002', 'English for Work', 3, 'International language'),
('1211011', 'English for Public Speaking', 3, 'International language'),
('1211013', 'English for Edutainment', 3, 'International language');

-- --------------------------------------------------------

--
-- Table structure for table `table_teacher`
--

CREATE TABLE `table_teacher` (
  `id_teacher` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `fname_teacher` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `lname_teacher` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `table_teacher`
--

INSERT INTO `table_teacher` (`id_teacher`, `fname_teacher`, `lname_teacher`) VALUES
('11111', '๋๊๋่Jum', 'Jim'),
('22222', 'Moo', 'Mun');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_grade`
--
ALTER TABLE `table_grade`
  ADD PRIMARY KEY (`id_sub`,`id_student`,`year`,`term`),
  ADD KEY `id_student` (`id_student`);

--
-- Indexes for table `table_student`
--
ALTER TABLE `table_student`
  ADD PRIMARY KEY (`id_student`),
  ADD KEY `table_student_ibfk_1` (`id_teacher`);

--
-- Indexes for table `table_sub`
--
ALTER TABLE `table_sub`
  ADD PRIMARY KEY (`id_sub`);

--
-- Indexes for table `table_teacher`
--
ALTER TABLE `table_teacher`
  ADD PRIMARY KEY (`id_teacher`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `table_grade`
--
ALTER TABLE `table_grade`
  ADD CONSTRAINT `table_grade_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `table_student` (`id_student`),
  ADD CONSTRAINT `table_grade_ibfk_2` FOREIGN KEY (`id_sub`) REFERENCES `table_sub` (`id_sub`);

--
-- Constraints for table `table_student`
--
ALTER TABLE `table_student`
  ADD CONSTRAINT `table_student_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `table_teacher` (`id_teacher`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

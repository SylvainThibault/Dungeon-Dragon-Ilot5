-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 12 avr. 2018 à 15:16
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `donjon-ilot5`
--

-- --------------------------------------------------------

--
-- Structure de la table `bonusitems`
--

DROP TABLE IF EXISTS `bonusitems`;
CREATE TABLE IF NOT EXISTS `bonusitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bonusitems`
--

INSERT INTO `bonusitems` (`id`, `name`, `type`, `level`) VALUES
(1, 'FrostMourne', 'Weapon', 50),
(2, 'Soul Edge', 'Weapon', 60),
(3, 'Indignation!', 'Spell', 50),
(4, 'Team Eric', 'Spell', 100),
(5, 'AraShield', 'Shield', 2),
(6, 'insectiShield', 'Shield', 3),
(7, 'Shield Abuse', 'Shield', 5),
(8, 'Philtre à air', 'Philter', 2),
(9, 'Philtre à café', 'Philter', 3),
(10, 'Philtre à huile', 'Philter', 3);

-- --------------------------------------------------------

--
-- Structure de la table `enemies`
--

DROP TABLE IF EXISTS `enemies`;
CREATE TABLE IF NOT EXISTS `enemies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `power` int(11) NOT NULL,
  `life` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `enemies`
--

INSERT INTO `enemies` (`id`, `name`, `type`, `power`, `life`, `age`) VALUES
(1, 'Incubus', 'Succubus', 40, 90, NULL),
(2, 'SuperBus', 'Succubus', 50, 80, NULL),
(3, 'GrozoBus', 'Succubus', 60, 95, NULL),
(4, 'DragiBus', 'Succubus', 50, 100, NULL),
(5, 'DragQueen', 'Dragon', 25, 100, 3),
(6, 'DragAndDrop', 'Dragon', 50, 75, 2),
(7, 'Dragonasse', 'Dragon', 75, 50, 5),
(8, 'Dragueuse de Fondpagnier', 'Dragon', 40, 80, 1),
(9, 'Lezard', 'Dragon', 20, 40, 1),
(10, 'Sorce Rouge', 'Sorcerer', 80, 60, NULL),
(11, 'Sorce Bleu', 'Sorcerer', 70, 50, NULL),
(12, 'May the Sorce be with you', 'Sorcerer', 32, 80, NULL),
(13, 'David VaginaFill', 'Sorcerer', 12, 100, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `attack-suc` int(11) DEFAULT NULL,
  `attack-dra` int(11) DEFAULT NULL,
  `attack-sor` int(11) DEFAULT NULL,
  `defense-suc` int(11) DEFAULT NULL,
  `defense-dra` int(11) DEFAULT NULL,
  `defense-sor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `items`
--

INSERT INTO `items` (`id`, `name`, `type`, `attack-suc`, `attack-dra`, `attack-sor`, `defense-suc`, `defense-dra`, `defense-sor`) VALUES
(1, 'Crozemarie rend l\'argent (arc)', 'Weapon', 25, 50, 0, 0, 0, 0),
(2, 'Un orteil de Maïté (massue)', 'Weapon', 30, 30, 30, 0, 0, 0),
(3, 'L\'épée Nickelée (épée) ', 'Weapon', 25, 25, 25, 2, 2, 2),
(4, 'Flatul-Foudre (Eclair)', 'Spell', 0, 25, 50, 0, 0, 0),
(5, 'La cave d\'Oussama (invisibilité)', 'Spell', 30, 30, 30, 0, 0, 0),
(6, 'le WTC le 11/09/2001 (mur de feu)', 'Spell', 25, 25, 25, 0, 0, 3);

-- --------------------------------------------------------

--
-- Structure de la table `item_perso`
--

DROP TABLE IF EXISTS `item_perso`;
CREATE TABLE IF NOT EXISTS `item_perso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `perso_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `perso_id` (`perso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Structure de la table `persos`
--

DROP TABLE IF EXISTS `persos`;
CREATE TABLE IF NOT EXISTS `persos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `life` int(11) NOT NULL,
  `power` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `persos`
--

INSERT INTO `persos` (`id`, `name`, `type`, `life`, `power`) VALUES
(1, 'Eric les doigts de fée', 'Wizard', 100, 15),
(51, 'Papa', 'Warrior', 100, 15),
(52, 'Fokoff', 'Wizard', 100, 15),
(53, 'bop', 'Warrior', 100, 15),
(54, 'Linguini', 'Warrior', 100, 15),
(55, 'Lizzie', 'Wizard', 100, 15),
(56, 'wiz', 'Warrior', 100, 15),
(57, 'wiz', 'Wizard', 100, 15),
(58, 'pi', 'Wizard', 100, 15),
(59, 'prtrtrr', 'Warrior', 100, 15),
(60, '2', 'Wizard', 100, 15),
(61, 'gdoutre', 'Warrior', 100, 15),
(62, 'jjj', 'Warrior', 100, 15),
(63, '', 'Warrior', 100, 15),
(64, 'jn', 'Warrior', 100, 15),
(65, '1', 'Warrior', 100, 15),
(66, '2', 'Warrior', 100, 15),
(67, 'ytd', 'Wizard', 100, 15),
(68, 'pepe', 'Warrior', 100, 15),
(69, 'preepep', 'Warrior', 100, 15);

-- --------------------------------------------------------

--
-- Structure de la table `powerups`
--

DROP TABLE IF EXISTS `powerups`;
CREATE TABLE IF NOT EXISTS `powerups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `powerups`
--

INSERT INTO `powerups` (`id`, `name`, `type`, `value`) VALUES
(3, 'Drop The Mic', 'Bonus', 5),
(4, 'C\'est un zoophile, il prend son élan', 'Malus', 5),
(5, 'Blague d\'Olivier sur nos amis Portugais', 'Malus', 5),
(6, 'Vodka-Mescalito', 'Joker', 25),
(7, 'Un weekend à Amsterdam', 'Joker', 50);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `item_perso`
--
ALTER TABLE `item_perso`
  ADD CONSTRAINT `item_perso_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_perso_ibfk_2` FOREIGN KEY (`perso_id`) REFERENCES `persos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema spring
--

CREATE DATABASE IF NOT EXISTS spring;
USE spring;

--
-- Definition of table `actor`
--

DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `birth_date` varchar(255) default NULL,
  `birth_name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `image` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `actor`
--

/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` (`id`,`active`,`birth_date`,`birth_name`,`email`,`image`,`name`) VALUES 
 (3,0x01,'24-08-18','Kamal','kamalparvez71@gmail.com','https://stocklandmartelblog.files.wordpress.com/2013/07/nino-muncc83oz_hugh-jackman_page_3.jpg','Kamal Parvez'),
 (2,0x01,'24-08-90','Kamal','kamalparvez71@gmail.com','jkgkjfdkgnkdfng','Kamal Parvez'),
 (5,0x01,'18-08-1992','Hasib','alhasib71@gmail.com','image of hasib','Al-Hasib');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;


--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `COURSE_ID` int(10) unsigned NOT NULL auto_increment,
  `COURSE_NAME` varchar(45) NOT NULL,
  PRIMARY KEY  (`COURSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`COURSE_ID`,`COURSE_NAME`) VALUES 
 (1,'JAVA'),
 (2,'Oracle');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `customer_table`
--

DROP TABLE IF EXISTS `customer_table`;
CREATE TABLE `customer_table` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) default NULL,
  `cphone` varchar(255) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_table`
--

/*!40000 ALTER TABLE `customer_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_table` ENABLE KEYS */;


--
-- Definition of table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES 
 (7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;


--
-- Definition of table `order_detail_table`
--

DROP TABLE IF EXISTS `order_detail_table`;
CREATE TABLE `order_detail_table` (
  `odid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `price` double NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY  (`odid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_detail_table`
--

/*!40000 ALTER TABLE `order_detail_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail_table` ENABLE KEYS */;


--
-- Definition of table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `oid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `order_date` datetime default NULL,
  `order_type` varchar(255) default NULL,
  `total` double NOT NULL,
  PRIMARY KEY  (`oid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_table`
--

/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;


--
-- Definition of table `person_info`
--

DROP TABLE IF EXISTS `person_info`;
CREATE TABLE `person_info` (
  `id` bigint(20) NOT NULL,
  `dob` datetime default NULL,
  `address` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `profession` varchar(255) default NULL,
  `serial_versionuid` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person_info`
--

/*!40000 ALTER TABLE `person_info` DISABLE KEYS */;
INSERT INTO `person_info` (`id`,`dob`,`address`,`email`,`name`,`profession`,`serial_versionuid`) VALUES 
 (6,'2018-09-16 01:13:03','string','string','string','string',-3009157732242241606);
/*!40000 ALTER TABLE `person_info` ENABLE KEYS */;


--
-- Definition of table `product_table`
--

DROP TABLE IF EXISTS `product_table`;
CREATE TABLE `product_table` (
  `pid` int(11) NOT NULL,
  `pcreate_date` date default '0000-00-00',
  `pimage` varchar(255) default NULL,
  `pname` varchar(255) default NULL,
  `pprice` double NOT NULL,
  `pquantity` double NOT NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_table`
--

/*!40000 ALTER TABLE `product_table` DISABLE KEYS */;
INSERT INTO `product_table` (`pid`,`pcreate_date`,`pimage`,`pname`,`pprice`,`pquantity`) VALUES 
 (208,'2018-06-30','image/Tune Box (Metal).jpg','Tune Box (Metal)',25,25),
 (210,'2018-07-27','image/photo_frame.jpg','Photo Frame',13,23),
 (212,'2018-07-27','image/aarong_belt_01 Aaromg.jpg','Aarong Belt (Black)',11,78),
 (213,'2018-07-27','image/aarong_belt_02 Aarong.jpg','Aarong Belt (Brown)',11,12),
 (214,'2018-07-27','image/aarong_black_wallet black.jpg','Aarong Walet (Black)',10,45),
 (229,'2018-07-27','image/DunHill Perfume (Men).jpg','DunHill Perfume (Men)',45,45),
 (230,'2018-07-27','image/Hugo boss 125ml (Men).jpg','Hugo boss 125ml (Men)',45,75),
 (233,'2018-07-27','image/Eternity CK_Men 100ml.jpg','Eternity CK_Men 100ml',50,35),
 (234,'2018-07-27','image/Seikko Watch Rounded.jpg','Seikko Watch Rounded',65,75),
 (235,'2018-07-27','image/Seikko Watch Rounded(gold).jpg','Seikko Watch Rounded(gold)',55,13),
 (236,'2018-07-27','image/Seikko Watch Rounded(Silver).jpg','Seikko Watch Rounded(Silver)',45,75),
 (237,'2018-07-27','image/Seikko Watch squre.jpg','Seikko Watch Square',50,38),
 (239,'2018-07-27','image/Love_Bird.jpg','Love Bird Show Piece (Antique)',15,15),
 (240,'2018-07-27','image/DoubleDoveandHeart.jpg','Double Doveand Heart',30,42),
 (252,'2018-07-27','image/desktop organizer.jpg','Desktop Organizer',20,25),
 (253,'2018-07-27','image/Swing Machine(Showpieces).jpg','Swing Machine(Showpieces)',40,45),
 (254,'2018-07-09',' image/Ladies_Vanity_Bag_Black.jpg','Ladies Vanity Bag (Black)',10,15),
 (256,'2018-09-08','image/money_walet_leather.jpg','Money Bag',15,22),
 (261,'2018-10-18','image/dunhill_custom.jpg','Dunhill Perfume',15,35),
 (263,'2018-10-27','image/blv-pour-home.jpg','BLV Perfume',25,20);
/*!40000 ALTER TABLE `product_table` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `rollno` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY  (`rollno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`rollno`,`name`,`course`,`age`,`address`) VALUES 
 (1,'Test','1',22,'dhaka'),
 (2,'abc','1',34,'sss');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`username`,`password`) VALUES 
 ('a','a');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `user_id` int(11) NOT NULL,
  `password` varchar(255) default NULL,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

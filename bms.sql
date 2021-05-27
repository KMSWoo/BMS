/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.11 : Database - bms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bms`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) NOT NULL,
  `state` varchar(1) NOT NULL DEFAULT '0' COMMENT '0 fot available,1 for be reserved,2 for be borrowed',
  `name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `publisher` varchar(20) NOT NULL,
  `is_delete` varchar(1) NOT NULL DEFAULT '0' COMMENT '0 for no,1 for yes',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`isbn`,`state`,`name`,`author`,`publisher`,`is_delete`) values 
(1,'9787536692930','0','三体','刘慈欣','重庆出版社','0'),
(2,'9787536693968','0','三体Ⅱ','刘慈欣','重庆出版社','0'),
(3,'9787229030933','0','三体Ⅲ','刘慈欣','重庆出版社','0'),
(5,'9787536455382','0','球状闪电','刘慈欣','四川科学技术出版社','0'),
(6,'9787536455382','0','球状闪电','刘慈欣','四川科学技术出版社','0'),
(7,'9787536455382','0','球状闪电','刘慈欣','四川科学技术出版社','1'),
(8,'9787536455382','0','球状闪电','刘慈欣','四川科学技术出版社','1'),
(9,'9787536455382','0','球状闪电','刘慈欣','四川科学技术出版社','1');

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(10) unsigned NOT NULL,
  `bid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `b_bid` (`bid`),
  KEY `b_uid` (`uid`),
  CONSTRAINT `b_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`id`),
  CONSTRAINT `b_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

/*Table structure for table `reserve` */

DROP TABLE IF EXISTS `reserve`;

CREATE TABLE `reserve` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `bid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `r_bid` (`bid`),
  KEY `r_uid` (`uid`),
  CONSTRAINT `r_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`id`),
  CONSTRAINT `r_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `reserve` */

insert  into `reserve`(`id`,`bid`,`uid`) values 
(1,2,1),
(2,3,1),
(3,5,1),
(4,5,1),
(5,1,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'user',
  `email` varchar(50) NOT NULL,
  `state` varchar(1) NOT NULL DEFAULT '0' COMMENT '0 for ok,1 for deleted,2 for locked',
  `salt` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`role`,`email`,`state`,`salt`) values 
(1,'www','bbdbb3be3d2b4352660d13a5e87e67ad','admin','www@www.com','0','5PjWpr1KdD5lfaEE5v1BNQ=='),
(2,'kms','a1c813fbcdf1246495b9bd9d5c7941e1','user','kms@kms.com','0','rd+10tXH6khW/lyXw+/lMw=='),
(5,'qwe','70342171b02b091b4fbf494a3d8f8898','guest','12@1212','1','kV1Wn6gzbpuCcEUzZJz3rA==');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.13-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
/*
 
create table `user` (
	`UserId` blob ,
	`UserType` varchar (192),
	`Username` varchar (192),
	`Password` varchar (192),
	`Email` varchar (192),
	`Phone` varchar (192),
	`IdType` varchar (192),
	`IdNo` varchar (192),
	`CreateDate` date 
); 
*/
insert into `user` (`UserId`, `UserType`, `Username`, `Password`, `Email`, `Phone`, `IdType`, `IdNo`, `CreateDate`) values('1000','1','admin','123456','10@qq.com','12345678901','11','340828198812025689','2017-05-15');
insert into `user` (`UserId`, `UserType`, `Username`, `Password`, `Email`, `Phone`, `IdType`, `IdNo`, `CreateDate`) values('1001','1','admin1','admin1','10@qq.com','12345678901','11','340828198812025689','2017-05-15');

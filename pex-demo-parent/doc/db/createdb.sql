
DROP TABLE IF EXISTS `FLOWCTRL`;
CREATE TABLE FLOWCTRL(
	FC_ID  VARCHAR(128) PRIMARY KEY NOT NULL,
	FC_INSTANCEID VARCHAR(64),
	FC_DOMAIN VARCHAR(64),
	FC_FCTYPE VARCHAR(64), 
	FC_TYPE VARCHAR(64),
	FC_CONDITION VARCHAR(128),
    FC_VALUE BLOB,	
	FC_UPDATETIME INT,
	FC_STATE INT(1));
	
DROP TABLE IF EXISTS `JTFBankinner`;
CREATE TABLE JTFBankinner(
	JnlNo     VARCHAR(128) PRIMARY KEY NOT NULL,
	PayerAcNo VARCHAR(64),
	PayeeAcNo VARCHAR(64),
	Amount    VARCHAR(64), 
	fundUsage     VARCHAR(64),
	UserId    bigint(18)
	);

DROP TABLE IF EXISTS `User`;
create table `User`( 
   `UserId` longtext , 
   `UserType` varchar(64) , 
   `Username` varchar(64) , 
   `Password` varchar(64) , 
   `Email` varchar(64) , 
   `Phone` varchar(64) , 
   `IdType` varchar(64) , 
   `IdNo` varchar(64) , 
   `CreateDate` date 
 )
	
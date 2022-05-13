ALTER USER `admin` IDENTIFIED WITH mysql_native_password BY 'admin';

CREATE TABLE `request` (
    `id` bigint unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `featureid` varchar(100) NOT NULL,
    `coordinate` varchar(23),
    `requesttime` timestamp 
);

CREATE TABLE `response` (
    `responseid` bigint unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `requestid` bigint unsigned NOT NULL,
    `timestamp` datetime,
    `chsaid` int,
    `crs` varchar(100) 
);

CREATE TABLE `chsa` (
    `sysid` int PRIMARY KEY NOT NULL,
    `areacode` varchar(4) NOT NULL,
    `areaname` varchar(100) NOT NULL,
    `ojectid` int 
);
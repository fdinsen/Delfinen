-- Members

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
	`member_id` int(11) NOT null auto_increment,
    `member_name` varchar(45) NOT null,
    `phone_number` varchar(8) Not null,
    `address` varchar(45) NOT null, 
    `email` varchar(45) NOT null,
    `birthday` date NOT null,
    `trainer_id` int(11) default 0,
    `membership_status` enum  ('ACTIVE','PASSIVE') NOT null,
    `membership_type` enum ('CASUAL','COMPETITIVE') NOT null,
    PRIMARY KEY (`member_id`)
);

-- restance

DROP TABLE IF EXISTS `restance`;

CREATE TABLE `restance` (
	`restance_id` int(11) NOT null auto_increment,
	`member_id` int(11) NOT null,
    PRIMARY KEY (`restance_id`)
);

-- events

DROP TABLE IF EXISTS `tournaments`;

CREATE TABLE `tournaments` (
	`t_id` int(11) NOT null auto_increment,
	`t_name` varchar(45),
    `t_date` datetime NOT null,
    `t_location` varchar(45) NOT null,
    PRIMARY KEY (`t_id`)
);

-- competition

DROP TABLE IF EXISTS `competitions`;

CREATE TABLE `competitions` (
	`competitions_id` int(11) NOT null auto_increment,
	`t_id` int(11) NOT null,
    `swimming_discipline` enum ('CRAWL','BACK CRAWL','BREASTSTROKE','BUTTERFLY') NOT null,
    PRIMARY KEY (`competitions_id`)
);

-- competition times

DROP TABLE IF EXISTS `competition_times`;

CREATE TABLE `competition_times` (
	`c_time_id` int(11) NOT null auto_increment,
	`competitions_id` int(11) NOT null,
    `member_id` int(11) NOT null,
    `c_time_ms` int(11) NOT null,
    PRIMARY KEY (`c_time_id`)
);

-- training times

DROP TABLE IF EXISTS `training_times`;

CREATE TABLE `training_times` (
	`t_time_id` int(11) NOT null auto_increment,
	`t_date` date NOT null,
    `member_id` int(11) NOT null,
    `t_time_ms` int(11) NOT null,
    `swimming_discipline` enum ('CRAWL','BACK CRAWL','BREASTSTROKE','BUTTERFLY') NOT null,
    PRIMARY KEY (`t_time_id`)
);

-- trainers

DROP TABLE IF EXISTS `trainers`;

CREATE TABLE `trainers` (
	`trainer_id` int(11) NOT null auto_increment,
	`trainer_id_name` varchar(45) NOT null,
    PRIMARY KEY (`trainer_id`)
);

-- member swiming discipline

DROP TABLE IF EXISTS `member_swiming_discipline`;

CREATE TABLE `member_swiming_discipline` (
	`msd_id` int(11) NOT null auto_increment,
	`member_id` int(11) NOT null,
    `discipline_name` enum ('CRAWL','BACK CRAWL','BREASTSTROKE','BUTTERFLY') NOT null,
    PRIMARY KEY (`msd_id`)
);


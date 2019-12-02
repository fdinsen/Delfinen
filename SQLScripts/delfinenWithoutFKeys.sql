DROP TABLE IF EXISTS `members`;
DROP TABLE IF EXISTS `restance`;
DROP TABLE IF EXISTS `competitions`;
DROP TABLE IF EXISTS `tournaments`;
DROP TABLE IF EXISTS `competition_times`;
DROP TABLE IF EXISTS `training_times`;
DROP TABLE IF EXISTS `trainers`;
DROP TABLE IF EXISTS `member_swiming_discipline`;
DROP TABLE IF exists `user_privileges`;

-- Members
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
CREATE TABLE `restance` (
	`restance_id` int(11) NOT null auto_increment,
	`member_id` int(11) NOT null,
    PRIMARY KEY (`restance_id`)
);

-- tournaments
CREATE TABLE `tournaments` (
	`t_id` int(11) NOT null auto_increment,
	`t_name` varchar(45),
    `t_date` datetime NOT null,
    `t_location` varchar(45) NOT null,
    PRIMARY KEY (`t_id`)
);

-- competition
CREATE TABLE `competitions` (
	`competitions_id` int(11) NOT null auto_increment,
	`t_id` int(11) NOT null,
    `discipline_id` int(11) NOT null,
    PRIMARY KEY (`competitions_id`)
);

-- competition times
CREATE TABLE `competition_times` (
	`c_time_id` int(11) NOT null auto_increment,
	`competitions_id` int(11) NOT null,
    `member_id` int(11) NOT null,
    `c_time_ms` int(11) NOT null,
    PRIMARY KEY (`c_time_id`)
);

-- training times
CREATE TABLE `training_times` (
	`t_time_id` int(11) NOT null auto_increment,
	`t_date` date NOT null,
    `member_id` int(11) NOT null,
    `t_time_ms` int(11) NOT null,
    `discipline_id` int(11) NOT null,
    PRIMARY KEY (`t_time_id`)
);

-- trainers
CREATE TABLE `trainers` (
	`trainer_id` int(11) NOT null auto_increment,
	`trainer_name` varchar(45) NOT null,
    PRIMARY KEY (`trainer_id`)
);

-- member swiming discipline
CREATE TABLE `member_swiming_discipline` (
	`msd_id` int(11) NOT null auto_increment,
	`member_id` int(11) NOT null,
    `discipline_id` int(11) NOT null,
    PRIMARY KEY (`msd_id`)
);

-- user_privileges
CREATE TABLE `user_privileges`(
	`user_piv_id` int(11) NOT NULL auto_increment,
    `create_member` tinyInt default 0,
	`see_member` tinyInt default 0,
    `edit_member` tinyInt default 0,
    `create_trainer` tinyInt default 0,
    `edit_trainer` tinyInt default 0,
    `see_restance` tinyInt default 0,
    `mark_as_payed` tinyInt default 0,
    `add_training_time` tinyInt default 0,
    `see_tournament` tinyInt default 0,
    `add_tournament` tinyInt default 0,
    `see_competition` tinyInt default 0,
    `add_competition` tinyInt default 0,
    `add_member_to_competition` tinyInt default 0,
    `show_top_5` tinyInt default 0,
    `edit_competition` tinyInt default 0,
    `edit_tournament` tinyInt default 0,
	PRIMARY KEY (`user_piv_id`)
);

-- Discipline
CREATE TABLE `disciplines` (
	`discipline_id` int(11) not null auto_increment,
	`discipline_name` enum ('CRAWL','BACKCRAWL','BREASTSTROKE','BUTTERFLY') NOT null,
    PRIMARY KEY (`discipline_id`)
);
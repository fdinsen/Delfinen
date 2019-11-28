TRUNCATE TABLE members;
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("John","12345678","vejvej 1","John@gmail.com",'1996-05-06',0,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Simon","23456789","vejvej 2","Simon@gmail.com",'2005-05-06',1,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Suzan","34567890","Veeeej 1","SUzan@gmail.com",'1940-05-06',2,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Cecillie","45678901","Veeeej 2","Cecilie@gmail.com",'2010-01-22',0,'PASSIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Mathias","56789012","Veeeej 2","Mathias@gmail.com",'1939-10-22',0,'PASSIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Mikkel","67890123","Veeeej 3","Mikkel@gmail.com",'1990-10-22',3,'ACTIVE','COMPETITIVE');
TRUNCATE TABLE trainers;
INSERT INTO trainers (trainer_id_name) VALUES ("TrainerJohn"), ("TrainerJoe"), ("TrainerMagrette");
TRUNCATE TABLE restance;
INSERT INTO restance (member_id) VALUES (1),(2),(4);
TRUNCATE TABLE training_times;
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',1,60000,'CRAWL');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',1,65000,'BUTTERFLY');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',1,66000,'BACKSTROKE');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',2,60000,'CRAWL');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',2,64000,'BACKSTROKE');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',2,66000,'BACKSTROKE');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',2,68000,'BACKSTROKE');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',2,69000,'CRAWL');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',6,70000,'BACKSTROKE');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',6,80000,'BUTTERFLY');
INSERT INTO training_times (t_date, member_id, t_time_ms, swimming_discipline) VALUES ('2018-11-27',6,120000,'BUTTERFLY');

--Tournaments
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('1', 'JuleCup', '2019-02-18', 'Espergærde');
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('2', 'SommerCup', '2019-07-28', 'Oslo');
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('3', 'VinterCup', '2019-12-31', 'Kbh');
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('4', 'FerieCup', '2018-08-19', 'Roskilde');
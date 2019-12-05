set foreign_key_checks=0;
TRUNCATE TABLE competition_times;
INSERT INTO `delfinen`.`competition_times` (`c_time_id`, `competitions_id`, `member_id`, `c_time_ms`) VALUES ('1', '1', '12', '1234');
INSERT INTO `delfinen`.`competition_times` (`c_time_id`, `competitions_id`, `member_id`, `c_time_ms`) VALUES ('2', '1', '2', '4321');
INSERT INTO `delfinen`.`competition_times` (`c_time_id`, `competitions_id`, `member_id`, `c_time_ms`) VALUES ('3', '1', '4', '1001');
INSERT INTO `delfinen`.`competition_times` (`c_time_id`, `competitions_id`, `member_id`, `c_time_ms`) VALUES ('4', '2', '2', '500');
INSERT INTO `delfinen`.`competition_times` (`c_time_id`, `competitions_id`, `member_id`, `c_time_ms`) VALUES ('5', '2', '3', '600');
TRUNCATE TABLE competitions;
INSERT INTO `delfinen`.`competitions` (`competitions_id`, `t_id`, `discipline_id`) VALUES ('1', '1', '1');
INSERT INTO `delfinen`.`competitions` (`competitions_id`, `t_id`, `discipline_id`) VALUES ('2', '1', '4');
INSERT INTO `delfinen`.`competitions` (`competitions_id`, `t_id`, `discipline_id`) VALUES ('3', '1', '3');
INSERT INTO `delfinen`.`competitions` (`competitions_id`, `t_id`, `discipline_id`) VALUES ('4', '2', '3');
INSERT INTO `delfinen`.`competitions` (`competitions_id`, `t_id`, `discipline_id`) VALUES ('5', '2', '4');
INSERT INTO `delfinen`.`competitions` (`competitions_id`, `t_id`, `discipline_id`) VALUES ('6', '2', '2');
TRUNCATE TABLE tournaments;
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('1', 'JuleCup', '2019-02-18', 'Espergaerde');
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('2', 'SommerCup', '2019-07-28', 'Oslo');
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('3', 'VinterCup', '2019-12-31', 'Kbh');
INSERT INTO `delfinen`.`tournaments` (`t_id`, `t_name`, `t_date`, `t_location`) VALUES ('4', 'FerieCup', '2018-08-19', 'Roskilde');
TRUNCATE TABLE members;
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("John","12345678","vejvej 1","John@gmail.com",'1996-05-06',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Simon","23456789","vejvej 2","Simon@gmail.com",'2005-05-06',2,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Suzan","34567890","Veeeej 1","SUzan@gmail.com",'1940-05-06',3,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Cecillie","45678901","Veeeej 2","Cecilie@gmail.com",'2010-01-22',1,'PASSIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Mathias","56789012","Veeeej 2","Mathias@gmail.com",'1939-10-22',1,'PASSIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Mikkel","67890123","Veeeej 3","Mikkel@gmail.com",'1990-10-22',4,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Peter","78901234","Vejen 1","Peter@gmail.com",'1989-10-22',4,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Thomas","89012345","Vejen 2","Thomas@gmail.com",'1988-10-22',4,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Henrik","90123456","Vejen 3","Henrik@gmail.com",'1987-10-22',4,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES  ("Bjørn","99001122","Vejen 4","Bjørn@gmail.com",'1988-10-22',4,'ACTIVE','COMPETITIVE');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Trevor","12345678","N vej 1","Trevor@gmail.com",'1994-08-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Marcus","12345678","N vej 2","Marcus@gmail.com",'1983-04-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Louise","12345678","N vej 3","Louise@gmail.com",'1983-04-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Benjamin","12131415","N vej 4","mor@gmail.com",'2012-04-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Annemette","13141516","N vej 4","mor@gmail.com",'2013-04-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Bertram","15161718","N vej 4","mor@gmail.com",'2014-04-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Bertram","17181920","N vej 5","Bertram2@gmail.com",'2014-04-22',1,'ACTIVE','CASUAL');
INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) VALUES ("Bertram","18192021","N vej 6","Bertram3@gmail.com",'2014-04-22',1,'ACTIVE','CASUAL');
TRUNCATE TABLE trainers;
INSERT INTO trainers (trainer_id, trainer_name) VALUES (0, "DEFAULT");
INSERT INTO trainers (trainer_name) VALUES ("TrainerJohn"), ("TrainerJoe"), ("TrainerMagrette");
TRUNCATE TABLE restance;
INSERT INTO restance (member_id) VALUES (1),(2),(4);
TRUNCATE TABLE training_times;
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',1,60000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-26',1,59000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-25',1,62000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-24',1,45000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',1,65000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',1,66000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',2,60000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',2,64000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',2,66000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',2,68000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',2,69000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',6,70000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',6,80000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',6,120000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',7,66000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',8,67000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',9,68000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',10,69000,1);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',7,70000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',8,71000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',9,72000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',10,73000,4);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',7,74000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',8,75000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',9,76000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',10,78000,3);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',7,79000,2);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',8,80000,2);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',9,81000,2);
INSERT INTO training_times (t_date, member_id, t_time_ms, discipline_id) VALUES ('2018-11-27',10,82000,2);
TRUNCATE TABLE user_privileges;
INSERT INTO user_privileges (see_member,see_restance,mark_as_payed) VALUES (1,1,1);
INSERT INTO user_privileges (see_member, add_training_time,see_tournament,add_tournament, see_competition,add_competition,add_member_to_competition,show_top_5,edit_competition) VALUES (1,1,1,1,1,1,1,1,1);
INSERT INTO user_privileges (create_member, see_member, create_trainer,edit_trainer) VALUES (1,1,1,1); 
TRUNCATE TABLE disciplines;
INSERT INTO disciplines (discipline_name) VALUES ('CRAWL');
INSERT INTO disciplines (discipline_name) VALUES ('BACKCRAWL');
INSERT INTO disciplines (discipline_name) VALUES ('BREASTSTROKE');
INSERT INTO disciplines (discipline_name) VALUES ('BUTTERFLY');
TRUNCATE TABLE member_swiming_discipline;
INSERT INTO member_swiming_discipline (member_id, discipline_id) values (1,4);
INSERT INTO member_swiming_discipline (member_id, discipline_id) values (1,2);
INSERT INTO member_swiming_discipline (member_id, discipline_id) values (1,3);
INSERT INTO member_swiming_discipline (member_id, discipline_id) values (2,3);
INSERT INTO member_swiming_discipline (member_id, discipline_id) values (2,1);
INSERT INTO member_swiming_discipline (member_id, discipline_id) values (3,3);
set foreign_key_checks=1;
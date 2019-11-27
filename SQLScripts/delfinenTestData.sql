TRUNCATE TABLE members;

INSERT INTO members (member_name,phone_number,address,email,birthday,trainer_id, membership_status, membership_type) 
VALUES ("John","12345678","vejvej 1","John@gmail.com",'1996-05-06',0,'ACTIVE','CASUAL'),
 ("Simon","23456789","vejvej 2","Simon@gmail.com",'2005-05-06',1,'ACTIVE','COMPETITIVE'),
 ("Suzan","34567890","Veeeej 1","SUzan@gmail.com",'1940-05-06',2,'ACTIVE','COMPETITIVE'),
 ("Cecillie","45678901","Veeeej 2","Cecilie@gmail.com",'2010-01-22',0,'PASSIVE','CASUAL'),
 ("Mathias","56789012","Veeeej 2","Mathias@gmail.com",'1939-10-22',0,'PASSIVE','CASUAL'),
 ("Mikkel","67890123","Veeeej 3","Mikkel@gmail.com",'1990-10-22',3,'ACTIVE','COMPETITIVE');
 
 TRUNCATE TABLE trainers;
 
 INSERT INTO trainers (trainer_id_name) 
 VALUES ("TrainerJohn"),
 ("TrainerJoe"),
 ("TrainerMagrette");
 
TRUNCATE TABLE restance;

INSERT INTO restance (member_id)
VALUES (1),
(2),
(4);


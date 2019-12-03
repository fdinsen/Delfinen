DROP DATABASE IF EXISTS `testing`;
CREATE SCHEMA `testing`;
USE testing;

CREATE TABLE Persons(
	PersonID int(11) not null auto_increment,
    lastName varChar(80) not null,
	firstName varchar(80) not null,
    age int(11) not null,
    PRIMARY KEY (PersonID)
);

CREATE TABLE Orders (
    OrderID int(11) NOT NULL auto_increment,
    OrderNumber int(11) NOT NULL,
    PersonID int(11),
    PRIMARY KEY (OrderID),
    CONSTRAINT order_fkey
    FOREIGN KEY (PersonID) 
    REFERENCES Persons(PersonID)
    ON DELETE CASCADE
); 

CREATE TABLE dogs(
	DogId int(11) NOT NULL auto_increment,
    DogName varchar(45) not null,
    PersonID int(11) not null,
    PRIMARY KEY (DogId),
	CONSTRAINT dogs_fkey
    FOREIGN KEY (PersonID) 
    REFERENCES Persons(PersonID)
    ON DELETE CASCADE
);



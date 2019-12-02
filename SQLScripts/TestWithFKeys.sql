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
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    CONSTRAINT fk_name
    FOREIGN KEY (PersonID) 
    REFERENCES Persons(PersonID)
    ON DELETE CASCADE
); 


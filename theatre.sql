create table zone(
id INT(6) AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(30) NOT NULL,
prix NUMERIC(10,2) NOT NULL
);

create table spectacle(
num INT(6) AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(30) NOT NULL
);

create table salle(
id INT(6) AUTO_INCREMENT PRIMARY KEY
);

create table place(
numRg INT(6),
numPl INT(6),
zone INT(6),
salle INT(6),
primary key (numRg, numPl),
foreign key zone references zone(id),
foreign key salle references salle(id)
);

create table representation(
id INT(6) AUTO_INCREMENT PRIMARY KEY
date date,
salle INT(6),
spectacle INT(6),
foreign key spectacle references spectacle(id),
foreign key salle references salle(id)
);

create table vente(
num INT(6) PRIMARY KEY,
date date,
prix NUMBER(10,2),
representation INT(6),
place INT(6),
foreign key representation references representation(id),
foreign key place references place(id)
);
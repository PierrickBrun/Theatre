drop table LesVentes;
drop table LesTickets;
drop table LaSalle;
drop table lesZones;
drop table LesRepresentations;
drop table LesSpectacles;

/*Schema de la table:
  LesSpectacles(ID du spectacle, Nom du spectacle)
 la clef est l'ID du spectacle (NumSpec)*/
create table LesSpectacles(
  NumSpec integer primary key,
  NomSpec varchar2(64),
  constraint spec_c0 check (NumSpec > 0)
);


/*Schema de la table:
  LesRepresentations(ID du spectacle, Date de representation)
la clef est le couple unique (NumSpec, DateRep)*/
create table LesRepresentations(
  NumSpec integer not null references LesSpectacles(NumSpec),
  DateRep date not null Unique ,
primary key(NumSpec, DateRep)
);

/*Schema de la table:
  LesZones(ID de la zone, nom de la zone, tarif de la zone)
la clef est l'ID de la zone (NumZone)*/
create table LesZones(
  NumZone integer primary key,
  NomZone varchar2(64),
  Tarif integer
);


/*Schema de la table:
  LaSalle(ID de zone, ID de rang, ID de place)
 La clef esst le triplet unique(Numzone, NumRang, NumPlace)
i.e il n'existe qu'une seule place d'ID P dans le rang R de la zone Z*/
create table LaSalle(
  NumZone integer not null references LesZones(NumZone),
  NumRang integer,
  NumPlace integer,
  primary key(NumZone, NumRang, NumPlace)
);

/*Schema de la table:
  LesTickets(ID du ticket, ID de zone, ID de rang, ID de place, ID de spectacle, Date de representation)
 La clef est l'ID du ticket (NumTicket)
On peut récuperer le tarif grâce à l'ID de zone.*/
create table LesTickets(
  NumTicket integer primary key,
  NumZone integer not null,
  NumRang integer not null,
  NumPlace integer not null,
  NumSpec integer not null,
  DateRep date not null,
  foreign key(NumZone, NumRang, NumPlace) references LaSalle(NumZone, NumRang, NumPlace),
  foreign key(NumSpec, DateRep) references LesRepresentations(NumSpec, DateRep)
);

/*Schema de la table:
  LesVentes(ID du dossier, Date d'achet, Numero de ticket(s) lié(s)
 la clef est le triplet unique(NumDossier, DateAchat, NumTicket)
i.e il n'existe qu'un dossier d'ID I dont la transaction a été effecutée en date D
et dont le numéro de ticket est N
Cela pemet quand meme des configurations du genre :
  Dossier 12 date '23/12/2013/12:32:24' Ticket 231
  Dossier 12 date '23/12/2013/12:32:24' Ticket 232
  Dossier 12 date '23/12/2013/12:32:24' Ticket 233
  Dossier 12 date '23/12/2013/12:32:24' Ticket 253
*/
create table LesVentes(
  NumDossier integer,
  DateAchat timestamp,
  NumTicket integer not null references LesTickets(NumTicket),
  primary key(NumDossier, DateAchat, NumTicket),
  constraint vente_c0 check(NumDossier > 0),
  constraint vente_c1 check(NumTicket > 0)
);


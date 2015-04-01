drop table LesVentes;
drop table LesTickets;
drop table LesPlaces;
drop table lesZones;
drop table LesRepresentations;
drop table LesSpectacles;

/*Schema de la table:
  LesSpectacles(ID du spectacle, Nom du spectacle)
 la clef est l'ID du spectacle (NumSpec)*/
create table LesSpectacles(
  IdSpec integer primary key,
  NomSpec varchar2(64),
  constraint spec_c0 check (IdSpec > 0)
);


/*Schema de la table:
  LesRepresentations(ID du spectacle, Date de representation)
la clef est le couple unique (NumSpec, DateRep)*/
create table LesRepresentations(
  IdSpec integer not null references LesSpectacles(IdSpec) primary key,
  DateRep date not null Unique ,
constraint rep_c0 Unique (IdSpec, DateRep)
);

/*Schema de la table:
  LesZones(ID de la zone, nom de la zone, tarif de la zone)
la clef est l'ID de la zone (NumZone)*/
create table LesZones(
  IdZone Integer primary key,
  NomZone varchar2(64),
  Tarif integer
);


/*Schema de la table:
  LesPlaces(ID de zone, ID de rang, ID de place)
 La clef esst le triplet unique(Numzone, NumRang, NumPlace)
i.e il n'existe qu'une seule place d'ID P dans le rang R de la zone Z*/
create table LesPlaces(
  IdPlace integer primary key,
  IdZone integer not null references LesZones(IdZone),
  NumRang integer,
  NumPlace integer,
  constraint salle_c0 unique(IdPlace, IdZone, NumRang, NumPlace)
);

/*Schema de la table:
  LesTickets(ID du ticket, ID de zone, ID de rang, ID de place, ID de spectacle, Date de representation)
 La clef est l'ID du ticket (NumTicket)
On peut récuperer le tarif grâce à l'ID de zone.*/
create table LesTickets(
  IdTicket integer primary key,
  NumTicket integer unique,
  IdPlace integer not null references LesPlaces(IdPlace),
  IdSpec integer not null,
  DateRep date not null,
  foreign key(IdSpec, DateRep) references LesRepresentations(IdSpec, DateRep),
  constraint tickets_c0 check(NumTicket > 0)
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
  Dossier 12 date '23/12/2013/12:32:24' Ticket 256
*/
create table LesVentes(
  IdDossier integer,
  NumDossier integer,
  DateAchat timestamp,
  IdTicket integer not null references LesTickets(IdTicket),
  primary key(IdDossier, DateAchat, IdTicket),
  constraint vente_c0 check(NumDossier > 0)
);


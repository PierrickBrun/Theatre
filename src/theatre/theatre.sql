drop table LesVentes;
drop table LesTickets;
drop table LaSalle;
drop table lesZones;
drop table LesRepresentations;
drop table LesSpectacles;

create table LesSpectacles(
  NumSpec integer primary key,
  NomSpec varchar2(64),
  constraint spec_c0 check (NumSpec > 0)
);

create table LesRepresentations(
  NumSpec integer not null references LesSpectacles(NumSpec),
  DateRep date not null Unique ,
primary key(NumSpec, DateRep)
);

create table LesZones(
  NumZone integer primary key,
  NomZone varchar2(64),
  Tarif integer
);

create table LaSalle(
  NumZone integer not null references LesZones(NumZone),
  NumRang integer,
  NumPlace integer,
  primary key(NumZone, NumRang, NumPlace)
);


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


create table LesVentes(
  NumDossier integer,
  DateAchat timestamp,
  NumTicket integer not null references LesTickets(NumTicket),
  primary key(NumDossier, DateAchat, NumTicket),
  constraint vente_c0 check(NumDossier > 0),
  constraint vente_c1 check(NumTicket > 0)
);


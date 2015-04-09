INSERT INTO LesSpectacles VALUES (001,'Les Decafeines');
INSERT INTO LesSpectacles VALUES (002,'Elie et Dieudonne');
INSERT INTO LesSpectacles VALUES (003,'La cage aux folles');
INSERT INTO LesSpectacles VALUES (004,'Toc toc');
INSERT INTO LesSpectacles VALUES (005,'Sans filtre');
INSERT INTO LesSpectacles VALUES (006,'Foresti Party');
INSERT INTO LesSpectacles VALUES (007,'A l''etat sauvage');
INSERT INTO LesSpectacles VALUES (008,'Le pere noel est une ordure');
INSERT INTO LesSpectacles VALUES (009,'Le diner de con');
INSERT INTO LesSpectacles VALUES (010,'Arnaud Tsamere');



INSERT INTO LesRepresentations VALUES (002,to_date('15/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (003,to_date('15/04/2015 22:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (004,to_date('17/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (002,to_date('17/04/2015 22:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (010,to_date('18/04/2015 16:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (005,to_date('18/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (009,to_date('18/04/2015 22:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (006,to_date('19/04/2015 16:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (001,to_date('19/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesRepresentations VALUES (007,to_date('19/04/2015 23:00:00','dd/mm/yyyy hh24:mi:ss'));


INSERT INTO LesZones VALUES (1,'Fosse',15);
INSERT INTO LesZones VALUES (2,'Parterre',20);
INSERT INTO LesZones VALUES (3,'LogeG',50);
INSERT INTO LesZones VALUES (4,'LogeD',50);
INSERT INTO LesZones VALUES (5,'VIP',100);
INSERT INTO LesZones VALUES (6,'Invite',0);
INSERT INTO LesZones VALUES (7,'Balcon',15);
INSERT INTO LesZones VALUES (8,'Second Balcon',12);
INSERT INTO LesZones VALUES (9,'Fond de salle',10);
INSERT INTO LesZones VALUES (10,'Strapontin',10);


/*LesPlaces(ID de place, ID de zone, num de rang, num de place)*/


INSERT INTO LesPlaces Values(1,1,1,1);
INSERT INTO LesPlaces Values(2,1,1,2);
INSERT INTO LesPlaces Values(30,3,2,10);
INSERT INTO LesPlaces Values(248,2,12,28);
INSERT INTO LesPlaces Values(21,1,3,1);
INSERT INTO LesPlaces Values(37,3,3,7);
INSERT INTO LesPlaces Values(45,4,1,5);
INSERT INTO LesPlaces Values(11,1,2,1);
INSERT INTO LesPlaces Values(98,7,5,8);
INSERT INTO LesPlaces Values(100,7,5,10);
INSERT INTO LesPlaces Values(376,9,7,16);
INSERT INTO LesPlaces Values(291,2,17,1);
INSERT INTO LesPlaces Values(632,8,3,2);
INSERT INTO LesPlaces Values(1000,6,1,1);
INSERT INTO LesPlaces Values(1001,6,1,2);




/*  LesTickets(ID du ticket, Num du ticket, ID de place, ID de spectacle, Date de representation)
*/

INSERT INTO LesTickets Values(1,1054,632,003,to_date('15/04/2015 22:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(2,1055,98,005,to_date('18/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(3,1056,376,001,to_date('19/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(4,1057,21,005,to_date('18/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(5,1058,2,010,to_date('18/04/2015 16:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(523,4502,37,010,to_date('18/04/2015 16:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(734,4832,1000,002,to_date('15/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(800,4903,1,002,to_date('15/04/2015 20:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(943,5023,30,006,to_date('19/04/2015 16:00:00','dd/mm/yyyy hh24:mi:ss'));
INSERT INTO LesTickets Values(1034,5123,248,009,to_date('18/04/2015 22:00:00','dd/mm/yyyy hh24:mi:ss'));



/*  LesVentes(ID du dossier, Num du dossier, Date achat, Numero de ticket(s) lié(s)*/

INSERT INTO LesVentes values(1,10321,to_date('17/02/2015 21:22:14','dd/mm/yyyy hh24:mi:ss'),3);
INSERT INTO LesVentes values(2,10322,to_date('17/02/2015 23:45:52','dd/mm/yyyy hh24:mi:ss'),2);
INSERT INTO LesVentes values(2,10322,to_date('17/02/2015 23:45:52','dd/mm/yyyy hh24:mi:ss'),4);
INSERT INTO LesVentes values(42,11039,to_date('28/02/2015 13:58:22','dd/mm/yyyy hh24:mi:ss'),5);
INSERT INTO LesVentes values(42,11039,to_date('28/02/2015 13:58:22','dd/mm/yyyy hh24:mi:ss'),523);
INSERT INTO LesVentes values(42,11039,to_date('28/02/2015 13:58:22','dd/mm/yyyy hh24:mi:ss'),734);
INSERT INTO LesVentes values(121,11231,to_date('03/03/2015 08:58:12','dd/mm/yyyy hh24:mi:ss'),1);
INSERT INTO LesVentes values(123,11041,to_date('03/03/2015 11:23:17','dd/mm/yyyy hh24:mi:ss'),800);
INSERT INTO LesVentes values(210,11342,to_date('08/03/2015 17:02:44','dd/mm/yyyy hh24:mi:ss'),943);
INSERT INTO LesVentes values(243,11382,to_date('09/03/2015 00:23:10','dd/mm/yyyy hh24:mi:ss'),1034);


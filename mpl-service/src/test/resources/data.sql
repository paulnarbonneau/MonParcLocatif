/*
create table mpl_utilisateur(
	id number,
	identifiant varchar2(10),
	nom varchar2(100),
	prenom varchar2(100),
	email varchar2(100),
	adresse1 varchar2(255),
	adresse2 varchar2(255),
	code_postal varchar2(5),
	ville varchar2(100),
	mot_de_passe varchar2(100)
);

create table mpl_role(
	id number,
	role varchar2(100),
	parent number
);
*/


insert into mpl_utilisateur (id,identifiant,nom,prenom,email,adresse1,adresse2,code_postal,ville,mot_de_passe) 
values (99,'paulo','Narbonneau','Paul','pnarbonn@gmail.com','17 allée de l''ile marante','Appartement 225','92700','Colombes','Poupou2017.');


insert into mpl_role values(1,'VISITEUR');
insert into mpl_role values(2,'ADMIN PARC LOCATIF');
insert into mpl_role values(99,'ROOT ADMIN');

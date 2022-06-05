
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
	id number not null,
	role varchar2(100),
	parent number
);


create table locataire(
	id number,
	qualite varchar2(20),
	nom varchar2(100),
	prenom varchar2(100),
	email varchar2(255)	
);

create table biens(
	 id_bien number,
	 idProprietaire number,
	idLocataire number,
 	adresse1 varchar2(255),
	adresse2 varchar2(255),
	codePostal varchar2(255),
	ville varchar2(255),
	loyer number
);

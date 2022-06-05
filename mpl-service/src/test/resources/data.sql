


insert into mpl_utilisateur (id,identifiant,nom,prenom,email,adresse1,adresse2,code_postal,ville,mot_de_passe) 
values (1,'paulo','Narbonneau','Paul','pnarbonn@gmail.com','17 allée de l''ile marante','Appartement 225','92700','Colombes','Poupou2017.');

insert into locataire (id,qualite,nom,prenom,email)
values (1,'monsieur','NomLocataire','prenom','pnarbonn@gmail.com');


insert into mpl_role(id,role) values(1,'VISITEUR');
insert into mpl_role(id,role,parent) values(2,'ADMIN PARC LOCATIF',99);
insert into mpl_role(id,role) values(99,'ROOT ADMIN');

insert into biens values (1,1,1,'26 avenue Jean Moulin','','28100','Dreux','750');

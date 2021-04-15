drop table if exists users;
create table users (
    id int auto_increment primary key,
    nom varchar2(250) not null,
    prenom varchar2(250) not null,
    email varchar2(250),
    adresse1 varchar2(250) not null,
    adresse2 varchar2(250),
    codepostal varchar2(5) not null,
    ville varchar2(100) not null
);

insert into users (nom,prenom,email,adresse1,adresse2,codepostal,ville) 
values ('Narbonneau','Paul','pnarbonn@gmail.com','17 allée de l''ile marante','Appartement 225','92700','Colombes');
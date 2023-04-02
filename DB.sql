// db name  gestion_ecole


create table section(
id_section int not null auto_increment,
primary key(id_section),
nom_section varchar(20),
niveau varchar(20),
specialite varchar(20));

create table etudiant(
matricule_etu int not null ,
nom_etu varchar(20),
prenom_etu varchar(20),
date_naissance varchar(20),
adresse varchar(20),
id_section int,
primary key(matricule_etu),
foreign key(id_section) references section(id_section)
);


create table enseignant(
matricule_ens int not null ,
nom_ens varchar(20),
prenom_ens varchar(20),
age int,
primary key(matricule_ens)
);

create table unite(
code_unite varchar(20) not null ,
libelle varchar(20),
nbr_heures int,
matricule_ens int,
primary key(code_unite),
foreign key(matricule_ens) references enseignant(matricule_ens)
);

create table etudiantunite(
matricule_etu int,
code_unite varchar(20),
note_cc int,
note_tp int,
note_examen int,
primary key(matricule_etu,code_unite),
foreign key(matricule_etu) references etudiant(matricule_etu),
foreign key(code_unite) references unite(code_unite)
);

create table user_app(
user_name varchar(255),
motdepasse varchar(255),
primary key(user_name)
);



INSERT INTO `user_app` ( `user_name`, `motdepasse`) 
VALUES ( 'BDDAdmin', '123'),
 ( 'Etudiant', '123'),
 ( 'Enseignant', '123');

INSERT INTO `section` (`id_section`, `nom_section`, `niveau`, `specialite`) VALUES 
('1', 'A', 'L2', 'ACAD'), 
('2', 'B', 'L2', 'ACAD'), 
('3', 'A', 'L2', 'ISIL'), 
('4', 'B', 'L2', 'ISIL'), 
('5', 'A', 'M1', 'SII'), 
('6', 'A', 'M1', 'SSI');

INSERT INTO `etudiant` (`matricule_etu`, `nom_etu`, `prenom_etu`, `date_naissance`, `adresse`, `id_section`) VALUES
 ('20190001', 'BOUSSAI', 'MOHAMED', '12/01/2000', 'Alger', '1'),
 ('20190002', 'CHAID', 'LAMIA', '01/10/1999', 'Batna', '2'),
 ('20190003', 'BRAHIMI', 'SOUAD', '18/11/2000', 'Sétif', '1'), 
 ('20190004', 'LAMA', 'SAID', '23/05/1999', 'Oran', '2');
 
 
 INSERT INTO `enseignant` (`matricule_ens`, `nom_ens`, `prenom_ens`, `age`) VALUES 
 ('20000001', 'HAROUNI', 'AMINE', NULL), 
 ('19990011', 'FATHI', 'OMAR', NULL), 
 ('19980078', 'BOUZIDANE', 'FARAH', NULL),
 ('20170015', 'ARABI', 'ZOUBIDA', NULL);

INSERT INTO `unite` (`code_unite`, `libelle`, `nbr_heures`, `matricule_ens`) VALUES 
('FEI0001', 'POO', '6', '20000001'),
 ('FEI0002', 'PDD', '6', '19990011'),
 ('FEI0003', 'RESEAU', '3', '20170015'),
 ('FEI0004', 'SYSTEME', '6', '19980078');


-- Titre :             Création base cabinet recrutement version élèves.sql
-- Version :           1.0
-- Date création :     28 juin 2011
-- Date modification : 16 janvier 2021
-- Auteur :            Philippe Tanguy
-- Description :       Script de création de la base de données pour le SI "gestion de cabinet de
--                     recrutement"
--                     Note : script pour PostgreSQL
--                     Ebauche du script : ne contient pour le moment que la table "entreprise".

-- +----------------------------------------------------------------------------------------------+
-- | Suppression des tables                                                                       |
-- +----------------------------------------------------------------------------------------------+

drop table if exists entreprise cascade;
drop table if exists offresEmploi cascade;
drop table if exists messageCandidature cascade;
drop table if exists messageOffreDEmploi cascade;
drop table if exists candidature cascade;
drop table if exists secteurActivite cascade;
drop table if exists secteurCandidat cascade;
drop table if exists secteurOffre cascade;
drop table if exists niveauQualification cascade;

-- +----------------------------------------------------------------------------------------------+
-- | Création des tables                                                                          |
-- +----------------------------------------------------------------------------------------------+

create table entreprise
(
  id              serial primary key,
  nom             varchar(50) not null,
  descriptif      text,
  adresse_postale varchar(30) 
);

create table offresEmploi
(
  id                serial primary key,
  titre             text,
  descriptifMission varchar(50) not null,
  dateDepot         varchar(30),
  profilRecherche   varchar,
  idEntreprise      integer, 
  idNiveauQualif    integer
);

create table messageOffreDEmploi
(
  id            serial primary key,
  dateEnvoi     varchar(50) not null,
  corpsMessage  varchar(50) not null,
  idOffreEmploi integer, 
  idCandidature integer 
);

create table messageCandidature
(
  id            serial primary key,
  dateEnvoi     varchar(50) not null,
  corpsMessage  varchar(50) not null,
  idOffreEmploi integer, 
  idCandidature integer
);

create table niveauQualification
(
  id        serial primary key,
  intitule  varchar(50) not null
);

create table secteurOffre
(
  idOffreEmploi     integer, 
  idSecteurActivite integer,
  nombreDeSecteurs  integer,
  PRIMARY KEY (idOffreEmploi,idSecteurActivite)
);

create table secteurActivite
(
  id              serial primary key,
  intitule        varchar(50) not null
);

create table secteurCandidat
(
  idSecteurActivite  integer, 
  idCandidature      integer, 
  nombreDeCandidats  integer,
  PRIMARY KEY (idSecteurActivite,idCandidature)
);

create table candidature
(
  id                serial primary key,
  nom               varchar(50) not null,
  prénom            text,
  dateNaissance     text,
  adresse_postale   text,
  adresseEmail      text,
  CV                text,
  dateDepot         text,
  idNiveauQualif    integer 
);

ALTER TABLE offresEmploi
ADD CONSTRAINT fk_id_niveau_qualif_offres FOREIGN KEY (idNiveauQualif) REFERENCES niveauQualification(id),
ADD CONSTRAINT fk_id_entreprise_offres FOREIGN KEY (idEntreprise) REFERENCES entreprise(id);

ALTER TABLE messageOffreDEmploi
ADD CONSTRAINT fk_id_offre_emploi_message_offre FOREIGN KEY (idOffreEmploi) REFERENCES offresEmploi(id),
ADD CONSTRAINT fk_id_candidature_message_offre FOREIGN KEY (idCandidature) REFERENCES candidature(id);

ALTER TABLE messageCandidature
ADD CONSTRAINT fk_id_offre_emploi_message_candidature FOREIGN KEY (idOffreEmploi) REFERENCES offresEmploi(id),
ADD  CONSTRAINT fk_id_candidature_message_candidature FOREIGN KEY (idCandidature) REFERENCES candidature(id);

ALTER TABLE secteurOffre
ADD CONSTRAINT fk_id_offre_emploi_secteur_offre FOREIGN KEY (idOffreEmploi) REFERENCES offresEmploi(id),
ADD CONSTRAINT fk_id_secteur_activite_secteur_offre FOREIGN KEY (idSecteurActivite) REFERENCES secteurActivite(id);

ALTER TABLE secteurCandidat
ADD CONSTRAINT fk_id_secteur_activite_secteur_candidat FOREIGN KEY (idSecteurActivite) REFERENCES secteurActivite(id),
ADD CONSTRAINT fk_id_candidature_secteur_candidat FOREIGN KEY (idCandidature) REFERENCES candidature(id);

ALTER TABLE candidature
ADD CONSTRAINT fk_id_niveau_qualif_candidature FOREIGN KEY (idNiveauQualif) REFERENCES niveauQualification(id);
-- +----------------------------------------------------------------------------------------------+
-- | Insertion de quelques données de pour les tests                                              |
-- +----------------------------------------------------------------------------------------------+

-- Insertion des secteurs d'activité

insert into entreprise values (nextval('entreprise_id_seq'),'IMT Atlantique','IMT Atlantique est une grande école pionnière en formation, en recherche et en entrepreneuriat et en tout plein de choses...','Plouzané');
insert into entreprise values (nextval('entreprise_id_seq'),'ENIB','Une école d''ingénieur juste à côté...','Plouzané');


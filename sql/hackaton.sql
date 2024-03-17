CREATE TABLE Genre(
   id_genre SERIAL,
   valeur VARCHAR(50),
   PRIMARY KEY(id_genre)
);

CREATE TABLE Nationalite(
   id_nationalite SERIAL,
   valeur VARCHAR(60),
   PRIMARY KEY(id_nationalite)
);

CREATE TABLE Tags(
   id_tag SERIAL,
   tag VARCHAR(50) UNIQUE,
   PRIMARY KEY(tag)
);

CREATE TABLE Media(
   id_media SERIAL,
   valeur TEXT,
   type SERIAL,
   PRIMARY KEY(id_media)
);

CREATE TABLE Action(
   id_action SERIAL,
   valeur SERIAL,
   note DOUBLE PRECISION,
   PRIMARY KEY(id_action)
);

CREATE TABLE Profil(
   id_profil SERIAL,
   nom VARCHAR(70) ,
   prenom VARCHAR(80) ,
   date_naissance DATE,
   id_genre INT NOT NULL,
   id_nationalite INT NOT NULL,
   PRIMARY KEY(id_profil),
   FOREIGN KEY(id_genre) REFERENCES Genre(id_genre),
   FOREIGN KEY(id_nationalite) REFERENCES Nationalite(id_nationalite)
);

CREATE TABLE Publication(
   id_publication SERIAL,
   description VARCHAR(200) ,
   nombre_vue INTEGER,
   id_profil INT NOT NULL,
   longitude DOUBLE PRECISION,
   latitude DOUBLE PRECISION,
   date_debut DATE,
   date_fin DATE,
   PRIMARY KEY(id_publication),
   FOREIGN KEY(id_profil) REFERENCES Profil(id_profil)
);

CREATE TABLE reaction(
   id_reaction SERIAL,
   valeur INTEGER,
   id_publication INT NOT NULL,
   id_profil INT NOT NULL,
   PRIMARY KEY(id_reaction),
   FOREIGN KEY(id_publication) REFERENCES Publication(id_publication),
   FOREIGN KEY(id_profil) REFERENCES Profil(id_profil)
);

CREATE TABLE commentaire(
   id_commentaire SERIAL,
   valeur VARCHAR(200) ,
   id_publication SERIAL NOT NULL,
   id_profil INT,
   PRIMARY KEY(id_commentaire),
   FOREIGN KEY(id_publication) REFERENCES Publication(id_publication),
   FOREIGN KEY(id_profil) REFERENCES Profil(id_profil)
);

CREATE TABLE Tags_publication(
   tag INT,
   id_publication INT,
   PRIMARY KEY(tag, id_publication),
   FOREIGN KEY(tag) REFERENCES Tags(tag),
   FOREIGN KEY(id_publication) REFERENCES Publication(id_publication)
);

CREATE TABLE Media_publication(
   id_publication INT,
   id_media INT,
   PRIMARY KEY(id_publication, id_media),
   FOREIGN KEY(id_publication) REFERENCES Publication(id_publication),
   FOREIGN KEY(id_media) REFERENCES Media(id_media)
);

CREATE TABLE Preference(
   id_profil INT,
   tag INT,
   note INTEGER,
   PRIMARY KEY(id_profil, tag),
   FOREIGN KEY(id_profil) REFERENCES Profil(id_profil),
   FOREIGN KEY(tag) REFERENCES Tags(tag)
);

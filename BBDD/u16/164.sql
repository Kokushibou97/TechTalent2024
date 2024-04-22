CREATE TABLE SALAS (
    Codigo int PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(100)
);

CREATE TABLE PELICULAS (
    Codigo int PRIMARY KEY AUTO_INCREMENT,
    Nombre varchar(100),
    CalificacionEdad int,
    Sala int,
    FOREIGN KEY (Sala) REFERENCES SALAS(Codigo)
);

INSERT INTO SALAS (Nombre) VALUES
('Sala Magna'),
('Sala Premium'),
('Sala English'),
('Sala Estandar'),
('Sala Individual');

INSERT INTO PELICULAS (Nombre, CalificacionEdad, Sala) VALUES
('Godzilla', 7, 1),
('Hobbit', 12, 2),
('Avatar', 16, 3),
('Kung Fu Panda', 18, 4),
('El camino del Samurai', 7, 5),
('Harry Potter', 12, NULL),
('Shrek', NULL, NULL),
('Gato con Botas', 16, NULL),
('Perfectos desconocidos', 18, NULL),
('Given', NULL, NULL);
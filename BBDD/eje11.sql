
CREATE TABLE FACULTAD (
    Codigo INT PRIMARY KEY,
    Nombre NVARCHAR(100)
);


CREATE TABLE INVESTIGADORES (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels NVARCHAR(255)
);

<<<<<<< HEAD
=======

>>>>>>> 4e06e26a76cad3fc86ccfdf65917b880c82aa3d9
CREATE TABLE RESERVA (
    Facultad INT,
    Comienzo DATETIME,
    Fin DATETIME,
    PRIMARY KEY (Facultad, Comienzo, Fin),
    FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)
);


CREATE TABLE EQUIPOS (
    NumSerie CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(100),
    Facultad INT,
    FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)
);

-- Crear la tabla FACULTAD
CREATE TABLE FACULTAD (
    Codigo INT PRIMARY KEY,
    Nombre NVARCHAR(100)
);

-- Crear la tabla INVESTIGADORES
CREATE TABLE INVESTIGADORES (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels NVARCHAR(255)
);

-- Crear la tabla RESERVA
CREATE TABLE RESERVA (
    Facultad INT,
    Comienzo DATETIME,
    Fin DATETIME,
    PRIMARY KEY (Facultad, Comienzo, Fin),
    FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)
);

-- Crear la tabla EQUIPOS
CREATE TABLE EQUIPOS (
    NumSerie CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(100),
    Facultad INT,
    FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)
);

CREATE TABLE CIENTIFICOS (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels NVARCHAR(255)
);

INSERT INTO CIENTIFICOS (DNI, NomApels) VALUES
('11111111', 'Juli Martin'),
('22222222', 'Maruchi Maray'),
('33333333', 'Yumi Yamishibai'),
('44444444', 'Carmona Sandía'),
('55555555', 'Charlie Cebolla'),
('66666666', 'Kaki Mara'),
('77777777', 'Pedro DelHierro'),
('88888888', 'Sarai Faruchi'),
('99999999', 'Daniel Rojo'),
('10101010', 'Helen Malona');

CREATE TABLE PROYECTO (
    Proyecto CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(255),
    Horas INT
);

INSERT INTO PROYECTO (Proyecto, Nombre, Horas) VALUES
('M001', 'Proyecto Cardamomo', 100),
('N200', 'Proyecto Cafe', 150),
('V622', 'Proyecto Maracuya', 200),
('F589', 'Proyecto Arsenico', 180),
('S788', 'Proyecto Colágeno', 120),
('X155', 'Proyecto Anacardos', 250),
('P320', 'Proyecto Granizdo', 170),
('L414', 'Proyecto HieloSalado', 190),
('Y936', 'Proyecto Limonchilo', 220),
('U899', 'Proyecto Jarabe', 140);

CREATE TABLE ASIGNADO_A (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Cientifico VARCHAR(8),
    Proyecto CHAR(4),
    FOREIGN KEY (Cientifico) REFERENCES CIENTIFICOS(DNI),
    FOREIGN KEY (Proyecto) REFERENCES PROYECTO(Proyecto)
);

INSERT INTO ASIGNADO_A (Cientifico, Proyecto) VALUES
('11111111', 'M001'),
('22222222', 'N200'),
('33333333', 'V622'),
('44444444', 'F589'),
('55555555', 'S788'),
('66666666', 'X155'),
('77777777', 'P320'),
('88888888', 'L414'),
('99999999', 'Y936'),
('10101010', 'U899');

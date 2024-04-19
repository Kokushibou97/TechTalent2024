DROP TABLE IF EXISTS RESERVA;
CREATE TABLE FACULTAD (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Nombre NVARCHAR(100)
);
INSERT INTO FACULTAD (Nombre) VALUES
('Facultad de Ciencias'),
('Facultad de Ingenieria'),
('Facultad de Medicina'),
('Facultad de Física'),
('Facultad de Derecho'),
('Facultad de Economia'),
('Facultad de Geografia'),
('Facultad de Bellas Artes'),
('Facultad de Turismo'),
('Facultad de Química');
CREATE TABLE INVESTIGADORES (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels NVARCHAR(255),
    Facultad INT,
    FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)
);
INSERT INTO INVESTIGADORES (DNI, NomApels, Facultad) VALUES
('Y4529752L', 'Juan Jarron', 1),
('04193581K', 'Shalom Shalom', 2),
('Y286304PO', 'Dopa Mina', 3),
('04892561P', 'Karin Voila', 4),
('24283230A', 'Fadi Ahmed', 5),
('D0858883N', 'Larin Garmin', 6),
('G1293684A', 'Pedro Sanchez', 7),
('94658900I', 'Shakra Mudra', 8),
('63665500S', 'Marta Mariano', 9),
('A4545571C', 'Angel Valentín', 10);
CREATE TABLE EQUIPOS (
    NumSerie CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(100),
    Facultad INT,
    FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)
);
INSERT INTO EQUIPOS (NumSerie, Nombre, Facultad) VALUES
('A001', 'Equipo de Ciencias', 1),
('B002', 'Equipo de Ingeniería', 2),
('C003', 'Equipo de Medicina', 3),
('J004', 'Equipo de Física', 4),
('O005', 'Equipo de Derecho', 5),
('D006', 'Equipo de Economía', 6),
('F007', 'Equipo de Geografía', 7),
('X008', 'Equipo de Bellas Artes', 8),
('Z009', 'Equipo de Turismo', 9),
('H010', 'Equipo de Quimica', 10);
CREATE TABLE RESERVA (
    DNI VARCHAR(8),
    NumSerie CHAR(4),
    Comienzo DATETIME,
    Fin DATETIME,
    PRIMARY KEY (DNI, NumSerie),
    FOREIGN KEY (DNI) REFERENCES INVESTIGADORES(DNI),
    FOREIGN KEY (NumSerie) REFERENCES EQUIPOS(NumSerie)
);
INSERT INTO RESERVA (DNI, NumSerie, Comienzo, Fin) VALUES
('Y4529752L', 'A001', '2024-01-10 08:00:00', '2024-01-20 09:00:00'),
('04193581K', 'B002', '2024-01-21 10:00:00', '2024-01-21 11:00:00'),
('Y2863040P', 'C003', '2024-01-22 12:00:00', '2024-01-22 13:00:00'),
('04892561P', 'J004', '2024-02-23 14:00:00', '2024-02-23 15:00:00'),
('24283230A', 'O005', '2024-02-24 16:00:00', '2024-02-24 17:00:00'),
('D0858883N', 'D006', '2024-02-25 18:00:00', '2024-02-25 19:00:00'),
('G1293684A', 'F007', '2024-03-26 20:00:00', '2024-03-26 21:00:00'),
('94658900I', 'X008', '2024-03-27 08:00:00', '2024-03-27 10:00:00'),
('63665500S', 'Z009', '2024-03-28 11:00:00', '2024-03-28 13:00:00'),
('A4545571C', 'H010', '2020-04-30 09:00:00', '2024-04-16 15:00:00');
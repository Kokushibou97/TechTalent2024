CREATE TABLE DESPACHOS (
    Numero int PRIMARY KEY,
    Capacidad int
);

CREATE TABLE DIRECTORES (
    DNI varchar(8) PRIMARY KEY,
    NomApels nvarchar(255),
    DNIJefe varchar(8),
    Despacho int,
    FOREIGN KEY (DNIJefe) REFERENCES DIRECTORES(DNI)
);

INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES
('12345678', 'Mari Loli', '958742658', 501),
('23456789', 'Pepito polo', '789143572', 502),
('34567890', 'Pedro Delhierro', '9726348512', 503),
('45678901', 'Yasmina Galletadulce', '23456789', 504),
('56789012', 'Charlie Delgato', '23456789', 505),
('67890123', 'Marmon Bonbon', '34567890', 506),
('78901234', 'Koke Sabrón', '34567890', 507),
('89012345', 'Maruja Marga', '45678901', 508),
('90123456', 'Nainai Llacer', '45678901', 509),
('01234567', 'Maruchi Palles', '56789012', 510);

INSERT INTO DESPACHOS (Numero, Capacidad) VALUES
(501, 5),
(502, 8),
(503, 6),
(504, 4),
(505, 7),
(506, 5),
(507, 9),
(508, 6),
(509, 8),
(510, 7);

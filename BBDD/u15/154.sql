CREATE TABLE CAJEROS (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    NomApels NVARCHAR(255)
);
INSERT INTO CAJEROS (NomApels) VALUES
('Guillem Martin'),
('Momon Kun'),
('Yasmina Alawi'),
('Yolanda Gorgonzola'),
('Yu Yanli'),
('Carlina Herrera'),
('Padma Bigfoot'),
('Sandra Sangría'),
('Yuri Rodan'),
('Kim Kimchi');

CREATE TABLE MAQUINAS_REGISTRADORAS (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio INT,
    Piso INT
);

INSERT INTO MAQUINAS_REGISTRADORAS (Nombre, Precio, Piso) VALUES
('Máquina 80', 500, 1),
('Máquina 91', 600, 2),
('Máquina 46', 550, 1),
('Máquina 72', 700, 2),
('Máquina 64', 480, 1),
('Máquina 50', 520, 2),
('Máquina 08', 600, 1),
('Máquina 30', 550, 2),
('Máquina 20', 530, 1),
('Máquina 10', 580, 2);
CREATE TABLE PRODUCTOS (
    Cajero INT,
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Maquina INT,
    Producto INT,
    FOREIGN KEY (Cajero) REFERENCES CAJEROS(Codigo),
    FOREIGN KEY (Maquina) REFERENCES MAQUINAS_REGISTRADORAS(Codigo)
);
INSERT INTO PRODUCTOS (Cajero, Maquina, Producto) VALUES
(1, 1, 1001),
(2, 2, 1002),
(3, 3, 1003),
(4, 4, 1004),
(5, 5, 1005),
(6, 6, 1006),
(7, 7, 1007),
(8, 8, 1008),
(9, 9, 1009),
(10, 10, 1010);
CREATE TABLE VENTA (
    Cajero INT,
    Maquina INT,
    Producto INT,
    FOREIGN KEY (Cajero) REFERENCES CAJEROS(Codigo),
    FOREIGN KEY (Maquina) REFERENCES MAQUINAS_REGISTRADORAS(Codigo),
    FOREIGN KEY (Producto) REFERENCES PRODUCTOS(Codigo)
);

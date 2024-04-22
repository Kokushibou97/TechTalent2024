CREATE TABLE Almacenes (
    Codigo int PRIMARY KEY AUTO_INCREMENT,
    Lugar varchar(100),
    Capacidad int
);

CREATE TABLE CAJAS (
    NumReferencia char(5) PRIMARY KEY,
    Contenido varchar(100),
    Valor int,
    Almacen int,
    FOREIGN KEY (Almacen) REFERENCES Almacenes(Codigo)
);

INSERT INTO Almacenes (Lugar, Capacidad) VALUES
('Tarragona', 20),
('Madrid', 30),
('Murcia', 25),
('Valencia', 15),
('Barcelona', 10);

INSERT INTO CAJAS (NumReferencia, Contenido, Valor, Almacen) VALUES
('Z6201', 'Dieta', 200, 1),
('W7835', 'Ropa', 100, 2),
('X1489', 'Papeleria', 300, 3),
('Y4656', 'Jardenería', 150, 4),
('V8466', 'Utensilios', 120, 5),
('UH212', 'Electrodomestico', 180, 1),
('SG655', 'Herramientas', 250, 2),
('H0000', 'Muebles', 350, 3),
('Q1234', 'Mascotas', 180, 4),
('POO32', 'Otros', 130, 5);
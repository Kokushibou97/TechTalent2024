CREATE TABLE Fabricantes (
    Codigo int PRIMARY KEY AUTO_INCREMENT,
    Nombre nvarchar(100)
);

CREATE TABLE Articulos (
    Codigo int PRIMARY KEY AUTO_INCREMENT,
    Nombre nvarchar(100),
    Precio int,
    Fabricante int,
    FOREIGN KEY (Fabricante) REFERENCES Fabricantes(Codigo)
);

INSERT INTO Fabricantes (Nombre) VALUES
('Deliplus'),
('Danone'),
('chubb parsi'),
('Toshiba'),
('Xiaomi'),
('Universidades'),
('VichiCatalana'),
('H&M'),
('Ikea'),
('Yelmo Cines');

INSERT INTO Articulos (Nombre, Precio, Fabricante) VALUES
('Gel de baño', 150, 1),
('Yogurt sabor chocolate', 180, 2),
('Extintores', 220, 3),
('Ordenadores', 80, 4),
('Mobiles', 100, 5),
('Desempleados', 200, 6),
('Agua embotellada', 90, 7),
('Ropa', 120, 8),
('Muebles', 250, 9),
('Espacio Publico para la visualización del material audiovisual', 130, 10);

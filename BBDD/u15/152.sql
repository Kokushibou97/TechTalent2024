CREATE TABLE Piezas (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Nombre NVARCHAR(100)
);
INSERT INTO Piezas (Nombre) VALUES
('Pieza F'),
('Pieza U'),
('Pieza M'),
('Pieza D'),
('Pieza K'),
('Pieza L'),
('Pieza J'),
('Pieza G'),
('Pieza O'),
('Pieza P');
CREATE TABLE Proveedores (
    Codigo CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio INT
);
INSERT INTO Proveedores (Codigo, Nombre, Precio) VALUES
('A1000', 'Proveedor 1', 110),
('B2001', 'Proveedor 2', 125),
('C3001', 'Proveedor 3', 93),
('D4001', 'Proveedor 4', 130),
('E5001', 'Proveedor 5', 96),
('F6001', 'Proveedor 6', 142),
('H7001', 'Proveedor 7', 115),
('I8001', 'Proveedor 8', 135),
('P9001', 'Proveedor 9', 195),
('V0230', 'Proveedor 10', 80);
CREATE TABLE SUMINISTRA (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    CodigoPieza INT,
    IdProveedor CHAR(4),
    FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo),
    FOREIGN KEY (IdProveedor) REFERENCES Proveedores(Codigo)
);
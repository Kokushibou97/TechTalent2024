-- Crear la tabla PIEZAS
CREATE TABLE PIEZAS (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Nombre NVARCHAR(100)
);

-- Crear la tabla PROVEEDORES
CREATE TABLE PROVEEDORES (
    Id CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(100),
    Precio INT
);

-- Crear la tabla SUMINISTRA
CREATE TABLE SUMINISTRA (
    CodigoPieza INT,
    IdProveedor CHAR(4),
    Precio INT,
    PRIMARY KEY (CodigoPieza, IdProveedor),
    FOREIGN KEY (CodigoPieza) REFERENCES PIEZAS(Codigo),
    FOREIGN KEY (IdProveedor) REFERENCES PROVEEDORES(Id)
);

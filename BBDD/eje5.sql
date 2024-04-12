-- Crear la tabla ALMACENES
CREATE TABLE ALMACENES (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Lugar NVARCHAR(100),
    Capacidad INT
);

-- Crear la tabla CAJAS
CREATE TABLE CAJAS (
    NumReferencia CHAR(5) PRIMARY KEY,
    Contenido NVARCHAR(100),
    Valor INT,
    Almacen INT,
    FOREIGN KEY (Almacen) REFERENCES ALMACENES(Codigo)
);

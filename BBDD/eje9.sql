-- Crear la tabla PELICULAS
CREATE TABLE PELICULAS (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Nombre NVARCHAR(100),
    CalificacionEdad INT
);
-- Crear la tabla SALAS
CREATE TABLE SALAS (
    Codigo INT AUTO_INCREMENT PRIMARY KEY,
    Nombre NVARCHAR(100),
    Pelicula INT,
    FOREIGN KEY (Pelicula) REFERENCES PELICULAS(Codigo)
);

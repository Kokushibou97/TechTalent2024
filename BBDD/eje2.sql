
CREATE TABLE Tema (
    ClaveTema INT PRIMARY KEY,
    Nombre VARCHAR(40)
);

CREATE TABLE Autor (
    ClaveAutor INT PRIMARY KEY,
    Nombre VARCHAR(60)
);

CREATE TABLE Editorial (
    ClaveEditorial SMALLINT PRIMARY KEY,
    Nombre VARCHAR(60),
    Dirección VARCHAR(60),
    Teléfono VARCHAR(15)
);

CREATE TABLE Libro (
    ClaveLibro INT PRIMARY KEY,
    Título VARCHAR(60),
    Idioma VARCHAR(15),
    Formato VARCHAR(15),
    ClaveEditorial SMALLINT,
    FOREIGN KEY (ClaveEditorial) REFERENCES Editorial(ClaveEditorial)
);

CREATE TABLE Ejemplar (
    ClaveEjemplar INT PRIMARY KEY,
    ClaveLibro INT,
    NúmeroOrden SMALLINT,
    Edición SMALLINT,
    Ubicación VARCHAR(15),
    Categoría CHAR,
    FOREIGN KEY (ClaveLibro) REFERENCES Libro(ClaveLibro)
);

CREATE TABLE Socio (
    ClaveSocio INT PRIMARY KEY,
    Nombre VARCHAR(60),
    Dirección VARCHAR(60),
    Teléfono VARCHAR(15),
    Categoría CHAR
);


CREATE TABLE Préstamo (
    ClaveSocio INT,
    ClaveEjemplar INT,
    NúmeroOrden SMALLINT,
    Fecha_préstamo DATE,
    Fecha_devolución DATE,
    Notas BLOB,
    FOREIGN KEY (ClaveSocio) REFERENCES Socio(ClaveSocio),
    FOREIGN KEY (ClaveEjemplar) REFERENCES Ejemplar(ClaveEjemplar)
);

CREATE TABLE Trata_sobre (
    ClaveLibro INT,
    ClaveTema INT,
    FOREIGN KEY (ClaveLibro) REFERENCES Libro(ClaveLibro),
    FOREIGN KEY (ClaveTema) REFERENCES Tema(ClaveTema)
);

CREATE TABLE Escrito_por (
    ClaveLibro INT,
    ClaveAutor INT,
    Tipo CHAR,
    FOREIGN KEY (ClaveLibro) REFERENCES Libro(ClaveLibro),
    FOREIGN KEY (ClaveAutor) REFERENCES Autor(ClaveAutor)
);


CREATE TABLE Estación (
    Identificador INT PRIMARY KEY,
    Latitud FLOAT,
    Longitud FLOAT,
    Altitud FLOAT
);


CREATE TABLE Muestra (
    IdentificadorEstacion INT,
    Fecha DATE,
    Temperatura_min FLOAT,
    Temperatura_max FLOAT,
    Precipitaciones FLOAT,
    Humedad_min FLOAT,
    Humedad_max FLOAT,
    Velocidad_viento_min FLOAT,
    Velocidad_viento_max FLOAT,
    FOREIGN KEY (IdentificadorEstacion) REFERENCES Estación(Identificador)
);

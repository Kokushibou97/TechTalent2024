-- Drop the Empleados table
DROP TABLE IF EXISTS Empleados;

-- Remove the foreign key constraint temporarily
ALTER TABLE Empleados DROP FOREIGN KEY FK_Departamento;


DROP TABLE IF EXISTS Departamentos;


CREATE TABLE Departamentos (
    Codigo INT PRIMARY KEY,
    Nombre NVARCHAR(70),
    Presupuesto INT
);


TRUNCATE TABLE Empleados;


CREATE TABLE Empleados (
    DNI VARCHAR(8) PRIMARY KEY,
    Nombre FLOAT(20),
    Apellidos NVARCHAR(255),
    FK1_Departamento INT,
    CONSTRAINT FK_Departamento FOREIGN KEY (FK1_Departamento) REFERENCES Departamentos(Codigo)
);


TRUNCATE TABLE Departamentos;


INSERT INTO Departamentos (Codigo, Nombre, Presupuesto) VALUES
(1, 'Seguridad y Salud', 50000),
(2, 'IT', 60000),
(3, 'Recursos Humanos', 80000),
(4, 'Proyectos', 40000),
(5, 'Contabilidad', 70000);


INSERT INTO Empleados (DNI, Nombre, Apellidos, FK1_Departamento) VALUES
('12345678', 'Martu', 'Chimichurri', 3),
('23456789', 'Maria', 'Santa', 1),
('34567890', 'Shufei', 'Yang', 2),
('45678901', 'Carmona', 'Bombona', 3),
('56789012', 'Julian', 'Vergonzola', 4),
('67890123', 'Lorena', 'Eltemor', 5),
('78901234', 'Davide', 'Bajos', 1),
('89012345', 'Soria', 'Catalana', 2),
('90123456', 'Leweve', 'Perfumado', 3),
('01234567', 'Marcon', 'Zorron', 4);


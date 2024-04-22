CREATE TABLE Empleados (
    DNI varchar(9) PRIMARY KEY,
    Nombre nvarchar(100),
    Apellidos nvarchar(255),
    Departamento int,
    FOREIGN KEY (Departamento) REFERENCES Departamentos(Codigo)
);

CREATE TABLE Departamentos (
    Codigo varchar(8) PRIMARY KEY,
    Nombre nvarchar(100),
    Presupuesto int
);

INSERT INTO Departamentos (Codigo, Nombre, Presupuesto) VALUES
('14', 'D.proyectos', 50000),
('37', 'D.contabilidad', 70000),
('77', 'D.HR', 80000),
('11', 'D.Calidad', 40000);

INSERT INTO Empleados (DNI, Nombre, Apellidos, Departamento) VALUES
('11111111A', 'Juan', 'Jarron', '14'),
('22222222B', 'Mariano', 'Mereketengue', '37'),
('33333333C', 'Palomo', 'Malomo', '77'),
('44444444D', 'Marimar', 'Vergas', '14'),
('55555555E', 'Jorge', 'Chungo', '37'),
('66666666F', 'Sarai', 'Armay', '14'),
('77777777G', 'Carucha', 'Defresado', '77'),
('88888888H', 'Laurinda', 'Barbara', '37'),
('99999999I', 'Cristian', 'Pintado', '14'),
('89267109', 'Kolin', 'Lloron', '11');
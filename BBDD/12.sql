DROP TABLE IF EXISTS Profesores;
CREATE TABLE Profesores (
    DNI VARCHAR(10) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido1 VARCHAR(50),
    Apellido2 VARCHAR(50),
    Direccion VARCHAR(100),
    Titulo VARCHAR(100),
    Gana DECIMAL(10, 2)
);
DROP TABLE IF EXISTS Cursos;
CREATE TABLE Cursos (
    Codigo_curso INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_curso VARCHAR(100),
    DNI_profesor VARCHAR(10),
    Maximo_alumnos INT,
    Fecha_inicio DATE,
    Fecha_fin DATE,
    Num_horas INT,
    FOREIGN KEY (DNI_profesor) REFERENCES Profesores(DNI)
);
DROP TABLE IF EXISTS  Alumnos;
CREATE TABLE Alumnos (
    Codigo_alumno INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido1 VARCHAR(50),
    Apellido2 VARCHAR(50),
    DNI VARCHAR(10),
    Direccion VARCHAR(100),
    Sexo CHAR(1),
    Fecha_Nacimiento DATE,
    Curso_cod INT,
    FOREIGN KEY (Curso_cod) REFERENCES Cursos(Codigo_curso)
);

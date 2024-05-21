package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class EmpleadosporDepartamentos {
	  private static final String URL = "jdbc:mysql://localhost:3306";
	    private static final String USER = "root";
	    private static final String PASSWORD = "";
	    // JDBC variables for opening and managing connection
	    private static Connection con;
	    private static Statement stmt;

	    public static void main(String[] args) {
	        String dbName = "EmpleadosDB";
	        
	        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
	        String useDatabaseSQL = "USE " + dbName;

	        String createTableDepartamentosSQL = "CREATE TABLE IF NOT EXISTS DEPARTAMENTOS ("
	                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
	                + "Nombre NVARCHAR(100) NOT NULL,"
	                + "Presupuesto INT NOT NULL"
	                + ")";

	        String createTableEmpleadosSQL = "CREATE TABLE IF NOT EXISTS EMPLEADOS ("
	                + "DNI VARCHAR(8) PRIMARY KEY,"
	                + "Nombre NVARCHAR(100) NOT NULL,"
	                + "Apellidos NVARCHAR(255) NOT NULL,"
	                + "Departamento INT,"
	                + "FOREIGN KEY (Departamento) REFERENCES DEPARTAMENTOS(Codigo)"
	                + ")";

	        String[] insertDepartamentosSQL = {
	                "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES ('Recursos Humanos', 500000)",
	                "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES ('IT', 1500000)",
	                "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES ('Marketing', 300000)",
	                "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES ('Ventas', 400000)",
	                "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES ('Administración', 200000)"
	        };

	        String[] insertEmpleadosSQL = {
	                "INSERT INTO EMPLEADOS (DNI, Nombre, Apellidos, Departamento) VALUES ('12345678', 'Juan', 'Pérez', 1)",
	                "INSERT INTO EMPLEADOS (DNI, Nombre, Apellidos, Departamento) VALUES ('23456789', 'Ana', 'García', 2)",
	                "INSERT INTO EMPLEADOS (DNI, Nombre, Apellidos, Departamento) VALUES ('34567890', 'Luis', 'Martínez', 3)",
	                "INSERT INTO EMPLEADOS (DNI, Nombre, Apellidos, Departamento) VALUES ('45678901', 'María', 'López', 4)",
	                "INSERT INTO EMPLEADOS (DNI, Nombre, Apellidos, Departamento) VALUES ('56789012', 'Carlos', 'Gómez', 5)"
	        };

	        try {
	            // Opening database connection
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	            stmt = con.createStatement();

	            // Creating the database
	            stmt.executeUpdate(createDatabaseSQL);

	            // Using the newly created database
	            stmt.executeUpdate(useDatabaseSQL);

	            // Creating the tables
	            stmt.executeUpdate(createTableDepartamentosSQL);
	            stmt.executeUpdate(createTableEmpleadosSQL);

	            // Inserting records into DEPARTAMENTOS
	            for (String sql : insertDepartamentosSQL) {
	                stmt.executeUpdate(sql);
	            }

	            // Inserting records into EMPLEADOS
	            for (String sql : insertEmpleadosSQL) {
	                stmt.executeUpdate(sql);
	            }

	            System.out.println("Database, tables created, and records inserted successfully.");

	        } catch (SQLException sqlEx) {
	            sqlEx.printStackTrace();
	        } finally {
	            // Close connection and statement
	            try {
	                con.close();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	            try {
	                stmt.close();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    }
	}

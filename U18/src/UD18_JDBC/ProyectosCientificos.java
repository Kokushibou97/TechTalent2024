package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ProyectosCientificos {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    private static Statement stmt;
    
    public static void main(String[] args) {
        String dbName = "CientificosDB";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableCientificosSQL = "CREATE TABLE IF NOT EXISTS CIENTIFICOS ("
                + "DNI VARCHAR(8) PRIMARY KEY,"
                + "NomApels NVARCHAR(255) NOT NULL"
                + ")";

        String createTableProyectoSQL = "CREATE TABLE IF NOT EXISTS PROYECTO ("
                + "Id CHAR(4) PRIMARY KEY,"
                + "Nombre NVARCHAR(255) NOT NULL,"
                + "Horas INT NOT NULL"
                + ")";

        String createTableAsignadoASQL = "CREATE TABLE IF NOT EXISTS ASIGNADO_A ("
                + "Cientifico VARCHAR(8),"
                + "Proyecto CHAR(4),"
                + "PRIMARY KEY (Cientifico, Proyecto),"
                + "FOREIGN KEY (Cientifico) REFERENCES CIENTIFICOS(DNI),"
                + "FOREIGN KEY (Proyecto) REFERENCES PROYECTO(Id)"
                + ")";

        String[] insertCientificosSQL = {
                "INSERT INTO CIENTIFICOS (DNI, NomApels) VALUES ('12345678', 'Juan Pérez')",
                "INSERT INTO CIENTIFICOS (DNI, NomApels) VALUES ('23456789', 'Ana García')",
                "INSERT INTO CIENTIFICOS (DNI, NomApels) VALUES ('34567890', 'Luis Martínez')",
                "INSERT INTO CIENTIFICOS (DNI, NomApels) VALUES ('45678901', 'María López')",
                "INSERT INTO CIENTIFICOS (DNI, NomApels) VALUES ('56789012', 'Carlos Gómez')"
        };

        String[] insertProyectoSQL = {
                "INSERT INTO PROYECTO (Id, Nombre, Horas) VALUES ('P001', 'Proyecto 1', 100)",
                "INSERT INTO PROYECTO (Id, Nombre, Horas) VALUES ('P002', 'Proyecto 2', 200)",
                "INSERT INTO PROYECTO (Id, Nombre, Horas) VALUES ('P003', 'Proyecto 3', 150)",
                "INSERT INTO PROYECTO (Id, Nombre, Horas) VALUES ('P004', 'Proyecto 4', 120)",
                "INSERT INTO PROYECTO (Id, Nombre, Horas) VALUES ('P005', 'Proyecto 5', 300)"
        };

        String[] insertAsignadoASQL = {
                "INSERT INTO ASIGNADO_A (Cientifico, Proyecto) VALUES ('12345678', 'P001')",
                "INSERT INTO ASIGNADO_A (Cientifico, Proyecto) VALUES ('23456789', 'P002')",
                "INSERT INTO ASIGNADO_A (Cientifico, Proyecto) VALUES ('34567890', 'P003')",
                "INSERT INTO ASIGNADO_A (Cientifico, Proyecto) VALUES ('45678901', 'P004')",
                "INSERT INTO ASIGNADO_A (Cientifico, Proyecto) VALUES ('56789012', 'P005')"
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
            stmt.executeUpdate(createTableCientificosSQL);
            stmt.executeUpdate(createTableProyectoSQL);
            stmt.executeUpdate(createTableAsignadoASQL);

            // Inserting records into CIENTIFICOS
            for (String sql : insertCientificosSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into PROYECTO
            for (String sql : insertProyectoSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into ASIGNADO_A
            for (String sql : insertAsignadoASQL) {
                stmt.executeUpdate(sql);
            }

            System.out.println("Database, tables created, and records inserted successfully.");

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            // Close connection and statement
            try {
                if (con != null) {
                    con.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

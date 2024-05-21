package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DirectoresDespachos {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    private static Statement stmt;
    
    public static void main(String[] args) {
        String dbName = "DirectoresDB";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableDespachosSQL = "CREATE TABLE IF NOT EXISTS DESPACHOS ("
                + "Numero INT PRIMARY KEY,"
                + "Capacidad INT NOT NULL"
                + ")";

        String createTableDirectoresSQL = "CREATE TABLE IF NOT EXISTS DIRECTORES ("
                + "DNI VARCHAR(8) PRIMARY KEY,"
                + "NomApels NVARCHAR(255) NOT NULL,"
                + "DNIJefe VARCHAR(8),"
                + "Despacho INT,"
                + "FOREIGN KEY (DNIJefe) REFERENCES DIRECTORES(DNI),"
                + "FOREIGN KEY (Despacho) REFERENCES DESPACHOS(Numero)"
                + ")";

        String[] insertDespachosSQL = {
                "INSERT INTO DESPACHOS (Numero, Capacidad) VALUES (101, 4)",
                "INSERT INTO DESPACHOS (Numero, Capacidad) VALUES (102, 3)",
                "INSERT INTO DESPACHOS (Numero, Capacidad) VALUES (103, 2)",
                "INSERT INTO DESPACHOS (Numero, Capacidad) VALUES (104, 5)",
                "INSERT INTO DESPACHOS (Numero, Capacidad) VALUES (105, 3)"
        };

        String[] insertDirectoresSQL = {
                "INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES ('12345678', 'Juan Pérez', NULL, 101)",
                "INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES ('23456789', 'Ana García', '12345678', 102)",
                "INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES ('34567890', 'Luis Martínez', '12345678', 103)",
                "INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES ('45678901', 'María López', '23456789', 104)",
                "INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES ('56789012', 'Carlos Gómez', '34567890', 105)"
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
            stmt.executeUpdate(createTableDespachosSQL);
            stmt.executeUpdate(createTableDirectoresSQL);

            // Inserting records into DESPACHOS
            for (String sql : insertDespachosSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into DIRECTORES
            for (String sql : insertDirectoresSQL) {
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

package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Tiendainformatica {
	 // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
 // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;

    public static void main(String[] args) {
        String dbName = "tiendaInformatica";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableFabricantesSQL = "CREATE TABLE IF NOT EXISTS FABRICANTES ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL"
                + ")";

        String createTableArticulosSQL = "CREATE TABLE IF NOT EXISTS ARTICULOS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Precio INT NOT NULL,"
                + "Fabricante INT,"
                + "FOREIGN KEY (Fabricante) REFERENCES FABRICANTES(Codigo)"
                + ")";

        String[] insertFabricantesSQL = {
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante A')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante B')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante C')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante D')",
                "INSERT INTO FABRICANTES (Nombre) VALUES ('Fabricante E')"
        };

        String[] insertArticulosSQL = {
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 1', 100, 1)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 2', 200, 2)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 3', 300, 3)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 4', 400, 4)",
                "INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Articulo 5', 500, 5)"
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
            stmt.executeUpdate(createTableFabricantesSQL);
            stmt.executeUpdate(createTableArticulosSQL);

            // Inserting records into FABRICANTES
            for (String sql : insertFabricantesSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into ARTICULOS
            for (String sql : insertArticulosSQL) {
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



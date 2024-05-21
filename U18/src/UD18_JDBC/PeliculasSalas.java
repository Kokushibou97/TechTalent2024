package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class PeliculasSalas {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    private static Statement stmt;

    public static void main(String[] args) {
        String dbName = "PeliculasSalasDB";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTablePeliculasSQL = "CREATE TABLE IF NOT EXISTS PELICULAS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "CalificacionEdad INT NOT NULL"
                + ")";

        String createTableSalasSQL = "CREATE TABLE IF NOT EXISTS SALAS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Pelicula INT,"
                + "FOREIGN KEY (Pelicula) REFERENCES PELICULAS(Codigo)"
                + ")";

        String[] insertPeliculasSQL = {
                "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES ('Pelicula 1', 13)",
                "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES ('Pelicula 2', 16)",
                "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES ('Pelicula 3', 18)",
                "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES ('Pelicula 4', 7)",
                "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES ('Pelicula 5', 12)"
        };

        String[] insertSalasSQL = {
                "INSERT INTO SALAS (Nombre, Pelicula) VALUES ('Sala 1', 1)",
                "INSERT INTO SALAS (Nombre, Pelicula) VALUES ('Sala 2', 2)",
                "INSERT INTO SALAS (Nombre, Pelicula) VALUES ('Sala 3', 3)",
                "INSERT INTO SALAS (Nombre, Pelicula) VALUES ('Sala 4', 4)",
                "INSERT INTO SALAS (Nombre, Pelicula) VALUES ('Sala 5', 5)"
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
            stmt.executeUpdate(createTablePeliculasSQL);
            stmt.executeUpdate(createTableSalasSQL);

            // Inserting records into PELICULAS
            for (String sql : insertPeliculasSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into SALAS
            for (String sql : insertSalasSQL) {
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

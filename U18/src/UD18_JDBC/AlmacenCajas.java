package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class AlmacenCajas {
	  private static final String URL = "jdbc:mysql://localhost:3306";
	    private static final String USER = "root";
	    private static final String PASSWORD = "";
	    

	    // JDBC variables for opening and managing connection
	    private static Connection con;
	    private static Statement stmt;

	    public static void main(String[] args) {
	        String dbName = "AlmacenesDB";
	        
	        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
	        String useDatabaseSQL = "USE " + dbName;

	        String createTableAlmacenesSQL = "CREATE TABLE IF NOT EXISTS ALMACENES ("
	                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
	                + "Lugar NVARCHAR(100) NOT NULL,"
	                + "Capacidad INT NOT NULL"
	                + ")";

	        String createTableCajasSQL = "CREATE TABLE IF NOT EXISTS CAJAS ("
	                + "NumReferencia CHAR(5) PRIMARY KEY,"
	                + "Contenido NVARCHAR(100) NOT NULL,"
	                + "Valor INT NOT NULL,"
	                + "Almacen INT,"
	                + "FOREIGN KEY (Almacen) REFERENCES ALMACENES(Codigo)"
	                + ")";

	        String[] insertAlmacenesSQL = {
	                "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Madrid', 1000)",
	                "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Barcelona', 800)",
	                "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Valencia', 600)",
	                "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Sevilla', 700)",
	                "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES ('Bilbao', 500)"
	        };

	        String[] insertCajasSQL = {
	                "INSERT INTO CAJAS (NumReferencia, Contenido, Valor, Almacen) VALUES ('A001', 'Ropa', 100, 1)",
	                "INSERT INTO CAJAS (NumReferencia, Contenido, Valor, Almacen) VALUES ('A002', 'Electrónica', 200, 2)",
	                "INSERT INTO CAJAS (NumReferencia, Contenido, Valor, Almacen) VALUES ('A003', 'Juguetes', 150, 3)",
	                "INSERT INTO CAJAS (NumReferencia, Contenido, Valor, Almacen) VALUES ('A004', 'Libros', 120, 4)",
	                "INSERT INTO CAJAS (NumReferencia, Contenido, Valor, Almacen) VALUES ('A005', 'Muebles', 300, 5)"
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
	            stmt.executeUpdate(createTableAlmacenesSQL);
	            stmt.executeUpdate(createTableCajasSQL);

	            // Inserting records into ALMACENES
	            for (String sql : insertAlmacenesSQL) {
	                stmt.executeUpdate(sql);
	            }

	            // Inserting records into CAJAS
	            for (String sql : insertCajasSQL) {
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

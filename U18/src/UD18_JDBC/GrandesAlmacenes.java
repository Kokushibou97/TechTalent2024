package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class GrandesAlmacenes {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    private static Statement stmt;
    public static void main(String[] args) {
        String dbName = "GrandesAlmacenesDB";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableProductosSQL = "CREATE TABLE IF NOT EXISTS PRODUCTOS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Precio INT NOT NULL"
                + ")";

        String createTableCajerosSQL = "CREATE TABLE IF NOT EXISTS CAJEROS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "NomApels NVARCHAR(255) NOT NULL"
                + ")";

        String createTableMaquinasRegistradorasSQL = "CREATE TABLE IF NOT EXISTS MAQUINAS_REGISTRADORAS ("
                + "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "Piso INT NOT NULL"
                + ")";

        String createTableVentaSQL = "CREATE TABLE IF NOT EXISTS VENTA ("
                + "Cajero INT,"
                + "Maquina INT,"
                + "Producto INT,"
                + "PRIMARY KEY (Cajero, Maquina, Producto),"
                + "FOREIGN KEY (Cajero) REFERENCES CAJEROS(Codigo),"
                + "FOREIGN KEY (Maquina) REFERENCES MAQUINAS_REGISTRADORAS(Codigo),"
                + "FOREIGN KEY (Producto) REFERENCES PRODUCTOS(Codigo)"
                + ")";

        String[] insertProductosSQL = {
                "INSERT INTO PRODUCTOS (Nombre, Precio) VALUES ('Producto 1', 100)",
                "INSERT INTO PRODUCTOS (Nombre, Precio) VALUES ('Producto 2', 200)",
                "INSERT INTO PRODUCTOS (Nombre, Precio) VALUES ('Producto 3', 150)",
                "INSERT INTO PRODUCTOS (Nombre, Precio) VALUES ('Producto 4', 120)",
                "INSERT INTO PRODUCTOS (Nombre, Precio) VALUES ('Producto 5', 300)"
        };

        String[] insertCajerosSQL = {
                "INSERT INTO CAJEROS (NomApels) VALUES ('Juan Pérez')",
                "INSERT INTO CAJEROS (NomApels) VALUES ('Ana García')",
                "INSERT INTO CAJEROS (NomApels) VALUES ('Luis Martínez')",
                "INSERT INTO CAJEROS (NomApels) VALUES ('María López')",
                "INSERT INTO CAJEROS (NomApels) VALUES ('Carlos Gómez')"
        };

        String[] insertMaquinasRegistradorasSQL = {
                "INSERT INTO MAQUINAS_REGISTRADORAS (Piso) VALUES (1)",
                "INSERT INTO MAQUINAS_REGISTRADORAS (Piso) VALUES (2)",
                "INSERT INTO MAQUINAS_REGISTRADORAS (Piso) VALUES (3)",
                "INSERT INTO MAQUINAS_REGISTRADORAS (Piso) VALUES (4)",
                "INSERT INTO MAQUINAS_REGISTRADORAS (Piso) VALUES (5)"
        };

        String[] insertVentaSQL = {
                "INSERT INTO VENTA (Cajero, Maquina, Producto) VALUES (1, 1, 1)",
                "INSERT INTO VENTA (Cajero, Maquina, Producto) VALUES (2, 2, 2)",
                "INSERT INTO VENTA (Cajero, Maquina, Producto) VALUES (3, 3, 3)",
                "INSERT INTO VENTA (Cajero, Maquina, Producto) VALUES (4, 4, 4)",
                "INSERT INTO VENTA (Cajero, Maquina, Producto) VALUES (5, 5, 5)"
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
            stmt.executeUpdate(createTableProductosSQL);
            stmt.executeUpdate(createTableCajerosSQL);
            stmt.executeUpdate(createTableMaquinasRegistradorasSQL);
            stmt.executeUpdate(createTableVentaSQL);

            // Inserting records into PRODUCTOS
            for (String sql : insertProductosSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into CAJEROS
            for (String sql : insertCajerosSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into MAQUINAS_REGISTRADORAS
            for (String sql : insertMaquinasRegistradorasSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into VENTA
            for (String sql : insertVentaSQL) {
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

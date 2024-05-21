package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class PizzaProveedores {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    private static Statement stmt;
    

    public static void main(String[] args) {
        String dbName = "PiezasProveedoresDB";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableProveedoresSQL = "CREATE TABLE IF NOT EXISTS PROVEEDORES ("
                + "Id CHAR(4) PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL"
                + ")";

        String createTablePiezasSQL = "CREATE TABLE IF NOT EXISTS PIEZAS ("
                + "Codigo CHAR(4) PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Precio INT NOT NULL"
                + ")";

        String createTableSuministraSQL = "CREATE TABLE IF NOT EXISTS SUMINISTRA ("
                + "CodigoPieza CHAR(4),"
                + "IdProveedor CHAR(4),"
                + "PRIMARY KEY (CodigoPieza, IdProveedor),"
                + "FOREIGN KEY (CodigoPieza) REFERENCES PIEZAS(Codigo),"
                + "FOREIGN KEY (IdProveedor) REFERENCES PROVEEDORES(Id)"
                + ")";

        String[] insertProveedoresSQL = {
                "INSERT INTO PROVEEDORES (Id, Nombre) VALUES ('P001', 'Proveedor 1')",
                "INSERT INTO PROVEEDORES (Id, Nombre) VALUES ('P002', 'Proveedor 2')",
                "INSERT INTO PROVEEDORES (Id, Nombre) VALUES ('P003', 'Proveedor 3')",
                "INSERT INTO PROVEEDORES (Id, Nombre) VALUES ('P004', 'Proveedor 4')",
                "INSERT INTO PROVEEDORES (Id, Nombre) VALUES ('P005', 'Proveedor 5')"
        };

        String[] insertPiezasSQL = {
                "INSERT INTO PIEZAS (Codigo, Nombre, Precio) VALUES ('A001', 'Pieza 1', 100)",
                "INSERT INTO PIEZAS (Codigo, Nombre, Precio) VALUES ('A002', 'Pieza 2', 200)",
                "INSERT INTO PIEZAS (Codigo, Nombre, Precio) VALUES ('A003', 'Pieza 3', 150)",
                "INSERT INTO PIEZAS (Codigo, Nombre, Precio) VALUES ('A004', 'Pieza 4', 120)",
                "INSERT INTO PIEZAS (Codigo, Nombre, Precio) VALUES ('A005', 'Pieza 5', 300)"
        };

        String[] insertSuministraSQL = {
                "INSERT INTO SUMINISTRA (CodigoPieza, IdProveedor) VALUES ('A001', 'P001')",
                "INSERT INTO SUMINISTRA (CodigoPieza, IdProveedor) VALUES ('A002', 'P002')",
                "INSERT INTO SUMINISTRA (CodigoPieza, IdProveedor) VALUES ('A003', 'P003')",
                "INSERT INTO SUMINISTRA (CodigoPieza, IdProveedor) VALUES ('A004', 'P004')",
                "INSERT INTO SUMINISTRA (CodigoPieza, IdProveedor) VALUES ('A005', 'P005')"
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
            stmt.executeUpdate(createTableProveedoresSQL);
            stmt.executeUpdate(createTablePiezasSQL);
            stmt.executeUpdate(createTableSuministraSQL);

            // Inserting records into PROVEEDORES
            for (String sql : insertProveedoresSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into PIEZAS
            for (String sql : insertPiezasSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into SUMINISTRA
            for (String sql : insertSuministraSQL) {
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

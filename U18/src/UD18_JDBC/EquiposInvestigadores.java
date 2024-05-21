package UD18_JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class EquiposInvestigadores {
	private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    private static Statement stmt;
    
    public static void main(String[] args) {
        String dbName = "InvestigadoresDB";
        
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
        String useDatabaseSQL = "USE " + dbName;

        String createTableFacultadSQL = "CREATE TABLE IF NOT EXISTS FACULTAD ("
                + "Codigo INT PRIMARY KEY AUTO_INCREMENT,"
                + "Nombre NVARCHAR(100) NOT NULL"
                + ")";

        String createTableInvestigadoresSQL = "CREATE TABLE IF NOT EXISTS INVESTIGADORES ("
                + "DNI VARCHAR(8) PRIMARY KEY,"
                + "NomApels NVARCHAR(255) NOT NULL,"
                + "Facultad INT,"
                + "FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)"
                + ")";

        String createTableEquiposSQL = "CREATE TABLE IF NOT EXISTS EQUIPOS ("
                + "NumSerie CHAR(4) PRIMARY KEY,"
                + "Nombre NVARCHAR(100) NOT NULL,"
                + "Facultad INT,"
                + "FOREIGN KEY (Facultad) REFERENCES FACULTAD(Codigo)"
                + ")";

        String createTableReservaSQL = "CREATE TABLE IF NOT EXISTS RESERVA ("
                + "DNI VARCHAR(8),"
                + "NumSerie CHAR(4),"
                + "Comienzo DATETIME NOT NULL,"
                + "Fin DATETIME NOT NULL,"
                + "PRIMARY KEY (DNI, NumSerie),"
                + "FOREIGN KEY (DNI) REFERENCES INVESTIGADORES(DNI),"
                + "FOREIGN KEY (NumSerie) REFERENCES EQUIPOS(NumSerie)"
                + ")";

        String[] insertFacultadSQL = {
                "INSERT INTO FACULTAD (Nombre) VALUES ('Facultad de Ciencias')",
                "INSERT INTO FACULTAD (Nombre) VALUES ('Facultad de Ingeniería')",
                "INSERT INTO FACULTAD (Nombre) VALUES ('Facultad de Letras')",
                "INSERT INTO FACULTAD (Nombre) VALUES ('Facultad de Medicina')",
                "INSERT INTO FACULTAD (Nombre) VALUES ('Facultad de Derecho')"
        };

        String[] insertInvestigadoresSQL = {
                "INSERT INTO INVESTIGADORES (DNI, NomApels, Facultad) VALUES ('12345678', 'Juan Pérez', 1)",
                "INSERT INTO INVESTIGADORES (DNI, NomApels, Facultad) VALUES ('23456789', 'Ana García', 2)",
                "INSERT INTO INVESTIGADORES (DNI, NomApels, Facultad) VALUES ('34567890', 'Luis Martínez', 3)",
                "INSERT INTO INVESTIGADORES (DNI, NomApels, Facultad) VALUES ('45678901', 'María López', 4)",
                "INSERT INTO INVESTIGADORES (DNI, NomApels, Facultad) VALUES ('56789012', 'Carlos Gómez', 5)"
        };

        String[] insertEquiposSQL = {
                "INSERT INTO EQUIPOS (NumSerie, Nombre, Facultad) VALUES ('E001', 'Equipo 1', 1)",
                "INSERT INTO EQUIPOS (NumSerie, Nombre, Facultad) VALUES ('E002', 'Equipo 2', 2)",
                "INSERT INTO EQUIPOS (NumSerie, Nombre, Facultad) VALUES ('E003', 'Equipo 3', 3)",
                "INSERT INTO EQUIPOS (NumSerie, Nombre, Facultad) VALUES ('E004', 'Equipo 4', 4)",
                "INSERT INTO EQUIPOS (NumSerie, Nombre, Facultad) VALUES ('E005', 'Equipo 5', 5)"
        };

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = LocalDateTime.now().format(dtf);
        String later = LocalDateTime.now().plusHours(2).format(dtf);

        String[] insertReservaSQL = {
                "INSERT INTO RESERVA (DNI, NumSerie, Comienzo, Fin) VALUES ('12345678', 'E001', '" + now + "', '" + later + "')",
                "INSERT INTO RESERVA (DNI, NumSerie, Comienzo, Fin) VALUES ('23456789', 'E002', '" + now + "', '" + later + "')",
                "INSERT INTO RESERVA (DNI, NumSerie, Comienzo, Fin) VALUES ('34567890', 'E003', '" + now + "', '" + later + "')",
                "INSERT INTO RESERVA (DNI, NumSerie, Comienzo, Fin) VALUES ('45678901', 'E004', '" + now + "', '" + later + "')",
                "INSERT INTO RESERVA (DNI, NumSerie, Comienzo, Fin) VALUES ('56789012', 'E005', '" + now + "', '" + later + "')"
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
            stmt.executeUpdate(createTableFacultadSQL);
            stmt.executeUpdate(createTableInvestigadoresSQL);
            stmt.executeUpdate(createTableEquiposSQL);
            stmt.executeUpdate(createTableReservaSQL);

            // Inserting records into FACULTAD
            for (String sql : insertFacultadSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into INVESTIGADORES
            for (String sql : insertInvestigadoresSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into EQUIPOS
            for (String sql : insertEquiposSQL) {
                stmt.executeUpdate(sql);
            }

            // Inserting records into RESERVA
            for (String sql : insertReservaSQL) {
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

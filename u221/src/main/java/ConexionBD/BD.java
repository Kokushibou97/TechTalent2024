package ConexionBD;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class BD {
	    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
	    private static final String USUARIO = "usuario";
	    private static final String CONTRASENA = "contraseña";

	    public static Connection conectar() throws SQLException {
	        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
	    }
	}


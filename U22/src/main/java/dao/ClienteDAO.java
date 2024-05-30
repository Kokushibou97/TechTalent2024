package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    // Constructor y métodos de conexión

    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getDireccion());
            statement.setInt(4, cliente.getDni());
            statement.setDate(5, new java.sql.Date(cliente.getFecha().getTime()));
            statement.executeUpdate();
        }
    }

    public Cliente leerCliente(int id) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setFecha(resultSet.getDate("fecha"));
            }
        }
        return cliente;
    }

    // Métodos para actualizar y eliminar clientes
}

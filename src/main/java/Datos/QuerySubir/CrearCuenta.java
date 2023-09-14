package Datos.QuerySubir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearCuenta {
    private Connection connection;

    public CrearCuenta(Connection connection) {
        this.connection = connection;
    }


    public int crearCuenta(String CodigoCliente, String Fecha) throws SQLException {
        String sql = "INSERT INTO cuenta (CodigoCliente, fechaCreacion, saldo) VALUES (?, ?, 0)";
        System.out.println(sql);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, CodigoCliente);
            preparedStatement.setString(2, Fecha);

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                try (var resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                }
            }
            return -1;
        }
    }
}

package Datos.QuerySubir;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubirUsuario {
    private Connection connection;

    public SubirUsuario(Connection connection) {
        this.connection = connection;
    }

    public int insertarUsuario(String nombre, String direccion, String noIdentificacion, String sexo, String password, int tipoUsuario) throws SQLException {
        String sql = "INSERT INTO usuario (nombre, direccion, noIdentificacion, sexo, password, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, noIdentificacion);
            preparedStatement.setString(4, sexo);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, tipoUsuario);

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

package Datos.QueryActualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarTurno {
    private Connection connection;

    public ActualizarTurno(Connection connection) {
        this.connection = connection;
    }

    public void actualizarturno(String Codigo, String IDTunro) throws SQLException {
        String sql = "UPDATE empleado SET idTurno = ? WHERE  codigoUsuario = ? ";

        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, IDTunro);
            preparedStatement.setString(2, Codigo);
            preparedStatement.executeUpdate();
        }
    }

}

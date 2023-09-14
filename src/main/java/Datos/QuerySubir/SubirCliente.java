package Datos.QuerySubir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubirCliente {

    private Connection connection;

    public SubirCliente(Connection connection) {
        this.connection = connection;
    }

    public void insertarCliente(int idUsuario, String birth, byte[] pdfInputStream) throws SQLException {
        String sql = "INSERT INTO cliente (codigoUsuario, birth, pdfDPI) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setString(2, birth);
            preparedStatement.setBytes(3, pdfInputStream);
            preparedStatement.executeUpdate();
        }
    }

}

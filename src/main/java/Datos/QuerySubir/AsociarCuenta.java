package Datos.QuerySubir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AsociarCuenta {

    private Connection connection;

    public AsociarCuenta(Connection connection) {
        this.connection = connection;
    }

    public void asociarCuenta(String Codigo, String CodigoCuenta) throws SQLException {
        String sql = "INSERT INTO cuentaasociada (codCliente, codCuenta) VALUES (?, ?)";

        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, Codigo);
            preparedStatement.setString(2, CodigoCuenta);
            preparedStatement.executeUpdate();
        }
    }

}

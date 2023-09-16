package Datos.QueryActualizar;

import Datos.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaldoUsuario {
    private Connection connection;

    public SaldoUsuario(Connection connection) {
        this.connection = connection;
    }

    public float ActualizarSaldo(String CodigoCuenta, float MontoaAgregar) throws SQLException {
        String sql = "UPDATE cuenta SET saldo = saldo + ? WHERE codigo = ? ";


        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFloat(1, MontoaAgregar);
            preparedStatement.setString(2, CodigoCuenta);
            preparedStatement.executeUpdate();


        }

        String consultaSaldo = "SELECT saldo FROM cuenta WHERE codigo = ?";
        try (PreparedStatement consultaSaldoStatement = connection.prepareStatement(consultaSaldo)) {
            consultaSaldoStatement.setString(1, CodigoCuenta);
            ResultSet resultSet = consultaSaldoStatement.executeQuery();

            if (resultSet.next()) {
                float saldoActualizado = resultSet.getFloat("saldo");
                return saldoActualizado;
            } else {
                return -1.0f;
            }


        }
    }
}

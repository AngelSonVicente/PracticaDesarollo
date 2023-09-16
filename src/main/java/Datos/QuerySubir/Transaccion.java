package Datos.QuerySubir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    private Connection connection;

    public Transaccion(Connection connection) {
        this.connection = connection;
    }

    public int SubirTransaccion(String CodigoCuenta, String tipo, float monto, String CodigoCajero, float SaldoCuenta) throws SQLException {
        LocalDate fechaActual = LocalDate.now();

        LocalTime horaActual = LocalTime.now();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String fechaFormateada = fechaActual.format(formatoFecha);
        String horaFormateada = horaActual.format(formatoHora);


        String sql = "INSERT INTO transaccion (codCuenta, tipo, fecha, hora, monto, codCajero, saldoCuenta) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, CodigoCuenta);
            preparedStatement.setString(2, tipo);
            preparedStatement.setString(3, fechaFormateada);
            preparedStatement.setString(4, horaFormateada);
            preparedStatement.setFloat(5, monto);
            preparedStatement.setString(6, CodigoCajero);
            preparedStatement.setFloat(7, SaldoCuenta);

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

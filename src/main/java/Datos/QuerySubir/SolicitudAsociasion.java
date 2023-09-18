package Datos.QuerySubir;

import DatosBD.Estados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SolicitudAsociasion {
    private Connection connection;

    public SolicitudAsociasion(Connection connection) {
        this.connection = connection;
    }


    public int SoliAsociacion(String CodigoCliente, String CodigoCuenta) throws SQLException {


        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formatoFecha);

        String sql = "INSERT INTO solicitudasociacion (codCliente, codCuenta, fecha, estado) VALUES (?, ?, ?, ?)";
        System.out.println(sql);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, CodigoCliente);
            preparedStatement.setString(2, CodigoCuenta);
            preparedStatement.setString(3, fechaFormateada);
            preparedStatement.setString(4, Estados.Pendiente.name());

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

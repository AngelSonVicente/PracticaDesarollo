package Datos.QuerySubir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CambioRealizado {
    private Connection connection;

    public CambioRealizado(Connection connection) {
        this.connection = connection;
    }

    public void RegistrarCAmbio(String codGerente, String CodigoUsuario) throws SQLException {
        String sql = "INSERT INTO cambiorealizado (codGerente, codUsuarioModificado, fecha, hora) VALUES (?, ?, ?, ?)";

        System.out.println(sql);
        System.out.println("codigo gerente: "+codGerente);
        System.out.println("codigo usuario: " + CodigoUsuario);


        LocalDate fechaActual = LocalDate.now();

        LocalTime horaActual = LocalTime.now();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String fechaFormateada = fechaActual.format(formatoFecha);
        String horaFormateada = horaActual.format(formatoHora);



        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codGerente);
            preparedStatement.setString(2, CodigoUsuario);
            preparedStatement.setString(3, fechaFormateada);
            preparedStatement.setString(4, horaFormateada);
            preparedStatement.executeUpdate();
        }
    }
}

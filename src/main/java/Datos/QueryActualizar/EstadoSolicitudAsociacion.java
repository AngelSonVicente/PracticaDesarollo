package Datos.QueryActualizar;

import Datos.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstadoSolicitudAsociacion {

    private Connection connection;

    public EstadoSolicitudAsociacion(Connection connection) {
        this.connection = connection;
    }

    public void ActualizarEstadoSoliAsociacion(String IDSoli,String Estado) throws SQLException {
        String sql = "UPDATE solicitudasociacion SET estado = ? WHERE  id = ? ";
        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,Estado);
            preparedStatement.setString(2, IDSoli);
            preparedStatement.executeUpdate();
        }
    }


}

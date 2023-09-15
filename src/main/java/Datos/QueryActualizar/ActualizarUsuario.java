package Datos.QueryActualizar;

import Datos.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarUsuario {

    private Connection connection;

    public ActualizarUsuario(Connection connection) {
        this.connection = connection;
    }

    public void ActualizarUserConPass(String Codigo, String Nombre, String direccion, String DPI, String password ) throws SQLException {
        String sql = "UPDATE usuario SET nombre = ?, direccion  = ?, noIdentificacion = ?, password = ?  WHERE  codigo = ? ";



        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, Nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, DPI);
            preparedStatement.setString(4, Util.Encriptar(password));
            preparedStatement.setString(5, Codigo);
            preparedStatement.executeUpdate();
        }
    }
    public void ActualizarUser(String Codigo, String Nombre, String direccion, String DPI ) throws SQLException {
        String sql = "UPDATE usuario SET nombre = ?, direccion  = ?, noIdentificacion = ? WHERE  codigo = ? ";

        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, Nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, DPI);
            preparedStatement.setString(4, Codigo);
            preparedStatement.executeUpdate();
        }
    }


}

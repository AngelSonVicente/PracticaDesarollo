package Datos.QueryActualizar;

import Datos.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarLimites {
    Connection conexion = ConexionBD.getInstancia().getConexion();


    public void ActualizarLimite(String Codigo, float valor) throws SQLException {
        String sql = "UPDATE limite SET valor = ? WHERE  id = ? ";

        System.out.println(sql);
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setFloat(1, valor);
            preparedStatement.setString(2, Codigo);
            preparedStatement.executeUpdate();
        }
    }
}

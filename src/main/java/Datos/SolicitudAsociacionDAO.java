package Datos;

import DatosBD.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitudAsociacionDAO {


    static Connection conexion = ConexionBD.getInstancia().getConexion();

    public static SolicitudAsociacion getSolicitudAsociacion(String Codigo) {
        SolicitudAsociacion soli= new SolicitudAsociacion();

        String sql="SELECT * FROM solicitudasociacion WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("id");
                int CodigoCliente = resultSet.getInt("codCliente");
                int CodigoCuenta = resultSet.getInt("codCuenta");
                String fecha = resultSet.getString("fecha");
                String estado = resultSet.getString("estado");
                SolicitudAsociacion OBJ = new SolicitudAsociacion(codigo,CodigoCliente,CodigoCuenta,fecha,estado);
                soli=OBJ;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return soli;
    }

}

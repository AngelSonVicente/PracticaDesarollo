package Datos;

import DatosBD.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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


    public static ArrayList<SolicitudAsociacionDetalle> SolicitudPendienteCuenta(String CodigoCuenta) {
        ArrayList<SolicitudAsociacionDetalle> Listar = new ArrayList<>();
        String sql = "SELECT * FROM solicitudasociacion a INNER JOIN usuario b ON a.codCliente = b.codigo WHERE a.codCuenta = ? AND a.estado = 'Pendiente' ";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("id");
                int CodigoCliente = resultSet.getInt("codCliente");
                String Nombre = resultSet.getString("nombre");
                String DPI = resultSet.getString("noIdentificacion");
                String Fecha = resultSet.getString("fecha");
                String Estado = resultSet.getString("estado");
                SolicitudAsociacionDetalle OBJ = new SolicitudAsociacionDetalle(codigo, CodigoCliente,Nombre,DPI,Fecha,Estado);
                Listar.add(OBJ);
                System.out.println(OBJ.toString());
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }






}

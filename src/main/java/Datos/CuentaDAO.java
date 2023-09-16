package Datos;


import DatosBD.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO {
    static Connection conexion = ConexionBD.getInstancia().getConexion();



    public static Cuenta  getCuenta(String Codigo) {
        Cuenta usuario= new Cuenta();

        String sql="SELECT a.codigo, a.codigoCliente, b.nombre FROM cuenta a INNER JOIN usuario b ON a.codigoCliente = b.codigo WHERE a.codigo = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int CodigoCliente = resultSet.getInt("codigoCliente");
                String nombre = resultSet.getString("nombre");

                System.out.println(nombre);

                Cuenta OBJ = new Cuenta(codigo,CodigoCliente,nombre,null,0);
                usuario=OBJ;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return usuario;
    }




}

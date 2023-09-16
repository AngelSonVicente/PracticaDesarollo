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
    public static CuentaPDF  getCuentaCompleta(String Codigo) {
        CuentaPDF cuenta= new CuentaPDF();

        String sql="SELECT usuario.*, cliente.*, cuenta.*, cuenta.codigo AS CodigoCuenta FROM usuario INNER JOIN cuenta ON usuario.codigo = cuenta.codigoCliente INNER JOIN cliente ON usuario.codigo = cliente.codigoUsuario WHERE cuenta.codigo = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigoCuenta = resultSet.getInt("CodigoCuenta");
                int CodigoUsuario = resultSet.getInt("codigoUsuario");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String DPI = resultSet.getString("noIdentificacion");
                String sexo = resultSet.getString("sexo");
                String Cumple = resultSet.getString("birth");
                float saldo = resultSet.getFloat("saldo");
                byte[] archivo =resultSet.getBytes("pdfDPI");


                System.out.println(nombre);

                CuentaPDF OBJ = new CuentaPDF(codigoCuenta,CodigoUsuario,nombre,direccion,DPI,sexo,Cumple,saldo,archivo);
                cuenta=OBJ;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return cuenta;
    }







}

package Datos;
import DatosBD.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    static Connection conexion = ConexionBD.getInstancia().getConexion();



    public static Usuario getUsuario(String Codigo) {
     Usuario usuario= new Usuario();

     String sql="SELECT codigo, nombre, noIdentificacion, tipoUsuario FROM usuario WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                String dpi = resultSet.getString("noIdentificacion");
                int TipoUsuario = resultSet.getInt("tipoUsuario");

                System.out.println(nombre);

                Usuario OBJ = new Usuario(codigo,nombre,dpi,TipoUsuario);
                usuario=OBJ;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return usuario;
    }

    public static UsuarioT2 getUsuarioT2(String Codigo) {
     UsuarioT2 usuario= new UsuarioT2();

     String sql="SELECT * FROM usuario a INNER JOIN empleado b ON a.codigo = b.codigoUsuario WHERE a.codigo = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String dpi = resultSet.getString("noIdentificacion");
                String sexo = resultSet.getString("sexo");
                int turno = resultSet.getInt("idTurno");

                System.out.println(nombre);

                UsuarioT2 OBJ = new UsuarioT2(codigo,nombre,direccion,dpi,sexo,turno);
                usuario=OBJ;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return usuario;
    } public static UsuarioT3 getUsuarioT3(String Codigo) {
     UsuarioT3 usuario= new UsuarioT3();

     String sql="SELECT * FROM usuario WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String dpi = resultSet.getString("noIdentificacion");
                String sexo = resultSet.getString("sexo");

                System.out.println(nombre);

                UsuarioT3 OBJ = new UsuarioT3(codigo,nombre,direccion,dpi,sexo);
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

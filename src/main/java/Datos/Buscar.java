package Datos;


import DatosBD.Limites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Buscar {
    static Connection conexion = ConexionBD.getInstancia().getConexion();



    public String getDato(String tabla, String columna, String DatoaBuscar, String BuscarCon) {
        String Nombre = "";

        String sql = "SELECT * FROM " + tabla + " WHERE " + columna + " = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, BuscarCon);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Nombre = resultSet.getString(DatoaBuscar);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        System.out.println(sql);
        return Nombre;
    }

    public boolean PuedeSolicitarAsociar(String CodigoCuenta, String CodigoUsuario) {
        boolean puede = true;

        String sql = "SELECT COUNT(*) AS cantidad_solicitudes FROM solicitudasociacion WHERE codCliente = ? AND codCuenta = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, CodigoUsuario);
            preparedStatement.setString(2, CodigoCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cantidad = resultSet.getInt("cantidad_solicitudes");
                System.out.println("cantidad de solicitudes: " + cantidad);
                if (cantidad >= 3) {
                    puede = false;

                }

            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {

            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        System.out.println(sql);
        return puede;
    }

    public static Limites getLimite(String codigo) {
        Limites limite=new Limites();

        String sql = "SELECT * FROM limite WHERE id = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int Codigo = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                float valor = resultSet.getFloat("valor");

                limite.setCodigo(Codigo);
                limite.setNombre(nombre);
                limite.setValor(valor);

            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {

            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        System.out.println(sql);
        return limite;
    }


    public boolean ExisteUsuario(String id) {
        boolean existe = false;
        String Nombre = "";

        String sql = "SELECT * FROM usuario WHERE codigo = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                existe = true;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());

        }

        System.out.println(sql);
        return existe;
    }

    public boolean ExisteCuenta(String id) {
        boolean existe = false;

        String sql = "SELECT * FROM cuenta WHERE codigo = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                existe = true;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());

        }

        System.out.println(sql);
        return existe;
    }

    public boolean CuentaAsociada(String CodigoCuenta, String CodigoUsuario) {
        boolean existe = false;

        String sql = "SELECT * FROM cuentaasociada WHERE codCliente = ? AND codCuenta = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, CodigoUsuario);
            preparedStatement.setString(2, CodigoCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                existe = true;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());

        }

        System.out.println(sql);
        return existe;
    }

    public  static boolean EstaenTurno(int CodigoEmpleado) {
        boolean existe = false;

        String sql = "SELECT COUNT(*) AS cantidad FROM empleado e INNER JOIN turno t ON e.idTurno = t.id WHERE e.codigoUsuario = ? AND CURTIME() BETWEEN t.horaEntrada AND t.horaSalida;";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, CodigoEmpleado);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cantidad = resultSet.getInt("cantidad");
                if (cantidad > 0) {
                existe=true;
                }

            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());

        }

        System.out.println(sql);
        return existe;
    }

    public String ObtenerContra(String usuario) {
        String dato = "";
        dato = getDato("usuario", "codigo", "password", usuario);
        return dato;

    }


}

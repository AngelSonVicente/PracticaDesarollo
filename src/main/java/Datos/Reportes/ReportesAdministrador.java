package Datos.Reportes;

import Datos.ConexionBD;
import DatosBD.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesAdministrador {
    static Connection conexion = ConexionBD.getInstancia().getConexion();


    public static ArrayList<CambioRealizado> HistorialCambiosUsuarios(String CodigoUsuario) {
        ArrayList<CambioRealizado> Listar = new ArrayList<>();
        String sql = "SELECT a.*, B.nombre FROM cambiorealizado a INNER JOIN usuario b ON a.codUsuarioModificado = b.codigo WHERE A.codUsuarioModificado = ?;";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("id");
                int Codigogerente = resultSet.getInt("codGerente");
                int codusuario = resultSet.getInt("codusuarioModificado");
                String Nombre = resultSet.getString("nombre");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");



                CambioRealizado OBJ = new CambioRealizado(codigo,Codigogerente,codusuario,Nombre,fecha,hora);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }


    public static ArrayList<ClientesTransaccionesMayores> ClientesConTransaccionesMayoresaLimite() {
        ArrayList<ClientesTransaccionesMayores> Listar = new ArrayList<>();
        String sql = "SELECT usuario.nombre , transaccion.*, cuenta.codigoCliente FROM cuenta INNER JOIN transaccion ON transaccion.codCuenta = cuenta.codigo INNER JOIN usuario ON cuenta.codigoCliente = usuario.codigo WHERE transaccion.monto > (SELECT limite.valor FROM limite WHERE limite.id = 1);";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigoT = resultSet.getInt("codigo");
                int CodigoCuenta = resultSet.getInt("codCuenta");
                int codusuario = resultSet.getInt("codigoCliente");
                int codigoCajero = resultSet.getInt("codCajero");
                String Nombre = resultSet.getString("nombre");
                float monto= resultSet.getFloat("monto");

                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");



                ClientesTransaccionesMayores OBJ = new ClientesTransaccionesMayores(codigoT,CodigoCuenta,codusuario,codigoCajero,monto,Nombre,fecha,hora);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }

    public static ArrayList<ClienteTransaccionSumMayores> CLientesTransacionesSumadasMayores() {
        ArrayList<ClienteTransaccionSumMayores> Listar = new ArrayList<>();
        String sql = "SELECT usuario.nombre, SUM(transaccion.monto) AS suma_montos, cuenta.codigoCliente FROM cuenta INNER JOIN transaccion ON transaccion.codCuenta = cuenta.codigo INNER JOIN usuario ON cuenta.codigoCliente = usuario.codigo GROUP BY usuario.nombre, cuenta.codigoCliente HAVING suma_montos > (SELECT limite.valor FROM limite WHERE limite.id = 2)";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigoCliente");
                String Nombre = resultSet.getString("nombre");
                float monto = resultSet.getFloat("suma_montos");
                ClienteTransaccionSumMayores OBJ = new ClienteTransaccionSumMayores(codigo,Nombre,monto);
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


    public static ArrayList<Usuario> UsuariosSinTransacciones(String FechaInicio, String FechaFin) {
        ArrayList<Usuario> Listar = new ArrayList<>();


        String sql = "SELECT usuario.nombre, usuario.noIdentificacion, usuario.tipoUsuario, cuenta.codigoCliente FROM usuario LEFT JOIN cuenta ON usuario.codigo = cuenta.codigoCliente WHERE NOT EXISTS ( SELECT 1 FROM transaccion WHERE transaccion.codCuenta = cuenta.codigo AND transaccion.fecha BETWEEN ? AND ? ) AND usuario.tipoUsuario = 3;";
        try {        PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, FechaInicio);
            preparedStatement.setString(2, FechaFin);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigoCliente = resultSet.getInt("codigoCliente");
                String Nombre = resultSet.getString("nombre");
                String DPI = resultSet.getString("noIdentificacion");
                int tipoUsuario = resultSet.getInt("tipoUsuario");


                Usuario OBJ = new Usuario(codigoCliente,Nombre,DPI,tipoUsuario);
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



    public static ArrayList<Cuenta> Top10UsuariosMasDineroCuentas() {
        ArrayList<Cuenta> Listar = new ArrayList<>();
        String sql = "SELECT a.codigoCliente, b.nombre AS nombre_usuario, SUM(a.saldo) AS total_saldo FROM cuenta a INNER JOIN usuario b ON a.codigoCliente = b.codigo GROUP BY b.codigo, b.nombre ORDER BY total_saldo DESC LIMIT 10;";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigoCliente = resultSet.getInt("codigoCliente");
                String Nombre = resultSet.getString("nombre_usuario");
                float saldo = resultSet.getFloat("total_saldo");
                Cuenta OBJ = new Cuenta(0,codigoCliente,Nombre,null,saldo);
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


    public static ArrayList<HistorialTransaccion> HistorialTransaccion(String CodigoUsuario) {
        ArrayList<HistorialTransaccion> Listar = new ArrayList<>();
        String sql = "SELECT usuario.nombre , transaccion.*, cuenta.codigoCliente FROM cuenta INNER JOIN transaccion ON transaccion.codCuenta = cuenta.codigo INNER JOIN usuario ON cuenta.codigoCliente = usuario.codigo WHERE cuenta.codigoCliente = ?;";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigoTransaccion = resultSet.getInt("codigo");
                int codigoCliente = resultSet.getInt("codigoCliente");
                int codigoCuenta = resultSet.getInt("codCuenta");
                int codigoCajer = resultSet.getInt("codCajero");
                String Nombre = resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");


                float monto = resultSet.getFloat("monto");
                float saldoCuenta = resultSet.getFloat("saldoCuenta");



                HistorialTransaccion OBJ =
                        new HistorialTransaccion(codigoTransaccion,codigoCliente,Nombre,codigoCuenta,codigoCajer,tipo,fecha,hora,monto,saldoCuenta);
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




    public static CajeroMasTransacciones CajeroConMasTransacciones(String FechaInicio, String FechaFin) {
        CajeroMasTransacciones cajero = new CajeroMasTransacciones();

        String sql = "SELECT usuario.nombre AS nombre_cajero, usuario.codigo, COUNT(*) AS cantidad_transacciones FROM transaccion INNER JOIN usuario ON transaccion.codCajero = usuario.codigo WHERE transaccion.fecha BETWEEN ? AND ? GROUP BY usuario.nombre ORDER BY cantidad_transacciones DESC LIMIT 1;";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, FechaInicio);
            preparedStatement.setString(2, FechaFin);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String Nombre = resultSet.getString("nombre_cajero");
               int cantidadTransacciones = resultSet.getInt("cantidad_transacciones");


                CajeroMasTransacciones OBJ = new CajeroMasTransacciones(codigo,Nombre,cantidadTransacciones);
              cajero=OBJ;
                System.out.println(OBJ.toString());
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return cajero;
    }







}

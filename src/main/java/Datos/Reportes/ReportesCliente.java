package Datos.Reportes;

import Datos.ConexionBD;
import Datos.TransaccionDAO;
import DatosBD.CambioRealizado;
import DatosBD.SolicitudAsociacion;
import DatosBD.Transaccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesCliente {
    static Connection conexion = ConexionBD.getInstancia().getConexion();
    public static ArrayList<Transaccion> TransaccionesUltimoanio(String CodigoCuenta) {
        ArrayList<Transaccion> Listar = new ArrayList<>();
        String sql = "SELECT * FROM transaccion WHERE codCuenta = ? ORDER BY monto DESC LIMIT 15;";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int Codigocuenta = resultSet.getInt("codCuenta");
                String tipo = resultSet.getString("tipo");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                float monto= resultSet.getFloat("monto");
                int CodigoCajer = resultSet.getInt("codCajero");

                float SaldoCuenta= resultSet.getFloat("saldoCuenta");

                Transaccion OBJ = new Transaccion(codigo,Codigocuenta,tipo,fecha,hora,monto,CodigoCajer,SaldoCuenta);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }
 public static ArrayList<Transaccion> TransaccionesIntervaloTiempo(String CodigoCuenta, String FechaInicio, String FechaFin) {
        ArrayList<Transaccion> Listar = new ArrayList<>();

        String sql = "SELECT * FROM transaccion WHERE fecha BETWEEN ? AND ? AND codCuenta = ?;";
        System.out.println(sql);
        System.out.println(FechaInicio);
        System.out.println(FechaFin);
        System.out.println(CodigoCuenta);

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, FechaInicio);
            preparedStatement.setString(2, FechaFin);
            preparedStatement.setString(3, CodigoCuenta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                System.out.println(codigo);
                int Codigocuenta = resultSet.getInt("codCuenta");
                String tipo = resultSet.getString("tipo");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                float monto= resultSet.getFloat("monto");
                int CodigoCajer = resultSet.getInt("codCajero");

                float SaldoCuenta= resultSet.getFloat("saldoCuenta");

                Transaccion OBJ = new Transaccion(codigo,Codigocuenta,tipo,fecha,hora,monto,CodigoCajer,SaldoCuenta);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }

 public static ArrayList<Transaccion> CuentaConMasDineroyTransacciones(String CodigoCuenta, String Fecha) {
        ArrayList<Transaccion> Listar = new ArrayList<>();
        String sql = "SELECT t.* FROM transaccion AS t INNER JOIN ( SELECT codigo FROM cuenta WHERE codigoCliente = ? ORDER BY saldo DESC LIMIT 1 ) AS c ON t.codCuenta = c.codigo WHERE t.fecha >= ? AND t.fecha <= CURDATE();";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoCuenta);
            preparedStatement.setString(2,Fecha);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int Codigocuenta = resultSet.getInt("codCuenta");
                String tipo = resultSet.getString("tipo");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                float monto= resultSet.getFloat("monto");
                int CodigoCajer = resultSet.getInt("codCajero");

                float SaldoCuenta= resultSet.getFloat("saldoCuenta");

                Transaccion OBJ = new Transaccion(codigo,Codigocuenta,tipo,fecha,hora,monto,CodigoCajer,SaldoCuenta);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }


 public static ArrayList<SolicitudAsociacion> HistorialSoliAsociacioonRecibidos(String Codigocuenta) {
        ArrayList<SolicitudAsociacion> Listar = new ArrayList<>();
        String sql = "SELECT * FROM solicitudasociacion WHERE codCuenta = ?;";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigocuenta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("id");
                int Codigocliente = resultSet.getInt("codCliente");
                int CodCuenta = resultSet.getInt("codCuenta");
                String Fecha = resultSet.getString("fecha");
                String Estado = resultSet.getString("estado");


                SolicitudAsociacion OBJ = new SolicitudAsociacion(codigo,Codigocliente, CodCuenta,Fecha,Estado);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }
 public static ArrayList<SolicitudAsociacion> HstorialSoliAsociacionhecha(String CodigoCliente) {
        ArrayList<SolicitudAsociacion> Listar = new ArrayList<>();
        String sql = "SELECT * FROM solicitudasociacion WHERE codCliente = ?;";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("id");
                int Codigocliente = resultSet.getInt("codCliente");
                int CodCuenta = resultSet.getInt("codCuenta");
                String Fecha = resultSet.getString("fecha");
                String Estado = resultSet.getString("estado");


                SolicitudAsociacion OBJ = new SolicitudAsociacion(codigo,Codigocliente, CodCuenta,Fecha,Estado);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        return Listar;
    }






}

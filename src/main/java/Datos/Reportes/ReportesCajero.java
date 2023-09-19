package Datos.Reportes;

import Datos.ConexionBD;
import DatosBD.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesCajero {
    static Connection conexion = ConexionBD.getInstancia().getConexion();


    public static ArrayList<DeporsitoRetirosCajero> DepositosRetirosCajero(String CodigoUsuario) {
        ArrayList<DeporsitoRetirosCajero> Listar = new ArrayList<>();
        String sql = "SELECT usuario.nombre AS nombre_cajero, transaccion.*, ROUND(@saldo := @saldo + CASE WHEN transaccion.tipo = 'Credito' THEN transaccion.monto WHEN transaccion.tipo = 'Debito' THEN -transaccion.monto ELSE 0 END, 2) AS caja FROM (SELECT @saldo := 0) AS inicializacion, transaccion INNER JOIN usuario ON transaccion.codCajero = usuario.codigo INNER JOIN empleado ON transaccion.codCajero = empleado.codigoUsuario INNER JOIN turno ON empleado.idTurno = turno.id WHERE transaccion.hora BETWEEN turno.horaEntrada AND turno.horaSalida AND transaccion.codCajero = ?;";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, CodigoUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigotransaccion = resultSet.getInt("codigo");
                int codCajero = resultSet.getInt("codCajero");
                String Nombre = resultSet.getString("nombre_cajero");
                int CodigoCuenta = resultSet.getInt("codCuenta");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                String tipo= resultSet.getString("tipo");
                float monto = resultSet.getFloat("monto");
                float SaldoCuenta = resultSet.getFloat("saldoCuenta");
                float caja = resultSet.getFloat("caja");



                DeporsitoRetirosCajero OBJ = new DeporsitoRetirosCajero(codCajero,Nombre,CodigoCuenta,codigotransaccion,tipo,fecha,hora,monto,SaldoCuenta,caja);
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

    public static ArrayList<DeporsitoRetirosCajero> TransaccioneshechasDia(String CodigoUsuario, String Fecha) {
        ArrayList<DeporsitoRetirosCajero> Listar = new ArrayList<>();
        String sql = "SELECT usuario.nombre AS nombre_cajero, transaccion.*, ROUND(@saldo := @saldo + CASE WHEN transaccion.tipo = 'Credito' THEN transaccion.monto WHEN transaccion.tipo = 'Debito' THEN -transaccion.monto ELSE 0 END, 2) AS caja FROM (SELECT @saldo := 0) AS inicializacion, transaccion INNER JOIN usuario ON transaccion.codCajero = usuario.codigo WHERE transaccion.fecha = ? AND transaccion.codCajero = ?;";
        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Fecha);
            preparedStatement.setString(2, CodigoUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigotransaccion = resultSet.getInt("codigo");
                int codCajero = resultSet.getInt("codCajero");
                String Nombre = resultSet.getString("nombre_cajero");
                int CodigoCuenta = resultSet.getInt("codCuenta");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                String tipo= resultSet.getString("tipo");
                float monto = resultSet.getFloat("monto");
                float SaldoCuenta = resultSet.getFloat("saldoCuenta");
                float caja = resultSet.getFloat("caja");



                DeporsitoRetirosCajero OBJ = new DeporsitoRetirosCajero(codCajero,Nombre,CodigoCuenta,codigotransaccion,tipo,fecha,hora,monto,SaldoCuenta,caja);
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

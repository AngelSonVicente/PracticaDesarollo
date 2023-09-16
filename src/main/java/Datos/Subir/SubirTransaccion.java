package Datos.Subir;

import Datos.ConexionBD;
import Datos.QueryActualizar.SaldoUsuario;
import Datos.QuerySubir.SubirCliente;
import Datos.QuerySubir.SubirUsuario;
import Datos.TipoTransaccion;
import Datos.TransaccionDAO;
import Datos.Util;
import DatosBD.NuevoCliente;
import DatosBD.Transaccion;

import java.sql.Connection;
import java.sql.SQLException;

public class SubirTransaccion {

    Connection conexion = ConexionBD.getInstancia().getConexion();

    public Transaccion transaccion(String CodigoCuenta, TipoTransaccion tipo, float monto, String CodigoCajero) throws SQLException {



        int codigo = 0;


        try {
            conexion.setAutoCommit(false);
            SaldoUsuario actualizarsaldo = new SaldoUsuario(conexion);
            Datos.QuerySubir.Transaccion transaccion = new Datos.QuerySubir.Transaccion(conexion);

            float Saldofinal = actualizarsaldo.ActualizarSaldo(CodigoCuenta,monto);

            int IDtransaccion=transaccion.SubirTransaccion(CodigoCuenta,tipo.name(),monto,CodigoCajero,Saldofinal);

            codigo=IDtransaccion;


            conexion.commit();


        } catch (SQLException e) {
            e.printStackTrace(System.out);
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace(System.out);
                }
            }
        }

        Transaccion transaccionn =  TransaccionDAO.getTransaccion(String.valueOf(codigo));
        return transaccionn;


    }

}

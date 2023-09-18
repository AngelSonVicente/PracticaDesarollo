package Datos.Subir;

import Datos.ConexionBD;
import Datos.QueryActualizar.SaldoUsuario;
import Datos.QuerySubir.SolicitudAsociasion;
import Datos.SolicitudAsociacionDAO;
import Datos.TipoTransaccion;
import Datos.TransaccionDAO;
import DatosBD.SolicitudAsociacion;
import DatosBD.Transaccion;

import java.sql.Connection;
import java.sql.SQLException;

public class SubirSolicitudAsociacion {


    Connection conexion = ConexionBD.getInstancia().getConexion();

    public SolicitudAsociacion SoliAsociacion(String CodigoCuenta, String CodigoCliente) throws SQLException {



        int codigo = 0;


        try {
            conexion.setAutoCommit(false);
            SolicitudAsociasion solicitudAsociasion = new SolicitudAsociasion(conexion);



            int IDtransaccion=solicitudAsociasion.SoliAsociacion(CodigoCliente,CodigoCuenta);
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

        SolicitudAsociacion soli = SolicitudAsociacionDAO.getSolicitudAsociacion(String.valueOf(codigo));
        return soli;


    }
}

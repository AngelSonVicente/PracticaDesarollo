package Datos.Actualizar;

import Datos.ConexionBD;
import Datos.QueryActualizar.EstadoSolicitudAsociacion;
import Datos.QuerySubir.AsociarCuenta;
import Datos.QuerySubir.CambioRealizado;
import DatosBD.Estados;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoSoliyAsociarCuenta {
    Connection conexion = ConexionBD.getInstancia().getConexion();

    public void ActualizarEstadoSOliyAsociarCuenta(String idSoli, String CodigoCuenta, String CodigoCliente,Estados estado ){
        try {
            conexion.setAutoCommit(false);

            EstadoSolicitudAsociacion actualizarEstado=new EstadoSolicitudAsociacion(conexion);
            AsociarCuenta asociarCuenta= new AsociarCuenta(conexion);

            actualizarEstado.ActualizarEstadoSoliAsociacion(idSoli, estado.name());

            if(estado==Estados.Aceptado){

            asociarCuenta.asociarCuenta(CodigoCliente,CodigoCuenta);
            }





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


    }
}

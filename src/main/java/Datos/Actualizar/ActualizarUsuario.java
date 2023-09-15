package Datos.Actualizar;

import Datos.*;
import Datos.ConexionBD;
import Datos.QueryActualizar.ActualizarTurno;
import Datos.QuerySubir.AsociarCuenta;
import Datos.QuerySubir.CambioRealizado;
import Datos.QuerySubir.CrearCuenta;

import java.sql.Connection;
import java.sql.SQLException;

public class ActualizarUsuario {

    Connection conexion = ConexionBD.getInstancia().getConexion();

    public void ActulizarCuentaT3(String Codigogerente, String codigo,String nombre, String direccion, String DPI,  String password){
        try {
            conexion.setAutoCommit(false);

            Datos.QueryActualizar.ActualizarUsuario actualizarusuario= new Datos.QueryActualizar.ActualizarUsuario(conexion);

            CambioRealizado guardarcambio = new CambioRealizado(conexion);



            if(password.isEmpty()){

                actualizarusuario.ActualizarUser(codigo,nombre,direccion,DPI);
            }else{

                actualizarusuario.ActualizarUserConPass(codigo,nombre,direccion,DPI,password);
            }

            guardarcambio.RegistrarCAmbio(Codigogerente,codigo);



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
    public void ActulizarCuentaT2(String CodigoGerente, String codigo,String nombre, String direccion, String DPI, String password, String turno){
        try {
            conexion.setAutoCommit(false);
           Datos.QueryActualizar.ActualizarUsuario actualizarusuario= new Datos.QueryActualizar.ActualizarUsuario(conexion);

            ActualizarTurno actualizarTurno= new ActualizarTurno(conexion);
            CambioRealizado guardarcambio = new CambioRealizado(conexion);

            if(password.isEmpty()){

                actualizarusuario.ActualizarUser(codigo,nombre,direccion,DPI);

            }else{

                actualizarusuario.ActualizarUserConPass(codigo,nombre,direccion,DPI,password);
            }

            actualizarTurno.actualizarturno(codigo,turno);
            guardarcambio.RegistrarCAmbio(CodigoGerente,codigo);


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

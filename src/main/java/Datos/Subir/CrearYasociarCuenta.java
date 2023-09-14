package Datos.Subir;

import Datos.Buscar;
import Datos.ConexionBD;
import Datos.DatosBD;
import Datos.QuerySubir.AsociarCuenta;
import Datos.QuerySubir.CrearCuenta;
import Datos.QuerySubir.SubirCliente;
import Datos.QuerySubir.SubirUsuario;
import Datos.Util;
import DatosBD.*;

import java.sql.Connection;
import java.sql.SQLException;

public class CrearYasociarCuenta {

    Connection conexion = ConexionBD.getInstancia().getConexion();

    public Cuenta CrearYasociarCuenta(String CodigoCliente, String FechaCreacion) throws SQLException {


        Buscar buscar = new Buscar();
        int codigo = 0;


        try {
            conexion.setAutoCommit(false);
            AsociarCuenta asociar = new AsociarCuenta(conexion);
            CrearCuenta crearcuenta = new CrearCuenta(conexion);

            int IDCuenta = crearcuenta.crearCuenta(CodigoCliente,FechaCreacion) ;

            codigo = IDCuenta;
            asociar.asociarCuenta(CodigoCliente,String.valueOf(IDCuenta));

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

        Cuenta cuenta = new Cuenta(codigo,Integer.parseInt(CodigoCliente), buscar.getDato("usuario","codigo","nombre",CodigoCliente), FechaCreacion,0);

        return cuenta;


    }



}

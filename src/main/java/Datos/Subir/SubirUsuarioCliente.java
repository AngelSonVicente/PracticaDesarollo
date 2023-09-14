package Datos.Subir;

import Datos.ConexionBD;
import Datos.QuerySubir.SubirCliente;
import Datos.QuerySubir.SubirUsuario;

import Datos.Util;
import DatosBD.NuevoCliente;

import java.sql.Connection;
import java.sql.SQLException;

public class SubirUsuarioCliente {

    Connection conexion = ConexionBD.getInstancia().getConexion();

    public NuevoCliente ClienteUsuario(String nombre, String direccion, String noIdentificacion, String sexo, String birth, byte[] pdf) throws SQLException {

        String password = noIdentificacion.substring(0, 3) + nombre.substring(0, 2) + birth;
        String PassEncriptado = Util.Encriptar(password);


        int codigo = 0;


        try {
            conexion.setAutoCommit(false);
            SubirUsuario usuarioDAO = new SubirUsuario(conexion);
            SubirCliente clienteDAO = new SubirCliente(conexion);

            int userId = usuarioDAO.insertarUsuario(nombre, direccion, noIdentificacion, sexo, PassEncriptado, 3);

            codigo = userId;
            clienteDAO.insertarCliente(userId, birth, pdf);

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

        NuevoCliente cliente = new NuevoCliente(codigo, nombre, password);
        return cliente;


    }


}

package Datos;
import java.sql.Connection;
import DatosBD.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DatosBD {

    Util util = new Util();
    Buscar buscar =new Buscar();
    Listar listar=new Listar();
    //Actualizar actualizar= new Actualizar();
    static Connection conexion = ConexionBD.getInstancia().getConexion();

    public Usuario IsLogin(String ContraIngresada, String UsuarioIngresado) {
        String ContraEncriptada= util.Encriptar(ContraIngresada);


        String Contra= buscar.ObtenerContra(UsuarioIngresado);


        Usuario usuario = new Usuario();

        if(ContraEncriptada.equals(Contra)){

            return UsuarioDAO.getUsuario(UsuarioIngresado);


            }

        return null;
    }


}

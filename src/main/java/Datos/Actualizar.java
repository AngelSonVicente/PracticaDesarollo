package Datos;

import Datos.QuerySubir.Subir;

import java.sql.Connection;
import java.sql.SQLException;

public class Actualizar {
    Connection conexion = ConexionBD.getInstancia().getConexion();
    Buscar buscar = new Buscar();
    Subir subir = new Subir();
    private void  Actualizar(String sql){
        System.out.println(sql);

        try (var statement =conexion.prepareStatement(sql)){
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }


}

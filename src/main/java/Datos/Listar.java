package Datos;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import DatosBD.*;


import java.util.ArrayList;

public class Listar {
    static ConsultasBD consulta = new ConsultasBD();
    static Connection conexion = ConexionBD.getInstancia().getConexion();






    /*
    private static ArrayList<Libros> sqlLibros(String sql) {
        ArrayList<Libros> Listar = new ArrayList<>();

        try {
            // Crear un PreparedStatement en lugar de un Statement
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int isbn = resultSet.getInt("isbn");
                String nombre = resultSet.getString("nombre");
                float costo = resultSet.getFloat("costo");
                String categoria = resultSet.getString("categoria");
                String autor = resultSet.getString("autor");

                System.out.println(nombre);

                Libros OBJ = new Libros(isbn, nombre, costo, categoria, autor);
                Listar.add(OBJ);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return Listar;
    }





    public static ArrayList<Libros> Libros(){
        String sql = "SELECT * FROM libros";
        System.out.println(sql);
        return       sqlLibros(sql);
    }
    public static ArrayList<Libros> LibrosAAgregar(String codigobiblio){
        String sql = "SELECT * FROM libros a LEFT JOIN catalogo_bibliotecas b ON a.isbn = b.isbn AND b.biblioteca = "+codigobiblio+" WHERE b.isbn IS NULL";
        System.out.println(sql);
        return sqlLibros(sql);
    }
    public static ArrayList<Libros> Libro(String isbn){
        String sql = "SELECT * FROM libros WHERE isbn = " + isbn;
        System.out.println(sql);
        return sqlLibros(sql);
    }


*/
}

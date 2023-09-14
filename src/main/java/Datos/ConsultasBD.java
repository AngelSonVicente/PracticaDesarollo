package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class ConsultasBD {


    static Connection conexion = ConexionBD.getInstancia().getConexion();



    public <T> ArrayList<T> consultarRegistros(String tabla, ArrayList<String> campos, String clase) {
        ArrayList<T> resultado = new ArrayList<>();
        String consulta = "SELECT " + String.join(", ", campos) + " FROM " + tabla;

        System.out.println(consulta);
        try {
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ArrayList<Object> valores = new ArrayList<>();
                System.out.println("almenos hay un next");
                for (String campo : campos) {
                    valores.add(resultSet.getString(campo));
                System.out.println(resultSet.getObject(campo));
                }

               // T objeto = (T) Class.forName("main.java.DatosBD."+clase).getDeclaredConstructor().newInstance(valores.toArray());
                T objeto = (T) Class.forName("DatosBD.Libros").getDeclaredConstructor().newInstance(valores.toArray());


                resultado.add(objeto);
            }

            statement.close();
            resultSet.close();
        } catch (SQLException | ReflectiveOperationException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return resultado;
    }




}

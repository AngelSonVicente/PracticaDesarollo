package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Buscar {
    static Connection conexion = ConexionBD.getInstancia().getConexion();

    /*
    public String getDato(String tabla,String columna, String DatoaBucar,String BuscarCon){

        String Nombre="";

        String sql ="SELECT * FROM "+tabla+" WHERE "+columna+" = '" +BuscarCon+"'";

        try{
            var statement = conexion.createStatement();
            var resultset = statement.executeQuery(sql);

            if(resultset.next()){
                Nombre = resultset.getString(DatoaBucar);
            }

            statement.close();
            resultset.close();

        }catch(SQLException e){
            System.out.println("Error al realizar la consulta"+ e.getMessage());
        }
        return Nombre;
    }
    */

    public String getDato(String tabla, String columna, String DatoaBuscar, String BuscarCon) {
        String Nombre = "";

        String sql = "SELECT * FROM " + tabla + " WHERE " + columna + " = ?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, BuscarCon);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Nombre = resultSet.getString(DatoaBuscar);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta" + e.getMessage());
        }

        System.out.println(sql);
        return Nombre;
    }







        public String ObtenerContra( String usuario){
            String dato="";
        dato=getDato("usuario","codigo","password",usuario);
        return dato;

    }
    

}

package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Subir {
    Connection conexion = ConexionBD.getInstancia().getConexion();
    private void  Subir(String sql){
        System.out.println(sql);

        try (var statement =conexion.prepareStatement(sql)){
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }



    private int SubirRegresandoID(String sql) {
      System.out.println(sql);
        try (var preparedStatement = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                try (var resultset = preparedStatement.getGeneratedKeys()) {
                    if (resultset.next()) {
                        return resultset.getInt(1);
                    }
                }
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return -1;
        }
    }













    }





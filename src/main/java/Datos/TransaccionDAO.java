package Datos;

import DatosBD.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaccionDAO {
    static Connection conexion = ConexionBD.getInstancia().getConexion();
    public static Transaccion getTransaccion(String Codigo) {
        Transaccion transaccion= new Transaccion();

        String sql="SELECT * FROM transaccion WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, Codigo);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                int CodigoCuenta = resultSet.getInt("codCuenta");
                String tipo = resultSet.getString("tipo");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                float monto= resultSet.getFloat("monto");
                int CodigoCajer = resultSet.getInt("codCajero");

                float SaldoCuenta= resultSet.getFloat("saldoCuenta");

                Transaccion OBJ = new Transaccion(codigo,CodigoCuenta,tipo,fecha,hora,monto,CodigoCajer,SaldoCuenta);
                transaccion=OBJ;
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }

        return transaccion;
    }


}

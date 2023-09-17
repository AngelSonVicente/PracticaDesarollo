package Datos.Subir;

import Datos.ConexionBD;
import Datos.QueryActualizar.SaldoUsuario;
import Datos.TipoTransaccion;
import Datos.TransaccionDAO;
import DatosBD.TipoTransferencia;
import DatosBD.Transaccion;
import DatosBD.Transferencia;

import java.sql.Connection;
import java.sql.SQLException;

public class RealizarTransferencia {
    Connection conexion = ConexionBD.getInstancia().getConexion();

    public Transferencia Hacertransferencia(String CodigoCuentaDebito,String CodigoCuentaAcreditar, float monto, String CodigoCajero, TipoTransferencia tipotrasnferencia) throws SQLException {

        //Parametros que recibe SubirTransaccion
       // String CodigoCuenta, TipoTransaccion tipo, float monto, String CodigoCajero


    Transferencia transferencia= new Transferencia();
        int codigo = 0;


        try {
            conexion.setAutoCommit(false);
            SubirTransaccion Transaccion = new SubirTransaccion();
            SubirTransaccion Credito = new SubirTransaccion();

            Transaccion TransaccionDebito = Transaccion.transaccion(CodigoCuentaDebito,TipoTransaccion.Debito,monto,CodigoCajero);
            Transaccion TransaccionCredito = Transaccion.transaccion(CodigoCuentaAcreditar,TipoTransaccion.Credito,monto,CodigoCajero);

            Transferencia transferenciahecha= new Transferencia(Integer.parseInt(CodigoCuentaDebito),Integer.parseInt(CodigoCuentaAcreditar),TransaccionDebito.getCodigoTransaccion(), tipotrasnferencia,TransaccionCredito.getFecha(),TransaccionDebito.getHora(),monto,Integer.parseInt(CodigoCajero),TransaccionDebito.getSaldoCuenta());

            transferencia=transferenciahecha;

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

        return transferencia;


    }


}

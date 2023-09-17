package Web;

import Datos.*;
import Datos.Subir.RealizarTransferencia;
import DatosBD.TipoTransferencia;
import DatosBD.Transferencia;
import DatosBD.UsuarioT2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Transferencias")
public class Transferencias extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Util util = new Util();
        Buscar buscar = new Buscar();
        UsuarioT2 Cajero = UsuarioDAO.getUsuarioT2("101");

        String Tipotransferencia = request.getParameter("TipoTransferencia");
        String CuentaDebito = request.getParameter("CuentaDebido");
        String CuentaAcreditar = request.getParameter("CuentaCredito");
        String monto = request.getParameter("monto");


        System.out.println("Tipo de transferencia : " + Tipotransferencia);
        System.out.println("Cuenta Debito : " + CuentaDebito);
        System.out.println("Cuenta Credito : " + CuentaAcreditar);
        System.out.println("Monto : " + monto);


        if (Tipotransferencia == null || CuentaDebito == null || CuentaAcreditar == null || Tipotransferencia.isEmpty() || CuentaDebito.isEmpty() || CuentaAcreditar.isEmpty() || monto.isEmpty() || CuentaAcreditar.equals("Seleccione cuenta a Acreditar") || CuentaDebito.equals("Seleccione cuenta a Debito")) {
            request.setAttribute("error", "Necesita Llenar todos los campos");
            request.getRequestDispatcher("Transferencias.jsp").forward(request, response);

        } else {

            TipoTransferencia tipo =null;
            if(Tipotransferencia.equals("1")){
             tipo = TipoTransferencia.Propia;
            }
            if(Tipotransferencia.equals("2")){
               tipo = TipoTransferencia.ATerceros;
            }

            if (!util.esNumero(monto)) {
                request.setAttribute("error", "Ingrese un monto valido");
                request.getRequestDispatcher("Transferencias.jsp").forward(request, response);

            } else {
                if (CuentaDebito.equals(CuentaAcreditar)) {
                    request.setAttribute("error", "No Se puede transferir a la misma cuenta");
                    request.getRequestDispatcher("Transferencias.jsp").forward(request, response);

                } else {
                    float saldoCuenta = Float.parseFloat(buscar.getDato("cuenta", "codigo", "saldo", CuentaDebito));

                    if (saldoCuenta < Float.parseFloat(monto)) {
                        request.setAttribute("error", "La cuenta no tiene saldo suficiente para relizar la transferencia");
                        request.getRequestDispatcher("Transferencias.jsp").forward(request, response);

                    } else {
                        if (Float.parseFloat(monto) <= 0) {
                            request.setAttribute("error", "INgrese un monto valido");
                            request.getRequestDispatcher("Transferencias.jsp").forward(request, response);

                        } else {
                            RealizarTransferencia realizarTransferencia = new RealizarTransferencia();

                            try {
                                Transferencia transferencia = realizarTransferencia.Hacertransferencia(CuentaDebito,CuentaAcreditar,Float.parseFloat(monto),String.valueOf(Cajero.getCodigo()),tipo);

                                request.setAttribute("transferencia", transferencia);

                                request.getRequestDispatcher("MostrarTransferencia.jsp").forward(request,response);


                            } catch (SQLException e) {
                                request.setAttribute("error", "Ha Ocurrido un error al realizar la Transferencia, vuelva a hacerla");
                                request.getRequestDispatcher("Transferencias.jsp").forward(request, response);

                            }

                        }


                    }


                }

            }


        }


    }
}

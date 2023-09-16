package Web;

import Datos.CuentaDAO;
import Datos.Subir.SubirTransaccion;
import Datos.TipoTransaccion;
import Datos.Util;
import DatosBD.Cuenta;
import DatosBD.Transaccion;
import DatosBD.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/HacerDeposito")
public class HacerDeposito extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Usuario cajero = (Usuario) session.getAttribute("Cajero");


        String CodigoCuenta=request.getParameter("CodigoCuenta");
        String monto = request.getParameter("Monto");
        Util util = new Util();

        if(!util.esNumero(monto) || Float.parseFloat(monto)<=0){

            request.setAttribute("error", "Ingrese un monto Valido");
            Cuenta cuenta = CuentaDAO.getCuenta(CodigoCuenta);
            request.setAttribute("cuenta", cuenta);

            request.getRequestDispatcher("HacerDeposito.jsp").forward(request,response);


        }else{
            SubirTransaccion hacertransaccion = new SubirTransaccion();

            try {

                Transaccion transaccion = hacertransaccion.transaccion(CodigoCuenta, TipoTransaccion.Credito,Float.parseFloat(monto), String.valueOf(cajero.getCodigo()));
                request.setAttribute("transaccion", transaccion);

                request.getRequestDispatcher("MostrarTransaccion.jsp").forward(request,response);



            } catch (SQLException e) {
                request.setAttribute("error", "Ha ocurrido un error");
                Cuenta cuenta = CuentaDAO.getCuenta(CodigoCuenta);
                request.setAttribute("cuenta", cuenta);

                request.getRequestDispatcher("HacerDeposito.jsp").forward(request,response);



            }


        }



    }
}

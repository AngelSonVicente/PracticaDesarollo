package Web;

import Datos.*;
import Datos.Subir.SubirTransaccion;
import DatosBD.Cuenta;
import DatosBD.CuentaPDF;
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

@WebServlet("/HacerRetiro")
public class HacerRetiro extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Buscar buscar = new Buscar();

        HttpSession session = request.getSession();

        Usuario cajero = (Usuario) session.getAttribute("Cajero");


        String CodigoCuenta=request.getParameter("CodigoCuenta");
        String monto = request.getParameter("Monto");

        Util util = new Util();

        float saldoUsuario= Float.parseFloat(buscar.getDato("cuenta","codigo","saldo",CodigoCuenta));

        if(!util.esNumero(monto) || Float.parseFloat(monto)<=0 ){

            request.setAttribute("error", "Ingrese un monto Valido");
            CuentaPDF cuenta = CuentaDAO.getCuentaCompleta(CodigoCuenta);
            request.setAttribute("cuenta", cuenta);

            request.getRequestDispatcher("HacerRetiro.jsp").forward(request,response);




        }else{
            if(saldoUsuario<Float.parseFloat(monto)){
                request.setAttribute("error", "El Ciente no tiene saldo suficiente");
                CuentaPDF cuenta = CuentaDAO.getCuentaCompleta(CodigoCuenta);
                request.setAttribute("cuenta", cuenta);

                request.getRequestDispatcher("HacerRetiro.jsp").forward(request,response);


            }else{



            SubirTransaccion hacertransaccion = new SubirTransaccion();

            try {

                Transaccion transaccion = hacertransaccion.transaccion(CodigoCuenta, TipoTransaccion.Debito,Float.parseFloat(monto), String.valueOf(cajero.getCodigo()));
                request.setAttribute("transaccion", transaccion);

                request.getRequestDispatcher("MostrarTransaccion.jsp").forward(request,response);



            } catch (SQLException e) {
                request.setAttribute("error", "Ha ocurrido un error");
                CuentaPDF cuenta = CuentaDAO.getCuentaCompleta(CodigoCuenta);
                request.setAttribute("cuenta", cuenta);

                request.getRequestDispatcher("HacerRetiro.jsp").forward(request,response);



            }

            }


        }


    }
}

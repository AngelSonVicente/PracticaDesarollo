package Web;

import Datos.Buscar;
import Datos.CuentaDAO;
import Datos.Util;
import DatosBD.Cuenta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Depositar")
public class Depositar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CodigoCuenta=request.getParameter("CodigoCuenta");
Buscar buscar = new Buscar();
Util util = new Util();


        if(CodigoCuenta.isEmpty()){
            request.setAttribute("error", "Ingrese el Codigo De la Cuenta a Depositar");
            request.getRequestDispatcher("Depositar.jsp").forward(request,response);
        }
        if(!buscar.ExisteCuenta(CodigoCuenta ) ||  !    util.esNumero(CodigoCuenta)){

            request.setAttribute("error", "La cuenta no existe");
            request.getRequestDispatcher("Depositar.jsp").forward(request,response);

        }else{

            Cuenta cuenta = CuentaDAO.getCuenta(CodigoCuenta);
            request.setAttribute("cuenta", cuenta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("HacerDeposito.jsp");
            dispatcher.forward(request, response);




        }



    }
}

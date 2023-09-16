package Web;

import Datos.Buscar;
import Datos.CuentaDAO;
import Datos.Util;
import DatosBD.Cuenta;
import DatosBD.CuentaPDF;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Retirar")
public class Retirar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String CodigoCuenta=request.getParameter("CodigoCuenta");
        Buscar buscar = new Buscar();
        Util util = new Util();


        if(CodigoCuenta.isEmpty()){
            request.setAttribute("error", "Ingrese el Codigo De la Cuenta a Depositar");
            request.getRequestDispatcher("Retirar.jsp").forward(request,response);
        }
        if(!buscar.ExisteCuenta(CodigoCuenta ) ||  !    util.esNumero(CodigoCuenta)){

            request.setAttribute("error", "La cuenta no existe");
            request.getRequestDispatcher("Retirar.jsp").forward(request,response);

        }else{

            CuentaPDF cuenta = CuentaDAO.getCuentaCompleta(CodigoCuenta);
            request.setAttribute("cuenta", cuenta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("HacerRetiro.jsp");
            dispatcher.forward(request, response);




        }


    }
}

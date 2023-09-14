package Web;

import Datos.Subir.CrearYasociarCuenta;
import DatosBD.Cuenta;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CrearCuenta")
public class CrearCuenta extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String CodigoUsuario=request.getParameter("CodigoCliente");
        String fecha=request.getParameter("fecha");

        if(CodigoUsuario.isEmpty()||fecha.isEmpty()){

            request.setAttribute("error", "Ingrese Todos los valores");
            request.getRequestDispatcher("CrearCuenta.jsp").forward(request,response);


        }

        CrearYasociarCuenta crear = new CrearYasociarCuenta();

        try {
          Cuenta cuenta =  crear.CrearYasociarCuenta(CodigoUsuario,fecha);
            request.setAttribute("cuenta", cuenta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("CuentaCreada.jsp");
            dispatcher.forward(request, response);


        } catch (SQLException e) {
            request.setAttribute("error", "Hubo un error, ingrese de nuevo los valores");
            request.getRequestDispatcher("CrearCuenta.jsp").forward(request,response);

        }


    }
}

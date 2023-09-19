package Web;

import Datos.Buscar;
import Datos.QueryActualizar.ActualizarLimites;
import Datos.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CambiarLimite")
public class CambiarLimite extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Util util = new Util();

        String valor1 = request.getParameter("Valor1");
        String valor2 = request.getParameter("Valor2");

        if (valor1.isEmpty() || valor2.isEmpty()) {

            request.setAttribute("error", "Ingrese Todos los valores ");
            request.getRequestDispatcher("CambiarLimite.jsp").forward(request, response);
        } else {

            if (util.esNumero(valor1) && util.esNumero(valor2)) {

                ActualizarLimites actulizar = new ActualizarLimites();
                try {
                    if (Float.parseFloat(valor2) > Float.parseFloat(valor1)) {
                        actulizar.ActualizarLimite("1", Float.parseFloat(valor1));
                        actulizar.ActualizarLimite("2", Float.parseFloat(valor2));

                        request.setAttribute("exito", "Se Actualizaron Correctamente");
                        request.getRequestDispatcher("CambiarLimite.jsp").forward(request, response);

                    } else {
                        request.setAttribute("error", "El valor 2 debe ser menor al valor 1");
                        request.getRequestDispatcher("CambiarLimite.jsp").forward(request, response);

                    }


                } catch (SQLException e) {
                    request.setAttribute("error", "Algo Ocurrio mal, vuelva a intentarlo");
                    request.getRequestDispatcher("CambiarLimite.jsp").forward(request, response);

                }


            } else {
                request.setAttribute("error", " valores validos");
                request.getRequestDispatcher("CambiarLimite.jsp").forward(request, response);
            }

        }


    }
}

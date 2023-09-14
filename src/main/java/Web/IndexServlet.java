package Web;

import Datos.ConexionBD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/indexServlet")

public class IndexServlet extends HttpServlet {
    static Connection conexion = ConexionBD.getInstancia().getConexion();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  Connection connection =conexion.();
        HttpSession sesion =request.getSession();
        sesion.setMaxInactiveInterval(3600);
        sesion.setAttribute("conexion",conexion);

        response.sendRedirect("Principal.jsp");

    }
}

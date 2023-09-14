package Web;

import Datos.Buscar;
import Datos.*;
import DatosBD.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
    DatosBD dato = new DatosBD();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute("conexion");

        String usuario = request.getParameter("usuarioT");
        String password = request.getParameter("passwordT");
        if (!password.isEmpty()) {

            Usuario usuarioo = dato.IsLogin(password, usuario);
            if (usuarioo != null) {

                if (usuarioo.getTipoUsuario() == 1) {
                    response.sendRedirect("ModuloGerente.jsp");
                    session.setAttribute("Gerente",usuarioo);

                }
                if (usuarioo.getTipoUsuario() == 2) {
                    response.sendRedirect("ModuloCajero.jsp");
                }
                if (usuarioo.getTipoUsuario() == 3) {
                    response.sendRedirect("ModuloUsuario.jsp");
                }

            } else {
                request.setAttribute("error", "Usuario o contraseña Incorrecta");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Debe Ingresar sus Datos");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }


    }
}

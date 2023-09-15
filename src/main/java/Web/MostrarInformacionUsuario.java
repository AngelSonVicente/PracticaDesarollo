package Web;

import Datos.Buscar;
import Datos.UsuarioDAO;
import DatosBD.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/MostrarInformacionUsuario")
public class MostrarInformacionUsuario extends HttpServlet {

    Buscar buscar = new Buscar();

    String CodigoGerente="";
    Usuario Gerente=new Usuario();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Gerente = (Usuario) session.getAttribute("Gerente");





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Gerente = (Usuario) session.getAttribute("Gerente");



        String CodigoUsuario = request.getParameter("CodigoUsuario");

        if (CodigoUsuario.isEmpty()) {
            request.setAttribute("error", "Ingrese Un Codigo");
            request.getRequestDispatcher("EditarInformacion.jsp").forward(request, response);

        }

        if (!buscar.ExisteUsuario(CodigoUsuario)) {
            request.setAttribute("error", "El Usuario no existe");
            request.getRequestDispatcher("EditarInformacion.jsp").forward(request, response);

        }if (CodigoUsuario.equals("101")) {
            request.setAttribute("error", "No se puede editar este usuario");
            request.getRequestDispatcher("EditarInformacion.jsp").forward(request, response);

        }
        String Tipo=buscar.getDato("usuario","codigo","tipoUsuario",CodigoUsuario);

        System.out.println("Codigo Gerente : " +Gerente.getCodigo());

        if (Tipo.equals("1")) {
            if(CodigoUsuario.equals(String.valueOf(Gerente.getCodigo()) )){
                request.setAttribute("TipoUsuario", "2");
                UsuarioT2 usuario= UsuarioDAO.getUsuarioT2(CodigoUsuario);
                request.setAttribute("usuario", usuario);

                RequestDispatcher dispatcher = request.getRequestDispatcher("ActualizarInformacion.jsp");
                dispatcher.forward(request, response);
            }else{

            }
            request.setAttribute("error", "No se puede editar este usuario");
            request.getRequestDispatcher("EditarInformacion.jsp").forward(request, response);

        }



        if(Tipo.equals("2")){
            request.setAttribute("TipoUsuario", "2");

            UsuarioT2 usuario= UsuarioDAO.getUsuarioT2(CodigoUsuario);
            request.setAttribute("usuario", usuario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ActualizarInformacion.jsp");
            dispatcher.forward(request, response);
        }
        if(Tipo.equals("3")){
            request.setAttribute("TipoUsuario", "3");

            UsuarioT3 usuario= UsuarioDAO.getUsuarioT3(CodigoUsuario);
            request.setAttribute("usuario", usuario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ActualizarInformacion.jsp");
            dispatcher.forward(request, response);
        }



    }
}

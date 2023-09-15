package Web;

import Datos.UsuarioDAO;
import DatosBD.Usuario;
import DatosBD.UsuarioT2;
import DatosBD.UsuarioT3;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ActualizarUsuario")
public class ActualizarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Usuario gerente = (Usuario) session.getAttribute("Gerente");


        String Tipo = request.getParameter("tipousuario");
        String CodigoUsuario = request.getParameter("CodigoSuario");

        Datos.Actualizar.ActualizarUsuario actualizarUsuario = new Datos.Actualizar.ActualizarUsuario();

        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String contra = request.getParameter("contra");
        String dpi = request.getParameter("dpi");

        if (nombre.isEmpty() || direccion.isEmpty() || dpi.isEmpty()) {
            request.setAttribute("error", "ningun campo debe estar vacio, ingreselos nuevamente");
            request.getRequestDispatcher("EditarInformacion.jsp").forward(request, response);


        }else{

        if (Tipo.equals("2")) {
            String turno = request.getParameter("turno");

            actualizarUsuario.ActulizarCuentaT2(String.valueOf(gerente.getCodigo()),CodigoUsuario, nombre, direccion, dpi, contra, turno);



            request.setAttribute("TipoUsuario", "2");
            UsuarioT2 usuario= UsuarioDAO.getUsuarioT2(CodigoUsuario);
            request.setAttribute("usuario", usuario);
            request.setAttribute("exito", "Se ha actualizado el usuario correctamente");

            RequestDispatcher dispatcher = request.getRequestDispatcher("ActualizarInformacion.jsp");
            dispatcher.forward(request, response);

        }
        if (Tipo.equals("3")) {
            actualizarUsuario.ActulizarCuentaT3(String.valueOf(gerente.getCodigo()),CodigoUsuario,nombre,direccion,dpi,contra);


            request.setAttribute("TipoUsuario", "3");

            request.setAttribute("exito", "Se ha actualizado el usuario correctamente");
            UsuarioT3 usuario= UsuarioDAO.getUsuarioT3(CodigoUsuario);
            request.setAttribute("usuario", usuario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("ActualizarInformacion.jsp");
            dispatcher.forward(request, response);
        }


        }



    }


}


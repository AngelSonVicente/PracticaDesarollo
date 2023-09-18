package Web;

import Datos.Buscar;
import Datos.Subir.SubirSolicitudAsociacion;
import DatosBD.SolicitudAsociacion;
import DatosBD.Transferencia;
import DatosBD.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/GenerarSolicitudAsociacion")
public class GenerarSolicitudAsociacion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Buscar buscar = new Buscar();
        HttpSession session = request.getSession();

        Usuario usuario = (Usuario) session.getAttribute("Cliente");


        String CodigoCuenta = request.getParameter("CodigoCuenta");

        if (buscar.CuentaAsociada(CodigoCuenta, String.valueOf(usuario.getCodigo()))) {
            request.setAttribute("error", "La Cuenta ya esta asociada a tu usuario");
            request.getRequestDispatcher("CrearSolicitudAsociacion.jsp").forward(request, response);

        } else {

            if(buscar.PuedeSolicitarAsociar(CodigoCuenta, String.valueOf(usuario.getCodigo()))){


            SubirSolicitudAsociacion subir = new SubirSolicitudAsociacion();
            try {
                SolicitudAsociacion SolicitudAsociasion = subir.SoliAsociacion(CodigoCuenta,String.valueOf( usuario.getCodigo()));

                request.setAttribute("Solicitud", SolicitudAsociasion);

                request.getRequestDispatcher("MostrarSolicitudAsociacionHecha.jsp").forward(request,response);


            } catch (SQLException e) {
                request.setAttribute("error", "Ocurrio un error al generar la solicitud, vuelva a intentarlo");
                request.getRequestDispatcher("CrearSolicitudAsociacion.jsp").forward(request, response);

            }


            }else{
                request.setAttribute("error", "Ya no puede realizar mas solicitudes de asocion a esta cuenta");
                request.getRequestDispatcher("CrearSolicitudAsociacion.jsp").forward(request, response);
            }



        }


    }
}

package Web;

import Datos.Actualizar.EstadoSoliyAsociarCuenta;
import Datos.SolicitudAsociacionDAO;
import DatosBD.Estados;
import DatosBD.SolicitudAsociacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/AprobacionSolicitudAsociacion")

public class AprobacionSolicitudAsociacion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String estado =request.getParameter("Estado");
        String codigoSoli =request.getParameter("IDSolicitud");

        SolicitudAsociacion solicitud = SolicitudAsociacionDAO.getSolicitudAsociacion(codigoSoli);

        if(estado.equals("Aceptado")){
            EstadoSoliyAsociarCuenta actualizar = new EstadoSoliyAsociarCuenta();
            actualizar.ActualizarEstadoSOliyAsociarCuenta(codigoSoli,String.valueOf(solicitud.getCodigoCuenta()),String.valueOf(solicitud.getCodigoCliente()), Estados.Aceptado);

        request.setAttribute("mensaje", "Se  ha "+estado+" la solicitud");
        request.getRequestDispatcher("SolicitudesAsociacion.jsp").forward(request,response);
        }
        if(estado.equals("Rechazado")){
            EstadoSoliyAsociarCuenta actualizar = new EstadoSoliyAsociarCuenta();
            actualizar.ActualizarEstadoSOliyAsociarCuenta(codigoSoli,String.valueOf(solicitud.getCodigoCuenta()),String.valueOf(solicitud.getCodigoCliente()), Estados.Rechazada);
        request.setAttribute("mensaje", "Se  ha "+estado+" la solicitud");
        request.getRequestDispatcher("SolicitudesAsociacion.jsp").forward(request,response);
        }


        request.getRequestDispatcher("SolicitudesAsociacion.jsp").forward(request,response);




    }
}

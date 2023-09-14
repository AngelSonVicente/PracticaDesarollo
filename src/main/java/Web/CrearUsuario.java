package Web;

import Datos.Subir.SubirUsuarioCliente;
import DatosBD.NuevoCliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@WebServlet("/CrearUsuario")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 15, // 15 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class CrearUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Nombre = request.getParameter("Nombre");
        String Direccion = request.getParameter("descripcion");
        String DPI = request.getParameter("DPI");
        String Sexo = request.getParameter("Sexo");
        String Cumple = request.getParameter("birth");

        Part pdfPart = request.getPart("archivoPDF");

        if(Nombre.isEmpty() || Direccion.isEmpty() || DPI.isEmpty() || Sexo.isEmpty() ||Cumple.isEmpty()){
            request.setAttribute("error", "Ingrese Todos los valores");
            request.getRequestDispatcher("CrearUsuario.jsp").forward(request,response);


            System.out.println("tendria que regresarlo a la pagina ");
        }


        InputStream inputStream = pdfPart.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }


        byte[] pdfBytes = byteArrayOutputStream.toByteArray();


        if(pdfBytes.length==0){
            request.setAttribute("error", "Ingrese Todos los valores");
            request.getRequestDispatcher("CrearUsuario.jsp").forward(request,response);


        }

        SubirUsuarioCliente subir= new SubirUsuarioCliente();
        try {

           NuevoCliente usuario = subir.ClienteUsuario(Nombre,Direccion,DPI,Sexo,Cumple,pdfBytes);

            request.setAttribute("usuario", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("UsuarioCreado.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            request.setAttribute("error", "Hubo un error, ingrese de nuevo lo datos");
            request.getRequestDispatcher("CrearUsuario.jsp").forward(request,response);

        }


    }
}

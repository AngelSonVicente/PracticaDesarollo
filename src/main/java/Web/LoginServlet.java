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
    Buscar datos = new Buscar();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection connection = (Connection) session.getAttribute("conexion");

        String usuario=request.getParameter("usuarioT");
        String password=request.getParameter("passwordT");
        String Nombre="";
        String TipoTienda="";
        String CodigoTienda="";
        String  IDsuarioTienda="";
        String tipousuario= request.getParameter("tipousuario");

        System.out.println("tipo usuario: "+tipousuario);


        if(!password.isEmpty()){

            Usuario usuarioo= dato.IsLogin(password,usuario);
            if(usuarioo != null){

                if(usuarioo.getTipoUsuario()==1){
                    response.sendRedirect("ModuloGerente.jsp");
                }
                if(usuarioo.getTipoUsuario()==2){
                    response.sendRedirect("ModuloCajero.jsp");
                }
                if(usuarioo.getTipoUsuario()==3){
                    response.sendRedirect("ModuloUsuario.jsp");
                }





            }else{
                request.setAttribute("error", "Usuario o contraseña Incorrecta");
                request.getRequestDispatcher("Login.jsp?user="+tipousuario).forward(request,response);


            }


        }else{
          request.setAttribute("error", "Usuario o contraseña Incorrecta");
                request.getRequestDispatcher("Login.jsp?user="+tipousuario).forward(request,response);

        }

        /*
        if(!password.isEmpty()){

            if(tipousuario.equals("admin") && dato.IsLogin("administrador",password,usuario)){
                    response.sendRedirect("ModuloAdministrador.jsp");

            }else{
                if(tipousuario.equals("recepcion") && dato.IsLogin("recepcion",password,usuario)){

                    String biblioteca= datos.getDato("usuario_recepcion","usuario","biblioteca",usuario);
                    String IDrecepcionista= datos.getDato("usuario_recepcion","usuario","codigo",usuario);
                    session.setAttribute("CodigoRecepcion", IDrecepcionista);
                    session.setAttribute("biblioteca",biblioteca );


                    response.sendRedirect("ModuloRecepcionista.jsp");

                }else{

                    if(tipousuario.equals("final") && dato.IsLogin("final",password,usuario)){
                        String IDrecepcionista= datos.getDato("usuario_final","usuario","codigo",usuario);
                        session.setAttribute("CodigoUsuario", IDrecepcionista);



                        response.sendRedirect("ModuloUsuario.jsp");

                    }else{

                        if(tipousuario.equals("transporte") && dato.IsLogin("transporte",password,usuario)){

                        response.sendRedirect("ModuloTransporte.jsp");

                        }else{

                    request.setAttribute("error", "Usuario o contraseña Incorrecta");
                    request.getRequestDispatcher("Login.jsp?user="+tipousuario).forward(request,response);
                    }
                        }




                }

            }

        }else{
          request.setAttribute("error", "Usuario o contraseña Incorrecta");
                request.getRequestDispatcher("Login.jsp?user="+tipousuario).forward(request,response);

        }
*/


/*
        if(dato.IsLogin("administrador",password,usuario)){

           Nombre= datos.getDato("usuario_administrador","usuario","nombre",usuario);
     System.out.println("Nombre: " + Nombre);


            CodigoTienda= datos.getDato("usuario_tienda","usuario","codigo_tienda",usuario);
            TipoTienda= datos.getDato("tienda","codigo_tienda","tipo_tienda",CodigoTienda);
            IDsuarioTienda= datos.getDato("usuario_tienda","usuario","codigo",usuario);

            session.setAttribute("usuario", Nombre);
            session.setAttribute("TipoTienda", TipoTienda );
            //parametros que van a la base
            session.setAttribute("idUsuario", IDsuarioTienda );
            session.setAttribute("idTienda", CodigoTienda);
            session.setAttribute("bodega","no");
            session.setAttribute("supervisor","No");


        }else{
            if(dato.IsLogin("final",password,usuario)){
                response.sendRedirect("ModuloUsuario.jsp");


            }else{

                if(dato.IsLogin("recepcion",password,usuario)){
                    response.sendRedirect("ModuloRecepcion.jsp");


                }else{

                    if(dato.IsLogin("transporte",password,usuario)){
                        response.sendRedirect("ModuloTransporte.jsp");

                    }
                }


            }



            request.setAttribute("error", "Usuario o contraseña Incorrecta");
            request.getRequestDispatcher("Login.jsp").forward(request,response);

        }
*/




    }
}

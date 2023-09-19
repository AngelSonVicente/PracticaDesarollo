<%@ page import="DatosBD.Usuario" %>
<%@ page import="Datos.Buscar" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 13/09/2023
  Time: 11:44 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modulo Gerente</title>
</head>
<body>
<%
    Usuario gerente = (Usuario) session.getAttribute("Gerente");

    boolean turno = Buscar.EstaenTurno(gerente.getCodigo());
%>
<h1>Modulo Gerente</h1>

<h2>
<br>
   <%if(turno){%>
    <a href="CambiarLimite.jsp">Cambiar Limites de reportes</a></br></br>
    <a href="CrearUsuario.jsp">Crear Usuario</a></br></br>
    <a href="CrearCuenta.jsp">Crear Cuenta</a></br></br>
    <a href="EditarInformacion.jsp">Actualizar Informacion Clientes y Cajeros</a></br></br>
   <%}%>

    <a href="ReportesAdministrador.jsp">Reportes</a></br></br>




</h2>

</body>
</html>

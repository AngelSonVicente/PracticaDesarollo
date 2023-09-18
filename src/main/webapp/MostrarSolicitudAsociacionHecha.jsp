<%@ page import="DatosBD.SolicitudAsociacion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostar Solicitud Asociacion</title>
</head>
<body>

<%
    SolicitudAsociacion solicitud = (SolicitudAsociacion) request.getAttribute("Solicitud");

%>

<h1>Solicitud Realizado con exito</h1>

Codigo: <%=solicitud.getCodigo()%></br></br>
Codigo Cuenta Solicitada: <%=solicitud.getCodigoCuenta()%></br>
Fecha: <%=solicitud.getFecha()%></br>
Estado: <%=solicitud.getEstado()%></br>



<form action="CrearSolicitudAsociacion.jsp">
    <input type="submit" value="Seguir haciendo solicitudes">
</form>
<form action="ModuloUsuario.jsp">
    <input type="submit" value="Volver a la Pagina Principial">
</form>
</body>
</html>

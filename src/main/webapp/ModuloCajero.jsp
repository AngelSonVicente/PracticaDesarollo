<%@ page import="DatosBD.Usuario" %>
<%@ page import="Datos.Buscar" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 15/09/2023
  Time: 05:11 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modulo Cajero</title>
</head>
<body>
<h1>Modulo Cajero</h1>

<%
    Usuario gerente = (Usuario) session.getAttribute("Cajero");

    boolean turno = Buscar.EstaenTurno(gerente.getCodigo());
%>

<h2>
  <br>

    <%if (turno){%>
    <a href="Depositar.jsp">Hacer Deposito</a></br></br>
  <a href="Retirar.jsp">Hacer Retiro</a></br></br>
    <%}%>

  <a href="ReportesCajero.jsp">Reportes</a></br></br>




</h2>

</body>
</html>

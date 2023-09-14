<%@ page import="DatosBD.Usuario" %><%--
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

%>
<h1>Modulo Gerente</h1>

<h2>
<a href="CrearUsuario.jsp">Crear Usuario</a>
<a href="CrearCuenta.jsp">Crear Cuenta</a>

</h2>

</body>
</html>

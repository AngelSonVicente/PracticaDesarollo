<%@ page import="DatosBD.NuevoCliente" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 14/09/2023
  Time: 05:48 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuario Creado</title>

</head>
<body>

<%
    NuevoCliente cliente = (NuevoCliente) request.getAttribute("usuario");

%>
<h1> Usuario nuevo Creado</h1> </br>
<h2> Datos</h2> </br>
<h3>
    Codigo:   <%=cliente.getCodigo()%> </br>
    Nombre:   <%=cliente.getNombre()%> </br>
    Contraseña:   <%=cliente.getTemporalPass()%>  (Se recomienda Cambiarlo)</br></br>
    Apuntar Los datos del usuario

<form action="CrearCuenta.jsp" method="post">
    <input type="hidden" name="Codigo" value="<%=cliente.getCodigo()%>">

    <input type="submit" value="Crear Cuenta">
</form>


</h3>




</body>
</html>

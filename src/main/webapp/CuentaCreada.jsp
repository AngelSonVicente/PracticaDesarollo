<%@ page import="DatosBD.Cuenta" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 14/09/2023
  Time: 08:12 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CuentaCreada</title>
</head>
<body>


<%
  Cuenta cuenta = (Cuenta) request.getAttribute("cuenta");

%>
<h1> Cuenta Creada con exito</h1> </br>
<h2> Datos</h2> </br>
<h3>
  Codigo:   <%=cuenta.getCodigo()%> </br>
  CodigoCliente:   <%=cuenta.getCodigoCliente()%> </br>
  Nombre:   <%=cuenta.getNombreCliente()%>  </br></br>
  saldo:   <%=cuenta.getSaldo()%>  </br></br>

  <form action="ModuloGerente.jsp" >

    <input type="submit" value="Volver Al Modulo">
  </form>


</h3>


</body>
</html>

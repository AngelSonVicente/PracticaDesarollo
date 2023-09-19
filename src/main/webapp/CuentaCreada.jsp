<%@ page import="DatosBD.Cuenta" %>
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

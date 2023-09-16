<%@ page import="DatosBD.Transaccion" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 15/09/2023
  Time: 11:39 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transaccion Hecha</title>
</head>
<body>
<%

  Transaccion transaccion = (Transaccion) request.getAttribute("transaccion");

%>

<%if(transaccion!=null){%>

<h1>Transaccion Hecha Con Exito</h1></br></br>

Codigo de Transaccion: <%=transaccion.getCodigoTransaccion()%> </br>
Codigo de Cuenta: <%=transaccion.getCodigoCuenta()%> </br>
Codigo Cajero: <%=transaccion.getCodigoCajero()%></br>
Tipo de Transaccion: <%=transaccion.getTipo()%> </br>
Hecha el : <%=transaccion.getFecha()%>  <%=transaccion.getHora()%></br>
Monto: <%=transaccion.getMonto()%>

<form action="Depositar.jsp">
    <input type="submit" value="Seguir haciendo depositos">
</form>
<form action="ModuloCajero.jsp">
    <input type="submit" value="Volver al Modulo">
</form>





<%}%>


</body>
</html>

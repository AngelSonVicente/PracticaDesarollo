<%@ page import="DatosBD.Transaccion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transaccion Hecha</title>
</head>
<body>
<%

    Transaccion transaccion = (Transaccion) request.getAttribute("transaccion");


    String accion = "";
    String accion2 = "";
    if (transaccion.getTipo().equals("Credito")) {
        accion = "Depositar";
        accion2 = "Depositos";
    }
    if (transaccion.getTipo().equals("Debito")) {
        accion = "Retirar";
        accion2 = "Retiros";
    }

%>

<%if (transaccion != null) {%>

<h1>Transaccion Hecha Con Exito</h1></br></br>

Codigo de Transaccion: <%=transaccion.getCodigoTransaccion()%> </br>
Codigo de Cuenta: <%=transaccion.getCodigoCuenta()%> </br>
Codigo Cajero: <%=transaccion.getCodigoCajero()%></br>
Tipo de Transaccion: <%=transaccion.getTipo()%> </br>
Hecha el : <%=transaccion.getFecha()%>  <%=transaccion.getHora()%></br>
Monto: <%=transaccion.getMonto()%>


<form action="<%=accion%>.jsp">
    <input type="submit" value="Seguir haciendo <%=accion2%>">
</form>
<form action="ModuloCajero.jsp">
    <input type="submit" value="Volver al Modulo">
</form>


<%}%>


</body>
</html>

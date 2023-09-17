<%@ page import="DatosBD.Transferencia" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar Transferencia</title>
</head>
<body>
<%
  Transferencia transferencia = (Transferencia) request.getAttribute("transferencia");
%>


<%if (transferencia != null) {%>

<h1>Transaccion Hecha Con Exito</h1></br></br>

Codigo de Transaccion: <%=transferencia.getCodigotransaccion()%> </br>
Codigo de Cuenta Debito: <%=transferencia.getCuentaDebito()%> </br>
Codigo Cuenta Acreditada: <%=transferencia.getCuentaCredito()%> </br>
<%
if(transferencia.getCodigoCajero()==101){


%>
Cajero: Banca En Linea

<%}%>

Hecha el : <%=transferencia.getFecha()%>  <%=transferencia.getHora()%></br>
Monto: <%=transferencia.getMonto()%></br>
Tipo de Transferencia: <%=transferencia.getTipo()%></br>
Saldo de La cuenta : <%=transferencia.getSaldoCuenta()%></br>



<form action="ModuloUsuario.jsp">
  <input type="submit" value="Volver al Modulo">
</form>
<form action="Transferencias.jsp">
  <input type="submit" value="Seguir Haciendo Transferencias">
</form>


<%}%>

</body>
</html>

<%@ page import="DatosBD.CuentaPDF" %>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hacer Retiro</title>
</head>
<body>

<%

    CuentaPDF cuenta = (CuentaPDF) request.getAttribute("cuenta");

    String base64PDF = Base64.getEncoder().encodeToString(cuenta.getPdfdpi());
%>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

Datos de la cuenta: </br></br>
Codigo Cuenta: <%=cuenta.getCodigoCuenta()%> </br></br>
Propetario : <%=cuenta.getNombreCliente()%></br></br>
No. DPI : <%=cuenta.getDPI()%></br></br>
Fecha de Nacmiento : <%=cuenta.getFechaCumple()%></br></br>
Sexo : <%=cuenta.getSexo()%></br></br>
Direccion : <%=cuenta.getDireccion()%></br></br>
Saldo : <%=cuenta.getSaldo()%></br></br>

DPI escaneado :</br></br>

<object data="data:application/pdf;base64,<%= base64PDF %>" type="application/pdf" width="100%" height="460px">
    <p>Tu navegador web no puede mostrar el archivo PDF. Puedes descargarlo <a href="Examen.pdf">aquí</a>.</p>
</object>
</br></br></br></br>
<form action="HacerRetiro" method="post">
    Ingrese la cantidad ha Retirar
    <input type="text" name="Monto" >
    <input type="hidden" name="CodigoCuenta" value="<%=cuenta.getCodigoCuenta()%>">
    <input type="submit" value="Realizar Retiro">

</form>

<form action="Retirar.jsp" method="post">
    <input type="submit" value="No Hacer Retiro">
</form>


</body>
</html>

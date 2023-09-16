<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DatosBD.Cuenta" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Realizar Deposito</title>
</head>
<body>
<%

    Cuenta cuenta = (Cuenta) request.getAttribute("cuenta");


%>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

Datos de la cuenta: </br></br>
Codigo: <%=cuenta.getCodigo()%> </br></br>
Nombre Del propetario de la cuenta: <%=cuenta.getNombreCliente()%></br></br>

<form action="HacerDeposito" method="post">
    Ingrese la cantidad ha depositar
    <input type="text" name="Monto" required>
    <input type="hidden" name="CodigoCuenta" value="<%=cuenta.getCodigo()%>">


    <input type="submit" value="Realizar Deposito">

</form>


</body>
</html>

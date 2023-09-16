
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hacer Deposito</title>
</head>
<body>
<c:if   test="${not empty error}">
    <p  style="color: red">${error}</p>
</c:if>
<form action="Depositar" method="post">

  <input type="text" name="CodigoCuenta">

  <input type="submit" value="Buscar Cuenta">

</form>




</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 16/09/2023
  Time: 01:22 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retirar</title>
</head>
<body>

<c:if   test="${not empty error}">
  <p  style="color: red">${error}</p>
</c:if>
<form action="Retirar" method="post">

  <input type="text" name="CodigoCuenta">

  <input type="submit" value="Buscar Cuenta">

</form>




</body>
</html>

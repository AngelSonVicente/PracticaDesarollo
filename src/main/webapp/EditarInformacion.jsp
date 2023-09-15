
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actulizar Informacion</title>
</head>
<body>

<c:if   test="${not empty error}">
    <p  style="color: red">${error}</p>
</c:if>

<form action="MostrarInformacionUsuario" method="post">
    Ingrese el Codigo del Usuario <input type="text" name="CodigoUsuario"> </br>

<input type="submit" value="Editar">
</form>



</body>
</html>

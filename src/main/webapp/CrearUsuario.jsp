<%@ page import="DatosBD.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 14/09/2023
  Time: 12:34 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear usuario</title>
</head>

<%
    Usuario gerente = (Usuario) session.getAttribute("Gerente");

%>
<c:if   test="${not empty error}">
    <p  style="color: red">${error}</p>
</c:if>

<form action="CrearUsuario" method="post" enctype="multipart/form-data">

Nombre: <input type="text" name="Nombre" maxlength="45" > </br></br>
Direccion:<textarea  name="descripcion" rows="5" cols="50" maxlength="250" style="resize: none"></textarea></br></br>
DPI: <input type="text" name="DPI" maxlength="15" > </br></br>
Sexo:
<select name="Sexo" required>
    <option value="Masculino"> Masculino</option>
    <option value="Femenino">Femenino</option>
</select></br></br>

DPI: <input type="date" name="birth" > </br></br>

DPI Escaneado <input type="file" name="archivoPDF"></br></br>

<input type="submit" value="CrearUsuario">

</form>




</body>
</html>

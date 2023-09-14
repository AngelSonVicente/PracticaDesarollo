<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 14/09/2023
  Time: 05:59 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Cuenta</title>
</head>
<body>
<%
    String Codigousuario=request.getParameter("Codigo");
    String codigo ="";
    if(Codigousuario!=null){
        codigo=Codigousuario;
    }

    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    String fechaActual = formatoFecha.format(fecha);




%>
<c:if   test="${not empty error}">
    <p  style="color: red">${error}</p>
</c:if>

<form action="CrearCuenta" method="post">

<input type="text"  name="CodigoCliente" value="<%=codigo%>"></br></br>
<input type="date"  name="fecha" value="<%=fechaActual%>"></br></br>
    <input type="submit" value="Crear Cuenta">
</form>


</body>
</html>

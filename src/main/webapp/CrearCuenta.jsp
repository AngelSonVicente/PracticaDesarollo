<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Cuenta</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
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

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<div class="container mt-5">
    <h2>Crear Cuenta</h2>
    <form action="CrearCuenta" method="post">
        <div class="mb-3">
            <label for="CodigoCliente" class="form-label">Código de Cliente:</label>
            <input type="text" class="form-control" id="CodigoCliente" name="CodigoCliente" value="<%=codigo%>">
        </div>
        <div class="mb-3">
            <label for="fecha" class="form-label">Fecha:</label>
            <input type="date" class="form-control" id="fecha" name="fecha" value="<%=fechaActual%>">
        </div>
        <div class="mb-3">
            <input type="submit" class="btn btn-primary" value="Crear Cuenta">
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"></script>
</body>
</html>


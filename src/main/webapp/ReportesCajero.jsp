<%@ page import="DatosBD.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Datos.Reportes.ReportesAdministrador" %>
<%@ page import="Datos.Reportes.ReportesCajero" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reportes Cajero</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Reportes Cajero</h2>

    <%
        Usuario Cajero = (Usuario) session.getAttribute("Cajero");

        String tipoReporte = request.getParameter("reporte");


        String FechaInicio = request.getParameter("FechaIncio");


        ArrayList<DeporsitoRetirosCajero> Listatransaccion = ReportesCajero.DepositosRetirosCajero(String.valueOf(Cajero.getCodigo()));
        ArrayList<DeporsitoRetirosCajero> ListraTrasaccion2 = ReportesCajero.TransaccioneshechasDia(String.valueOf(Cajero.getCodigo()), FechaInicio);


    %>
    <div class="form-group">
        <label for="TipoReporte">Seleccione un Reporte:</label>
        <select class="form-control" id="TipoReporte" onchange="Actualizar()">
            <option value="0">Seleccione un Reporte</option>
            <option value="1">Listado de depósitos y retiros realizados durante su turno</option>
            <option value="2">Listado de las transacciones realizadas por día</option>
        </select>
    </div>

    <%
        if (tipoReporte != null) {
    %>

    <% if (tipoReporte.equals("2")) { %>
    <form>
        <div class="form-group">
            <label>Ingrese la Fecha:</label>
            <input type="date" class="form-control" name="FechaIncio">
        </div>
        <input type="hidden" name="reporte" value="<%=tipoReporte%>">
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Mostrar Reporte</button>
        </div>
    </form>
    <% } %>
    <% } %>

    <%
        if (tipoReporte != null) {
    %>

    <% if (tipoReporte.equals("1")) { %>
    <table class="table table-success table-striped" id="tabla_libros">
        <thead class="table-dark">
        <tr>
            <th>Codigo Cajero</th>
            <th>Nombre Cajero</th>
            <th>Codigo Transaccion</th>
            <th>Codigo Cuenta</th>
            <th>Fecha y Hora</th>
            <th>Monto</th>
            <th>Saldo Cuenta</th>
            <th>Saldo Caja</th>
            <th></th>
        </tr>
        </thead>
        <% for (DeporsitoRetirosCajero transaccion : Listatransaccion) { %>
        <tr>
            <td><%= transaccion.getCodigoCajero() %></td>
            <td><%= transaccion.getNombreCajero() %></td>
            <td><%= transaccion.getCodigoTransaccion() %></td>
            <td><%= transaccion.getCodigoCuenta() %></td>
            <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %></td>
            <td><%=transaccion.getTipo()%></td>
            <td><%=transaccion.getMonto()%></td>
            <td><%=transaccion.getSaldoCuenta()%></td>
            <td><%=transaccion.getCaja()%></td>
        </tr>
        <% } %>
    </table>
    <% } %>

    <% if (tipoReporte.equals("2")) { %>
    <table class="table table-success table-striped" id="tabla_libros">
        <thead class="table-dark">
        <tr>
            <th>Codigo Cajero</th>
            <th>Nombre Cajero</th>
            <th>Codigo Transaccion</th>
            <th>Codigo Cuenta</th>
            <th>Fecha y Hora</th>
            <th>Monto</th>
            <th>Saldo Cuenta</th>
            <th>Saldo Caja</th>
            <th></th>
        </tr>
        </thead>
        <% for (DeporsitoRetirosCajero transaccion : ListraTrasaccion2) { %>
        <tr>
            <td><%= transaccion.getCodigoCajero() %></td>
            <td><%= transaccion.getNombreCajero() %></td>
            <td><%= transaccion.getCodigoTransaccion() %></td>
            <td><%= transaccion.getCodigoCuenta() %></td>
            <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %></td>
            <td><%=transaccion.getTipo()%></td>
            <td><%=transaccion.getMonto()%></td>
            <td><%=transaccion.getSaldoCuenta()%></td>
            <td><%=transaccion.getCaja()%></td>
        </tr>
        <% } %>
    </table>
    <% } %>

    <% } %>
</div>

<script>
    function Actualizar() {
        var id = document.getElementById("TipoReporte").value;
        window.location.href = "ReportesCajero.jsp?reporte=" + id;
    }
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

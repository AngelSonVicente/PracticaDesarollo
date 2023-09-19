<%@ page import="DatosBD.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Datos.Reportes.ReportesAdministrador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reportes Administrador</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>



<%
    String tipoReporte = request.getParameter("reporte");

    String CodigoUsuario = request.getParameter("Codigousuario");

    String FechaInicio=request.getParameter("FechaIncio");
    String FechaFin=request.getParameter("FechaFin");


    ArrayList<CambioRealizado> ListaCambios = ReportesAdministrador.HistorialCambiosUsuarios(CodigoUsuario);
    ArrayList<ClientesTransaccionesMayores> ListaClientesML = ReportesAdministrador.ClientesConTransaccionesMayoresaLimite();
    ArrayList<ClienteTransaccionSumMayores> ListaClientesMLSUMA = ReportesAdministrador.CLientesTransacionesSumadasMayores();
    ArrayList<Cuenta> TOP10CLientesPistudos = ReportesAdministrador.Top10UsuariosMasDineroCuentas();
    ArrayList<Usuario> ClientesSinTransacciones = ReportesAdministrador.UsuariosSinTransacciones(FechaInicio,FechaFin);
    ArrayList<HistorialTransaccion> HistorialTransaccion = ReportesAdministrador.HistorialTransaccion(CodigoUsuario);

    CajeroMasTransacciones cajero = ReportesAdministrador.CajeroConMasTransacciones(FechaInicio, FechaFin);



%>

<div class="container mt-5">
    <h2 class="text-center mb-4">Reportes Administrador</h2>

    <form>
        <div class="form-group">
            <label for="TipoReporte">Seleccione un Reporte:</label>
            <select class="form-control" id="TipoReporte" onchange="Actualizar()">
                <option value="0">Seleccione un Reporte</option>
                <option value="1">Historial de cambios realizados en la información</option>
                <option value="2">Clientes con transacciones monetarias mayores a</option>
                <option value="3">Clientes con transacciones monetarias sumadas mayores a un límite establecido</option>
                <option value="4">Los 10 clientes con más dinero en sus cuentas</option>
                <option value="5">Clientes que no han realizado transacciones dentro de un intervalo de tiempo</option>
                <option value="6">Historial de transacciones de un cliente</option>
                <option value="7">Cajero que más transacciones ha realizado en un intervalo de tiempo</option>
            </select>
        </div>

        <% if (tipoReporte != null) { %>
        <% if (tipoReporte.equals("1") ||   tipoReporte.equals("6") ) { %>
        <div class="form-group">
            <label for="Codigousuario">Ingrese el código del usuario:</label>
            <input type="text" class="form-control" id="Codigousuario" name="Codigousuario">
        </div>
        <% } %>

        <% if (tipoReporte.equals("5") || tipoReporte.equals("7")) { %>
        <div class="form-group">
            <label for="FechaIncio">Ingrese la Fecha de Inicio:</label>
            <input type="date" class="form-control" id="FechaIncio" name="FechaIncio">
        </div>

        <div class="form-group">
            <label for="FechaFin">Ingrese la Fecha de Fin:</label>
            <input type="date" class="form-control" id="FechaFin" name="FechaFin">
        </div>
        <% } %>

        <input type="hidden" name="reporte" value="<%=tipoReporte%>">

        <div class="text-center">
            <button type="submit" class="btn btn-primary">Mostrar Reporte</button>
        </div>
        <% } %>
    </form>
</div>

<% if (tipoReporte != null) { %>
<% if (tipoReporte.equals("1")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Cambio</th>
        <th>Codigo Gerente</th>
        <th>Codigo Usuario Modificado</th>
        <th>Nombre Usuario</th>
        <th>Fecha y Hora</th>
    </tr>
    </thead>
    <% for (CambioRealizado cambio : ListaCambios) { %>
    <tr>
        <td><%= cambio.getCodigo() %></td>
        <td><%= cambio.getCodigoGerente() %></td>
        <td><%= cambio.getCodigoUsuarioModificafo() %></td>
        <td><%= cambio.getNombreUsuarioModificado() %></td>
        <td><%= cambio.getFecha() + "  " + cambio.getHora() %></td>
    </tr>
    <% } %>
</table>
<% } %>

<% if (tipoReporte.equals("2")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Cliente</th>
        <th>Nombre Cliente</th>
        <th>Codigo de Cuenta</th>
        <th>Codigo Transaccion</th>
        <th>Codigo Cajero</th>
        <th>Monto</th>
        <th>Fecha y Hora</th>
    </tr>
    </thead>
    <% for (ClientesTransaccionesMayores cliente : ListaClientesML) { %>
    <tr>
        <td><%= cliente.getCodigoCliente() %></td>
        <td><%= cliente.getNombreCliente() %></td>
        <td><%= cliente.getCodigoCuenta() %></td>
        <td><%= cliente.getCodigoTransaccion() %></td>
        <td><%= cliente.getCodigoCajero() %></td>
        <td><%= cliente.getMonto() %></td>
        <td><%= cliente.getFecha() + "  " + cliente.getHora() %></td>
    </tr>
    <% } %>
</table>
<% } %>

<% if (tipoReporte.equals("3")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Cliente</th>
        <th>Nombre Cliente</th>
        <th>Monto</th>
    </tr>
    </thead>
    <% for (Cuenta cliente : TOP10CLientesPistudos) { %>
    <tr>
        <td><%= cliente.getCodigoCliente() %></td>
        <td><%= cliente.getNombreCliente() %></td>
        <td><%= cliente.getSaldo() %></td>
    </tr>
    <% } %>
</table>
<% } %>

<% if (tipoReporte.equals("4")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Cliente</th>
        <th>Nombre Cliente</th>
        <th>Monto</th>
    </tr>
    </thead>
    <% for (ClienteTransaccionSumMayores cliente : ListaClientesMLSUMA) { %>
    <tr>
        <td><%= cliente.getCodigoCliente() %></td>
        <td><%= cliente.getNombreCliente() %></td>
        <td><%= cliente.getMonto() %></td>
    </tr>
    <% } %>
</table>
<% } %>

<% if (tipoReporte.equals("5")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Cliente</th>
        <th>Nombre Cliente</th>
        <th>DPI</th>
    </tr>
    </thead>
    <% for (Usuario usuario : ClientesSinTransacciones) { %>
    <tr>
        <td><%= usuario.getCodigo() %></td>
        <td><%= usuario.getNombre() %></td>
        <td><%= usuario.getDPI() %></td>
    </tr>
    <% } %>
</table>
<% } %>

<% if (tipoReporte.equals("7")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Cajero</th>
        <th>Nombre Cajero</th>
        <th>Cantidad de Transacciones</th>
    </tr>
    </thead>
    <tr>
        <td><%= cajero.getCodigo() %></td>
        <td><%= cajero.getNombre() %></td>
        <td><%= cajero.getCantidadTransacciones() %></td>
    </tr>
</table>
<% } %>

<% if (tipoReporte.equals("6")) { %>
<table class="table table-success table-striped" id="tabla_libros">
    <thead class="table-dark">
    <tr>
        <th>Codigo Transaccion</th>
        <th>Codigo Cliente</th>
        <th>Nombre Cliente</th>
        <th>Codigo Cuenta</th>
        <th>Codigo Cajero</th>
        <th>Tipo</th>
        <th>Fecha y Hora</th>
        <th>Monto</th>
        <th>Saldo Cuenta</th>
    </tr>
    </thead>
    <% for (HistorialTransaccion transaccion : HistorialTransaccion) { %>
    <tr>
        <td><%= transaccion.getCodigoTransaccion() %></td>
        <td><%= transaccion.getCodigoCliente() %></td>
        <td><%= transaccion.getNombreCliente() %></td>
        <td><%= transaccion.getCodigoCuenta() %></td>
        <td><%= transaccion.getCodigoCajero() %></td>
        <td><%= transaccion.getTipo() %></td>
        <td><%= transaccion.getFecha() + "  " + transaccion.getHora() %></td>
        <td><%= transaccion.getMonto() %></td>
        <td><%= transaccion.getSaldoCuenta() %></td>
    </tr>
    <% } %>
</table>
<% } %>
<% } %>

<script>
    function Actualizar() {
        var id = document.getElementById("TipoReporte").value;
        window.location.href = "ReportesAdministrador.jsp?reporte=" + id;
    }
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

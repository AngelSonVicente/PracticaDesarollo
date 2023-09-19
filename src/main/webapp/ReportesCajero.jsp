<%@ page import="DatosBD.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Datos.Reportes.ReportesAdministrador" %>
<%@ page import="Datos.Reportes.ReportesCajero" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reportes Cajero</title>
</head>
<body>

<%
    Usuario Cajero = (Usuario) session.getAttribute("Cajero");

    String tipoReporte = request.getParameter("reporte");


    String FechaInicio = request.getParameter("FechaIncio");


    ArrayList<DeporsitoRetirosCajero> Listatransaccion = ReportesCajero.DepositosRetirosCajero(String.valueOf(Cajero.getCodigo()));
    ArrayList<DeporsitoRetirosCajero> ListraTrasaccion2 = ReportesCajero.TransaccioneshechasDia(String.valueOf(Cajero.getCodigo()),FechaInicio);



%>
<select id="TipoReporte" onchange="Actualizar()">
    <option value="0">Selecione un Reporte</option>
    <option value="1">Listado de depósitos y retiros realizados durante su turno</option>
    <option value="2">Listado de las transacciones realizadas por dia</option>


</select>

<%
    if (tipoReporte != null) {

%>

<%if (tipoReporte.equals("2")) {%>

<form action="ReportesCajero.jsp">



    Ingrese la Fecha <input type="date" name="FechaIncio"> </br>


    <input type="hidden" name="reporte" value="<%=tipoReporte%>">

    <input type="submit" value="Mostrar Reporte">
</form>
<%}%>
<%}%>


<%
    if (tipoReporte != null) {

%>


<%if (tipoReporte.equals("1")) {%>

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
        <th>Saldo Caja </th>

        <th></th>

    </tr>
    </thead>
    <% for (DeporsitoRetirosCajero transaccion : Listatransaccion) {
    %>

    <tr>
        <td><%= transaccion.getCodigoCajero() %>
        </td>
        <td><%=transaccion.getNombreCajero()%>
        </td>
        <td><%= transaccion.getCodigoTransaccion() %>
        </td>
        <td><%= transaccion.getCodigoCuenta()%>
        </td>
        <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %>
        <td><%=transaccion.getTipo()%>
        </td>
        <td><%=transaccion.getMonto()%>
        </td>
        <td><%=transaccion.getSaldoCuenta()%>
        </td>
        <td><%=transaccion.getCaja()%>
        </td>


        <%}%>
    </tr>

</table>
<%
    }

    if (tipoReporte.equals("2")) {
%>

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
        <th>Saldo Caja </th>

        <th></th>

    </tr>
    </thead>
    <% for (DeporsitoRetirosCajero transaccion : ListraTrasaccion2) {
    %>

    <tr>
        <td><%= transaccion.getCodigoCajero() %>
        </td>
        <td><%=transaccion.getNombreCajero()%>
        </td>
        <td><%= transaccion.getCodigoTransaccion() %>
        </td>
        <td><%= transaccion.getCodigoCuenta()%>
        </td>
        <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %>
        <td><%=transaccion.getTipo()%>
        </td>
        <td><%=transaccion.getMonto()%>
        </td>
        <td><%=transaccion.getSaldoCuenta()%>
        </td>
        <td><%=transaccion.getCaja()%>
        </td>


        <%}%>
    </tr>

</table>

<%
    }

    }
%>


<script>

    function Actualizar() {
        var id = document.getElementById("TipoReporte").value;

        window.location.href = "ReportesCajero.jsp?reporte=" + id;

    }
</script>

</body>
</html>

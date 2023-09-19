<%@ page import="DatosBD.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Datos.Reportes.ReportesAdministrador" %>
<%@ page import="Datos.CuentaDAO" %>
<%@ page import="Datos.Reportes.ReportesCliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Reportes Cliente</title>
</head>
<body>

<%
  Usuario cliente = (Usuario) session.getAttribute("Cliente");

  ArrayList<Cuenta> CuentasPropias = CuentaDAO.CuentasPropias(String.valueOf(cliente.getCodigo()));




  String tipoReporte = request.getParameter("reporte");

  String CodigoCuenta = request.getParameter("CodCuenta");

  String FechaInicio=request.getParameter("FechaIncio");
  String FechaFin=request.getParameter("FechaFin");



  ArrayList<Transaccion> Ultimos15Transacciones = ReportesCliente.TransaccionesUltimoanio(CodigoCuenta);

  ArrayList<Transaccion> ListatransaccionesIT = ReportesCliente.TransaccionesIntervaloTiempo(CodigoCuenta,FechaInicio,FechaFin);

  ArrayList<Transaccion> TransaccionesCuentaMasDinero = ReportesCliente.CuentaConMasDineroyTransacciones(String.valueOf(cliente.getCodigo()),FechaInicio);



  ArrayList<SolicitudAsociacion> SolisRecibidas = ReportesCliente.HistorialSoliAsociacioonRecibidos(CodigoCuenta);

  ArrayList<SolicitudAsociacion> SolisHechas = ReportesCliente.HstorialSoliAsociacionhecha(String.valueOf(cliente.getCodigo()));




%>

<select id="TipoReporte" onchange="Actualizar()">
  <option value="0">Selecione un Reporte</option>
  <option value="1">Las últimas 15 transacciones más grandes realizadas en el último año </option>
  <option value="2"> Listado de todas las transacciones realizadas dentro de un intervalo de tiempo </option>
  <option value="3"> La cuenta con más dinero y sus transacciones </option>
  <option value="4">Historial con el listado de solicitud de asociación de cuenta recibidas</option>
  <option value="5">Historial con el listado de solicitud de asociación de cuenta realizadas  </option>


</select>

<%
  if(tipoReporte!=null){

%>

<%if(tipoReporte.equals("1")||tipoReporte.equals("2") || tipoReporte.equals("3") || tipoReporte.equals("4")){%>

<form action="ReportesCliente.jsp">

  <select  name="CodCuenta" >
<%if(tipoReporte.equals("1")||tipoReporte.equals("2")|| tipoReporte.equals("4")){%>
    <option >Seleccione una Cuenta</option>
    <% for (Cuenta cuenta : CuentasPropias) {
    %>
    <option value="<%=cuenta.getCodigo() %>">
      No. Cuenta <%= cuenta.getCodigo() %> - Propietario:  <%=cuenta.getNombreCliente()%> -
      Saldo:  <%=cuenta.getSaldo()%>
    </option>
    <% } %>
  </select>
  <%}%>

  <%if(tipoReporte.equals("2")){%>
  Ingrese la Fecha Inicio <input type="date" name="FechaIncio" > </br>
  Ingrese la Fecha Fin <input type="date" name="FechaFin" > </br>
  <%}%>
<%if(tipoReporte.equals("3")){

%>
  Ingrese la Fecha Inicio <input type="date" name="FechaIncio" > </br>
 <%}%>


  <input type="hidden" name="reporte" value="<%=tipoReporte%>">

  <input type="submit" value="Mostrar Reporte">
</form>
<%}%>
<%}%>






<%
  if(tipoReporte!=null){

%>


<%if(tipoReporte.equals("1")){%>

<table class="table table-success table-striped" id="tabla_libros">

  <thead class="table-dark">
  <tr>
    <th>Codigo Transaccion</th>
    <th>Codigo Cuenta</th>
    <th>Tipo</th>
    <th>Fecha y Hora</th>
    <th>Monto</th>
    <th>Codigo Cajero</th>
    <th>Saldo Cuenta</th>

  </tr>
  </thead>
  <% for (Transaccion transaccion : Ultimos15Transacciones) {
  %>

  <tr>
    <td><%= transaccion.getCodigoTransaccion() %>
    </td>
    <td><%= transaccion.getCodigoCuenta() %>
    </td>
    <td><%= transaccion.getTipo()%></td>
    <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %>
    <td><%= transaccion.getMonto()%></td>
    <td><%= transaccion.getCodigoCajero()%></td>
    <td><%= transaccion.getSaldoCuenta()%></td>


        <%}%>
  </tr>

</table>
<%}

  if(tipoReporte.equals("2")){%>
<table class="table table-success table-striped" id="tabla_libros">

  <thead class="table-dark">
  <tr>
    <th>Codigo Transaccion</th>
    <th>Codigo Cuenta</th>
    <th>Tipo</th>
    <th>Fecha y Hora</th>
    <th>Monto</th>
    <th>Codigo Cajero</th>
    <th>Saldo Cuenta</th>

  </tr>
  </thead>
  <% for (Transaccion transaccion : ListatransaccionesIT) {
  %>

  <tr>
    <td><%= transaccion.getCodigoTransaccion() %>
    </td>
    <td><%= transaccion.getCodigoCuenta() %>
    </td>
    <td><%= transaccion.getTipo()%></td>
    <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %>
    <td><%= transaccion.getMonto()%></td>
    <td><%= transaccion.getCodigoCajero()%></td>
    <td><%= transaccion.getSaldoCuenta()%></td>


    <%}%>
  </tr>

</table><%}

  if(tipoReporte.equals("3")){%>

<table class="table table-success table-striped" id="tabla_libros">

  <thead class="table-dark">
  <tr>
    <th>Codigo Transaccion</th>
    <th>Codigo Cuenta</th>
    <th>Tipo</th>
    <th>Fecha y Hora</th>
    <th>Monto</th>
    <th>Codigo Cajero</th>
    <th>Saldo Cuenta</th>

  </tr>
  </thead>
  <% for (Transaccion transaccion : TransaccionesCuentaMasDinero) {
  %>

  <tr>
    <td><%= transaccion.getCodigoTransaccion() %>
    </td>
    <td><%= transaccion.getCodigoCuenta() %>
    </td>
    <td><%= transaccion.getTipo()%></td>
    <td><%= transaccion.getFecha() +"  "+ transaccion.getHora() %>
    <td><%= transaccion.getMonto()%></td>
    <td><%= transaccion.getCodigoCajero()%></td>
    <td><%= transaccion.getSaldoCuenta()%></td>


    <%}%>
  </tr>

</table><%}if(tipoReporte.equals("4")){%>


<table class="table table-success table-striped" id="tabla_libros">

  <thead class="table-dark">
  <tr>
    <th>Codigo Solicitud</th>
    <th>Codigo Cliente </th>
    <th>Codigo Cuenta </th>
    <th>Fecha </th>
    <th>Estado </th>

  </tr>
  </thead>
  <% for (SolicitudAsociacion solicitud : SolisRecibidas) {
  %>

  <tr>
    <td><%= solicitud.getCodigo() %></td>
    <td><%= solicitud.getCodigoCliente() %></td>
    <td><%= solicitud.getCodigoCuenta() %></td>
    <td><%= solicitud.getFecha()%>  </td>
    <td><%= solicitud.getEstado()%>  </td>


    <%}%>
  </tr>

</table>

<%}
  if (tipoReporte.equals("5")){%>

<table class="table table-success table-striped" id="tabla_libros">

  <thead class="table-dark">
  <tr>
    <th>Codigo Solicitud</th>
    <th>Codigo Cuenta </th>
    <th>Fecha </th>
    <th>Estado </th>

  </tr>
  </thead>
  <% for (SolicitudAsociacion solicitud : SolisHechas) {
  %>

  <tr>
    <td><%= solicitud.getCodigo() %></td>
    <td><%= solicitud.getCodigoCuenta() %></td>
    <td><%= solicitud.getFecha()%>  </td>
    <td><%= solicitud.getEstado()%>  </td>


    <%}%>
  </tr>

</table>



<%}}%>








<script>

  function Actualizar() {
    var id=document.getElementById("TipoReporte").value;

    window.location.href = "ReportesCliente.jsp?reporte="+id;

  }
</script>

</body>
</html>

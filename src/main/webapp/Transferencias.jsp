<%@ page import="DatosBD.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DatosBD.Cuenta" %>
<%@ page import="Datos.CuentaDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Transferencias Propias</title>
</head>
<body>

<%
  Usuario cliente = (Usuario) session.getAttribute("Cliente");
  ArrayList<Cuenta> CuentasPropias = CuentaDAO.CuentasPropias(String.valueOf(cliente.getCodigo()));
  ArrayList<Cuenta> CuentasAsociadas = CuentaDAO.CuentasTerceros(String.valueOf(cliente.getCodigo()));


  String tipo = request.getParameter("tipo");

%>

<c:if test="${not empty error}">
  <p style="color: red">${error}</p>
</c:if>


<form action="Transferencias" method="post">


  <select id="tipotransferencia" name="TipoTransferencia" onchange="Actualizar()">
    <%
      String selected1 = "";
      String selected2 = "";
      if (tipo != null) {

        if (tipo.equals("1")) {
          selected1 = "selected";
        }
        if (tipo.equals("2")) {
          selected2 = "selected";

        }

      }%>


    <option>
      Seleccione el tipo de transferencia
    </option>
    <option value="1"<%=selected1%>>
      Transferencias Propias
    </option>
    <option value="2"<%=selected2%>>
      Transferencias a Terceros
    </option>

  </select>

  </br>
  </br>


  <select id="debito" name="CuentaDebido" onchange="Catalogo()">

    <option >Seleccione cuenta a Debito</option>
    <% for (Cuenta cuenta : CuentasPropias) {
    %>
    <option value="<%=cuenta.getCodigo() %>">
      No. Cuenta <%= cuenta.getCodigo() %> - Propietario:  <%=cuenta.getNombreCliente()%> -
      Saldo:  <%=cuenta.getSaldo()%>
    </option>
    <% } %>
  </select>
  </br>
  </br>

  <%
    if (tipo != null) {
  %>
  <%if (tipo.equals("1")) {%>

  <select id="credito" name="CuentaCredito">

    <option>Seleccione cuenta a Acreditar</option>
    <% for (Cuenta cuenta : CuentasPropias) {
    %>
    <option value="<%=cuenta.getCodigo() %>">
      No. Cuenta <%= cuenta.getCodigo() %> - Propietario:  <%=cuenta.getNombreCliente()%> -
      Saldo:  <%=cuenta.getSaldo()%>
    </option>
    <% } %>
  </select>


  <%}%>

  <%if (tipo.equals("2")) {%>

  <select id="credito" name="CuentaCredito">

    <option>Seleccione cuenta a Acreditar</option>
    <% for (Cuenta cuenta : CuentasAsociadas) {
    %>
    <option value="<%=cuenta.getCodigo() %>">
      No. Cuenta <%= cuenta.getCodigo() %> - Propietario:  <%=cuenta.getNombreCliente()%>
    </option>
    <% } %>
  </select>


  <%}%>


  <%


    }%>
  </br>
  </br>

  Ingrese el monto a Trasferir:   <input type="text" name="monto">
  <input type="submit" value="Transferir">

</form>

<script>


  function Actualizar() {
    var id = document.getElementById("tipotransferencia").value;

    window.location.href = "Transferencias.jsp?tipo=" + id;

  }
</script>
</body>
</html>
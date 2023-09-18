<%@ page import="Datos.CuentaDAO" %>
<%@ page import="DatosBD.Cuenta" %>
<%@ page import="Datos.Buscar" %>
<%@ page import="DatosBD.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Solicitud de asociacion de cuenta</title>
</head>
<body>
<%
    Usuario cliente = (Usuario) session.getAttribute("Cliente");

    Buscar buscar= new Buscar();
    String NumeroCuenta = request.getParameter("cuenta");

    Cuenta cuenta=null;
    if(NumeroCuenta!=null){
     cuenta = CuentaDAO.getCuentaaAsociar(NumeroCuenta, String.valueOf(cliente.getCodigo()));

    }


%>

<c:if   test="${not empty error}">
    <p  style="color: red">${error}</p>
</c:if>

<h1>Crear Solicitud de Asociacion de cuenta</h1>


<form action="CrearSolicitudAsociacion.jsp" method="post">
    Ingrese el numero de cuenta <input type="text" name="cuenta">

</form>

<%
    if (NumeroCuenta != null) {


if(cuenta!=null && cuenta.getCodigo()>0){
%>
Numero de Cuenta: <%=cuenta.getCodigo()%></br></br>
Propietario: <%=cuenta.getNombreCliente()%></br></br>
DPI: <%=buscar.getDato("usuario","codigo","noIdentificacion",String.valueOf( cuenta.getCodigoCliente()))%></br></br>

<form action="GenerarSolicitudAsociacion" method="post">
   <input type="hidden" name="CodigoCuenta" value="<%=cuenta.getCodigo()%>">
    <input type="submit" value="Crear Solicitud">


</form>

<%}else{


    %>

<h2>La Cuenta no existe o te pertenece</h2>

<%
    }}
%>


</body>
</html>

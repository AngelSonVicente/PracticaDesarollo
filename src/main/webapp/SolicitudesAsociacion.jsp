
<%@ page import="Datos.Listar" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DatosBD.Cuenta" %>
<%@ page import="Datos.CuentaDAO" %>
<%@ page import="DatosBD.Usuario" %>
<%@ page import="DatosBD.SolicitudAsociacionDetalle" %>
<%@ page import="Datos.SolicitudAsociacionDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SOlicitudes de Asociacion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<c:if test="${not empty mensaje}">
    <p style="color: red">${mensaje}</p>
</c:if>



<div class="container">
    <%
        Usuario cliente = (Usuario) session.getAttribute("Cliente");

        String CodigoCuenta=request.getParameter("cuenta");

        String estado=request.getParameter("estado");
        ArrayList<Cuenta> CuentasPropias = CuentaDAO.CuentasPropias(String.valueOf(cliente.getCodigo()));
        ArrayList<SolicitudAsociacionDetalle> ListaSolicitudes = SolicitudAsociacionDAO.SolicitudPendienteCuenta(CodigoCuenta);



    %>




    <div class="card">
        <div class="card-header">
            <h1 class="text-center">Solicitudes Asociacion de Cuenta</h1></br>
            <hr>
        </div>
        <div class="card-body">
            <div class="card-head">
                <h3>Seleccione una Cuenta</h3>
                <select id="bibliotecas" name="biblioteca" onchange="Catalogo()">

                    <option >Seleccione cuenta</option>
                    <% for (Cuenta cuenta : CuentasPropias) {
                        String selected = "";
                        if (CodigoCuenta != null && CodigoCuenta.equals(String.valueOf(cuenta.getCodigo()))) {
                            selected = "selected";
                        }

                    %>
                    <option value="<%=cuenta.getCodigo() %>"<%=selected%>>
                        No. Cuenta <%= cuenta.getCodigo() %> - Propietario:  <%=cuenta.getNombreCliente()%> -
                        Saldo:  <%=cuenta.getSaldo()%>
                    </option>
                    <% } %>



                </select>

            </div>
            <%if(CodigoCuenta!=null){%>
            <table class="table table-success table-striped" id="tabla_libros">

                <thead class="table-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Codigo Del Cliente</th>
                    <th>Nombre del Cliente</th>
                    <th>DPI</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Aceptar</th>
                    <th>Rechazar</th>

                </tr>
                </thead>
                <% for (SolicitudAsociacionDetalle solicitud : ListaSolicitudes) {
                %>

                <tr>
                    <td><%= solicitud.getCodigo() %>
                    </td>
                    <td><%= solicitud.getCodigoCliente() %>
                    </td>
                    <td><%= solicitud.getNombreCliente()%>
                    </td>
                    <td><%= solicitud.getDPI()%>
                    </td>
                    <td><%=solicitud.getFecha()%></td>
                    <td><%=solicitud.getEstado()%></td>

                    <td>
                        <form id="formulario<%=solicitud.getCodigo()%>" action="AprobacionSolicitudAsociacion" method="post">
                            <input type="hidden" name="IDSolicitud" value="<%=solicitud.getCodigo()%>">
                            <input type="hidden" name="Estado" value="Aceptado">
                            <input type="hidden" name="desbloqueo" value="si">

                            <input type="hidden" name="EstadoAnterior" value="<%=estado%>">
                        </form>
                        <a href="#" onclick="enviarFormulario('<%=solicitud.getCodigo()%>')">Aceptar Solicitud</a>
                    </td>

                    <td>
                        <form id="formularioo<%=solicitud.getCodigo()%>" action="AprobacionSolicitudAsociacion" method="post">
                            <input type="hidden" name="IDSolicitud" value="<%=solicitud.getCodigo()%>">
                            <input type="hidden" name="Estado" value="Rechazado">

                        </form>
                        <a href="#" onclick="enviarFormulario2('<%=solicitud.getCodigo()%>')">Rechazar Solicitud</a>
                    </td>

                    <%}%>
                </tr>

            </table>
            <%}%>

        </div>

    </div>


</div>









<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous">


</script>

<script>

    function Catalogo() {
        var estadooo=document.getElementById("bibliotecas").value;

        window.location.href = "SolicitudesAsociacion.jsp?cuenta="+estadooo;

    }

    function enviarFormulario(isbn) {
        document.getElementById("formulario" + isbn).submit();
    }  function enviarFormulario2(isbn) {
        document.getElementById("formularioo" + isbn).submit();
    }




</script>


</body>
</html>
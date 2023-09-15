<%@ page import="DatosBD.UsuarioT2" %>
<%@ page import="DatosBD.UsuarioT3" %><%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 14/09/2023
  Time: 10:00 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar Informacion Usuario</title>
</head>
<body>

<h2>

<c:if   test="${not empty error}">
    <p  style="color: red">${error}</p>
</c:if>

<c:if   test="${not empty exito}">
    <p  style="color: black">${exito}</p>
</c:if>

</h2>


<%
    String tipo = (String) request.getAttribute("TipoUsuario");
    UsuarioT2 usuariot2 = new UsuarioT2();
    UsuarioT3 usuariot3 = new UsuarioT3();


    int codigo=0;

    if (tipo.equals("2")) {
        usuariot2 = (UsuarioT2) request.getAttribute("usuario");
        codigo=usuariot2.getCodigo();
    }
    if (tipo.equals("3")) {
        usuariot3 = (UsuarioT3) request.getAttribute("usuario");
        codigo=usuariot3.getCodigo();
    }





%>
<form action="ActualizarUsuario" method="post">



<%
    if (tipo.equals("2")) {
%>
Codigo: <%=usuariot2.getCodigo()%> </br> </br>
Nombre: <input type="text" name="nombre" value="<%=usuariot2.getNombre()%>"></br> </br>
Direccion: <input type="text" name="direccion" value="<%=usuariot2.getDireccion()%>"></br> </br>
Para conservar la contraseña deje en blanco el campo contraseña </br>
Contraseña: <input type="text" name="contra"></br> </br>
DPI: <input type="text" name="dpi" value="<%=usuariot2.getDPI()%>"></br> </br>
Turno: <select name="turno">
    <%
    String selected1 ="";
    String selected2 ="";
    if(usuariot2.getTurno()==1){
        selected1="selected";
    }
    if(usuariot2.getTurno()==2){
        selected2="selected";
    }

    %>
    <option value="1" <%=selected1%>>Matutino  6:00 a 14:30</option>
    <option value="2" <%=selected2%>>Verspertino 13:00 a 22:00 </option>
</select>

<%
    }
%>



<%
    if (tipo.equals("3")) {
%>
Codigo: <%=usuariot3.getCodigo()%> </br> </br>
Nombre: <input type="text" name="nombre" value="<%=usuariot3.getNombre()%>"></br> </br>
Direccion: <input type="text" name="direccion" value="<%=usuariot3.getDireccion()%>"></br> </br>
contraseña <input type="text" name="contra">
DPI: <input type="text" name="dpi" value="<%=usuariot3.getDpi()%>"></br> </br>

<%
    }
%>


    <input type="hidden" name="tipousuario" value="<%=tipo%>">
    <input type="hidden" name="CodigoSuario" value="<%=codigo%>">


</br>
</br>
</br>
  <input type="submit" value="Actualizar Datos">
</form>


</body>
</html>

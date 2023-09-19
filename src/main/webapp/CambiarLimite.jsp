<%@ page import="DatosBD.Limites" %>
<%@ page import="Datos.Buscar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cambiar limites</title>
</head>
<body>
<%
  Limites limite1 = Buscar.getLimite("1");
  Limites limite2 = Buscar.getLimite("2");
%>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if><c:if test="${not empty exito}">
    <p style="color: red">${exito}</p>
</c:if>
<form  action="CambiarLimite" method="post">
  Codigo Limite: <%=limite1.getCodigo()%> -- Nombre: <%=limite1.getNombre()%></br>
  valor: <input type="text" name="Valor1" value="<%=limite1.getValor()%>"></br></br></br>

 Codigo Limite: <%=limite2.getCodigo()%> -- Nombre: <%=limite2.getNombre()%></br>
  valor: <input type="text" name="Valor2" value="<%=limite2.getValor()%>">

  <input type="submit"  value="Actualizar">
</form>

<form action="ModuloGerente.jsp">
    <input type="submit" value="Regresar al Modulo">

</form>

</body>
</html>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>

</head>
<body>



<div style="display: flex; justify-content: center;">

  <h1>    Inicio de sesion</h1>
</div>
<div style="display: flex; justify-content: center;">
  <div style="width: 15%; height: 0%; display: flex; justify-content: space-between; align-items: end;">
    <form name="SesionT" action="LoginServlet" method="POST" style="width: 10%;">
      <%
      String usuario= request.getParameter("user");
      %>
      <input type="hidden" name="tipousuario" value="<%=usuario%>">

      Usuario: <input type ="text" name="usuarioT"/>
      <br/>
      <br/>
      Password: <input type ="password" name="passwordT"/>
      <br/>
      <br/>
      <input type="submit" value="Acceder"/>
    </form>


  </div>
</div>

<c:if   test="${not empty error}">
  <p  style="color: red">${error}</p>
</c:if>


tipo usuario: <%=usuario%>

</body>
</html>
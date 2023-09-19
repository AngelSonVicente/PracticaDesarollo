<%@ page import="DatosBD.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>Crear Usuario</h2>

    <c:if test="${not empty error}">
        <p class="text-danger">${error}</p>
    </c:if>

    <form action="CrearUsuario" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="Nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="Nombre" name="Nombre" maxlength="45">
        </div>
        <div class="mb-3">
            <label for="descripcion" class="form-label">Dirección:</label>
            <textarea class="form-control" id="descripcion" name="descripcion" rows="5" cols="50" maxlength="250" style="resize: none"></textarea>
        </div>
        <div class="mb-3">
            <label for="DPI" class="form-label">DPI:</label>
            <input type="text" class="form-control" id="DPI" name="DPI" maxlength="15">
        </div>
        <div class="mb-3">
            <label for="Sexo" class="form-label">Sexo:</label>
            <select class="form-select" id="Sexo" name="Sexo" required>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="birth" class="form-label">Fecha de Nacimiento:</label>
            <input type="date" class="form-control" id="birth" name="birth">
        </div>
        <div class="mb-3">
            <label for="archivoPDF" class="form-label">DPI Escaneado:</label>
            <input type="file" class="form-control" id="archivoPDF" name="archivoPDF">
        </div>
        <div class="mb-3">
            <input type="submit" class="btn btn-primary" value="Crear Usuario">
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"></script>
</body>
</html>


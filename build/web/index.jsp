<%-- 
    Document   : index
    Created on : 10/03/2026, 09:44:09 AM
    Author     : PC-13
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Consejo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SafeNet ASI - Seguridad Informática</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container mt-5">
            <h1 class="text-center mb-4">🛡️ SafeNet ASI: Portal de Ciberseguridad</h1>
            
            <div class="row">
                <div class="col-md-4">
                    <div class="card shadow">
                        <div class="card-header bg-primary text-white">Nuevo Consejo / Legislación</div>
                        <div class="card-body">
                            <form action="Controlador" method="POST">
                                <div class="mb-3">
                                    <label>Título del Consejo:</label>
                                    <input type="text" name="txtTitulo" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label>Categoría:</label>
                                    <select name="txtCategoria" class="form-select">
                                        <option>Tips de Seguridad</option>
                                        <option>Legislación (Leyes)</option>
                                        <option>Protección de Datos</option>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label>Descripción:</label>
                                    <textarea name="txtDescripcion" class="form-control" rows="3" required></textarea>
                                </div>
                                <div class="mb-3">
                                    <label>Prioridad:</label>
                                    <select name="txtPrioridad" class="form-select">
                                        <option>Alta</option>
                                        <option>Media</option>
                                        <option>Baja</option>
                                    </select>
                                </div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-success w-100">Guardar Información</button>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-8">
                    <div class="card shadow">
                        <div class="card-header bg-dark text-white d-flex justify-content-between">
                            Lista de Información Registrada
                            <a href="Controlador?accion=Listar" class="btn btn-sm btn-outline-light">Actualizar Tabla</a>
                        </div>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Título</th>
                                        <th>Categoría</th>
                                        <th>Prioridad</th>
                                        <th>Descripción</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<Consejo> lista = (List<Consejo>) request.getAttribute("datos");
                                        if (lista != null) {
                                            for (Consejo c : lista) {
                                    %>
                                    <tr>
                                        <td><%= c.getId() %></td>
                                        <td><%= c.getTitulo() %></td>
                                        <td><%= c.getCategoria() %></td>
                                        <td><span class="badge bg-info text-dark"><%= c.getPrioridad() %></span></td>
                                        <td><%= c.getDescripcion() %></td>
                                    </tr>
                                    <% 
                                            }
                                        } 
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="org.dentalclinic.logic.Patient"%>
<%@page import="org.dentalclinic.logic.Dentist"%>
<%@page import="org.dentalclinic.logic.User"%>
<%@page import="java.util.List"%>
<%@include file ="components/header.jsp" %>
<%@include file ="components/firstBody.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">A continuación puede ver los datos de los Pacientes registrados</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>dni</th>
                        <th>telefono</th>
                        <th>direccion</th>
                        <th>tipo de sangre</th>
                        <th>fecha nacimiento</th>
                        <th>tiene Seguro</th>
                        <th style = "width: 210px">Acción</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>dni</th>
                        <th>telefono</th>
                        <th>direccion</th>
                        <th>tipo de sangre</th>
                        <th>fecha nacimiento</th>
                        <th>tiene Obra Social</th>
                        <th style = "width: 210px">Acción</th>
                    </tr>
                    </tfoot>
                    <%
                        List<Patient> patientList = (List<Patient>) session.getAttribute("patientList");
                        if (patientList != null && !patientList.isEmpty()) {
                    %>
                    <tbody>
                    <% for (Patient patient : patientList) { %>
                    <tr>
                        <td><%= patient.getId() %></td>
                        <td><%= patient.getFirstName() %></td>
                        <td><%= patient.getLastName() %></td>
                        <td><%= patient.getDni() %></td>
                        <td><%= patient.getPhone() %></td>
                        <td><%= patient.getAddress() %></td>
                        <td><%= patient.getBloodType() %></td>
                        <td><%= patient.getDateOfBirth() %></td>
                        <td><%= patient.isMedicalInsurance() ? "Sí" : "No" %></td>
                        <td>
                            <div style="display: flex; gap: 10px;">
                                <!-- Botón Eliminar -->
                                <form action="SvDeleteUsers" method="POST">
                                    <input type="hidden" name="id" value="<%= patient.getId() %>" />
                                    <button type="submit" class="btn btn-danger btn-sm">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                </form>

                                <!-- Botón Editar -->
                                <form action="SvModifyUsers" method="GET">
                                    <input type="hidden" name="id" value="<%= patient.getId() %>" />
                                    <button type="submit" class="btn btn-primary btn-sm">
                                        <i class="fas fa-edit"></i> Editar
                                    </button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                    <% } else { %>
                    <tbody>
                    <tr>
                        <td colspan="10" class="text-center">No hay pacientes para mostrar.</td>
                    </tr>
                    </tbody>
                    <% } %>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file = "components/lastBody.jsp" %>

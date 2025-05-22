<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="org.dentalclinic.logic.Dentist"%>
<%@page import="org.dentalclinic.logic.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@include file = "components/header.jsp" %>
<%@include file = "components/firstBody.jsp" %>
<div class="container-fluid">

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Ver Odontologos</h1>
  <p class="mb-4">A continuación puede ver los datos de los odontólogos registrados</p>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Odontólogos</h6>
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
            <th>fecha nacimiento</th>
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
            <th>fecha nacimiento</th>
            <th style = "width: 210px">Acción</th>

          </tr>
          </tfoot>
          <% List<Dentist> dentists = (List) request.getSession().getAttribute("dentists"); %>
          <tbody>
          <% for (Dentist dentist : dentists) {%>
          <tr>
            <td><%= dentist.getId()%></td>
            <td><%= dentist.getFirstName()%></td>
            <td><%= dentist.getLastName()%></td>
            <td><%= dentist.getDni()%></td>
            <td><%= dentist.getPhone()%></td>
            <td><%= dentist.getAddress()%></td>
            <td><%= DateUtils.formatearFechaPerso(dentist.getDateOfBirth())%></td>
            <td style = "display: flex ; width: 210px">
              <form action="SvDeleteDentist" method="POST">
                <button type = "submit" class = "btn btn-primary btn-user btn-block" style = " background-color:red; margin-right:5px">
                  <i class="fas fa-solid fa-trash"></i>
                  eliminar</button>
                <input name = "id" type= "hidden" value = "<%= dentist.getId()%>"/>
              </form>
              <form action="SvModifyDentist" method="GET">
                <button type = "submit" class = "btn btn-primary btn-user btn-block" style = "margin-left:5px">
                  <i class="fas fa-solid fa-pen"></i>
                  editar</button>
                <input name = "id" type= "hidden" value = "<%= dentist.getId()%>"/>
              </form>
            </td>
          </tr>
          <%}%>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</div>

<%@include file = "components/lastBody.jsp" %>
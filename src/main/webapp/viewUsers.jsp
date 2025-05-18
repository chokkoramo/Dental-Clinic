<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="logic.User"%>
<%@page import="java.util.List"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/firstBody.jsp"%>


<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
  <p class="mb-4">A continuación podrá visualizar la lista completa de usuarios</p>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Id</th>
            <th>Nombre de Usuario</th>
            <th>Rol</th>
            <th style="width: 210px">Acción</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Id</th>
            <th>Nombre de Usuario</th>
            <th>Rol</th>
            <th style=" width: 210px">Acción</th>
          </tr>
          </tfoot>

          <%
            List<User> userList = (List) request.getSession().getAttribute("userList");
          %>

          <tbody>
          <% for (User user : userList) {%>
          <tr>
            <td id="id_usu<%=user.getUserId()%>"><%=user.getUserId() %>   </td>
            <td><%=user.getUserName() %></td>
            <td><%=user.getRol()%></td>

            <td style="display: flex; width: 230px;">
              <form name="delete" action="SvElimuserarios" method="POST"> <!-- esto es para mandar el codigo al servlet -->
                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px; ">
                  <i class="fas fa-trash-alt"></i>  Eliminar
                </button>
                <input type="hidden" name="id" value="<%=user.getUserId()%>"> <!-- esto es para mandar el codigo al servlet -->
              </form>
              <form name="modify" action="SvEdituserarios" method="GET"> <!-- esto es para mandar el codigo al servlet -->
                <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                  <i class="fas fa-pencil-alt"></i>  Editar
                </button>
                <input type="hidden" name="id" value="<%=user.getUserId()%>"> <!-- esto es para mandar el codigo al servlet -->
              </form>
            </td>
          </tr>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<%@ include file="components/lastBody.jsp"%>
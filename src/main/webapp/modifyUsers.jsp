<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.dentalclinic.logic.User"%>

<%@ include file="components/header.jsp"%>
<%@ include file="components/firstBody.jsp"%>

<h1>Edición de Usuarios</h1>
<p>Este es el apartado para modificar un usuario del sistema.</p>

<% User u = (User) request.getSession().getAttribute("modifyUser");%>

<form class="user" action="SvModifyUsers" method="POST">
  <div class="form-group col">
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="userName" name="userName"
             placeholder="Nombre Usuario" value="<%=u.getUserName()%>">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="password" class="form-control form-control-user" id="password" name ="password"
             placeholder="Contraseña" value="<%=u.getPassword()%>">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="rol" name="rol"
             placeholder="Rol" value="<%=u.getRol()%>">
    </div>

  </div>

  <button class="btn btn-primary btn-user btn-block" type="submit">
    Guardar Modificación
  </button>

</form>


<%@ include file="components/lastBody.jsp"%>
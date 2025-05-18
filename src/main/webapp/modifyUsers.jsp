<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="logic.User"%>

<%@ include file="components/header.jsp"%>
<%@ include file="components/firstBody.jsp"%>

<h1>Edición de Usuarios</h1>
<p>Este es el apartado para modificar un usuario del sistema.</p>

<% User user = (User) request.getSession().getAttribute("modifyUser");%>

<form class="user" action="SvEditUsuarios" method="POST">
  <div class="form-group col">
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="nombreusu" name="nombreusu"
             placeholder="Nombre Usuario" value="<%=user.getUserName)%>">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="password" class="form-control form-control-user" id="contrasenia" name ="contrasenia"
             placeholder="Contraseña" value="<%=user.getPassword()%>">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="rol" name="rol"
             placeholder="Rol" value="<%=user.getRol()%>">
    </div>

  </div>

  <button class="btn btn-primary btn-user btn-block" type="submit">
    Guardar Modificación
  </button>

</form>


<%@ include file="components/lastBody.jsp"%>
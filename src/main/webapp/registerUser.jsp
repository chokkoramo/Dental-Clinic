<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="components/header.jsp"%>
<%@ include file="components/firstBody.jsp"%>

<h1>Alta Usuarios</h1>
<p>Este es el apartado para dar de alta los diferentes usuarios del sistema.</p>

<form class="user" action="SvUsers" method="POST">
  <div class="form-group col">
    <div class="col-sm-6 mb-3">
      <label for="username">Nombre Usuario</label>
      <input type="text" class="form-control form-control-user" id="username" name="username"
             placeholder="Nombre Usuario" required>
    </div>
    <div class="col-sm-6 mb-3">
      <label for="password">Contraseña</label>
      <input type="password" class="form-control form-control-user" id="password" name="password"
             placeholder="Contraseña" required>
    </div>
    <div class="col-sm-6 mb-3">
      <label for="rol">Rol</label>
      <input type="text" class="form-control form-control-user" id="rol" name="rol"
             placeholder="Rol" required>
    </div>
  </div>

  <button class="btn btn-primary btn-user btn-block" type="submit">
    Crear Usuario
  </button>
</form>

<%@ include file="components/lastBody.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="components/header.jsp"%>
<%@ include file="components/firstBody.jsp"%>

<h1>Alta Odontólogos</h1>

<form class="user">
  <div class="form-group col">
    <div class="col-sm-6 mb-3">
      <label for="dni">DNI
      </label><input type="text" class="form-control form-control-user" id="dni" placeholder="DNI">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="firstName" placeholder="Nombre">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="lastName" placeholder="Apellido">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="phone" placeholder="Teléfono">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="address" placeholder="Dirección">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="dateOfBirth" placeholder="Fecha Nac">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="specialty" placeholder="Especialidad">
    </div>

    <!-- Acá va a ir todo lo que respecta a horarios y usuarios -->

  </div>

  <a href="#" class="btn btn-primary btn-user btn-block">
    Crear Odontólogo
  </a>

</form>


<%@ include file="components/lastBody.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="components/header.jsp" %>
<%@include file="components/firstBody.jsp" %>
<h1>Alta Odontólogo</h1>

<form class="user" action="SvDentist" method="POST">
  <div class="form-group col-sm-6 mb-3">

    <div class="col-sm-6 mb-3 ">
      <input type="text" class="form-control form-control-user" id="name"
             name="name"   placeholder="Nombre">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="exampleLastName"
             name="lastName"   placeholder="Apellido">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="exampleLastName"
             name="dni"   placeholder="dni">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="phone"   id="exampleInputPassword" placeholder="telefono">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="address"   id="exampleRepeatPassword" placeholder="dirección">
    </div>

    <label for="dateOfBirth">Fecha de Nacimiento</label><br>
    <div class="col-sm-6 mb-3">
      <input type="date" class="form-control form-control-user"
             name="dateOfBirth" id="dateOfBirth" placeholder="Fecha nacimiento">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             id="exampleRepeatPassword" name="startingTime"placeholder="horario inicio">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             id="exampleRepeatPassword" name="endingTime" placeholder="horario fin">
    </div>
  </div>
  <button  class="btn btn-primary btn-user btn-block" type = "submit" >
    Registrar Odontólogo
  </button>
  <hr>
</form>
<%@include file="components/lastBody.jsp" %>
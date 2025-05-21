<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="components/header.jsp" %>
<%@include file="components/firstBody.jsp" %>
<h1>Alta Paciente</h1>

<br>
<form class="user" action="SvPatient" method="POST">
  <div class="form-group col-sm-6 mb-3">
    <div class="col-sm-6 mb-3 ">
      <input type="text" class="form-control form-control-user" id="exampleFirstName"
             name="firstName" placeholder="Nombre">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="exampleLastName"
             name="lastName" placeholder="Apellido">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="exampleDNI"
             name="patientDNI" placeholder="dni">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="phone" id="exampleInputPassword" placeholder="Teléfono">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="address" id="exampleRepeatPassword" placeholder="Dirección">
    </div>
    <label>fecha de nacimiento</label><br>
    <div class="col-sm-6 mb-3">
      <input type="date" class="form-control form-control-user"
             name="patientDateOfBirth" id="exampleRepeatPassword" placeholder="Fecha de Nac.">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             id="exampleTipoSangre" name="bloodType" placeholder="Tipo de Sangre">
    </div>

    <div class="form-group col-sm-6 mb-3">
      <label>¿Tiene seguro medico?</label><br>
      <div class="form-check form-check-inline">
        <input type="radio" id="obraSocialSi" name="medicalInsuranceYes" value="si" class="form-check-input">
        <label for="medicalInsuranceYes" class="form-check-label">Sí</label>
      </div>
      <div class="form-check form-check-inline">
        <input type="radio" id="obraSocialNo" name="medicalInsuranceNo" value="no" class="form-check-input">
        <label for="medicalInsuranceNo" class="form-check-label">No</label>
      </div>
    </div>

    <br>
    <h4>Si el paciente es menor de edad, el adulto responsable deberá llenar el siguiente formulario</h4>
    <br>
    <div class="col-sm-6 mb-3 ">
      <input type="text" class="form-control form-control-user" id="exampleFirstNameRespon"
             name="legalGuardianFirstName" placeholder="Nombre">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="exampleLastNameRespon"
             name="legalGuardianLastName" placeholder="Apellido">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user" id="exampleDNIRespon"
             name="legalGuardianDNI" placeholder="DNI">
    </div>

    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="legalGuardianPhone" id="exampleInputPasswordRespon" placeholder="Teléfono">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="legalGuardianAddress" id="exampleRepeatPasswordRespon" placeholder="Dirección">
    </div>
    <label>fecha de nacimiento</label><br>
    <div class="col-sm-6 mb-3">
      <input type="date" class="form-control form-control-user"
             name="legalGuardianDateOfBirth" id="exampleRepeatPasswordRespon" placeholder="Fecha de Nac.">
    </div>
    <div class="col-sm-6 mb-3">
      <input type="text" class="form-control form-control-user"
             name="typeOfLegalGuardian" id="exampleInputPasswordRespon" placeholder="tipo de responsable">
    </div>
  </div>
  <br>
  <button  class="btn btn-primary btn-user btn-block" type = "submit" >
    registrar paciente
  </button>

  <hr>

</form>
<%@include file="components/lastBody.jsp" %>
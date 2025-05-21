<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="components/header.jsp"%>
<%@ include file="components/firstBody.jsp"%>

<h1>Alta Pacientes</h1>
<p>Este es el apartado para dar de alta los diferentes pacientes del sistema.</p>

<form class="user" action="SvPatient" method="POST">
  <div class="form-group col">
    <div class="col-sm-6 mb-3">
      <label for="patientName">Nombre:</label>
      <input type="text" class="form-control form-control-user" id="patientName" name="patientName"
             placeholder="Nombre Usuario" required>
    </div>
    <div class="col-sm-6 mb-3">
      <label for="patientLastName">Apellido:</label>
      <input type="text" class="form-control form-control-user" id="patientLastName" name="patientLastName"
             placeholder="Apellido" required>
    </div>
  </div>
  <div class="col-sm-6 mb-3">
      <label for="password">Contraseña:</label>
      <input type="text" class="form-control form-control-user" id="password" name="password"
             placeholder="Contraseña" required>
    </div>

  <div class="form-check mb-3">
    <input class="form-check-input" type="checkbox" id="medicalInsurance" name="medicalInsurance">
    <label class="form-check-label" for="medicalInsurance">¿Tiene seguro médico?</label>
  </div>

  <div class="mb-3">
    <label for="bloodType" class="form-label">Tipo de sangre:</label>
    <select class="form-select" id="bloodType" name="bloodType" required>
      <option value="" selected disabled>Seleccione una opción</option>
      <option value="A+">A+</option>
      <option value="A-">A-</option>
      <option value="B+">B+</option>
      <option value="B-">B-</option>
      <option value="AB+">AB+</option>
      <option value="AB-">AB-</option>
      <option value="O+">O+</option>
      <option value="O-">O-</option>
    </select>
  </div>

  <button class="btn btn-primary btn-user btn-block" type="submit">
    Crear Usuario
  </button>
</form>

<%@ include file="components/lastBody.jsp"%>
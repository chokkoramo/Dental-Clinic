<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Bienvenido</title>
</head>
<body>
<%
  String username = (String) request.getAttribute("username");
  if (username != null && !username.trim().isEmpty()) {
%>
<p>Bienvenido, <%= username %></p>
<%
} else {
%>
<p>No se recibió el nombre de usuario.</p>
<%
  }
%>
</body>
</html>

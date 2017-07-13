<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%
    if (request.getSession().equals(false)) {
        if (session.getAttribute("logged").toString().compareTo("true")==0) {
            response.sendRedirect("index.xhtml");
        }
    }
    String mensaje = session.getAttribute("mensaje") + "";
    if (mensaje.compareTo("null") == 0) {
        mensaje = "";
    }
%>
<%
ArrayList errores = (ArrayList) request.getAttribute("errores");
if (errores != null) {
    out.println("<div class='alert alert-danger'>");
    for (int i = 0; i < errores.size(); i++) {
        out.println(errores.get(i) + "</br>");
    }
    out.println("</div>");
}
%>
<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		
		<link rel="icon" href="images/escudo1.ico">
	</head>
	<body>

		<!-- Header -->
			<header id="header" >
				<h1>SIGN IN</h1>
				<p>Please identify yourself so that you can access the system
				Please enter the system with username or email address assigned by the institution and your password.</p>
			</header>

		<!-- Signup Form -->
			<form id="signup-form" method="post" action="log">
			<input type="hidden" name="accion" value="login"/>
				<input type="text" name="usuario" id="usuario" placeholder="Usuario"><br>
				<input type="password" name="password" id="pass" placeholder="Password"><br>
				<input class="boton"  type="submit" value="Ingresar" name="IniciarSesion" />
				<input class="boton"  type="button" value="Registrar" name="Registro" onclick="window.location = 'registro.jsp'" />
			</form>

		<!-- Footer -->
			<footer id="footer">
				
				<ul class="copyright">
					<li>&copy; Pontificia Universidad Catolica del Ecuador.</li><li>Credits: <a href="http://www.armada.mil.ec/">Marina del Ecuador</a></li>
				</ul>
			</footer>

		<!-- Scripts -->
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<!-- script src="assets/js/main.js"--></script>

	</body>
</html>
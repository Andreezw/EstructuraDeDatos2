<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%

    if (request.getSession().equals(false)) {
        if (session.getAttribute("logged").toString().compareTo("true") == 0) {
            response.sendRedirect("index.xhtml");
        }
    }
    String mensaje = request.getAttribute("mensaje") + "";
    if (mensaje.compareTo("null") == 0) {
        mensaje = "";
    }
%>
<html>
    <body class="bg-login">
        <div class="form-box" id="login-box">
            <div class="header">Registro</div>
            <form id="frmreg" method="post" action="log">
                <input type="hidden" name="accion" value="registro"/>
                <div class="body bg-gray">
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                            </span>
                            <input name="txtusuario" type="text" id="usuario" class="form-control" placeholder="Usuario" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input name="txtclave" type="password" id="clave" class="form-control" placeholder="Contrase&ntilde;a" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-email"></span></span>
                            <input name="txtcorreo" type="text" id="correo" class="form-control" placeholder="Correo" />
                        </div>
                    </div>
                                        <%
                        if (mensaje.length() > 0) {
                            out.println("<div class='alert alert-danger'>");
                            out.println("<h3>" + mensaje + "</h3>");
                            out.println("</div>");
                        }
                    %>  

                    <input type="submit" name="SubmitRegistro" value="Registrarse"  class="btn bg-olive btn-block">
                </div>
            </form>
        </div>
    </body>
</html>

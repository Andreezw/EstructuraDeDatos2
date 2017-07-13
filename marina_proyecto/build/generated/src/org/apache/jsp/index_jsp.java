package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");

    if (request.getSession().equals(false)) {
        if (session.getAttribute("logged").toString().compareTo("true")==0) {
            response.sendRedirect("index.xhtml");
        }
    }
    String mensaje = session.getAttribute("mensaje") + "";
    if (mensaje.compareTo("null") == 0) {
        mensaje = "";
    }

      out.write('\n');

ArrayList errores = (ArrayList) request.getAttribute("errores");
if (errores != null) {
    out.println("<div class='alert alert-danger'>");
    for (int i = 0; i < errores.size(); i++) {
        out.println(errores.get(i) + "</br>");
    }
    out.println("</div>");
}

      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Login</title>\n");
      out.write("\t\t<meta charset=\"utf-8\" />\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\n");
      out.write("\t\t<!--[if lte IE 8]><script src=\"assets/js/ie/html5shiv.js\"></script><![endif]-->\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n");
      out.write("\t\t<!--[if lte IE 8]><link rel=\"stylesheet\" href=\"assets/css/ie8.css\" /><![endif]-->\n");
      out.write("\t\t<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"assets/css/ie9.css\" /><![endif]-->\n");
      out.write("\t\t\n");
      out.write("\t\t<link rel=\"icon\" href=\"images/escudo1.ico\">\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\n");
      out.write("\t\t<!-- Header -->\n");
      out.write("\t\t\t<header id=\"header\" >\n");
      out.write("\t\t\t\t<h1>SIGN IN</h1>\n");
      out.write("\t\t\t\t<p>Please identify yourself so that you can access the system\n");
      out.write("\t\t\t\tPlease enter the system with username or email address assigned by the institution and your password.</p>\n");
      out.write("\t\t\t</header>\n");
      out.write("\n");
      out.write("\t\t<!-- Signup Form -->\n");
      out.write("\t\t\t<form id=\"signup-form\" method=\"post\" action=\"log\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"accion\" value=\"login\"/>\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"usuario\" id=\"usuario\" placeholder=\"Usuario\"><br>\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"password\" id=\"pass\" placeholder=\"Password\"><br>\n");
      out.write("\t\t\t\t<input class=\"boton\"  type=\"submit\" value=\"Ingresar\" name=\"IniciarSesion\" />\n");
      out.write("\t\t\t\t<input class=\"boton\"  type=\"button\" value=\"Registrar\" name=\"Registro\" onclick=\"window.location = 'registro.jsp'\" />\n");
      out.write("\t\t\t</form>\n");
      out.write("\n");
      out.write("\t\t<!-- Footer -->\n");
      out.write("\t\t\t<footer id=\"footer\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<ul class=\"copyright\">\n");
      out.write("\t\t\t\t\t<li>&copy; Pontificia Universidad Catolica del Ecuador.</li><li>Credits: <a href=\"http://www.armada.mil.ec/\">Marina del Ecuador</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</footer>\n");
      out.write("\n");
      out.write("\t\t<!-- Scripts -->\n");
      out.write("\t\t\t<!--[if lte IE 8]><script src=\"assets/js/ie/respond.min.js\"></script><![endif]-->\n");
      out.write("\t\t\t<!-- script src=\"assets/js/main.js\"--></script>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class registro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");


    if (request.getSession().equals(false)) {
        if (session.getAttribute("logged").toString().compareTo("true") == 0) {
            response.sendRedirect("index.xhtml");
        }
    }
    String mensaje = request.getAttribute("mensaje") + "";
    if (mensaje.compareTo("null") == 0) {
        mensaje = "";
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <body class=\"bg-login\">\n");
      out.write("        <div class=\"form-box\" id=\"login-box\">\n");
      out.write("            <div class=\"header\">Registro</div>\n");
      out.write("            <form id=\"frmreg\" method=\"post\" action=\"log\">\n");
      out.write("                <input type=\"hidden\" name=\"accion\" value=\"registro\"/>\n");
      out.write("                <div class=\"body bg-gray\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-envelope\"></span>\n");
      out.write("                            </span>\n");
      out.write("                            <input name=\"txtusuario\" type=\"text\" id=\"usuario\" class=\"form-control\" placeholder=\"Usuario\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-lock\"></span></span>\n");
      out.write("                            <input name=\"txtclave\" type=\"password\" id=\"clave\" class=\"form-control\" placeholder=\"Contrase&ntilde;a\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-email\"></span></span>\n");
      out.write("                            <input name=\"txtcorreo\" type=\"text\" id=\"correo\" class=\"form-control\" placeholder=\"Correo\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                                        ");

                        if (mensaje.length() > 0) {
                            out.println("<div class='alert alert-danger'>");
                            out.println("<h3>" + mensaje + "</h3>");
                            out.println("</div>");
                        }
                    
      out.write("  \n");
      out.write("\n");
      out.write("                    <input type=\"submit\" name=\"SubmitRegistro\" value=\"Registrarse\"  class=\"btn bg-olive btn-block\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

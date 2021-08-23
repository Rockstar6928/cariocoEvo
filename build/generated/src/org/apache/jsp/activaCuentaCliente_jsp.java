package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class activaCuentaCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>Carioco Chicken | Activa tu cuenta</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stylesOwn.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap/css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"img/carioco.jpeg\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"POST\" action=\"controladorValidar\">\n");
      out.write("            <div id=\"logo-login\">\n");
      out.write("                <img src=\"img/carioco.jpeg\">\n");
      out.write("            </div>\n");
      out.write("            <h1 id=\"msg-welcome-activa\"> Bievenido/a ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nombreCliente}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("  </h1>\n");
      out.write("            <div class=\"alert alert-danger d-none\" id=\"msg-alert\" role=\"alert\">\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msgerror}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"box-login\" class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-lg-3 col-sm-6 col-xs-6\">\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"exampleInputEmail1\" class=\"form-label\">Correo</label>\n");
      out.write("                        <input type=\"email\" name=\"email\" class=\"form-control\" id=\"email-login\" aria-describedby=\"emailHelp\" required=\"required\">\n");
      out.write("                        <div id=\"emailHelp\" class=\"form-text\">Nosotros nunca compartiremos tú email con alguien mas...</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-3\">\n");
      out.write("                        <label for=\"exampleInputPassword1\" class=\"form-label\">Contraseña</label>\n");
      out.write("                        <input type=\"password\" name=\"password\" class=\"form-control\" id=\"pass-login\" required=\"required\">\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"links-extra\">\n");
      out.write("                        <a href=\"registroCliente.jsp\" id=\"link-register\" >¿No tienes cuenta? Registrate</a>\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"#\" id=\"link-register\" >¿Olvidaste tu contraseña?</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <input type=\"submit\" id=\"btn-login\" class=\"btn justify-content-center\" name=\"accion\" value=\"Activar\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p class=\"text-center mt-5\">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>\n");
      out.write("        </footer>\n");
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

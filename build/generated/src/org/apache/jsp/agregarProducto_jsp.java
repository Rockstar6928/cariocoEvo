package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agregarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Carioco Chicken | Agregar Pro.</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/stylesLayout.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap/css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"img/carioco.jpeg\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12 mt-4 \">\n");
      out.write("                    <h2 class=\"text-center\">Nuevo Producto</h2>\n");
      out.write("                    <div class=\"justify-content-center\">\n");
      out.write("                        <form class=\"col-lg-6 form-horizontal\" style=\"margin: 0 auto;\" action=\"ControladorProducto?menu=producto\" method=\"POST\">\n");
      out.write("\n");
      out.write("                            <div class=\"mb-3\">\n");
      out.write("                                <div class=\"form-floating\">\n");
      out.write("                                    <label for=\"floatingSelectGrid\">Categoria</label>\n");
      out.write("                                    <select class=\"form-select\" name=\"listCats\" id=\"listCatsid\" aria-label=\"Floating label select example\">\n");
      out.write("                                        <option selected value=\"-1\">Todos</option>\n");
      out.write("                                    </select>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"mb-3\">\n");
      out.write("                                <input type=\"text\" name=\"nombrepro\" class=\"form-control\" id=\"nombre-pro\" aria-describedby=\"emailHelp\" required=\"required\" placeholder=\"Nombre producto\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"mb-3\">\n");
      out.write("                                <input type=\"text\" name=\"despro\" class=\"form-control\" id=\"des-pro\" aria-describedby=\"emailHelp\" required=\"required\" placeholder=\"Descripción producto\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"text-center\">\n");
      out.write("                                <input type=\"submit\" id=\"btn-addcat\" class=\"btn btn-success\" name=\"accion\" value=\"Agregar\">    \n");
      out.write("                            </div>\n");
      out.write("                        </form> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $.ajax({\n");
      out.write("                url: \"ControladorProducto?menu=producto&&accion=LCats\",\n");
      out.write("                method: \"POST\",\n");
      out.write("                success: function (data, textStatus, jqXHR) {\n");
      out.write("                    let obj = $.parseJSON(data);\n");
      out.write("                    $.each(obj, function (key, value) {\n");
      out.write("                        const $select = document.querySelector(\"#listCatsid\");\n");
      out.write("                        const option = document.createElement('option');\n");
      out.write("                        option.value = value.idCat;\n");
      out.write("                        option.text = value.desCat;\n");
      out.write("                        $select.appendChild(option);\n");
      out.write("                    })\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
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

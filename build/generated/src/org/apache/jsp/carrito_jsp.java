package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class carrito_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\"\n");
      out.write("        content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" integrity=\"sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/\" crossorigin=\"anonymous\">\n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap/css/sweetalert2.min.css\">\n");
      out.write("\n");
      out.write("    <title>Carrito Compras en JavaScript</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <header>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row align-items-stretch justify-content-between\">\n");
      out.write("                <nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">El Carioco</a>\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\"\n");
      out.write("                        aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n");
      out.write("                        <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <img src=\"img/cart.jpeg\" class=\"nav-link dropdown-toggle img-fluid\" height=\"70px\"\n");
      out.write("                                    width=\"70px\" href=\"#\" id=\"dropdown01\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\n");
      out.write("                                    aria-expanded=\"false\"></img>\n");
      out.write("                                <div id=\"carrito\" class=\"dropdown-menu\" aria-labelledby=\"navbarCollapse\">\n");
      out.write("                                    <table id=\"lista-carrito\" class=\"table\">\n");
      out.write("                                        <thead>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <th>Imagen</th>\n");
      out.write("                                                <th>Nombre</th>\n");
      out.write("                                                <th>Precio</th>\n");
      out.write("                                                <th></th>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody></tbody>\n");
      out.write("                                    </table>\n");
      out.write("\n");
      out.write("                                    <a href=\"#\" id=\"vaciar-carrito\" class=\"btn btn-primary btn-block\">Vaciar Carrito</a>\n");
      out.write("                                    <a href=\"#\" id=\"procesar-pedido\" class=\"btn btn-danger btn-block\">Procesar\n");
      out.write("                                        Compra</a>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("        <div class=\"pricing-header px-3 py-3 pt-md-5 pb-md-4 my-4 mx-auto text-center\">\n");
      out.write("            <h1 class=\"display-4 mt-4\">Lista de Productos</h1>\n");
      out.write("            <p class=\"lead\">Selecciona uno de nuestros productos y accede a un descuento</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"lista-productos\">\n");
      out.write("            \n");
      out.write("            <div class=\"card-deck mb-3 text-center\">\n");
      out.write("                \n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">HP PAVILION</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/hp1.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">5000</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>8 GB RAM</li>\n");
      out.write("                            <li>COLOR PLATEADO</li>\n");
      out.write("                            <li>256 GB DISCO SSD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"1\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">ACER </h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/acer.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">3000</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>16 GB RAM</li>\n");
      out.write("                            <li>COLOR NEGRO</li>\n");
      out.write("                            <li>1 TB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"2\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">LENOVO</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/lenovo.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">4000</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>4 GB RAM</li>\n");
      out.write("                            <li>COLOR PLATEADO</li>\n");
      out.write("                            <li>1 TB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"3\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"card-deck mb-3 text-center\">\n");
      out.write("                \n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">APPLE</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/apple.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">5900</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>8 GB RAM</li>\n");
      out.write("                            <li>COLOR GOLD</li>\n");
      out.write("                            <li>128 GB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"4\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">HUAWEI</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/huawei.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">5769</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>8 GB RAM</li>\n");
      out.write("                            <li>COLOR NEGRO</li>\n");
      out.write("                            <li>256 GB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"5\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">SAMSUNG</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/samsung.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">2599</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>4 GB RAM</li>\n");
      out.write("                            <li>COLOR BLANCO</li>\n");
      out.write("                            <li>64 GB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"6\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"card-deck mb-3 text-center\">\n");
      out.write("                \n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">LG</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/lg.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">4299</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>8 GB RAM</li>\n");
      out.write("                            <li>COLOR PLATEADO</li>\n");
      out.write("                            <li>256 GB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"7\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">ADVANCE</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/advance.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">869</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>3 GB RAM</li>\n");
      out.write("                            <li>COLOR NEGRO</li>\n");
      out.write("                            <li>64 GB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"8\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mb-4 shadow-sm\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h4 class=\"my-0 font-weight-bold\">DELL</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <img src=\"img/dell.jpg\" class=\"card-img-top\">\n");
      out.write("                        <h1 class=\"card-title pricing-card-title precio\">S/. <span class=\"\">5397</span></h1>\n");
      out.write("\n");
      out.write("                        <ul class=\"list-unstyled mt-3 mb-4\">\n");
      out.write("                            <li></li>\n");
      out.write("                            <li>8 GB RAM</li>\n");
      out.write("                            <li>COLOR NEGRO</li>\n");
      out.write("                            <li>1 TB DD</li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"\" class=\"btn btn-block btn-primary agregar-carrito\" data-id=\"9\">Comprar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("    <script src=\"js/jquery-3.4.1.min.js\"></script>\n");
      out.write("    <script src=\"css/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/sweetalert2.min.js\"></script>\n");
      out.write("    <script src=\"js/carrito.js\"></script>\n");
      out.write("    <script src=\"js/pedido.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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

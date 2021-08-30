/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Menu;
import Modelo.Perfil;
import Modelo.Usuario;
import ModeloDAO.ObtenerUsuarioMaximo;
import ModeloDAO.ValidarMenuDAO;
import ModeloDAO.ValidarUsuario;
import ModeloDAO.agregarClienteActivar;
import ModeloDAO.agregarUsuarioActivarCuenta;
import ModeloDAO.revisarDatosRegistro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leonardo
 */
public class controladorValidar extends HttpServlet {

    String nro = "";
    String nombreClienteRegistro = "";
    String direccionClienteRegistro = "";
    String apellidosClienteRegistro = "";
    String celularClienteRegistro = "";
    String fechaNacimientoClienteRegistro = "";
    String pass1ClienteRegistro = "";
    Usuario usu = new Usuario();
    Cliente cli = new Cliente();
    Menu m = new Menu();
    ValidarUsuario valUsu = new ValidarUsuario();
    revisarDatosRegistro checkData = new revisarDatosRegistro();
    ValidarMenuDAO valMenuDao = new ValidarMenuDAO();
    Map<String, Integer> map = new HashMap<>();
    String destinatario = "";

    agregarUsuarioActivarCuenta addUser = new agregarUsuarioActivarCuenta();
    ObtenerUsuarioMaximo getMaxUser = new ObtenerUsuarioMaximo();
    agregarClienteActivar addCliente = new agregarClienteActivar();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion1 = request.getSession();
        String accion = request.getParameter("accion");
        if (accion.equals("cerrar")) {
            sesion1.setAttribute("username", null);
            request.getRequestDispatcher("indexGusi.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion1 = request.getSession();
        String op = request.getParameter("accion");
        PrintWriter out = response.getWriter();
        if (op.equals("Ingresar")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            usu.setMailUser(email);
            usu.setPasswordUser(password);
            usu = valUsu.validarUsuario(usu);
            //Validando los menus
            List lista = new ArrayList();
            m.setIdPerfil(usu.getIdPerfil());
            lista = valMenuDao.listarMenu(m);
            //Opciones del menu por rol
            sesion1.setAttribute("listadoMenu", lista);

            //Datos del usuario que ingrea
            sesion1.setAttribute("datosUsuario", usu);
            //Validando errores
            request.setAttribute("iderror", usu.getpError());
            request.setAttribute("msgerror", usu.getpMsg_error());
            if (usu.getpError() == 0 && usu.getUsuEstado() == 1 && usu.getIdPerfil() == 1) {
                sesion1.setAttribute("username", email);
                request.getRequestDispatcher("vistaPrincipalAdministrativa.jsp").forward(request, response);
            } else if (usu.getpError() == 0 && usu.getUsuEstado() == 1 && usu.getIdPerfil() == 2) {
                sesion1.setAttribute("username", email);
                request.getRequestDispatcher("vistaPrincipalCliente.jsp").forward(request, response);
            } else {
                request.setAttribute("openit", 1);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if (op.equals("Registrar")) {
            //Primero vamos a revisar estos datos para ver si 
            //ya existen en la base de datos 
            String emailClienteRegistro = request.getParameter("emailClienteRegistro");
            String dniClienteRegistro = request.getParameter("dniClienteRegistro");
            cli.setMailUser(emailClienteRegistro);
            cli.setDniCliente(dniClienteRegistro);
            cli = checkData.validarDatosRegistro(cli);
            if (cli.getpError() != 0) {
                request.setAttribute("iderror", cli.getpError());
                request.setAttribute("msgerror", cli.getpMsg_error());
                request.setAttribute("openit", 1);
                request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
            } else {
                //Una vez pasen ese filtro terminamos de pedir estos datos
                nombreClienteRegistro = request.getParameter("nombreClienteRegistro");
                direccionClienteRegistro = request.getParameter("direccionClienteRegistro");
                apellidosClienteRegistro = request.getParameter("apellidosClienteRegistro");
                celularClienteRegistro = request.getParameter("celularClienteRegistro");
                fechaNacimientoClienteRegistro = request.getParameter("fechaNacimientoClienteRegistro");
                pass1ClienteRegistro = request.getParameter("pass1ClienteRegistro");

                //Enviar Correos
                Properties propiedad = new Properties();
                propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
                propiedad.setProperty("mail.smtp.starttls.enable", "true");
                propiedad.setProperty("mail.smtp.port", "587");
                propiedad.setProperty("mail.smtp.auth", "true");
                Session sesion = Session.getDefaultInstance(propiedad);
                String correoEnvia = "infopolleriacarioco@gmail.com";
                String contrasena = "evo20212gato";
                destinatario = request.getParameter("emailClienteRegistro");
                String asunto = "Activa tu cuenta: código de confirmación";
                String mensaje;
                int i = 0, cant = 5, rango = 10;
                int arreglo[] = new int[cant];
                arreglo[i] = (int) (Math.random() * rango);
                for (i = 1; i < cant; i++) {
                    arreglo[i] = (int) (Math.random() * rango);
                    for (int j = 0; j < i; j++) {
                        if (arreglo[i] == arreglo[j]) {
                            i--;
                        }
                    }
                }
                nro = "";
                for (int k = 0; k < cant; k++) {
                    nro += arreglo[k] + "";
                }
                MimeMessage mail = new MimeMessage(sesion);
                try {
                    request.setAttribute("nombreCliente", nombreClienteRegistro);
                    mensaje = "Bienvenido/a " + nombreClienteRegistro + " " + apellidosClienteRegistro + ", este es tu código de confirmación: <br>" + "<strong>" + nro + "</strong>";

                    BodyPart codigo = new MimeBodyPart();
                    codigo.setContent(mensaje, "text/html");

                    BodyPart text = new MimeBodyPart();
                    text.setDataHandler(new DataHandler(new FileDataSource("C:\\Users\\USER\\Documentos\\NetBeansProjects\\GusiEvolucion\\web\\Correo.html")));
                    //text.setContent(mensaje, "text/html");                   

                    BodyPart imagen = new MimeBodyPart();
                    imagen.setDataHandler(new DataHandler(new FileDataSource("D:\\carioco.jpeg")));
                    imagen.setFileName("Carioco.jpeg");
                    MimeMultipart partes = new MimeMultipart();
                    partes.addBodyPart(text);
                    partes.addBodyPart(imagen);
                    partes.addBodyPart(codigo);

                    mail.setFrom(new InternetAddress(correoEnvia));
                    mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                    mail.setSubject(asunto);
                    mail.setContent(partes);

                    Transport transporte = sesion.getTransport("smtp");
                    transporte.connect(correoEnvia, contrasena);
                    transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                    transporte.close();

                    //Agregamos diccionario para separar los codigos, 
                    //ya que podemos recibir decenas de peticiones para crearnos una cuenta
                    map.put(destinatario, Integer.parseInt(nro));

                    //Lo direcciono para que digite el código
                    request.getRequestDispatcher("activaCuentaCliente.jsp").forward(request, response);
                    System.out.println("Correo enviado correctamente | Destino: " + destinatario);
                } catch (Exception e) {
                    System.out.println("Error en el envío de correo!" + destinatario + ", posible causa: " + e);
                }

            }

        } else if (op.equals("Activar")) {
            //Ver lo del diccionario correo:codigo
            String codigo = request.getParameter("codigoActiva");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (map.containsKey(destinatario) && map.containsValue(Integer.parseInt(codigo))) {
                    /*out.println("<script type=\"text/javascript\">");
                    out.println("location='activaCuentaCliente.jsp';");
                    out.println("</script>");*/

                    request.setAttribute("rs", 1);
                    request.getRequestDispatcher("activaCuentaCliente.jsp").forward(request, response);
                    map.remove(destinatario);
                    usu.setMailUser(destinatario);
                    usu.setPasswordUser(pass1ClienteRegistro);
                    addUser.agregarUsuario(usu);
                    //Borrar dato del diccionario cuando entra al if
                    //Tengo un problema, ya que si dos usuarios mandan la solicitud, habrá 
                    //Un cruce de datos, por los request.getParamenter
                    //Presione la tecla de atras y me salió el modal ver ese tema tmb
                    //Si podemos hacer que al volver te mande al index o q ya no se mande el modal
                    break;
                } else {
                    request.setAttribute("rs", 2);
                    request.getRequestDispatcher("activaCuentaCliente.jsp").forward(request, response);
                    /*out.println("<script type=\"text/javascript\">");
                    out.println("location='activaCuentaCliente.jsp';");
                    out.println("</script>");*/
                }
            }
        } else {
            request.getRequestDispatcher("indexGusi.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

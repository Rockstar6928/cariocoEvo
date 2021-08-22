/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Usuario;
import ModeloDAO.ValidarUsuario;
import ModeloDAO.revisarDatosRegistro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
public class controladorValidar extends HttpServlet {

    Usuario usu = new Usuario();
    Cliente cli = new Cliente();
    ValidarUsuario valUsu = new ValidarUsuario();
    revisarDatosRegistro checkData = new revisarDatosRegistro();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        String op = request.getParameter("accion");
        if (op.equals("Ingresar")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            usu.setMailUser(email);
            usu.setPasswordUser(password);
            usu = valUsu.validarUsuario(usu);
            request.setAttribute("iderror", usu.getpError());
            request.setAttribute("msgerror", usu.getpMsg_error());
            if (usu.getpError() == 0 && usu.getUsuEstado() == 1) {

                request.getRequestDispatcher("vistaPrueba.jsp").forward(request, response);
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
                String nombreClienteRegistro = request.getParameter("nombreClienteRegistro");
                String direccionClienteRegistro = request.getParameter("direccionClienteRegistro");
                String apellidosClienteRegistro = request.getParameter("apellidosClienteRegistro");
                String celularClienteRegistro = request.getParameter("celularClienteRegistro");
                String fechaNacimientoClienteRegistro = request.getParameter("fechaNacimientoClienteRegistro");
                String pass1ClienteRegistro = request.getParameter("pass1ClienteRegistro");
                
                //Enviar Correos
                
                
                
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

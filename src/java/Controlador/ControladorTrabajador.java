/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Perfil;
import ModeloDAO.listarPerfilEmp;
import ModeloDAO.listarTrabajador;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
public class ControladorTrabajador extends HttpServlet {

    listarTrabajador listarTra = new listarTrabajador();
    listarPerfilEmp listPerf = new listarPerfilEmp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menuNavBar = request.getParameter("menu");
        String accionMenu = request.getParameter("accion");
        if (menuNavBar.equals("trabajador")) {
            switch (accionMenu) {
                case "listar":
                    List<Empleado> lista = new ArrayList<>();
                    lista = listarTra.listar();
                    request.setAttribute("listaEmpleados", lista);
                    request.getRequestDispatcher("trabajadorAdmin.jsp").forward(request, response);
                    break;
                case "LPerf":
                    List<Perfil> listaP = listPerf.listar();
                    Gson json = new Gson();
                    String countryList = json.toJson(listaP);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList);
                    break;
                default:
                    throw new AssertionError();
            }
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
        processRequest(request, response);
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

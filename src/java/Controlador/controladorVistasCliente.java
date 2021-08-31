/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import ModeloDAO.ListaProductosGeneralById;
import ModeloDAO.productosListarAdmin;
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
public class controladorVistasCliente extends HttpServlet {

    productosListarAdmin listProductos = new productosListarAdmin();
    ListaProductosGeneralById listprobycat = new ListaProductosGeneralById();
    Producto pro = new Producto();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menuNavBar = request.getParameter("menu");
        String accionMenu = request.getParameter("accion");
        if (menuNavBar.equals("vistasCliente")) {
            switch (accionMenu) {
                case "listar":
                    List<Producto> lPro = new ArrayList<>();
                    lPro = listProductos.listar();
                    request.setAttribute("listaProductos", lPro);
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                    break;
                case "sProbCat":
                    int id = Integer.parseInt(request.getParameter("id"));
                    pro.setIdCat(id);
                    System.out.println("id: " + id);
                    List<Producto> lPro2 = new ArrayList<>();
                    lPro2 = listprobycat.listarById(pro);
                    request.setAttribute("listaProductos", lPro2);
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
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

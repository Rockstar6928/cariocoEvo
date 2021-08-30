/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import ModeloDAO.agregarCategoria;
import ModeloDAO.buscarCategoria;
import ModeloDAO.categoriaListarAdmin;
import ModeloDAO.editarCategoria;
import ModeloDAO.eliminarCategoria;
import ModeloDAO.listarCategoriaPorID;
import ModeloDAO.mostrarCategoria;
import ModeloDAO.ocultarCategoria;
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
public class ControladorCategoria extends HttpServlet {

    categoriaListarAdmin catListar = new categoriaListarAdmin();
    buscarCategoria buscarCategoria = new buscarCategoria();
    Categoria cate = new Categoria();
    ocultarCategoria ocuCate = new ocultarCategoria();
    mostrarCategoria mostrarCat = new mostrarCategoria();
    eliminarCategoria delCat = new eliminarCategoria();
    agregarCategoria addCat = new agregarCategoria();
    listarCategoriaPorID listCatId = new listarCategoriaPorID();
    editarCategoria editCat = new editarCategoria();

    int idEditar = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menuNavBar = request.getParameter("menu");
        String accionMenu = request.getParameter("accion");
        if (menuNavBar.equals("categoria")) {
            switch (accionMenu) {
                case "listar":
                    List<Categoria> lista = new ArrayList();
                    lista = catListar.listar();
                    request.setAttribute("listaCategorias", lista);
                    request.getRequestDispatcher("categoriaAdmin.jsp").forward(request, response);
                    break;
                case "Buscar":
                    String categoriaBuscada = request.getParameter("categoriaBuscada");
                    int estadoCate = Integer.parseInt(request.getParameter("estadoCate"));
                    cate.setDesCat(categoriaBuscada);
                    cate.setCatEstado(estadoCate);
                    List<Categoria> listaBusquedaCategoria = new ArrayList<>();
                    listaBusquedaCategoria = buscarCategoria.buscar(cate);
                    request.setAttribute("catBuscada", categoriaBuscada);
                    request.setAttribute("catEstado", estadoCate);
                    request.setAttribute("listaCategorias", listaBusquedaCategoria);
                    request.getRequestDispatcher("categoriaAdmin.jsp").forward(request, response);
                    break;
                case "Ocultar":
                    int idCategoriaOcultar = Integer.parseInt(request.getParameter("id"));
                    cate.setIdCat(idCategoriaOcultar);
                    ocuCate.cambiarEstado(cate);
                    request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    break;
                case "Visible":
                    int idCategoriaMostrar = Integer.parseInt(request.getParameter("id"));
                    cate.setIdCat(idCategoriaMostrar);
                    mostrarCat.cambiarEstado(cate);
                    request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idCategoriaEliminar = Integer.parseInt(request.getParameter("id"));
                    cate.setIdCat(idCategoriaEliminar);
                    delCat.cambiarEstado(cate);
                    request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    break;

                case "Agregar":
                    String categoriaagregar = request.getParameter("categoriaagregar");
                    System.out.println(categoriaagregar);
                    cate.setDesCat(categoriaagregar);
                    addCat.agregarThing(cate);

                    if (cate.getpError() == 101) {
                        request.setAttribute("iderror", cate.getpError());
                        request.setAttribute("msgerror", cate.getpMsg_error());
                        request.setAttribute("openit", 1);
                        request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    } else {
                        addCat.agregarThing(cate);
                        request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    }
                    break;

                case "obtenerDatos":
                    idEditar = Integer.parseInt(request.getParameter("id"));
                    cate.setIdCat(idEditar);
                    List<Categoria> listaEditar = listCatId.listarById(cate);
                    Gson json = new Gson();
                    String countryList = json.toJson(listaEditar);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList);
                    break;
                case "Editar":
                    String namecate = request.getParameter("namecate");
                    cate.setIdCat(idEditar);
                    cate.setDesCat(namecate);
                    editCat.editarThing(cate);
                    if (cate.getpError() == 101) {
                        request.setAttribute("iderror", cate.getpError());
                        request.setAttribute("msgerror", cate.getpMsg_error());
                        request.setAttribute("openit2", 1);
                        request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    } else {
                        editCat.editarThing(cate);
                        request.getRequestDispatcher("ControladorCategoria?menu=categoria&&accion=listar").forward(request, response);
                    }
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

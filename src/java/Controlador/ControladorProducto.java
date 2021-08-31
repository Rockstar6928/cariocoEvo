/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import ModeloDAO.actualizarProducto;
import ModeloDAO.agregarProducto;
import ModeloDAO.buscarProductoAdmin;
import ModeloDAO.categoriaListarAdmin;
import ModeloDAO.eliminarProducto;
import ModeloDAO.mostrarProducto;
import ModeloDAO.ocultarProducto;
import ModeloDAO.productoListarById;
import ModeloDAO.productosListarAdmin;
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
public class ControladorProducto extends HttpServlet {

    categoriaListarAdmin catListar = new categoriaListarAdmin();
    productosListarAdmin listProductos = new productosListarAdmin();
    buscarProductoAdmin buscarPro = new buscarProductoAdmin();
    ocultarProducto hideProducto = new ocultarProducto();
    mostrarProducto showProducto = new mostrarProducto();
    eliminarProducto delPro = new eliminarProducto();
    agregarProducto addPro = new agregarProducto();
    productoListarById proById = new productoListarById();
    actualizarProducto updatePro = new actualizarProducto();
    Producto pro = new Producto();
    int idEditar = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menuNavBar = request.getParameter("menu");
        String accionMenu = request.getParameter("accion");
        if (menuNavBar.equals("producto")) {
            switch (accionMenu) {
                case "listar":
                    List<Producto> lPro = new ArrayList<>();
                    lPro = listProductos.listar();
                    request.setAttribute("listaProductos", lPro);
                    request.getRequestDispatcher("productosAdmin.jsp").forward(request, response);
                    break;
                case "LCats":
                    List<Categoria> lista = catListar.listar();
                    Gson json = new Gson();
                    String countryList = json.toJson(lista);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList);
                    break;
                case "Buscar":
                    int listCats = Integer.parseInt(request.getParameter("listCats"));
                    String productoBuscado = request.getParameter("productoBuscado");
                    int estadoPro = Integer.parseInt(request.getParameter("estadoPro"));
                    List<Producto> lProBu = new ArrayList<>();
                    pro.setIdCat(listCats);
                    pro.setDescPro(productoBuscado);
                    pro.setProEstado(estadoPro);
                    lProBu = buscarPro.buscar(pro);
                    request.setAttribute("listaProductos", lProBu);
                    request.setAttribute("productoBuscado", productoBuscado);
                    request.setAttribute("proEstado", estadoPro);
                    request.setAttribute("catbu", listCats);
                    request.getRequestDispatcher("productosAdmin.jsp").forward(request, response);
                    break;
                case "Ocultar":
                    int idProductoOcultar = Integer.parseInt(request.getParameter("id"));
                    pro.setIdPro(idProductoOcultar);
                    hideProducto.cambiarEstado(pro);
                    request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
                    break;
                case "Visible":
                    int idProductoMostrar = Integer.parseInt(request.getParameter("id"));
                    pro.setIdPro(idProductoMostrar);
                    showProducto.cambiarEstado(pro);
                    request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idProductoEliminar = Integer.parseInt(request.getParameter("id"));
                    pro.setIdPro(idProductoEliminar);
                    delPro.cambiarEstado(pro);
                    request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
                    break;
                case "Agregar":
                    int listCats2 = Integer.parseInt(request.getParameter("listCats2"));
                    String nombrepro = request.getParameter("nombrepro");
                    String despro = request.getParameter("despro");
                    Double preciopro = Double.parseDouble(request.getParameter("preciopro"));
                    String imgpro = request.getParameter("imgpro");
                    pro.setIdCat(listCats2);
                    pro.setNomPro(nombrepro);
                    pro.setDescPro(despro);
                    pro.setPrecioPro(preciopro);
                    pro.setImgPro(imgpro);
                    addPro.agregarThing(pro);
                    if (pro.getpError() == 101) {
                        request.setAttribute("iderror", pro.getpError());
                        request.setAttribute("msgerror", pro.getpMsg_error());
                        request.setAttribute("openit", 1);
                        request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
                    } else {
                        addPro.agregarThing(pro);
                        request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
                    }
                    break;

                case "obtenerDatos":
                    idEditar = Integer.parseInt(request.getParameter("id"));
                    pro.setIdPro(idEditar);
                    List<Producto> listaEditar = proById.listarById(pro);
                    Gson json2 = new Gson();
                    String countryList2 = json2.toJson(listaEditar);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList2);
                    break;

                case "Editar":
                    int listCats3 = Integer.parseInt(request.getParameter("listCats3"));
                    String nombrepro2 = request.getParameter("nombrepro");
                    String despro2 = request.getParameter("despro");
                    Double preciopro2 = Double.parseDouble(request.getParameter("preciopro"));
                    String imgpro2 = request.getParameter("imgpro");
                    String imgproprevious = request.getParameter("imgproprevious");
                    pro.setIdCat(listCats3);
                    pro.setNomPro(nombrepro2);
                    pro.setDescPro(despro2);
                    pro.setPrecioPro(preciopro2);
                    if (imgpro2.equals("")) {
                        pro.setImgPro(imgproprevious);
                    } else {
                        pro.setImgPro(imgpro2);
                    }
                    updatePro.editarThing(pro);
                    if (pro.getpError() == 101) {
                        request.setAttribute("iderror", pro.getpError());
                        request.setAttribute("msgerror", pro.getpMsg_error());
                        request.setAttribute("openit2", 1);
                        request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
                    } else {
                        updatePro.editarThing(pro);
                        request.getRequestDispatcher("ControladorProducto?menu=producto&&accion=listar").forward(request, response);
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

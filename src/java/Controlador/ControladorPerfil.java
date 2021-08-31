/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Menu;
import Modelo.MenuPerfil;
import Modelo.Perfil;
import ModeloDAO.PerfilAsignarMenuDAO;
import ModeloDAO.PerfilEditarDAO;
import ModeloDAO.actualizarPerfil;
import ModeloDAO.agregarPerfil;
import ModeloDAO.deshabilitarPerfil;
import ModeloDAO.filtrarPerfil;
import ModeloDAO.habilitarPerfil;
import ModeloDAO.listarMenu;
import ModeloDAO.listarPerfilId;
import ModeloDAO.listarUsuariosRoles;
import ModeloDAO.perfilEliminar;
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
public class ControladorPerfil extends HttpServlet {

    listarUsuariosRoles listRoles = new listarUsuariosRoles();
    filtrarPerfil searchPerfil = new filtrarPerfil();
    deshabilitarPerfil offPerfil = new deshabilitarPerfil();
    habilitarPerfil onPerfil = new habilitarPerfil();
    agregarPerfil addPerfil = new agregarPerfil();
    perfilEliminar delPerfil = new perfilEliminar();
    actualizarPerfil upPerfil = new actualizarPerfil();
    listarPerfilId liPerId = new listarPerfilId();
    listarMenu listaM = new listarMenu();
    PerfilEditarDAO opPerfil = new PerfilEditarDAO();
    PerfilAsignarMenuDAO addOpPer = new PerfilAsignarMenuDAO();
    Perfil perf = new Perfil();
    Menu me = new Menu();
    int idEditar = 0;
    MenuPerfil menuP = new MenuPerfil();
    String abcDoc = "";
    int idGetOp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menuNavBar = request.getParameter("menu");
        String accionMenu = request.getParameter("accion");
        if (menuNavBar.equals("perfil")) {
            switch (accionMenu) {
                case "listar":
                    List<Perfil> lista = new ArrayList<>();
                    lista = listRoles.listar();
                    request.setAttribute("listaRoles", lista);
                    request.getRequestDispatcher("rolesAdmin.jsp").forward(request, response);
                    break;
                case "Buscar":
                    String perfilBuscado = request.getParameter("perfilBuscado");
                    int estadoPerfil = Integer.parseInt(request.getParameter("estadoPerfil"));
                    perf.setDesPerfil(perfilBuscado);
                    perf.setPerfilEstado(estadoPerfil);
                    List<Perfil> listaBuscada = new ArrayList<>();
                    listaBuscada = searchPerfil.buscar(perf);
                    request.setAttribute("listaRoles", listaBuscada);
                    request.setAttribute("desperf", perfilBuscado);
                    request.setAttribute("perfEstado", estadoPerfil);
                    request.getRequestDispatcher("rolesAdmin.jsp").forward(request, response);
                    break;
                case "Ocultar":
                    int idPerfilOcultar = Integer.parseInt(request.getParameter("id"));
                    perf.setIdPerfil(idPerfilOcultar);
                    offPerfil.cambiarEstado(perf);
                    request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    break;
                case "Visible":
                    int idPerfilMostrar = Integer.parseInt(request.getParameter("id"));
                    perf.setIdPerfil(idPerfilMostrar);
                    onPerfil.cambiarEstado(perf);
                    request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    break;
                case "Agregar":
                    String txtperfil = request.getParameter("perfilagregar");
                    perf.setDesPerfil(txtperfil);
                    addPerfil.agregarThing(perf);
                    if (perf.getpError() == 101) {
                        request.setAttribute("iderror", perf.getpError());
                        request.setAttribute("msgerror", perf.getpMsg_error());
                        request.setAttribute("openit", 1);
                        request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    } else {
                        addPerfil.agregarThing(perf);
                        request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    int idPerfilEliminar = Integer.parseInt(request.getParameter("id"));
                    perf.setIdPerfil(idPerfilEliminar);
                    delPerfil.cambiarEstado(perf);
                    request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    break;
                case "obtenerDatos":
                    idEditar = Integer.parseInt(request.getParameter("id"));
                    perf.setIdPerfil(idEditar);
                    List<Perfil> listaEditar = liPerId.listarById(perf);
                    Gson json2 = new Gson();
                    String countryList2 = json2.toJson(listaEditar);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList2);
                    break;
                case "Editar":
                    String nameperfil = request.getParameter("nameperfil");
                    perf.setDesPerfil(nameperfil);
                    upPerfil.editarThing(perf);
                    if (perf.getpError() == 101) {
                        request.setAttribute("iderror", perf.getpError());
                        request.setAttribute("msgerror", perf.getpMsg_error());
                        request.setAttribute("openit2", 1);
                        request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    } else {
                        upPerfil.editarThing(perf);
                        request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
                    }
                    break;
                case "mostrarMenu":
                    List<Menu> listaMenu = listaM.listar();
                    Gson json = new Gson();
                    String countryList = json.toJson(listaMenu);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList);
                    break;

                case "obtenerOpciones":
                    idGetOp = Integer.parseInt(request.getParameter("id"));
                    menuP.setIdPerfil(idGetOp);
                    List<MenuPerfil> listaOp = new ArrayList<>();
                    listaOp = opPerfil.listarById(menuP);
                    Gson json3 = new Gson();
                    String countryList3 = json3.toJson(listaOp);
                    response.setContentType("text/html");
                    response.getWriter().write(countryList3);
                    break;

                case "AgregarMenu":
                    String menus[] = request.getParameterValues("grupoOp");
                    String inicio = "\'&ROOT>";
                    for (String menu1 : menus) {
                        abcDoc = "&doc>&menu>" + menu1 + "&/menu>&/doc>" + abcDoc;
                    }
                    abcDoc = inicio + abcDoc + "&/ROOT>\'";
                    abcDoc = abcDoc.replaceAll("&", "<");
                    menuP.setXmlDAO(abcDoc);
                    menuP.setIdPerfil(idGetOp);
                    addOpPer.agregarThing(menuP);
                    request.getRequestDispatcher("ControladorPerfil?menu=perfil&&accion=listar").forward(request, response);
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

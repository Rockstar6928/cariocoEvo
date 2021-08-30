/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Leonardo
 */
public class MenuPerfil extends Menu {

    private String xmlDAO;
    private int validandoMenu;

    public MenuPerfil(String xmlDAO, int validandoMenu, int idMenu, String desMenu, String rutaMenu, String classMenu, String targetMenu, int idPerfil, String desPerfil, int perfilEstado, int pError, String pMsg_error) {
        super(idMenu, desMenu, rutaMenu, classMenu, targetMenu, idPerfil, desPerfil, perfilEstado, pError, pMsg_error);
        this.xmlDAO = xmlDAO;
        this.validandoMenu = validandoMenu;
    }

    public MenuPerfil(String xmlDAO, int validandoMenu, int idMenu, String desMenu, String rutaMenu, String classMenu, String targetMenu) {
        super(idMenu, desMenu, rutaMenu, classMenu, targetMenu);
        this.xmlDAO = xmlDAO;
        this.validandoMenu = validandoMenu;
    }

    public MenuPerfil(String xmlDAO, int validandoMenu) {
        this.xmlDAO = xmlDAO;
        this.validandoMenu = validandoMenu;
    }

    public MenuPerfil() {
    }

    public String getXmlDAO() {
        return xmlDAO;
    }

    public void setXmlDAO(String xmlDAO) {
        this.xmlDAO = xmlDAO;
    }

    public int getValidandoMenu() {
        return validandoMenu;
    }

    public void setValidandoMenu(int validandoMenu) {
        this.validandoMenu = validandoMenu;
    }

}

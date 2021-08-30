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
public class Menu extends Perfil {

    private int idMenu;
    private String desMenu;
    private String rutaMenu;
    private String classMenu;
    private String targetMenu;

    public Menu(int idMenu, String desMenu, String rutaMenu, String classMenu, String targetMenu, int idPerfil, String desPerfil, int perfilEstado, int pError, String pMsg_error) {
        super(idPerfil, desPerfil, perfilEstado, pError, pMsg_error);
        this.idMenu = idMenu;
        this.desMenu = desMenu;
        this.rutaMenu = rutaMenu;
        this.classMenu = classMenu;
        this.targetMenu = targetMenu;
    }

    public Menu(int idMenu, String desMenu, String rutaMenu, String classMenu, String targetMenu) {
        this.idMenu = idMenu;
        this.desMenu = desMenu;
        this.rutaMenu = rutaMenu;
        this.classMenu = classMenu;
        this.targetMenu = targetMenu;
    }

    public Menu() {
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getDesMenu() {
        return desMenu;
    }

    public void setDesMenu(String desMenu) {
        this.desMenu = desMenu;
    }

    public String getRutaMenu() {
        return rutaMenu;
    }

    public void setRutaMenu(String rutaMenu) {
        this.rutaMenu = rutaMenu;
    }

    public String getClassMenu() {
        return classMenu;
    }

    public void setClassMenu(String classMenu) {
        this.classMenu = classMenu;
    }

    public String getTargetMenu() {
        return targetMenu;
    }

    public void setTargetMenu(String targetMenu) {
        this.targetMenu = targetMenu;
    }

}

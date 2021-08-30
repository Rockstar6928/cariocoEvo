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
public class Categoria {

    private int idCat;
    private String desCat;
    private String rutaMenu;
    private String classMenu;
    private String targetMenu;
    private int catEstado;
    private String catEstadoDes;
    private int pError;
    private String pMsg_error;

    public Categoria(int idCat, String desCat, String rutaMenu, String classMenu, String targetMenu, int catEstado, String catEstadoDes, int pError, String pMsg_error) {
        this.idCat = idCat;
        this.desCat = desCat;
        this.rutaMenu = rutaMenu;
        this.classMenu = classMenu;
        this.targetMenu = targetMenu;
        this.catEstado = catEstado;
        this.catEstadoDes = catEstadoDes;
        this.pError = pError;
        this.pMsg_error = pMsg_error;
    }

    public Categoria() {
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getDesCat() {
        return desCat;
    }

    public void setDesCat(String desCat) {
        this.desCat = desCat;
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

    public int getCatEstado() {
        return catEstado;
    }

    public void setCatEstado(int catEstado) {
        this.catEstado = catEstado;
    }

    public String getCatEstadoDes() {
        return catEstadoDes;
    }

    public void setCatEstadoDes(String catEstadoDes) {
        this.catEstadoDes = catEstadoDes;
    }

    public int getpError() {
        return pError;
    }

    public void setpError(int pError) {
        this.pError = pError;
    }

    public String getpMsg_error() {
        return pMsg_error;
    }

    public void setpMsg_error(String pMsg_error) {
        this.pMsg_error = pMsg_error;
    }

}

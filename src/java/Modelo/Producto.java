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
public class Producto extends Categoria {

    private int idPro;
    private String nomPro;
    private String descPro;
    private double precioPro;
    private String imgPro;
    private int proEstado;
    private String proEstadoDes;

    public Producto(int idPro, String nomPro, String descPro, double precioPro, String imgPro, int proEstado, String proEstadoDes, int idCat, String desCat, String rutaMenu, String classMenu, String targetMenu, int catEstado, String catEstadoDes, int pError, String pMsg_error) {
        super(idCat, desCat, rutaMenu, classMenu, targetMenu, catEstado, catEstadoDes, pError, pMsg_error);
        this.idPro = idPro;
        this.nomPro = nomPro;
        this.descPro = descPro;
        this.precioPro = precioPro;
        this.imgPro = imgPro;
        this.proEstado = proEstado;
        this.proEstadoDes = proEstadoDes;
    }

    public Producto(int idPro, String nomPro, String descPro, double precioPro, String imgPro, int proEstado, String proEstadoDes) {
        this.idPro = idPro;
        this.nomPro = nomPro;
        this.descPro = descPro;
        this.precioPro = precioPro;
        this.imgPro = imgPro;
        this.proEstado = proEstado;
        this.proEstadoDes = proEstadoDes;
    }

    public Producto() {
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public String getDescPro() {
        return descPro;
    }

    public void setDescPro(String descPro) {
        this.descPro = descPro;
    }

    public double getPrecioPro() {
        return precioPro;
    }

    public void setPrecioPro(double precioPro) {
        this.precioPro = precioPro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }

    public int getProEstado() {
        return proEstado;
    }

    public void setProEstado(int proEstado) {
        this.proEstado = proEstado;
    }

    public String getProEstadoDes() {
        return proEstadoDes;
    }

    public void setProEstadoDes(String proEstadoDes) {
        this.proEstadoDes = proEstadoDes;
    }

}

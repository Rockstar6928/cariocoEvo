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
public class Usuario {

    private int idUser;
    private int idPerfil;
    private String idPerfilString;
    private String mailUser;
    private String passwordUser;
    private int usuEstado;
    private String usuEstadoString;
    private int pError;
    private String pMsg_error;

    public Usuario(int idUser, int idPerfil, String idPerfilString, String mailUser, String passwordUser, int usuEstado, String usuEstadoString, int pError, String pMsg_error) {
        this.idUser = idUser;
        this.idPerfil = idPerfil;
        this.idPerfilString = idPerfilString;
        this.mailUser = mailUser;
        this.passwordUser = passwordUser;
        this.usuEstado = usuEstado;
        this.usuEstadoString = usuEstadoString;
        this.pError = pError;
        this.pMsg_error = pMsg_error;
    }

  

    

    public Usuario() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public int getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(int usuEstado) {
        this.usuEstado = usuEstado;
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

    public String getIdPerfilString() {
        return idPerfilString;
    }

    public void setIdPerfilString(String idPerfilString) {
        this.idPerfilString = idPerfilString;
    }

    public String getUsuEstadoString() {
        return usuEstadoString;
    }

    public void setUsuEstadoString(String usuEstadoString) {
        this.usuEstadoString = usuEstadoString;
    }

}

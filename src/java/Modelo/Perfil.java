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
public class Perfil {

    private int idPerfil;
    private String desPerfil;
    private int perfilEstado;
    private int pError;
    private String pMsg_error;

    public Perfil(int idPerfil, String desPerfil, int perfilEstado, int pError, String pMsg_error) {
        this.idPerfil = idPerfil;
        this.desPerfil = desPerfil;
        this.perfilEstado = perfilEstado;
        this.pError = pError;
        this.pMsg_error = pMsg_error;
    }

    public Perfil() {
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDesPerfil() {
        return desPerfil;
    }

    public void setDesPerfil(String desPerfil) {
        this.desPerfil = desPerfil;
    }

    public int getPerfilEstado() {
        return perfilEstado;
    }

    public void setPerfilEstado(int perfilEstado) {
        this.perfilEstado = perfilEstado;
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

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
public class Empleado extends Usuario {

    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String celularEmpleado;
    private String dniEmpleado;

    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String celularEmpleado, String dniEmpleado, int idUser, int idPerfil, String idPerfilString, String mailUser, String passwordUser, int usuEstado, String usuEstadoString, int pError, String pMsg_error) {
        super(idUser, idPerfil, idPerfilString, mailUser, passwordUser, usuEstado, usuEstadoString, pError, pMsg_error);
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.celularEmpleado = celularEmpleado;
        this.dniEmpleado = dniEmpleado;
    }

    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String celularEmpleado, String dniEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.celularEmpleado = celularEmpleado;
        this.dniEmpleado = dniEmpleado;
    }

 

   

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getCelularEmpleado() {
        return celularEmpleado;
    }

    public void setCelularEmpleado(String celularEmpleado) {
        this.celularEmpleado = celularEmpleado;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

}

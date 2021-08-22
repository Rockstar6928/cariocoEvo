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
public class Cliente extends Usuario {

    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String celularCliente;
    private String dniCliente;
    private String fechaNacimiento;
    private String direccionCliente;

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String celularCliente, String dniCliente, String fechaNacimiento, String direccionCliente, int idUser, int idPerfil, String mailUser, String passwordUser, int usuEstado, int pError, String pMsg_error) {
        super(idUser, idPerfil, mailUser, passwordUser, usuEstado, pError, pMsg_error);
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.celularCliente = celularCliente;
        this.dniCliente = dniCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionCliente = direccionCliente;
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String celularCliente, String dniCliente, String fechaNacimiento, String direccionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.celularCliente = celularCliente;
        this.dniCliente = dniCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionCliente = direccionCliente;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

}

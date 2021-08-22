/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;

/**
 *
 * @author Leonardo
 */
public abstract interface IValidarDatosRegistro<T> {

    public abstract Cliente validarDatosRegistro(T t);
}

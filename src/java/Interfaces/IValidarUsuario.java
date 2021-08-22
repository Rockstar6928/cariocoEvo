/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Usuario;

/**
 *
 * @author Leonardo
 */
public abstract interface IValidarUsuario<T> {

    public abstract Usuario validarUsuario(T t);
}

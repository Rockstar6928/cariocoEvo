/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.Connection;

/**
 *
 * @author Leonardo
 */
public abstract interface IConexion {

    public abstract Connection getConexion();
}

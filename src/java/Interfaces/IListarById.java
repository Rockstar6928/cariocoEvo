/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public abstract interface IListarById<T> {

    public abstract List<T> listarById(T t);
}

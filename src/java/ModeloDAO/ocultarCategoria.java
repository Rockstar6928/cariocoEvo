/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import Modelo.Categoria;
import Interfaces.ICambiarEstado;

/**
 *
 * @author Leonardo
 */
public class ocultarCategoria implements ICambiarEstado<Categoria> {

    Connection cn;
    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    int r;

    @Override
    public int cambiarEstado(Categoria t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_OcultarCategoria(?)}");
            cl.setInt(1, t.getIdCat());
            cl.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}

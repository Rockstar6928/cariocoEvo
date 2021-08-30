/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.ICambiarEstado;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Leonardo
 */
public class ocultarProducto implements ICambiarEstado<Producto> {

    Connection cn;
    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    int r;

    @Override
    public int cambiarEstado(Producto t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_OcultarProducto(?)}");
            cl.setInt(1, t.getIdPro());
            cl.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IEditarGeneral;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class actualizarProducto implements IEditarGeneral<Producto> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    int r;

    @Override
    public int editarThing(Producto t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_actualizaProducto(?,?,?,?,?,?,?,?)}");
            cl.setInt(1, t.getIdPro());
            cl.setInt(2, t.getIdCat());
            cl.setString(3, t.getNomPro());
            cl.setString(4, t.getDescPro());
            cl.setDouble(5, t.getPrecioPro());
            cl.setString(6, t.getImgPro());
            cl.registerOutParameter(7, Types.INTEGER);
            cl.registerOutParameter(8, Types.VARCHAR);
            cl.executeUpdate();
            t.setpError(cl.getInt(7));
            t.setpMsg_error(cl.getString(8));
        } catch (Exception e) {
        }
        return r;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IAgregarGeneral;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class agregarProducto implements IAgregarGeneral<Producto> {

    int r;
    Connection cn;
    ConexionMySQL obcn = new ConexionMySQL();
    CallableStatement cl;

    @Override
    public int agregarThing(Producto t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_agregarPRO(?,?,?,?,?,?,?)}");
            cl.setInt(1, t.getIdCat());
            cl.setString(2, t.getNomPro());
            cl.setString(3, t.getDescPro());
            cl.setDouble(4, t.getPrecioPro());
            cl.setString(5, t.getImgPro());
            cl.registerOutParameter(6, Types.INTEGER);
            cl.registerOutParameter(7, Types.VARCHAR);
            cl.executeUpdate();
            t.setpError(cl.getInt(6));
            t.setpMsg_error(cl.getString(7));
        } catch (Exception e) {
        }
        return r;
    }

}

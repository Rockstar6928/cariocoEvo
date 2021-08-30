/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IAgregarGeneral;
import Modelo.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class agregarCategoria implements IAgregarGeneral<Categoria> {

    int r;
    Connection cn;
    ConexionMySQL obcn = new ConexionMySQL();
    CallableStatement cl;

    @Override
    public int agregarThing(Categoria t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_agregarCAT(?,?,?)}");
            cl.setString(1, t.getDesCat());
            cl.registerOutParameter(2, Types.INTEGER);
            cl.registerOutParameter(3, Types.VARCHAR);
            cl.executeUpdate();
            t.setpError(cl.getInt(2));
            t.setpMsg_error(cl.getString(3));
        } catch (Exception e) {
        }
        return r;
    }

}

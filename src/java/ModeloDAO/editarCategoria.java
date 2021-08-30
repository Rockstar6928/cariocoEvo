/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IEditarGeneral;
import Modelo.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class editarCategoria implements IEditarGeneral<Categoria> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    int r;

    @Override
    public int editarThing(Categoria t) {
        try {
            cn=obcn.getConexion();
            cl=(CallableStatement)cn.prepareCall("{CALL spF_actualizaCAT(?,?,?,?)}");
            cl.setInt(1, t.getIdCat());
            cl.setString(2, t.getDesCat());
            cl.registerOutParameter(3, Types.INTEGER);
            cl.registerOutParameter(4, Types.VARCHAR);
            cl.executeUpdate();
            t.setpError(cl.getInt(3));
            t.setpMsg_error(cl.getString(4));
        } catch (Exception e) {
        }
        return r;
    }

}

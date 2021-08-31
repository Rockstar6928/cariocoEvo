/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IEditarGeneral;
import Modelo.Perfil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class actualizarPerfil implements IEditarGeneral<Perfil> {

    Connection cn;
    CallableStatement cl;
    int r;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public int editarThing(Perfil t) {
        try {
            cn=obcn.getConexion();
            cl=(CallableStatement)cn.prepareCall("{CALL spF_actualizarPERFIL(?,?,?,?)}");
            cl.setInt(1, t.getIdPerfil());
            cl.setString(2, t.getDesPerfil());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IAgregarGeneral;
import Modelo.Perfil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class agregarPerfil implements IAgregarGeneral<Perfil> {
    
    Connection cn;
    CallableStatement cl;
    int r;
    ConexionMySQL obcn = new ConexionMySQL();
    
    @Override
    public int agregarThing(Perfil t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_agregarPerfil(?,?,?)}");
            cl.setString(1, t.getDesPerfil());
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

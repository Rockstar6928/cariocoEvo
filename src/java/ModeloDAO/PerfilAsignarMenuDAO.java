/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IAgregarGeneral;
import Modelo.MenuPerfil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class PerfilAsignarMenuDAO implements IAgregarGeneral<MenuPerfil> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    int r;

    @Override
    public int agregarThing(MenuPerfil t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_AsignarMenus(?,?,?,?)}");
            cl.setString(1, t.getXmlDAO());
            cl.setInt(2, t.getIdPerfil());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IValidarUsuario;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class ValidarUsuario implements IValidarUsuario<Usuario> {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public Usuario validarUsuario(Usuario t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_validarUsuario(?,?,?,?)}");
            cl.setString(1, t.getMailUser());
            cl.setString(2, t.getPasswordUser());
            cl.registerOutParameter(3, Types.INTEGER);
            cl.registerOutParameter(4, Types.VARCHAR);
            rs = cl.executeQuery();
            t.setpError(cl.getInt(3));
            t.setpMsg_error(cl.getString(4));
            while (rs.next()) {
                t.setIdUser(rs.getInt(1));
                t.setIdPerfil(rs.getInt(2));
                t.setMailUser(rs.getString(3));
                t.setPasswordUser(rs.getString(4));
                t.setUsuEstado(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error, posible causa: " + e);
        }
        return t;
    }

}

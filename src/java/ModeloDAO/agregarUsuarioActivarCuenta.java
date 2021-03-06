/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IAgregarUsuario;
import Modelo.Md5;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Leonardo
 */
public class agregarUsuarioActivarCuenta implements IAgregarUsuario<Usuario> {

    Connection cn;
    ConexionMySQL obcn = new ConexionMySQL();
    CallableStatement cl;
    int r;
    Md5 md5 = new Md5();

    @Override
    public int agregarUsuario(Usuario t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_agregarUSUARIO(?,?)}");
            cl.setString(1, t.getMailUser());
            cl.setString(2, md5.ecnode(t.getPasswordUser()));
            cl.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}

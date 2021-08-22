/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IValidarDatosRegistro;
import Modelo.Cliente;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Leonardo
 */
public class revisarDatosRegistro implements IValidarDatosRegistro<Cliente> {
    
    Connection cn;
    ConexionMySQL obcn = new ConexionMySQL();
    CallableStatement cl;
    ResultSet rs;
    
    @Override
    public Cliente validarDatosRegistro(Cliente t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ChecarDatosRegister(?,?,?,?)}");
            cl.setString(1, t.getMailUser());
            cl.setString(2, t.getDniCliente());
            cl.registerOutParameter(3, Types.INTEGER);
            cl.registerOutParameter(4, Types.VARCHAR);
            rs = cl.executeQuery();
            t.setpError(cl.getInt(3));
            t.setpMsg_error(cl.getString(4));
        } catch (Exception e) {
        }
        return t;
    }
    
}

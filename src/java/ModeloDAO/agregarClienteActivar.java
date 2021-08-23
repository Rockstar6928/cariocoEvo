/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IAgregarCliente;
import Modelo.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class agregarClienteActivar implements IAgregarCliente<Cliente> {

    Connection cn;
    ConexionMySQL obcn = new ConexionMySQL();
    CallableStatement cl;
    int r;

    @Override
    public int agregarCliente(Cliente t) {
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_agregarCliente(?,?,?,?,?,?,?)}");
            cl.setString(1, t.getNombreCliente());
            cl.setString(2, t.getApellidoCliente());
            cl.setString(3, t.getCelularCliente());
            cl.setString(4, t.getDniCliente());
            cl.setString(5, t.getFechaNacimiento());
            cl.setString(6, t.getDireccionCliente());
            cl.setInt(7, t.getIdUser());
            cl.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}

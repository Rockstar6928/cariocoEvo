/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IObtenerMaxId;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class ObtenerUsuarioMaximo implements IObtenerMaxId {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public int getMaxId() {
        int codigo = 0;
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_obtenerMaxUser()}");
            rs = cl.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return codigo;
    }

}

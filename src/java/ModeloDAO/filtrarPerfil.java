/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IBuscar;
import Modelo.Menu;
import Modelo.Perfil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class filtrarPerfil implements IBuscar<Perfil> {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public List<Perfil> buscar(Perfil t) {
        List<Perfil> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_FiltrarPerfil(?,?)}");
            cl.setString(1, t.getDesPerfil());
            cl.setInt(2, t.getPerfilEstado());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new Menu();
                t.setIdPerfil(rs.getInt(1));
                t.setDesPerfil(rs.getString(2));
                t.setContadorRoles(rs.getInt(3));
                t.setPerfilEstadoDes(rs.getString(4));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IValidarMenu;
import Modelo.Menu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class ValidarMenuDAO implements IValidarMenu<Menu> {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public List<Menu> listarMenu(Menu t) {
        List<Menu> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_validarMenu(?)}");
            cl.setInt(1, t.getIdPerfil());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new Menu();
                t.setIdPerfil(rs.getInt(1));
                t.setDesPerfil(rs.getString(2));
                t.setIdMenu(rs.getInt(3));
                t.setDesMenu(rs.getString(4));
                t.setRutaMenu(rs.getString(5));
                t.setClassMenu(rs.getString(6));
                t.setTargetMenu(rs.getString(7));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

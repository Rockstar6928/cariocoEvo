/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListarById;
import Modelo.MenuPerfil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class PerfilEditarDAO implements IListarById<MenuPerfil> {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public List<MenuPerfil> listarById(MenuPerfil t) {
        List<MenuPerfil> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_EditarMenu(?)}");
            cl.setInt(1, t.getIdPerfil());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new MenuPerfil();
                t.setIdPerfil(rs.getInt(1));
                t.setIdMenu(rs.getInt(2));
                t.setValidandoMenu(rs.getInt(3));
                t.setDesMenu(rs.getString(4));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

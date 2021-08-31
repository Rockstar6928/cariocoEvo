/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListar;
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
public class listarMenu implements IListar<Menu> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    ResultSet rs;

    @Override
    public List<Menu> listar() {
        List<Menu> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListarMenu()}");
            rs = cl.executeQuery();
            while (rs.next()) {
                Menu m = new Menu();
                m.setIdMenu(rs.getInt(1));
                m.setDesMenu(rs.getString(2));
                lista.add(m);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

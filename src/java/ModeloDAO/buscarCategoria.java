/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IBuscar;
import Modelo.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class buscarCategoria implements IBuscar<Categoria> {

    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    ResultSet rs;

    @Override
    public List<Categoria> buscar(Categoria t) {
        List<Categoria> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_BuscarCAT(?,?)}");
            cl.setString(1, t.getDesCat());
            cl.setInt(2, t.getCatEstado());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new Categoria();
                t.setIdCat(rs.getInt(1));
                t.setDesCat(rs.getString(2));
                t.setRutaMenu(rs.getString(3));
                t.setClassMenu(rs.getString(4));
                t.setTargetMenu(rs.getString(5));
                t.setCatEstadoDes(rs.getString(6));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

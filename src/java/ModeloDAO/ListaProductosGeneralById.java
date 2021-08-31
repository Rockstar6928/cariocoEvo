/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListarById;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class ListaProductosGeneralById implements IListarById<Producto> {
    
    Connection cn;
    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    ResultSet rs;
    
    @Override
    public List<Producto> listarById(Producto t) {
        List<Producto> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListaProductosGeneralById(?)}");
            cl.setInt(1, t.getIdCat());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new Producto();
                t.setIdPro(rs.getInt(1));
                t.setDesCat(rs.getString(2));
                t.setNomPro(rs.getString(3));
                t.setDescPro(rs.getString(4));
                t.setPrecioPro(rs.getDouble(5));
                t.setImgPro(rs.getString(6));
                t.setProEstadoDes(rs.getString(7));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
}

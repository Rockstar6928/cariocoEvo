/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListarById;
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
public class listarCategoriaPorID implements IListarById<Categoria> {

    Connection cn;
    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    ResultSet rs;

    @Override
    public List<Categoria> listarById(Categoria t) {
        List<Categoria> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListarCATID(?)}");
            cl.setInt(1, t.getIdCat());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new Categoria();
                t.setIdCat(rs.getInt(1));
                t.setDesCat(rs.getString(2));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

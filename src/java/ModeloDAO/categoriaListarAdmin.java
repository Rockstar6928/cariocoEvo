/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListar;
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
public class categoriaListarAdmin implements IListar<Categoria> {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListarCats()}");
            rs = cl.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt(1));
                cat.setDesCat(rs.getString(2));
                cat.setRutaMenu(rs.getString(3));
                cat.setClassMenu(rs.getString(4));
                cat.setTargetMenu(rs.getString(5));
                cat.setCatEstadoDes(rs.getString(6));
                lista.add(cat);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

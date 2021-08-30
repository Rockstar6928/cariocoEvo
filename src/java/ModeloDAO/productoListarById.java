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
public class productoListarById implements IListarById<Producto> {

    Connection cn;
    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    ResultSet rs;

    @Override
    public List<Producto> listarById(Producto t) {
        List<Producto> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListarPROID(?)}");
            cl.setInt(1, t.getIdPro());
            rs = cl.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdPro(rs.getInt(1));
                pro.setIdCat(rs.getInt(2));
                pro.setNomPro(rs.getString(3));
                pro.setDescPro(rs.getString(4));
                pro.setPrecioPro(rs.getDouble(5));
                pro.setImgPro(rs.getString(6));
                pro.setProEstadoDes(rs.getString(7));
                lista.add(pro);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

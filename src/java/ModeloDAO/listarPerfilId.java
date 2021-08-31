/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListarById;
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
public class listarPerfilId implements IListarById<Perfil> {

    Connection cn;
    CallableStatement cl;
    ConexionMySQL obcn = new ConexionMySQL();
    ResultSet rs;

    @Override
    public List<Perfil> listarById(Perfil t) {
        List<Perfil> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListarPerfilbyId(?)}");
            cl.setInt(1, t.getIdPerfil());
            rs = cl.executeQuery();
            while (rs.next()) {
                t = new Perfil();
                t.setIdPerfil(rs.getInt(1));
                t.setDesPerfil(rs.getString(2));
                t.setPerfilEstado(rs.getInt(3));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

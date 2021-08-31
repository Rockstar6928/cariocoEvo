/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListar;
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
public class listarUsuariosRoles implements IListar<Perfil> {

    Connection cn;
    CallableStatement cl;
    ResultSet rs;
    ConexionMySQL obcn = new ConexionMySQL();

    @Override
    public List<Perfil> listar() {
        List<Perfil> lista = new ArrayList<>();
        try {
            cn = obcn.getConexion();
            cl = (CallableStatement) cn.prepareCall("{CALL spF_ListarPerfilTotal()}");
            rs = cl.executeQuery();
            while (rs.next()) {
                Perfil per = new Perfil();
                per.setIdPerfil(rs.getInt(1));
                per.setDesPerfil(rs.getString(2));
                per.setContadorRoles(rs.getInt(3));
                per.setPerfilEstadoDes(rs.getString(4));
                lista.add(per);

            }
        } catch (Exception e) {
        }
        return lista;
    }

}

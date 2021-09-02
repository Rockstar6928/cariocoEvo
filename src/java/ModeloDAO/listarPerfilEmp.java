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
public class listarPerfilEmp implements IListar<Perfil> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    ResultSet rs;

    @Override
    public List<Perfil> listar() {
        List<Perfil> lista = new ArrayList<>();
        try {
            cn=obcn.getConexion();
            cl=(CallableStatement)cn.prepareCall("{CALL spF_ListarPerfilEmp()}");
            rs=cl.executeQuery();
            while(rs.next()){
                Perfil perf = new Perfil();
                perf.setIdPerfil(rs.getInt(1));
                perf.setDesPerfil(rs.getString(2));
                perf.setPerfilEstado(rs.getInt(3));
                lista.add(perf);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

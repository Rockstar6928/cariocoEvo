/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IListar;
import Modelo.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class listarTrabajador implements IListar<Empleado> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    ResultSet rs;

    @Override
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        try {
            cn=obcn.getConexion();
            cl=(CallableStatement)cn.prepareCall("{CALL spF_ListarUsu()}");
            rs=cl.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdUser(rs.getInt(1));
                emp.setMailUser(rs.getString(2));
                emp.setNombreEmpleado(rs.getString(3));
                emp.setApellidoEmpleado(rs.getString(4));
                emp.setCelularEmpleado(rs.getString(5));
                emp.setDniEmpleado(rs.getString(6));
                emp.setIdPerfilString(rs.getString(7));
                emp.setUsuEstadoString(rs.getString(8));
                lista.add(emp);
            }
        } catch (Exception e) {
        }
        return lista;
    }

}

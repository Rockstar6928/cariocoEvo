/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.ConexionMySQL;
import Interfaces.IBuscar;
import Modelo.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class filtrarEmpAdmin implements IBuscar<Empleado> {

    ConexionMySQL obcn = new ConexionMySQL();
    Connection cn;
    CallableStatement cl;
    ResultSet rs;

    @Override
    public List<Empleado> buscar(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

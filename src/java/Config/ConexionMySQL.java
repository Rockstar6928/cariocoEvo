/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leonardo
 */
public class ConexionMySQL implements IConexion {

    Connection cn;

    @Override
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/polleriaGusi", "root", "");
            //System.out.println("Conexion 1");
        } catch (Exception e) {
            //System.out.println("Conexion fallida, causa: " + e);
        }
        return cn;
    }

    /*
    public static void main(String[] args) {
        ConexionMySQL obcn = new ConexionMySQL();
        obcn.getConexion();
    }*/
}

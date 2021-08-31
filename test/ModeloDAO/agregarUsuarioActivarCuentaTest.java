/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Md5;
import Modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class agregarUsuarioActivarCuentaTest {

    public agregarUsuarioActivarCuentaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        System.out.print("agregar usuario");
        Usuario usu = new Usuario();
        Md5 md5 = new Md5();
        usu.setMailUser("mailprueba@prueba.com");
        usu.setPasswordUser(md5.ecnode("123"));
        agregarUsuarioActivarCuenta dao = new agregarUsuarioActivarCuenta();
        dao.agregarUsuario(usu);
    }
}

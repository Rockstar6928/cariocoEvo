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
public class ValidarUsuarioTest {

    public ValidarUsuarioTest() {
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
        System.out.println("validar usuario | login");
        Usuario usu = new Usuario();
        Md5 md5 = new Md5();
        usu.setMailUser("y1709");
        usu.setPasswordUser(md5.ecnode("cqSnNZ/C3c0="));
        usu.setpError(0);
        usu.setpMsg_error("");
        ValidarUsuario dao = new ValidarUsuario();
        dao.validarUsuario(usu);

    }
}

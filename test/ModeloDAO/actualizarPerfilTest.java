/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Perfil;
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
public class actualizarPerfilTest {

    public actualizarPerfilTest() {
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
        System.out.println("actualizar perfil");
        Perfil perf = new Perfil();
        perf.setIdPerfil(2);
        perf.setDesPerfil("sudesfperf");
        perf.setpError(0);
        perf.setpMsg_error("");
        actualizarPerfil dao = new actualizarPerfil();
        dao.editarThing(perf);
    }
}

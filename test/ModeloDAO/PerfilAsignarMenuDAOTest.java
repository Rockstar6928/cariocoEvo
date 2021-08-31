/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.MenuPerfil;
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
public class PerfilAsignarMenuDAOTest {

    public PerfilAsignarMenuDAOTest() {
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
        System.out.println("asignar ops");
        MenuPerfil c = new MenuPerfil();
        PerfilAsignarMenuDAO dao = new PerfilAsignarMenuDAO();
        c.setXmlDAO("'<ROOT><doc><menu>2</menu></doc><doc><menu>1</menu></doc></ROOT>'");
        c.setIdPerfil(1);
        dao.agregarThing(c);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Cliente;
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
public class revisarDatosRegistroTest {

    public revisarDatosRegistroTest() {
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
        System.out.println("revisar datos en el form de registro");
        Cliente cli = new Cliente();
        cli.setMailUser("correo@prueba.com");
        cli.setDniCliente("12374158");
        cli.setpError(0);
        cli.setpMsg_error("");
        revisarDatosRegistro dao = new revisarDatosRegistro();
        dao.validarDatosRegistro(cli);

    }
}
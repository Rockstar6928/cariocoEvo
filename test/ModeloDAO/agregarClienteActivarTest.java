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
public class agregarClienteActivarTest {

    public agregarClienteActivarTest() {
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
        System.out.println("agregar cliente");
        Cliente cli = new Cliente();
        cli.setNombreCliente("sunombre");
        cli.setApellidoCliente("suapellido");
        cli.setCelularCliente("123456789");
        cli.setFechaNacimiento("1999-05-25");
        cli.setDireccionCliente("sudir");
        cli.setIdUser(2);
        agregarClienteActivar dao = new agregarClienteActivar();
        dao.agregarCliente(cli);
    }
}

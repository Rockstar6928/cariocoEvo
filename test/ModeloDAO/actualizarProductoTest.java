/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Producto;
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
public class actualizarProductoTest {

    public actualizarProductoTest() {
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
        System.out.println("actualizar producto");
        Producto pro = new Producto();
        pro.setIdPro(3);
        pro.setIdCat(2);
        pro.setNomPro("elpro");
        pro.setDescPro("descpro");
        pro.setPrecioPro(5.5);
        pro.setImgPro("suimg");
        pro.setpError(0);
        pro.setpMsg_error("");
        actualizarProducto dao = new actualizarProducto();
        dao.editarThing(pro);
    }
}

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
public class agregarProductoTest {

    public agregarProductoTest() {
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
        System.out.println("agregar producto");
        Producto pro = new Producto();
        pro.setIdCat(1);
        pro.setNomPro("pruebapro");
        pro.setDescPro("despro");
        pro.setPrecioPro(1.5);
        pro.setImgPro("suimagen");
        pro.setpError(0);
        pro.setpMsg_error("");
        agregarProducto dao = new agregarProducto();
        dao.agregarThing(pro);
    }
}

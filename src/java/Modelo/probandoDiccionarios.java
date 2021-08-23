/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class probandoDiccionarios {

    public void devuelvemeDato() {

        Map<String, Integer> map = new HashMap<>();
        map.put("valor2", 54123);
        map.put("valor1", 12345);
        map.put("valor3", 11111);
        //Para analizar si los datos estan dentro
        int codigo = 12345;
        String correo = "valor1";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (map.containsKey(correo) && map.containsValue(codigo)) {
                System.out.println("ENCONTRADO");
                break;
            }

        }

    }

    public static void main(String[] args) {
        probandoDiccionarios pd = new probandoDiccionarios();
        pd.devuelvemeDato();
    }
}

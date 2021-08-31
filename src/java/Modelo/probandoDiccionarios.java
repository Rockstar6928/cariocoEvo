/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                map.remove(correo);
                break;
            }

        }

        System.out.println("Mapa: " + map);

    }

    Usuario usu = new Usuario();
    Map<String, Usuario> map1 = new HashMap<>();//This is one instance of the  map you want to store in the above list.

    public void devuelveDatojeje() {
        usu = new Usuario();
        usu.setMailUser("correo@prueba.com");
        usu.setPasswordUser("123456");
        map1.put(usu.getMailUser(), usu);
        for (Map.Entry<String, Usuario> entry : map1.entrySet()) {
            if (entry.getKey().equals("correo@prueba.com")) {
                System.out.println("K1: " + entry.getKey() + " | " + "V1: " + entry.getValue().getPasswordUser());
            }
        }
        //System.out.println(map1);
    }

    public void devuelveDatojeje2() {
        usu = new Usuario();
        usu.setMailUser("correo2@prueba2.com");
        usu.setPasswordUser("123456789");
        map1.put(usu.getMailUser(), usu);
        for (Map.Entry<String, Usuario> entry : map1.entrySet()) {
            if (entry.getKey().equals("correo2@prueba2.com")) {
                System.out.println("K2: " + entry.getKey() + " | " + "V2: " + entry.getValue().getPasswordUser());
            }
        }
        //System.out.println(map1);
    }

    public static void main(String[] args) {
        probandoDiccionarios pd = new probandoDiccionarios();
        pd.devuelveDatojeje();
        pd.devuelveDatojeje2();
        //pd.devuelvemeDato();
    }
}

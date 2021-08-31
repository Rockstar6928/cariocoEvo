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

    public void devuelveDatojeje() {
        //List<Map<String,List<String>>> list = new ArrayList<Map<String,List<String>>>();//This is the final list you need
        List<Map<String, Usuario>> list = new ArrayList<>();

        Map<String, Usuario> map1 = new HashMap<>();//This is one instance of the  map you want to store in the above list.

        usu.setMailUser("correo@prueba.com");
        usu.setPasswordUser("123456");

        map1.put(usu.getMailUser(), usu);
        list.add(map1);

        for (Map.Entry<String, Usuario> entry : map1.entrySet()) {
            if (entry.getKey().equals("correo@prueba.com")) {
                System.out.println(entry.getValue().getPasswordUser());
            }
        }

        
        
//        for (int i = 0; i < arraylist1.size(); i++) {
//            System.out.println("Mail: " + arraylist1.get(i).getMailUser() + " | " + "Pass: " + arraylist1.get(i).getPasswordUser());
//        }
//        for (Map.Entry<String, List<Usuario>> entry : map1.entrySet()) {
//            //System.out.println("K: "+entry.getKey()+" "+"V: "+entry.getValue().toString());
//            System.out.println("K: " + entry.getKey());
//            for (int i = 0; i < arraylist1.size(); i++) {
//                System.out.println("Mail: " + arraylist1.get(i).getMailUser() + " | " + "Pass: " + arraylist1.get(i).getPasswordUser());
//            }
//        }
//        System.out.println(list);
        //myMaps.put("corre1@prueba.com", new ArrayList<Usuario>(Arrays.as));
    }

    public static void main(String[] args) {
        probandoDiccionarios pd = new probandoDiccionarios();
        pd.devuelveDatojeje();
        //pd.devuelvemeDato();
    }
}

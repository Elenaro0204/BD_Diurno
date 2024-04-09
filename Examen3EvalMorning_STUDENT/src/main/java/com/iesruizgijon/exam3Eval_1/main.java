/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.exam3Eval_1;

import java.util.ArrayList;

/**
 *
 * @author grafeno30
 */
public class main {
    
    public static void main(String args[]){
        
        BaseDatos bd = new BaseDatos("northwind", "root", "123qweASD_");
        ArrayList<String> tabla = new ArrayList<>();
        String columnas[]= {"last_name","first_Name"};
        
        if (bd.Conecta()){
            System.out.println("Conectada con éxito");
        }else
        {
            System.out.println("Problemas con la conexión");
        }
        
        tabla = bd.getData("customers",columnas , 5);
        
        for (String fila : tabla) {
            
            System.out.println(fila);
            
        }
        
        bd.Desconecta();
        
        
    }
    
    
    
}

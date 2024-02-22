/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.iesruzgijon.programacionbasedatos;


/**
 *
 * @author elena
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String USER = "root";
        final String PASS = "123qweASD_";
        final String nameDB = "northwind";

        BaseDatos bd = new BaseDatos(nameDB, USER, PASS);
        
        bd.Conecta();
        
        bd.consultaPrueba2();
        
        bd.Desconecta();
        
    }
    
}

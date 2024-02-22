/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruzgijon.programacionbasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elena
 */
public class BaseDatos {

    private Connection conexion;

    private String USER;
    private String PASS;
    private String nameDB;
    private String URL = "jdbc:mysql://localhost:3306/";

    public BaseDatos(String nameDB, String USER, String PASS ) {
        this.USER = USER;
        this.PASS = PASS;
        this.nameDB = nameDB;
    }

    public void Conecta() {
        try {
            conexion = DriverManager.getConnection(URL + nameDB, USER, PASS);
            System.out.println("Conexion establecida...");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Desconecta() {
        try {
            if (conexion != null) {
                conexion.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaPrueba() {
        String company;
        String apellidos;
        String nombre;

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("select company, last_name, first_name from customers limit 10");
            while (resultado.next()) {
                company = resultado.getString("company");
                apellidos = resultado.getString("last_name");
                nombre = resultado.getString("first_name");

                System.out.println("Company " + company + " Apellidos " + apellidos + " Nombre " + nombre);
            }
            resultado.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void consultaPrueba2() {
        String nombre;
            
            try {
                Statement sentencia = conexion.createStatement();
                ResultSet resultado = sentencia.executeQuery("select concat_ws(\"-\", last_name, first_name) as nombre from customers;");
                while(resultado.next()){
                    nombre = resultado.getString("nombre");
                   
                    System.out.println("Nombre "+ nombre);

                }
                resultado.close();
                sentencia.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
}

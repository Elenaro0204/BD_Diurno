/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.iesruizgijon.diurno.programacionbasedatos;

/**
 *
 * @author elena
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {

        final String USER = "root";
        final String PASS = "123qweASD_";
        final String nameDB = "northwind";
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre de usuario:");
        String user = scanner.nextLine();

        System.out.println("Introduce la contraseña:");
        String pass = scanner.nextLine();

        BaseDatos db = new BaseDatos("", user, pass);

        if (db.Conecta()) {
            System.out.println("Conexión establecida");

            // Obtener nombres de las bases de datos
            ArrayList<String> databases = db.getDatabaseNames();
            System.out.println("Bases de datos disponibles:");
            for (int i = 0; i < databases.size(); i++) {
                System.out.println((i + 1) + ". " + databases.get(i));
            }

            // Elegir una base de datos
            System.out.println("Selecciona una base de datos:");
            int selectedDBIndex = scanner.nextInt();
            String selectedDBName = databases.get(selectedDBIndex - 1);

            // Obtener tablas de la base de datos seleccionada
            ArrayList<String> tables = db.getTables(selectedDBName);
            System.out.println("Tablas en " + selectedDBName + ":");
            for (int i = 0; i < tables.size(); i++) {
                System.out.println((i + 1) + ". " + tables.get(i));
            }
        } else {
            System.out.println("Error al conectar");
        }

        db.Desconecta();
    }

}

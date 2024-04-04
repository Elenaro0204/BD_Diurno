/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesruizgijon.diurno.programacionbasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    private String URL = "jdbc:mysql://127.0.0.1:3306/\"";

    public BaseDatos(String nameDB, String USER, String PASS) {
        this.USER = USER;
        this.PASS = PASS;
        this.nameDB = nameDB;
    }

    public boolean Conecta() {
        boolean conectado = false;
        try {
            conexion = DriverManager.getConnection(URL + nameDB, USER, PASS);
            conectado = true;
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex); // Corregir aquí
        }
        return conectado;
    }

    public void Desconecta() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getDatabaseNames() {
        ArrayList<String> databases = new ArrayList<>();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES");
            while (rs.next()) {
                databases.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return databases;
    }

    public ArrayList<String> getTables(String databaseName) {
        ArrayList<String> tables = new ArrayList<>();
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES IN " + databaseName);
            while (rs.next()) {
                tables.add(rs.getString(1)); // Corregir aquí
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tables;
    }

    public String[] describe(String tableName) {
        String[] columnas = null;
        int n_columnas = 0;
        int i = 0;

        try {
            Statement statement = conexion.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metadatos = resultset.getMetaData();

            n_columnas = metadatos.getColumnCount();
            columnas = new String[n_columnas];

            for (i = 1; i <= n_columnas; i++) {
                columnas[i - 1] = metadatos.getColumnName(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnas;
    }

    public String GetBaseDatosName() {
        return this.nameDB;
    }

}

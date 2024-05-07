/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.iesruzgijon.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;


public class App{
    public static void main(String[] args) throws URISyntaxException {

        App lector = new App();
        File fichero = lector.getFileFromResource("json/example_1.json");
        System.out.println(fichero);


        ObjectMapper mapper = new ObjectMapper();


        try {

            Producto producto = mapper.readValue(fichero, Producto.class);
            System.out.println(producto.getFruit());
            System.out.println(producto.getSize());
            System.out.println(producto.getColor());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

    private File getFileFromResource(String fichero) throws URISyntaxException {

        ClassLoader cargador = getClass().getClassLoader();
        URL resource = cargador.getResource(fichero);
        if (resource == null) {
            throw new IllegalArgumentException("fichero no encontrado" + fichero);
        } else {

            return new File(resource.toURI());
        }

    }

}
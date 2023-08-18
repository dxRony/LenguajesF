/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parserpy.be;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author romar
 */
public class Archivo {

    private String RUTA;
    private JFileChooser buscador = new JFileChooser();

    public String abrirArchivo() {

        String texto = "";
        try {
            buscador.showOpenDialog(buscador);
            RUTA = buscador.getSelectedFile().getAbsolutePath();
            File archivo = new File(RUTA);
            System.out.println("Abriendo... " + RUTA);
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                texto += linea + "\n";
            }
            buffer.close();
            lector.close();
        } catch (IOException error) {
            System.out.println(error);
        }
        return texto;
    }

    public void mostrarImagen(JLabel lblImagen) {
        ImageIcon imagenIcono = new ImageIcon("src\\main\\java\\archivos\\imagen.png");

        Image imagen = imagenIcono.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);

        ImageIcon imagenFinal = new ImageIcon(imagen);

        lblImagen.setIcon(imagenFinal);

    }
}

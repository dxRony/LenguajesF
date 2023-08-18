package com.mycompany.parserpy.be;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Token {

    private String lexema;
    private int linea;
    private int columna;
    private String tipo1;
    private String tipo2;
    private String patron;
    private String color;

    public Token() {
    }

    public Token(String lexema, int linea, int columna, String tipo1, String tipo2, String patron, String color) {
        this.lexema = lexema;//contenido del token
        this.linea = linea;//linea donde esta el token
        this.columna = columna;//columna donde esta el token
        this.tipo1 = tipo1;//tipo de token
        this.tipo2 = tipo2;//tipo de token
        this.patron = patron;//patron de token
        this.color = color;//color del token
    }

    public void llenarComboBox(ArrayList<Token> reporteTokens, JComboBox comboBoxIdentificadores,
            JComboBox comboBoxAritmeticos, JComboBox comboBoxComparacion, JComboBox comboBoxLogicos,
            JComboBox comboBoxAsignacion, JComboBox comboBoxKW) {
        for (int i = 0; i < reporteTokens.size(); i++) {
            String tipo2 = reporteTokens.get(i).getTipo2();
            String tipo1 = reporteTokens.get(i).getTipo1();
            String lexema = reporteTokens.get(i).getLexema();
            System.out.println("tipo2 = " + tipo2);
            System.out.println("tipo1 = " + tipo1);
            if (tipo2 == "Identificador" || tipo1 == "Identificador") {
                comboBoxIdentificadores.addItem(lexema);
            } else if (tipo1 == "Aritmetico" || tipo2 == "Aritmetico") {
                comboBoxAritmeticos.addItem(lexema);
            } else if (tipo1 == "Comparacion" || tipo2 == "Comparacion") {
                comboBoxComparacion.addItem(lexema);
            } else if (tipo1 == "Operador Logico" || tipo2 == "Operador Logico") {
                comboBoxLogicos.addItem(lexema);
            } else if (tipo1 == "Asignacion" || tipo2 == "Asignacion") {
                comboBoxAsignacion.addItem(lexema);
            } else if (tipo1 == "Palabra_Reservada" || tipo2 == "Palabra_Reservada") {
                comboBoxKW.addItem(lexema);
            }
            tipo1 = "";
            tipo2 = "";
            lexema = "";
        }
    }

    public void generarGrafica(String lexema) {

        String archivo = "src\\main\\java\\archivos\\grafo.dot";
        String imagen = "src\\main\\java\\archivos\\imagen.png";
        StringBuilder codigoDot = new StringBuilder("digraph{\nrankdir=LR\n");
        char[] caracteres = lexema.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            if (i + 1 == caracteres.length) {
                codigoDot.append(" node").append(i).append(" [label=\"").append(caracteres[i]).append("\", shape=doublecircle];\n");

            } else {
                codigoDot.append(" node").append(i).append(" [label=\"").append(caracteres[i]).append("\", shape=ellipse];\n");
            }
            if (i > 0) {
                codigoDot.append("  node").append(i - 1).append(" -> node").append(i).append(";\n");
            }
        }
        codigoDot.append("}\n");
        String codigoDotTxt = codigoDot.toString();
        try {
            FileWriter fileWriter = new FileWriter(archivo);
            fileWriter.write(codigoDotTxt);
            fileWriter.close();;
            System.out.println("Archivo modificado");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ProcessBuilder pB = new ProcessBuilder("dot", "-Tpng", archivo, "-o", imagen);

            Process process = pB.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Imagen modificada");
            } else {
                System.err.println("Error al generar imagen");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo(String tipo) {
        this.tipo1 = tipo;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    @Override
    public String toString() {
        return "Token: \n" + tipo2 + " / " + tipo1 + "  *Patron = " + patron + "   *Lexema = " + lexema + "   *Linea = " + linea + "   *Columna = " + columna + "\n";
    }
}

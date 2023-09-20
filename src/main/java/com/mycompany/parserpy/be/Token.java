package com.mycompany.parserpy.be;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
     
    /**
     * Esta funcion recibe el reporte de los Tokens y los comboBox del frame 
    * e identifica el tipo1 y tipo2 de cada token para clasificarlos en los distintos comboBox segun el 
    * tipo que tengan
     * @param reporteTokens
     * @param comboBoxIdentificadores
     * @param comboBoxAritmeticos
     * @param comboBoxComparacion
     * @param comboBoxLogicos
     * @param comboBoxAsignacion
     * @param comboBoxKW 
     */
    public void llenarComboBox(ArrayList<Token> reporteTokens, JComboBox comboBoxIdentificadores,
            JComboBox comboBoxAritmeticos, JComboBox comboBoxComparacion, JComboBox comboBoxLogicos,
            JComboBox comboBoxAsignacion, JComboBox comboBoxKW) {
        for (int i = 0; i < reporteTokens.size(); i++) {
            String tipo2 = reporteTokens.get(i).getTipo2();
            String tipo1 = reporteTokens.get(i).getTipo1();
            String lexema = reporteTokens.get(i).getLexema();
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
    
    /**
     * Esta funcion recibe el lexema de un token, para separarlo caracter por caracter y segun la cantidad de caracteres
     * que tenga genera los nodos y la estructura de un archivo .dot.
     * Luego con el archivo.dot genera la imgagen del lexema separado 
     * @param lexema 
     */
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

    /**
     * Esta funcion colorea los tokens recibiendo el area del texto y el reporte de los tokens
     * haciendo uso de la clase StyledDocument y comparando los tipos de los tokens para darles un color distinto segun el token
     * @param areaTxt
     * @param reporteTokens 
     */
    public void colorearTokens(JTextPane areaTxt, ArrayList<Token> reporteTokens) {
        StyledDocument doc = areaTxt.getStyledDocument();
        Style st = areaTxt.addStyle("StyleName", null);
        areaTxt.setText("");

        for (int i = 0; i < reporteTokens.size(); i++) {
            String texto = "Token: \n " + reporteTokens.get(i).getTipo2() + " / " + reporteTokens.get(i).getTipo1() + "  *Patron = " + reporteTokens.get(i).getPatron()
                    + "  *Lexema = " + reporteTokens.get(i).getLexema() + "  *Linea = " + reporteTokens.get(i).getLinea() + "  *Columna = " + reporteTokens.get(i).getColumna() + "\n";

            try {
                if ("Identificador".equals(reporteTokens.get(i).getTipo1())) {
                    StyleConstants.setForeground(st, Color.black);
                } else if ("Operador".equals(reporteTokens.get(i).getTipo1())) {
                    StyleConstants.setForeground(st, Color.cyan);
                } else if ("Palabra_Reservada".equals(reporteTokens.get(i).getTipo1())) {
                    StyleConstants.setForeground(st, Color.pink);
                } else if ("Constante".equals(reporteTokens.get(i).getTipo2())) {
                    StyleConstants.setForeground(st, Color.red);
                } else if ("Comentario".equals(reporteTokens.get(i).getTipo1())) {
                    StyleConstants.setForeground(st, Color.gray);
                } else if ("Otros".equals(reporteTokens.get(i).getTipo2())) {
                    StyleConstants.setForeground(st, Color.green);
                }
                try {
                    doc.insertString(doc.getLength(), texto + "\n", st);

                } catch (Exception e) {
                }

            } catch (Exception e) {
                //TODO MANEJAR EX
            }

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

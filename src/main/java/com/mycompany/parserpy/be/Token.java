/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parserpy.be;

/**
 *
 * @author romar
 */
public class Token {
     private String lexema;
    private int linea;
    private int columna;
    private String tipo1;
    private String tipo2;
    private String patron;

    public Token() {
    }

    public Token(String lexema, int linea, int columna, String tipo1, String tipo2, String patron) {
        this.lexema = lexema;//contenido del token
        this.linea = linea;//linea donde esta el token
        this.columna = columna;//columna donde esta el token
        this.tipo1 = tipo1;//tipo de token
        this.tipo2 = tipo2;//tipo de token
        this.patron = patron;//patron de token

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

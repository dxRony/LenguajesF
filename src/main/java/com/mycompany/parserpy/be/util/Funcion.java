/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parserpy.be.util;

/**
 *
 * @author rony
 */
public class Funcion {

    private int linea;
    private int columna;
    private String nombre;
    private int parametros;
    private int llamadas;

    public Funcion(int linea, int columna, String nombre, int parametros, int llamadas) {
        this.linea = linea;
        this.columna = columna;
        this.nombre = nombre;
        this.parametros = parametros;
        this.llamadas = llamadas;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getParametros() {
        return parametros;
    }

    public void setParametros(int parametros) {
        this.parametros = parametros;
    }

    public int getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(int llamadas) {
        this.llamadas = llamadas;
    }

    @Override
    public String toString() {
        return "Funcion: \n" + "  *Nombre = " + nombre + "   *Parametros = " + parametros + "   *Linea = " + linea + "   *Columna = " + columna + "\n";
    }

}

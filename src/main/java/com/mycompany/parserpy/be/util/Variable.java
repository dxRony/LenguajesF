/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parserpy.be.util;

/**
 *
 * @author rony
 */
public class Variable {

    private String nombre;
    private String tipo;
    private int linea;
    private int columna;

    public Variable(String nombre, String tipo, int linea, int columna) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }       

    @Override
    public String toString() {
        return "Variable: \n" + "  *Nombre = " + nombre +  "  *Tipo = " + tipo+"   *Linea = " + linea + "   *Columna = " + columna + "\n";
    }
}

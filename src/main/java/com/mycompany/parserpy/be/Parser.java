/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parserpy.be;

import java.util.ArrayList;

/**
 *
 * @author rony
 */
public class Parser {

    private ArrayList<Token> tokens;
    private int indice;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.indice = 0;
    }

    public void analizar() {
        while (indice < tokens.size()) {
            System.out.println(tokens.get(indice).getTipo1() + "/" + tokens.get(indice).getTipo2());
            if (tokens.get(indice).getTipo1().equals("Identificador")) {//se esta declarando un identificador              
                asignacion();
            } else {
                break;
            }
        }

    }

    private void asignacion() {
        indice++;
        if (tokens.get(indice).getTipo2().equals("Asignacion")) {//se le va a dar valor (asignacion)
            expresion();
            indice++;
        } else {
            //error sintactico
            System.out.println("no hay asignacion");
        }

    }

    private void expresion() {
        indice++;
        if (tokens.get(indice).getTipo1().equals("Cadena")) {//se le da el tipo cadena
            System.out.println("hay asignacion de tipo: cadena");
        } else if (tokens.get(indice).getTipo1().equals("Entero")) {
            System.out.println("hay asignacion de tipo: entero");
        } else if (tokens.get(indice).getTipo1().equals("Decimal")) {
            System.out.println("hay asignacion de tipo: decimal");
        } else if (tokens.get(indice).getTipo2().equals("Constante Booleana")) {
            System.out.println("hay asignacion de tipo: booleana");
        } else {
            System.out.println("no hay expresion");
            //error sintactico
        }

    }

}

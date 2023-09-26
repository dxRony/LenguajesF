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
        } else if (tokens.get(indice).getLexema().equals(",")) {//se va a declarar otro id
            indice++;
            if (tokens.get(indice).getTipo1().equals("Identificador")) {//viene otro id
                indice++;
                if (tokens.get(indice).getTipo2().equals("Asignacion")) {
                    expresion();
                    indice++;
                    if (tokens.get(indice).getLexema().equals(",")) {//se va a dar el otro valor
                        expresion();
                        indice++;
                    } else{
                        //error sintactico
                    }
                } else  {
                    //error sintactico
                }
            } else {
                //error sintactico
            }
        } else {
            //error sintactico 
            System.out.println("no hay asignacion");
        }

    }

    private void expresion() {
        indice++;
        if (tokens.get(indice).getTipo1().equals("Cadena")) {//se le da el tipo cadena
            System.out.println("hay asignacion de tipo: cadena");

        } else if (tokens.get(indice).getTipo1().equals("Entero")) {//se le da tipo entero
            System.out.println("hay asignacion de tipo: entero");

        } else if (tokens.get(indice).getTipo1().equals("Decimal")) {//se le da tipo decimal
            System.out.println("hay asignacion de tipo: decimal");

        } else if (tokens.get(indice).getTipo2().equals("Constante Booleana")) {//se le da tipo boolean
            System.out.println("hay asignacion de tipo: booleana");

        } else if (tokens.get(indice).getLexema().equals("[")) {//se abre un arreglo tipo=?
            System.out.println("se abre array");
            indice++;
            if (tokens.get(indice).getTipo1().equals("Entero")) {//arreglo tipo entero
                System.out.println("se agrego un entero");
                indice++;
                if (tokens.get(indice).getLexema().equals(",")) {//se agrega separador
                    System.out.println("se agrego ,");
                    indice++;
                    if (tokens.get(indice).getTipo1().equals("Entero")) {//se agrega otro entero
                        System.out.println("se agrego otro entero");
                        indice++;
                    } else {
                        //error sintactico
                    }
                } else {
                    //error sintactico
                }
            } else if (indice == 0) {
                //arreglo de arreglos
            } else {
                //error sintactico
            }
        } else {
            System.out.println("no hay expresion");
            //error sintactico
        }
    }
}

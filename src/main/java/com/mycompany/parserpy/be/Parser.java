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
            if (tokens.get(indice).getTipo1().equals("Identificador")) {//se esta declarando un identificador              
                System.out.println("hay identificador");
                expresion();

            } else if (tokens.get(indice).getLexema().equals("if")) {//se esta iniciando un if
                System.out.println("hay if");
                bloqueIf();

            } else if (tokens.get(indice).getLexema().equals("elif")) {//si hay un elif
                System.out.println("hay elif");
                bloqueElif();

            } else if (tokens.get(indice).getLexema().equals("else")) {//si hay un else
                System.out.println("hay else");
                bloqueElse();

            } else {
                break;
            }
        }
    }

    private void expresion() {
        indice++;

        if (tokens.get(indice).getTipo2().equals("Asignacion")) {//se le va a dar valor (asignacion)
            asignacion();
            indice++;

        } else if (tokens.get(indice).getLexema().equals(",")) {//se va a declarar otro id
            indice++;

            if (tokens.get(indice).getTipo1().equals("Identificador")) {//viene otro id
                indice++;

                if (tokens.get(indice).getTipo2().equals("Asignacion")) {
                    asignacion();
                    indice++;

                    if (tokens.get(indice).getLexema().equals(",")) {//se va a dar el otro valor
                        asignacion();
                        indice++;

                    } else {
                        //error sintactico
                    }
                } else {
                    //error sintactico
                }
            } else {
                //error sintactico
            }
        } else {
            //error sintactico 
        }

    }

    private void asignacion() {//expresion
        indice++;

        if (tokens.get(indice).getTipo1().equals("Cadena")) {//se le da el tipo cadena
            System.out.println("hay asignacion de tipo: cadena");

            indice++;
            if (tokens.get(indice).getLexema().equals("if")) { //hay ternario
                System.out.println("if(ternario)");
                ternario();
            }
        } else if (tokens.get(indice).getTipo1().equals("Entero")) {//se le da tipo entero
            System.out.println("hay asignacion de tipo: entero");

            indice++;
            if (tokens.get(indice).getLexema().equals("if")) { //hay ternario
                System.out.println("if(ternario)");
                ternario();
            }
        } else if (tokens.get(indice).getTipo1().equals("Decimal")) {//se le da tipo decimal
            System.out.println("hay asignacion de tipo: decimal");

            indice++;
            if (tokens.get(indice).getLexema().equals("if")) { //hay ternario
                System.out.println("if(ternario)");
                ternario();
            }
        } else if (tokens.get(indice).getTipo2().equals("Constante Booleana")) {//se le da tipo boolean
            System.out.println("hay asignacion de tipo: booleana");

            indice++;
            if (tokens.get(indice).getLexema().equals("if")) { //hay ternario
                System.out.println("if(ternario)");
                ternario();
            }
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
            } else if (indice == 0) {//arreglo de arreglos

            } else {
                //error sintactico
            }
        } else {
            System.out.println("no hay expresion");
            //error sintactico
        }

    }

    private void bloqueIf() {
        if (tokens.get(indice).getLexema().equals("if")) {
            indice++;

            System.out.println("hay if");
            if (tokens.get(indice).getTipo1().equals("Identificador")
                    || tokens.get(indice).getTipo2().equals("Constante Booleana")) {
                indice++;

                System.out.println("hay id/boolean");
                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;

                    System.out.println("hay :" + "\n bloque de codigo(if)");
                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    indice++;

                    System.out.println("hay comparacion");
                    if (tokens.get(indice).getTipo1().equals("Identificador")) {
                        indice++;

                        System.out.println("hay id");
                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;

                            System.out.println("hay :" + "\n bloque de codigo(if)");
                        } else {
                            //error sintactico
                        }
                    } else {
                        //error sintactico
                    }
                } else {
                    //error sintactico
                }
            } else {
                //error sintactico
            }
        } else {
            //error sintactico
        }
    }

    private void bloqueElif() {
        if (tokens.get(indice).getLexema().equals("elif")) {
            indice++;

            System.out.println("hay elif");
            if (tokens.get(indice).getTipo1().equals("Identificador")
                    || tokens.get(indice).getTipo2().equals("Constante Booleana")) {
                indice++;

                System.out.println("hay id/ boolean");
                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;

                    System.out.println("hay :" + "\n bloque de codigo(elif)");
                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    indice++;

                    System.out.println("hay comparacion");
                    if (tokens.get(indice).getTipo1().equals("Identificador")) {
                        indice++;

                        System.out.println("hay id");
                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;

                            System.out.println("hay :" + "\n bloque de codigo(elif)");
                        } else {
                            //error sintactico
                        }
                    } else {
                        //error sintactico
                    }
                } else {
                    //error sintactico
                }
            } else {
                //error sintactico
            }
        } else {
            //error sintactico
        }
    }

    private void bloqueElse() {
        if (tokens.get(indice).getLexema().equals("else")) {
            indice++;

            System.out.println("hay else");
            if (tokens.get(indice).getLexema().equals(":")) {//aparecen los 2 puntos del else
                indice++;
                System.out.println("hay :");
                System.out.println("bloque de codigo aqui...(else)");
                //#bloque de codigo
            }
        }
    }

    private void ternario() {
        System.out.println("entrando a ternario");
        indice++;
        if (tokens.get(indice).getTipo1().equals("Identificador")) {
            indice++;
            System.out.println("hay id");
            if (tokens.get(indice).getLexema().equals("else")) {
                indice++;
                System.out.println("hay else");
                if (tokens.get(indice).getTipo1().equals("Identificador")) {
                    indice++;
                    System.out.println("hay otro id");
                } else {
                    //error sintactico
                }
            } else {
                //error sintactico
            }
        } else if (tokens.get(indice).getLexema().equals("not")) {
            indice++;
            System.out.println("hay not (else not)");

            if (tokens.get(indice).getTipo1().equals("Identificador")) {
                indice++;
                System.out.println("hay id");
                if (tokens.get(indice).getLexema().equals("else")) {
                    indice++;
                    System.out.println("hay else");
                    if (tokens.get(indice).getTipo1().equals("Cadena")
                            || tokens.get(indice).getTipo1().equals("Entero")
                            || tokens.get(indice).getTipo1().equals("Decimal")
                            || tokens.get(indice).getTipo2().equals("Constante Booleana")) {
                        indice++;
                        System.out.println("hay otro id");
                    } else {
                        //error sintactico
                    }
                } else {
                    //error sintactico
                }
            } else {
                //error sintactico
            }
        } else {
            //error sintactico
        }
    }
}

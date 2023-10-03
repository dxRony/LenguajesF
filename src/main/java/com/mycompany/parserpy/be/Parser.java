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
                System.out.println("llendo a if");
                bloqueIf();

            } else if (tokens.get(indice).getLexema().equals("for")) {//empezando un ciclo for
                System.out.println("llendo a for");
                bloqueFor();

            } else if (tokens.get(indice).getLexema().equals("while")) {//empezando un ciclo while
                System.out.println("llendo a while");
                bloqueWhile();

            } else if (tokens.get(indice).getLexema().equals("def")) {//empieza un metodo
                System.out.println("hay funcion/metodo");
                funcionMetodo();

            } else if (tokens.get(indice).getTipo1().equals("Comentario")) {
                indice++;
            } else {
                //error lexico
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

            if (tokens.get(indice).getTipo2().equals("Aritmetico")) {//operadores aritmeticos
                System.out.println("hay operador aritmetico: " + tokens.get(indice).getLexema());
                indice++;

                if (tokens.get(indice).getTipo1().equals("Entero")) {
                    System.out.println("hay otro entero");
                    indice++;

                } else {
                    //error sintactico
                }
            } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {//operadores de comparacion
                System.out.println("hay comparacion");
                indice++;

                if (tokens.get(indice).getTipo1().equals("Entero")) {
                    System.out.println("hay otro entero");
                    indice++;

                    if (tokens.get(indice).getLexema().equals("and")
                            || tokens.get(indice).getLexema().equals("or")) {//operadores logicos
                        System.out.println("hay operador logico");
                        indice++;

                        if (tokens.get(indice).getTipo1().equals("Entero")) {
                            System.out.println("hay otro entero");
                            indice++;

                            if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                                System.out.println("hay otra comparacion");
                                indice++;

                                if (tokens.get(indice).getTipo1().equals("Entero")) {
                                    System.out.println("hay otro otro entero");
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
                } else {
                    //error sintactico
                }
            } else if (tokens.get(indice).getLexema().equals("is")) {//operadores de identidad
                System.out.println("hay operador identidad positivo");
                indice++;
                if (tokens.get(indice).getLexema().equals("not")) {
                    System.out.println("hay operador identidad negativo");
                    indice++;
                }
                if (tokens.get(indice).getTipo1().equals("Entero")) {
                    System.out.println("hay otro entero");
                    indice++;
                } else {
                    //error sintactico
                }
            } else {
                //error sintactico
            }

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
            //error sintactico
        }

    }

    private void bloqueIf() {
        if (tokens.get(indice).getLexema().equals("if")) {
            indice++;

            System.out.println("hay if");
            if (tokens.get(indice).getTipo1().equals("Identificador")
                    || tokens.get(indice).getTipo2().equals("Constante Booleana")
                    || tokens.get(indice).getTipo1().equals("Entero")) {
                indice++;

                System.out.println("hay id/boolean/entero");
                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;

                    System.out.println("hay :" + "\n bloque de codigo(if)");
                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    indice++;

                    System.out.println("hay comparacion");
                    if (tokens.get(indice).getTipo1().equals("Identificador")
                            || tokens.get(indice).getTipo2().equals("Constante Booleana")
                            || tokens.get(indice).getTipo1().equals("Entero")) {
                        indice++;

                        System.out.println("hay id/boolean/entero");
                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;
                            System.out.println(tokens.get(indice).getLexema());
                            System.out.println("hay :" + "\n bloque de codigo(if)");

                            if (tokens.get(indice).getLexema().equals("elif")) {//si hay un elif
                                System.out.println("hay elif");
                                bloqueElif();

                            } else {
                                //error sintactico
                            }
                            if (tokens.get(indice).getLexema().equals("else")) {//si hay un else
                                System.out.println("hay else");
                                bloqueElse();
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
        } else {
            //error sintactico
        }
    }

    private void bloqueElif() {
        if (tokens.get(indice).getLexema().equals("elif")) {
            indice++;

            System.out.println("hay elif");
            if (tokens.get(indice).getTipo1().equals("Identificador")
                    || tokens.get(indice).getTipo2().equals("Constante Booleana")
                    || tokens.get(indice).getTipo1().equals("Entero")) {
                indice++;

                System.out.println("hay id/ boolean/entero");
                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;

                    System.out.println("hay :" + "\n bloque de codigo(elif)");
                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    indice++;

                    System.out.println("hay comparacion");
                    if (tokens.get(indice).getTipo1().equals("Identificador")
                            || tokens.get(indice).getTipo2().equals("Constante Booleana")
                            || tokens.get(indice).getTipo1().equals("Entero")) {
                        indice++;

                        System.out.println("hay id/ boolean / entero");
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
            } else {
                //error sintactico
            }
        }
    }

    private void ternario() {
        System.out.println("entrando a ternario");
        indice++;

        if (tokens.get(indice).getTipo1().equals("Identificador")
                || tokens.get(indice).getTipo1().equals("Entero")) {
            indice++;

            System.out.println("hay id/entero");

            if (tokens.get(indice).getLexema().equals("else")) {
                indice++;

                System.out.println("hay else");
                if (tokens.get(indice).getTipo1().equals("Cadena")
                        || tokens.get(indice).getTipo1().equals("Entero")
                        || tokens.get(indice).getTipo1().equals("Decimal")
                        || tokens.get(indice).getTipo2().equals("Constante Booleana")) {
                    indice++;

                    System.out.println("hay constante");
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

                        System.out.println("hay constante");
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

    private void bloqueFor() {
        System.out.println("entrando a for");
        if (tokens.get(indice).getLexema().equals("for")) {
            indice++;
            System.out.println("hay for");

            if (tokens.get(indice).getTipo1().equals("Identificador")) {
                indice++;
                System.out.println("hay id");

                if (tokens.get(indice).getLexema().equals("in")) {
                    indice++;
                    System.out.println("hay in");

                    if (tokens.get(indice).getTipo1().equals("Identificador")) {
                        indice++;
                        System.out.println("hay otro id");

                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;
                            System.out.println("hay :");

                            if (tokens.get(indice).getLexema().equals("break")) {
                                indice++;
                                System.out.println("hay un break");

                                if (tokens.get(indice).getLexema().equals("else")) {
                                    System.out.println("llendo a else");
                                    bloqueElse();
                                } else {
                                    //error sintactico
                                }
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
        } else {
            //error sintactico
        }
    }

    private void bloqueWhile() {
        System.out.println("entrando a while");
        if (tokens.get(indice).getLexema().equals("while")) {
            indice++;
            System.out.println("hay while");

            if (tokens.get(indice).getTipo1().equals("Identificador")
                    || tokens.get(indice).getTipo2().equals("Constante Booleana")
                    || tokens.get(indice).getTipo1().equals("Entero")) {
                System.out.println("hay id/boolean/entero");
                indice++;

                if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    indice++;
                    System.out.println("hay comparacion");

                    if (tokens.get(indice).getTipo1().equals("Identificador")
                            || tokens.get(indice).getTipo2().equals("Constante Booleana")
                            || tokens.get(indice).getTipo1().equals("Entero")) {
                        System.out.println("hay id/boolean/entero");
                        indice++;

                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;
                            System.out.println("hay :");

                        }
                    }
                }
            }
        }
    }

    private void funcionMetodo() {
        System.out.println("entrando a funcion/metodo");
        indice++;
        if (tokens.get(indice).getTipo1().equals("Identificador")) {//nombre de la funcion
            indice++;
            System.out.println("hay nombre de funcion");
            if (tokens.get(indice).getLexema().equals("(")) {//parentesis abre
                indice++;
                System.out.println("hay ( de apertura");
                if (tokens.get(indice).getLexema().equals(")")) {//parentesis cierra
                    indice++;
                    System.out.println("hay ) de cierre");
                    if (tokens.get(indice).getLexema().equals(":")) {// hay :
                        System.out.println("hay :");
                        //bloque de codigo
                        if (tokens.get(indice).getLexema().equals("return")) {
                            retornar();
                        } else {
                            //otra cosa
                        }
                    } else {
                        //error sintactico
                    }
                } else if (tokens.get(indice).getTipo1().equals("Identificador")) {//hay argumento1
                    indice++;
                    System.out.println("hay 1 argumento");
                    if (tokens.get(indice).getLexema().equals(",")) {//hay coma
                        indice++;
                        System.out.println("hay ,");
                        if (tokens.get(indice).getTipo1().equals("Identificador")) {//hay argumento2
                            indice++;
                            System.out.println("hay 2 argumentos");
                            if (tokens.get(indice).getLexema().equals(":")) {// hay :
                                System.out.println("hay :");
                                //bloque de codigo
                                if (tokens.get(indice).getLexema().equals("return")) {
                                    retornar();
                                } else {
                                    //otra cosa
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
            } else {
                //error sintactico
            }
        } else {
            //error sintactico
        }
    }

    private void retornar() {
        System.out.println("entrando a retornar()");
        indice++;

        if (tokens.get(indice).getTipo1().equals("Identificador")) {//valor a retornar id o constante?
            indice++;
        }
    }
}

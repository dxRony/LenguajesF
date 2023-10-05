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
public class Parserdef {

    private ArrayList<Token> tokens;
    private ArrayList<String> errores;
    private int indice;

    public Parserdef(ArrayList<Token> tokens, ArrayList<String> errores) {
        this.tokens = tokens;
        this.errores = errores;
        this.indice = 0;
    }

    public void analizar() {
        System.out.println("tokens.size() = " + tokens.size());

        while (indice < tokens.size()) {
            System.out.println("indice = " + indice);
            if (tokens.get(indice).getTipo1().equals("Identificador")) {//se esta declarando un identificador              
                System.out.println("hay identificador");
                asignacion();

            } else if (tokens.get(indice).getLexema().equals("if")) {
                System.out.println("hay if");
                bloqueIf();
            } else {
                //esperando id, en linea
                indice++;
            }
        }
    }

    private void asignacion() {
        System.out.println("entrando a asignacion");
        identificador();

        if (tokens.get(indice).getTipo2().equals("Asignacion")) {//hay signo asignacion
            indice++;
            System.out.println("hay asignacion");

            expresion();
        } else {
            //  indice++;
            // esperando asignacion, en linea
        }
    }

    private void identificador() {
        System.out.println("entrando a identificador");
        if (tokens.get(indice).getTipo1().equals("Identificador")) {//hay id valido
            indice++;
            System.out.println("hay identificador");
        } else {
            //  indice++;
            // esperando id valido
        }
    }

    private void expresion() {
        System.out.println("entrando a expresion");

        if (tokens.get(indice).getTipo1().equals("Cadena")) {//
            System.out.println("hay asignacion de tipo: cadena");
            indice++;

        } else if (tokens.get(indice).getTipo1().equals("Entero")) {
            System.out.println("hay asignacion de tipo: entero");
            indice++;

        } else if (tokens.get(indice).getTipo1().equals("Decimal")) {
            System.out.println("hay asignacion de tipo: decimal");
            indice++;

        } else if (tokens.get(indice).getTipo2().equals("Constante Booleana")) {
            System.out.println("hay asignacion de tipo: booleana");
            indice++;

        } else if (tokens.get(indice).getLexema().equals("[")) {
            System.out.println("abre array [");
            indice++;
            bloqueArray();

            if (tokens.get(indice).getLexema().equals("]")) {
                indice++;
                System.out.println("cierra array ]");
                System.out.println("hay array");
            } else {
                //esperando ]
                //   indice++;
            }

        } else {
            //esperando valor de id
            // indice++;
        }
        System.out.println("saliendo");
    }

    private void bloqueArray() {
        //entrando a array
        int id = 0;

        expresion();
        id++;

        while (tokens.get(indice).getLexema().equals(",")) {//coma para separar
            indice++;
            System.out.println("hay ,");
            expresion();
            id++;
        }

    }

    private void bloqueIf() {
        if (tokens.get(indice).getLexema().equals("if")) {
            indice++;
            System.out.println("hay if");
            if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                    || tokens.get(indice).getTipo1().equals("Entero")
                    || tokens.get(indice).getTipo1().equals("Decimal")
                    || tokens.get(indice).getTipo1().equals("Cadena")) {
                indice++;
                System.out.println("hay boolean/entero/decimal/cadena");

                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;
                    System.out.println("hay :");
                    System.out.println("yendo a analizadr");
                    bloqueCodigoIf();//bloque de codigo

                    if (tokens.get(indice).getLexema().equals("elif")) {//bloqueelif
                        System.out.println("hay elif");

                        while (tokens.get(indice).getLexema().equals("elif")) {//si hay 0 o varios elifs
                            indice++;
                            System.out.println("hay elif");
                            if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                                    || tokens.get(indice).getTipo1().equals("Entero")
                                    || tokens.get(indice).getTipo1().equals("Decimal")
                                    || tokens.get(indice).getTipo1().equals("Cadena")) {
                                indice++;
                                System.out.println("hay boolean/entero/decimal/cadena");

                                if (tokens.get(indice).getLexema().equals(":")) {
                                    indice++;
                                    System.out.println("hay :");
                                    bloqueCodigoIf();//bloque de codigo

                                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                                    indice++;
                                    System.out.println("hay comparacion");

                                    if (tokens.get(indice).getTipo1().equals("Entero")
                                            || tokens.get(indice).getTipo1().equals("Decimal")
                                            || tokens.get(indice).getTipo1().equals("Cadena")) {
                                        indice++;
                                        System.out.println("hay entero/decimal/cadena para comparar");

                                        if (tokens.get(indice).getLexema().equals(":")) {
                                            indice++;
                                            System.out.println("hay :");
                                            bloqueCodigoIf();//bloque de codigo
                                        } else {
                                            //esperando :
                                        }
                                    } else {
                                        //esperando otra expresion a comparar
                                    }
                                } else {
                                    //esperando comparacion o :
                                }
                            } else {
                                //esperando expresion
                            }
                        }

                    } else {
                        System.out.println("no hay elif");
                    }
                    if (tokens.get(indice).getLexema().equals("else")) {//bloqueElse();
                        System.out.println("hay else");
                        if (tokens.get(indice).getLexema().equals("else")) {
                            indice++;
                            System.out.println("hay else");
                            if (tokens.get(indice).getLexema().equals(":")) {
                                indice++;
                                System.out.println("hay :");
                                bloqueCodigoIf();//bloque de codigo
                            }
                        }

                    } else {
                        System.out.println("no hay else");
                    }
                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    indice++;
                    System.out.println("hay comparacion");

                    if (tokens.get(indice).getTipo1().equals("Entero")
                            || tokens.get(indice).getTipo1().equals("Decimal")
                            || tokens.get(indice).getTipo1().equals("Cadena")) {
                        indice++;
                        System.out.println("hay entero/decimal/cadena para comparar");

                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;
                            System.out.println("hay :");
                            bloqueCodigoIf();//bloque de codigo

                            if (tokens.get(indice).getLexema().equals("elif")) {//bloqueElif();
                                System.out.println("hay elif");
                                while (tokens.get(indice).getLexema().equals("elif")) {//si hay 0 o varios elifs
                                    indice++;
                                    System.out.println("hay elif");
                                    if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                                            || tokens.get(indice).getTipo1().equals("Entero")
                                            || tokens.get(indice).getTipo1().equals("Decimal")
                                            || tokens.get(indice).getTipo1().equals("Cadena")) {
                                        indice++;
                                        System.out.println("hay boolean/entero/decimal/cadena");

                                        if (tokens.get(indice).getLexema().equals(":")) {
                                            indice++;
                                            System.out.println("hay :");
                                            bloqueCodigoIf();//bloque de codigo

                                        } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                                            indice++;
                                            System.out.println("hay comparacion");

                                            if (tokens.get(indice).getTipo1().equals("Entero")
                                                    || tokens.get(indice).getTipo1().equals("Decimal")
                                                    || tokens.get(indice).getTipo1().equals("Cadena")) {
                                                indice++;
                                                System.out.println("hay entero/decimal/cadena para comparar");

                                                if (tokens.get(indice).getLexema().equals(":")) {
                                                    indice++;
                                                    System.out.println("hay :");
                                                    bloqueCodigoIf();//bloque de codigo
                                                } else {
                                                    //esperando :
                                                }
                                            } else {
                                                //esperando otra expresion a comparar
                                            }
                                        } else {
                                            //esperando comparacion o :
                                        }
                                    } else {
                                        //esperando expresion
                                    }

                                }
                                if (tokens.get(indice).getLexema().equals("else")) {//bloqueElse();
                                    System.out.println("hay else");
                                    if (tokens.get(indice).getLexema().equals("else")) {
                                        indice++;
                                        System.out.println("hay else");
                                        if (tokens.get(indice).getLexema().equals(":")) {
                                            indice++;
                                            System.out.println("hay :");
                                            bloqueCodigoIf();//bloque de codigo
                                        }
                                    }

                                }
                            } else {
                                //esperando :
                            }
                        } else {
                            //esperando otra expresion a comparar
                        }
                    } else {
                        //esperando comparacion o :
                    }
                } else {
                    //esperando expresion
                }
            }
        }

    }

    private void bloqueCodigoIf() {
        bloqueIf();
        while (!tokens.get(indice).getLexema().equals("if") && !tokens.get(indice).getLexema().equals("elif") && !tokens.get(indice).getLexema().equals("else")) {
            asignacion();
        }
    }

}

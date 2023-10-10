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

            } else if (tokens.get(indice).getLexema().equals("for")) {
                System.out.println("hay for");
                bloqueFor();

            } else if (tokens.get(indice).getLexema().equals("while")) {
                System.out.println("hay while");
                bloqueWhile();

            } else if (tokens.get(indice).getLexema().equals("def")) {
                System.out.println("hay def");
                bloqueDef();

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

        if (tokens.get(indice).getTipo1().equals("Cadena")) {
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

        if (tokens.get(indice).getLexema().equals("if")) { //hay ternario
            System.out.println("hay if(ternario)");
            ternario();
        }
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
                    || tokens.get(indice).getTipo1().equals("Cadena")
                    || tokens.get(indice).getTipo1().equals("Identificador")) {
                indice++;
                System.out.println("hay boolean/entero/decimal/cadena/id");

                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;
                    System.out.println("hay :");
                    bloqueCodigoIf();//bloque de codigo

                    if (tokens.get(indice).getLexema().equals("elif")) {//bloqueelif
                        System.out.println("hay elif");

                        while (tokens.get(indice).getLexema().equals("elif")) {//si hay 0 o varios elifs
                            indice++;
                            System.out.println("hay elif");
                            if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                                    || tokens.get(indice).getTipo1().equals("Entero")
                                    || tokens.get(indice).getTipo1().equals("Decimal")
                                    || tokens.get(indice).getTipo1().equals("Cadena")
                                    || tokens.get(indice).getTipo1().equals("Identificador")) {
                                indice++;
                                System.out.println("hay boolean/entero/decimal/cadena/id");

                                if (tokens.get(indice).getLexema().equals(":")) {
                                    indice++;
                                    System.out.println("hay :");
                                    bloqueCodigoIf();//bloque de codigo

                                } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                                    indice++;
                                    System.out.println("hay comparacion");

                                    if (tokens.get(indice).getTipo1().equals("Entero")
                                            || tokens.get(indice).getTipo1().equals("Decimal")
                                            || tokens.get(indice).getTipo1().equals("Cadena")
                                            || tokens.get(indice).getTipo1().equals("Identificador")) {
                                        indice++;
                                        System.out.println("hay entero/decimal/cadena/id para comparar");

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
                            || tokens.get(indice).getTipo1().equals("Cadena")
                            || tokens.get(indice).getTipo1().equals("Identificador")) {
                        indice++;
                        System.out.println("hay entero/decimal/cadena/id para comparar");

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
                                            || tokens.get(indice).getTipo1().equals("Cadena")
                                            || tokens.get(indice).getTipo1().equals("Identificador")) {
                                        indice++;
                                        System.out.println("hay boolean/entero/decimal/cadena/id");

                                        if (tokens.get(indice).getLexema().equals(":")) {
                                            indice++;
                                            System.out.println("hay :");
                                            bloqueCodigoIf();//bloque de codigo

                                        } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                                            indice++;
                                            System.out.println("hay comparacion");

                                            if (tokens.get(indice).getTipo1().equals("Entero")
                                                    || tokens.get(indice).getTipo1().equals("Decimal")
                                                    || tokens.get(indice).getTipo1().equals("Cadena")
                                                    || tokens.get(indice).getTipo1().equals("Identificador")) {
                                                indice++;
                                                System.out.println("hay entero/decimal/cadena/id para comparar");

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

    private void ternario() {
        System.out.println("entrando a ternario");
        if (tokens.get(indice).getLexema().equals("if")) {
            indice++;

            if (tokens.get(indice).getLexema().equals("not")) {
                System.out.println("hay not ternario");
                indice++;

            }
            if (tokens.get(indice).getTipo1().equals("Identificador")) {
                System.out.println("hay id");
                indice++;

                if (tokens.get(indice).getLexema().equals("else")) {
                    System.out.println("hay else");
                    indice++;

                    if (tokens.get(indice).getTipo1().equals("Identificador")) {
                        System.out.println("hay id");
                        indice++;
                    } else {
                        //esperando id
                    }
                } else {
                    //esperando else   
                }
            } else {
                //esperando id
            }
        }
        System.out.println("saliendo de ternario");
    }

    private void bloqueFor() {
        System.out.println("entrando a for");

        if (tokens.get(indice).getLexema().equals("for")) {
            indice++;

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
                            bloqueCodigoFor();//bloque de codigo

                        } else {
                            //esperando :
                        }
                    } else {
                        //esperando id
                    }
                } else {
                    //esperando in
                }
            } else {
                //esperando id
            }
        }
        if (tokens.get(indice).getLexema().equals("else")) {
            indice++;
            System.out.println("hay else (for-else)");
            bloqueCodigoForElse();
        }
        System.out.println("saliendo de for");
    }

    private void bloqueCodigoFor() {
        System.out.println("entrando a bloqueCodigoFor");
        while (!tokens.get(indice).getLexema().equals("break")) {
            asignacion();
        }
        indice++;

        System.out.println("hay break");
        System.out.println("saliendo a bloqueCodigoFor");
    }

    private void bloqueCodigoForElse() {
        System.out.println("entrando a bloqueCodigoForElse");
        asignacion();
        System.out.println("saliendo de bloqueCodigoForElse");
    }

    private void bloqueWhile() {
        System.out.println("entrando a bloqueWhile");

        if (tokens.get(indice).getLexema().equals("while")) {
            indice++;

            if (tokens.get(indice).getTipo1().equals("Entero")
                    || tokens.get(indice).getTipo1().equals("Decimal")
                    || tokens.get(indice).getTipo1().equals("Cadena")
                    || tokens.get(indice).getTipo1().equals("Identificador")) {
                System.out.println("hay entero/decimal/cadena/id");
                indice++;

                if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    System.out.println("hay comparacion");
                    indice++;

                    if (tokens.get(indice).getTipo1().equals("Entero")
                            || tokens.get(indice).getTipo1().equals("Decimal")
                            || tokens.get(indice).getTipo1().equals("Cadena")
                            || tokens.get(indice).getTipo1().equals("Identificador")) {
                        System.out.println("hay entero/decimal/cadena/id");
                        indice++;

                        if (tokens.get(indice).getLexema().equals(":")) {
                            System.out.println("hay :");
                            indice++;
                            bloqueCodigoWhile();
                        } else {
                            //esperando :
                        }
                    } else {
                        //esprando entero/decimal/cadena/id   
                    }
                } else {
                    //esperando comparacion
                }
            } else {
                //esprando entero/decimal/cadena/id   
            }
        }
        if (tokens.get(indice).getLexema().equals("else")) {
            indice++;
            System.out.println("hay else (while-else)");
            bloqueCodigoForElse();
        }
        System.out.println("saliendo de bloqueWhile");
    }

    private void bloqueCodigoWhile() {
        System.out.println("entrando a bloqueCodigoWhile");
        asignacion();
        indice++;
        System.out.println("saliendo de  bloqueCodigoWhile");
    }

    private void bloqueDef() {
        System.out.println("entrando a def");

        if (tokens.get(indice).getLexema().equals("def")) {
            indice++;

            if (tokens.get(indice).getTipo1().equals("Identificador")) {//nombre de la funcion
                indice++;
                System.out.println("hay nombre de metodo");

                if (tokens.get(indice).getLexema().equals("(")) {//parentesis abre               
                    indice++;
                    System.out.println("hay ( de apertura");
                    parametros();

                    if (tokens.get(indice).getLexema().equals(")")) {//parentesis cierra
                        indice++;
                        System.out.println("hay ) de cierre");

                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;
                            System.out.println("hay :");

                            bloqueCodigoDef();//bloque codigo    

                        } else {
                            //esperando :
                        }
                    } else {
                        //esperando )
                    }
                } else {
                    //esperando (
                }
            } else {
                //esperando id
            }
        }
        if (tokens.get(indice).getLexema().equals("return")) {
            System.out.println("hay return");
            bloqueRetornar();
        }
        System.out.println("saliendo de def");
    }

    private void parametros() {
        System.out.println("entrando a parametros");
        int parametro = 0;
        if (tokens.get(indice).getTipo1().equals("Identificador")) {
            indice++;
            parametro++;
            System.out.println("hay parametro=" + parametro);
        }
        while (tokens.get(indice).getLexema().equals(",")) {
            indice++;
            System.out.println("hay ,");
            if (tokens.get(indice).getTipo1().equals("Identificador")) {
                indice++;
                parametro++;
                System.out.println("hay parametro = " + parametro);
            }
        }
        System.out.println("saliendo de parametros");
    }

    private void bloqueCodigoDef() {
        System.out.println("entrando a bloqueCodigoDef");
        asignacion();
       // indice++;
        System.out.println("saliendo de bloqueCodigoDef");
    }

    private void bloqueRetornar() {
        System.out.println("entrando a bloque retornar");
        if (tokens.get(indice).getLexema().equals("return")) {
            indice++;

            if (tokens.get(indice).getTipo1().equals("Identificador")) {
                System.out.println("hay id");
                indice++;

                if (tokens.get(indice).getTipo2().equals("Aritmetico")) {
                    System.out.println("hay operador aritmetico");
                    indice++;

                    if (tokens.get(indice).getTipo1().equals("Identificador")) {
                        System.out.println("hay valor a operar aritmeticamente");
                        indice++;

                    } else {
                        //esperando id
                    }
                } else {
                    //esperando operador aritmetico
                }
            } else {
                //esperando id
            }
        }
        System.out.println("saliendo de bloque retornar");
    }
}

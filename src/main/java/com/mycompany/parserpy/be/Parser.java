/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parserpy.be;

import com.mycompany.parserpy.be.util.Funcion;
import java.util.ArrayList;

/**
 *
 * @author rony
 */
public class Parser {

    private ArrayList<Token> tokens;
    private ArrayList<String> errores;
    private ArrayList<Funcion> funciones;
    private int indice;
    private int indiceError;
    private int numFunciones;
    private int llamadasFunciones;
    private String nombreLlamada;

    public Parser(ArrayList<Token> tokens, ArrayList<String> errores, ArrayList<Funcion> funciones) {
        this.tokens = tokens;
        this.errores = errores;
        this.funciones = funciones;
        this.indice = 0;
        this.indiceError = 1;
        this.numFunciones = 0;
        this.llamadasFunciones = 0;
        this.nombreLlamada = "";
    }

    public void analizar() {
        System.out.println("tokens.size() = " + tokens.size());

        while (indice < tokens.size()) {
            System.out.println("indice = " + indice);
            if (tokens.get(indice).getTipo1().equals("Identificador")
                    && tokens.get(indice + 1).getLexema().equals("(")) {
                System.out.println("hay llamada");
                identificador();

            } else if (tokens.get(indice).getTipo1().equals("Identificador")) {//se esta declarando un identificador              
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

            } else if (tokens.get(indice).getTipo1().equals("Comentario")) {
                indice++;

            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: ID, if, for, while, def o comentario\nEN LINEA:"
                        + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }

        }
        System.out.println("numFunciones = " + numFunciones);
    }

    private void asignacion() {
        System.out.println("entrando a asignacion");
        identificador();

        if (tokens.get(indice).getTipo2().equals("Asignacion")) {//hay signo asignacion
            indice++;
            System.out.println("hay asignacion");

            expresion();
        } else {
            errores.add(indiceError + ". ¡ERROR! Se esperaba: Token de Asignacion\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
            indice++;
            indiceError++;
        }
    }

    private void identificador() {
        System.out.println("entrando a identificador");

        if (tokens.get(indice).getTipo1().equals("Identificador")) {//hay id valido
            nombreLlamada = tokens.get(indice).getLexema();
            indice++;
            System.out.println("hay identificador");

            if (tokens.get(indice).getLexema().equals("(")) {
                indice++;
                System.out.println("hay (");
                parametros();

                if (tokens.get(indice).getLexema().equals(")")) {
                    indice++;
                    System.out.println("hay )");

                    for (int i = 0; i < funciones.size(); i++) {
                        System.out.println("a comparar= " + funciones.get(i).getNombre());
                        System.out.println("nombreLlamada = " + nombreLlamada);

                        if (funciones.get(i).getNombre().equals(nombreLlamada)) {
                            System.out.println("existe");
                            llamadasFunciones = funciones.get(i).getLlamadas();
                            funciones.get(i).setLlamadas(llamadasFunciones + 1);
                        }
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: <)>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            }
        } else {
            System.out.println("no ha id valido");
            errores.add(indiceError + ". ¡ERROR! Se esperaba: ID válido\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
            indice++;
            indiceError++;
        }
    }

    private void expresion() {
        System.out.println("entrando a expresion");

        if (tokens.get(indice).getTipo1().equals("Cadena")) {//cadenas
            System.out.println("hay asignacion de tipo: cadena");
            indice++;

        } else if (tokens.get(indice).getTipo1().equals("Entero")) {//enteros
            System.out.println("hay asignacion de tipo: entero");

            if (tokens.get(indice).getTipo2().equals("Aritmetico")) {//aritmeticos
                System.out.println("hay operador aritmetico");
                indice++;
                operadorAritmetico();

            } else if (tokens.get(indice).getTipo2().equals("Comparacion")) {//comparacion
                System.out.println("hay operador comparacion");
                indice++;

                if (tokens.get(indice).getTipo1().equals("Entero")) {
                    System.out.println("hay otro entero");
                    indice++;

                    if (tokens.get(indice).getLexema().equals("and")
                            || tokens.get(indice).getLexema().equals("or")
                            && tokens.get(indice - 2).getLexema().equals("==")) {
                        System.out.println("hay and/or");
                        indice++;

                        if (tokens.get(indice).getTipo1().equals("Entero")) {
                            System.out.println("hay otro entero");
                            indice++;

                            if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                                indice++;
                                System.out.println("hay otra comparacion");

                                if (tokens.get(indice).getTipo1().equals("Entero")) {
                                    System.out.println("hay otro otro otro entero");
                                    indice++;
                                } else {
                                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                    indice++;
                                    indiceError++;
                                }
                            } else {
                                errores.add(indiceError + ". ¡ERROR! Se esperaba: Token de Comparacion\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                indice++;
                                indiceError++;
                            }
                        } else {
                            errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                            indice++;
                            indiceError++;
                        }
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: and/or\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            } else if (tokens.get(indice).getLexema().equals("is")) {//identidad
                System.out.println("hay is");
                indice++;

                if (tokens.get(indice).getLexema().equals("not")) {
                    System.out.println("hay not");
                    indice++;
                }
                if (tokens.get(indice).getTipo1().equals("Entero")) {
                    System.out.println("hay entero");
                    indice++;
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            }
//            else {
//                System.out.println("a");
//                errores.add(indiceError + ". ¡ERROR! Se esperaba: Operador Aritmetico/Identidad/Comparacion\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
//                indice++;
//                indiceError++;
//            }

        } else if (tokens.get(indice).getTipo1().equals("Decimal")) {//decimales
            System.out.println("hay asignacion de tipo: decimal");
            indice++;

        } else if (tokens.get(indice).getTipo2().equals("Constante Booleana")) {//booleanos
            System.out.println("hay asignacion de tipo: booleana");
            indice++;

        } else if (tokens.get(indice).getLexema().equals("[")) {//arrays
            System.out.println("abre array [");
            indice++;
            bloqueArray();

            if (tokens.get(indice).getLexema().equals("]")) {
                indice++;
                System.out.println("cierra array ]");
                System.out.println("hay array");
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: <]> o <,>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }

        } else {
            errores.add(indiceError + ". ¡ERROR! Se esperaba: ID/Cadena/Decimal/Boolean\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
            indice++;
            indiceError++;
        }
        try {
            indice++;
            if (tokens.get(indice).getLexema().equals("if")) {//hay ternario
                System.out.println("hay if(ternario)");
                ternario();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("saliendo de expresion");
    }

    private void operadorAritmetico() {
        if (tokens.get(indice).getTipo1().equals("Entero")) {
            indice++;

            while (tokens.get(indice).getTipo2().equals("Aritmetico")) {
                System.out.println("hay otro operador aritmetico");
                indice++;

                if (tokens.get(indice).getTipo1().equals("Entero")) {
                    System.out.println("hay otro entero");
                    indice++;
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            }
        } else {
            errores.add(indiceError + ". ¡ERROR! Se esperaba: Operador Aritmetico\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
            indice++;
            indiceError++;
        }
    }

    private void bloqueArray() {
        //entrando a array
        int id = 0;

        // expresion();
        if (tokens.get(indice).getTipo1().equals("Entero")
                || tokens.get(indice).getTipo1().equals("Decimal")
                || tokens.get(indice).getTipo1().equals("Cadena")
                || tokens.get(indice).getTipo1().equals("Identificador")) {
            System.out.println("hay entero/decimal/cadena/id");
            indice++;
        } else {
            errores.add(indiceError + ". ¡ERROR! Se esperaba: ID/Cadena/Decimal/Boolean\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
            indice++;
            indiceError++;
        }
        id++;
        while (tokens.get(indice).getLexema().equals(",")) {//coma para separar
            System.out.println("hay ,");
            indice++;
            if (tokens.get(indice).getTipo1().equals("Entero")
                    || tokens.get(indice).getTipo1().equals("Decimal")
                    || tokens.get(indice).getTipo1().equals("Cadena")
                    || tokens.get(indice).getTipo1().equals("Identificador")) {
                System.out.println("hay entero/decimal/cadena/id");
                indice++;
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: ID/Cadena/Decimal/Boolean\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }
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
                    System.out.println("he salido");
                    if (tokens.get(indice).getLexema().equals("elif")) {//bloque elif
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
                                            System.out.println("he salido");
                                        } else {
                                            errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                            indice++;
                                            indiceError++;
                                        }
                                    } else {
                                        errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                        indice++;
                                        indiceError++;
                                    }
                                } else {
                                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Token de Comparacion o <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                    indice++;
                                    indiceError++;
                                }
                            } else {
                                errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                indice++;
                                indiceError++;
                            }
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
                                                    errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                                    indice++;
                                                    indiceError++;
                                                }
                                            } else {
                                                errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                                indice++;
                                                indiceError++;
                                            }
                                        } else {
                                            errores.add(indiceError + ". ¡ERROR! Se esperaba: Token de Comparacion o <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                            indice++;
                                            indiceError++;
                                        }
                                    } else {
                                        errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                        indice++;
                                        indiceError++;
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
                                errores.add(indiceError + ". ¡ERROR! Se esperaba: :\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                                indice++;
                                indiceError++;
                            }
                        } else {
                            errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                            indice++;
                            indiceError++;
                        }
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: Token de Comparacion o <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            }
        }
    }

    private void bloqueCodigoIf() {
        System.out.println("entrando a bloqueCodigoIf");
        // bloqueIf();
        while (!tokens.get(indice).getLexema().equals("if") && !tokens.get(indice).getLexema().equals("elif") && !tokens.get(indice).getLexema().equals("else")) {
            System.out.println(tokens.get(indice).getLexema());
            asignacion();
        }
        System.out.println("saliendo de bloqueCodigoIf");
    }

    private void ternario() {
        System.out.println("entrando a ternario");
        if (tokens.get(indice).getLexema().equals("if")) {
            indice++;

            if (tokens.get(indice).getLexema().equals("not")) {
                System.out.println("hay not ternario");
                indice++;

            }
            if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                    || tokens.get(indice).getTipo1().equals("Entero")
                    || tokens.get(indice).getTipo1().equals("Decimal")
                    || tokens.get(indice).getTipo1().equals("Cadena")
                    || tokens.get(indice).getTipo1().equals("Identificador")) {
                System.out.println("hay boolean/decimal/cadena/id");
                indice++;
                if (tokens.get(indice).getTipo2().equals("Comparacion")) {
                    System.out.println("hay comparacion");
                    indice++;

                    if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                            || tokens.get(indice).getTipo1().equals("Entero")
                            || tokens.get(indice).getTipo1().equals("Decimal")
                            || tokens.get(indice).getTipo1().equals("Cadena")
                            || tokens.get(indice).getTipo1().equals("Identificador")) {
                        System.out.println("hay boolean/decimal/cadena/id para comparar");
                        indice++;
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                }
                if (tokens.get(indice).getLexema().equals("else")) {
                    System.out.println("hay else");
                    indice++;

                    if (tokens.get(indice).getTipo2().equals("Constante Booleana")
                            || tokens.get(indice).getTipo1().equals("Entero")
                            || tokens.get(indice).getTipo1().equals("Decimal")
                            || tokens.get(indice).getTipo1().equals("Cadena")
                            || tokens.get(indice).getTipo1().equals("Identificador")) {
                        System.out.println("hay boolean/decimal/cadena/id");
                        indice++;
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: else\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
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
                            errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                            indice++;
                            indiceError++;
                        }
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: in\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }
        }

        try {
            if (tokens.get(indice).getLexema().equals("else")) {
                indice++;
                System.out.println("hay else (for-else)");
                if (tokens.get(indice).getLexema().equals(":")) {
                    indice++;
                    System.out.println("hay :");
                    bloqueCodigoForElse();
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
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

                            if (tokens.get(indice).getLexema().equals("break")) {
                                indice++;
                                System.out.println("hay break");
                            }
                        } else {
                            errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                            indice++;
                            indiceError++;
                        }
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Comparacion\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: Entero/Decimal/Cadena/ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }
        }
        try {
            if (tokens.get(indice).getLexema().equals("else")) {
                indice++;
                System.out.println("hay else (while-else)");
                if (tokens.get(indice).getLexema().equals(":")) {
                    System.out.println("hay : ");
                    indice++;
                    bloqueCodigoForElse();
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("saliendo de bloqueWhile");
    }

    private void bloqueCodigoWhile() {
        System.out.println("entrando a bloqueCodigoWhile");
        asignacion();
        // indice++;
        System.out.println("saliendo de  bloqueCodigoWhile");
    }

    private void bloqueDef() {
        String nombre = "";
        int linea = 0;
        int columna = 0;
        int parametros = 0;
        int llamadas = 0;
        System.out.println("entrando a def");

        if (tokens.get(indice).getLexema().equals("def")) {
            linea = tokens.get(indice).getLinea();
            columna = tokens.get(indice).getColumna();
            indice++;

            if (tokens.get(indice).getTipo1().equals("Identificador")) {//nombre de la funcion
                nombre = tokens.get(indice).getLexema();
                indice++;
                System.out.println("hay nombre de metodo");

                if (tokens.get(indice).getLexema().equals("(")) {//parentesis abre               
                    indice++;
                    System.out.println("hay ( de apertura");
                    parametros = parametros();

                    if (tokens.get(indice).getLexema().equals(")")) {//parentesis cierra
                        indice++;
                        System.out.println("hay ) de cierre");

                        if (tokens.get(indice).getLexema().equals(":")) {
                            indice++;
                            System.out.println("hay :");

                            bloqueCodigoDef();//bloque codigo    

                        } else {
                            errores.add(indiceError + ". ¡ERROR! Se esperaba: <:>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                            indice++;
                            indiceError++;
                        }
                    } else {
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: <)>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    System.out.println("E");
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: <(>\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }
        }
        if (tokens.get(indice).getLexema().equals("return")) {
            System.out.println("hay return");
            bloqueRetornar();
        }
        numFunciones++;
        funciones.add(new Funcion(linea, columna, nombre, parametros, llamadas));
        System.out.println("saliendo de def");
        System.out.println("nombre = " + nombre);
        System.out.println("parametros = " + parametros);
        System.out.println("linea = " + linea);
        System.out.println("columna = " + columna);
        System.out.println("llamadas = " + llamadas);
        System.out.println(funciones.toString());
    }

    private int parametros() {
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
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indiceError++;
            }
        }
        System.out.println("saliendo de parametros");
        return parametro;
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
                        errores.add(indiceError + ". ¡ERROR! Se esperaba: ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                        indice++;
                        indiceError++;
                    }
                } else {
                    errores.add(indiceError + ". ¡ERROR! Se esperaba: Operador Aritmetico\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                    indice++;
                    indiceError++;
                }
            } else {
                errores.add(indiceError + ". ¡ERROR! Se esperaba: ID\nEN LINEA:" + tokens.get(indice).getLinea() + "\n");
                indice++;
                indiceError++;
            }
        }
        System.out.println("saliendo de bloque retornar");
    }
}

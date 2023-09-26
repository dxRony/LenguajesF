package com.mycompany.parserpy.be;

import java.util.ArrayList;

public class Lexer {

    private ArrayList<Token> tablaTokens = new ArrayList();//lista donde se guardaran los tokens
    private ArrayList<Token> tablaErrores = new ArrayList();//lista donde se guardaran los errores
    private final String[] operadores = {"+", "-", "**", "/", "//", "%", "*", "==", "!=", ">", "<", ">=", "<=", "=", "(", ")", "{", "}",
        "[", "]", ",", ";", ":"};
    private final String[] palabrasReservadas = {"and", "as", "assert", "break", "class", "continue", "def", "del", "elif", "else", "except",
        "False", "finally", "for", "from", "global", "if", "import", "in", "is", "in", "lambda", "None", "nonlocal", "not", "or", "pass", "raise",
        "return", "True", "try", "while", "with", "yield"};

    public Lexer(ArrayList<Token> tablaTokens, ArrayList<Token> tablaErrores) {
        this.tablaTokens = tablaTokens;
        this.tablaErrores = tablaErrores;
    }

    /**
     * Esta funcion recibe el codigo a analizar para leerlo caracter a caracter
     * e ir definiedo al tipo que pertenece, tambien analiza errore lexicos y
     * cuando termina de leer un token lo manda a una lista donde se estan
     * guardando los tokens
     *
     * @param codigoFuente
     */
    public void analizar(String codigoFuente) {
        int estado = 0;
        String lexema = "";
        String tipo1 = "";
        String tipo2 = "";
        String patron = "";
        String color = "";
        String[] lineas = splitear(codigoFuente, '\n');

        boolean esPalabraReservada = false;
        boolean esOperador = false;
        boolean acaboCadena = false;

        for (int i = 0; i < lineas.length; i++) {//recorre el arreglo linea por linea
            for (int j = 0; j < lineas[i].length(); j++) {//recorre caracter a caracter que haya en la linea
                esPalabraReservada = false;
                esOperador = false;
                int caracterActual;
                int caracterSiguiente = -1;
                caracterActual = lineas[i].codePointAt(j);
                String letraSiguiente = "";

                if (acaboCadena == true) {
                    caracterActual = 32;
                }

                if (estado == 0) {
                    estado = evaluarEstadoTransicion(caracterActual);//evaluando caracter inicial
                }
                acaboCadena = false;
                try {//por si el caracter siguiente no existe
                    caracterSiguiente = lineas[i].codePointAt(j + 1);//guardando el caracter siguiente
                    char charSiguiente = (char) caracterSiguiente;
                    letraSiguiente = String.valueOf(charSiguiente);
                } catch (Exception e) {
                }
                esOperador = encontrarOperador(letraSiguiente);

                switch (estado) {
                    case 1://si es entero                      
                        lexema += lineas[i].charAt(j);
                        if (caracterSiguiente > 47 && caracterSiguiente < 58) {//si el caracter siguiente es un numero                           
                            estado = 1;
                        } else if (caracterSiguiente == 46) {//si viene un punto decimal, se convierte en un decimal
                            estado = 4;
                        } else if (esOperador == true) {//si el siguiente caracter es un operador o espacio
                            tipo1 = "Entero";
                            tipo2 = "Constante";
                            color = "RED";
                            patron = "[1-9]*";
                            estado = 0;
                        } else {
                            tipo1 = "Entero";
                            tipo2 = "Constante";
                            color = "RED";
                            patron = "[1-9]*";
                            estado = 0;
                        }
                        break;

                    case 2://si es letra
                        lexema += lineas[i].charAt(j);
                        if (caracterSiguiente > 96 && caracterSiguiente < 123 || caracterSiguiente > 64 && caracterSiguiente < 91) {// si el caracter siguiente es una letra
                            estado = 2;
                        } else if (caracterSiguiente == 95) {//se convierte en identificador
                            estado = 5;
                        } else if (caracterSiguiente > 47 && caracterSiguiente < 48) {//se convierte en un identificador
                            estado = 5;
                        } else {
                            tipo1 = "Identificador";
                            color = "BLACK";
                            patron = "([w]|_)+(w|d)*";
                            estado = 0;
                        }
                        break;

                    case 3://si hay un espacio o tab
                        estado = -2; // para evitar que se cree un token de un espacio en blanco
                        break;

                    case 4://si se ha convertido a decimal
                        lexema += lineas[i].charAt(j);
                        if (caracterSiguiente > 47 && caracterSiguiente < 58) {//si sigue un numero luego del .
                            estado = 4;
                        } else if (esOperador == true) {
                            tipo1 = "Decimal";
                            tipo2 = "Constante";
                            patron = "[1-9]*[.][0-9]*";
                            color = "RED";
                            estado = 0;
                        } else {
                            tipo1 = "Decimal";
                            tipo2 = "Constante";
                            patron = "[1-9]*[.][0-9]*";
                            color = "RED";
                            estado = 0;
                        }
                        break;

                    case 5://si se ha convertido en ID
                        lexema += lineas[i].charAt(j);
                        if (caracterSiguiente > 96 && caracterSiguiente < 123 || caracterSiguiente > 64 && caracterSiguiente < 91 || caracterSiguiente == 95) {
                            estado = 5;
                        } else if (esOperador == true) {
                            tipo1 = "Identificador";
                            color = "BLACK";
                            patron = "([w]|_)+(w|d)*";
                            estado = 0;
                        } else {
                            tipo1 = "Identificador";
                            color = "BLACK";
                            patron = "([w]|_)+(w|d)*";
                            estado = 0;
                        }
                        break;

                    case 6://si es comentario
                        lexema += lineas[i].charAt(j);
                        if (caracterSiguiente > 31 && caracterSiguiente < 127) {//agregar cualquier caracter al comentario
                            estado = 6;
                        } else {
                            tipo1 = "Comentario";
                            color = "GRAY";
                            estado = 0;
                            patron = "[#][w|operador]*";
                        }
                        break;

                    case 7:
                        lexema += lineas[i].charAt(j);

                        if (caracterSiguiente > 31 && caracterSiguiente < 127 && caracterSiguiente != 34 && caracterSiguiente != 39) {
                            estado = 7;
                        } else if (caracterSiguiente == 34 || caracterSiguiente == 39) {
                            lexema += lineas[i].charAt(j + 1);
                            tipo1 = "Cadena";
                            tipo2 = "Constante";
                            color = "RED";
                            patron = "['|comillaDoble][w|operador]*['|comillaDoble]";
                            estado = 0;
                            acaboCadena = true;
                        } else {
                            tipo1 = "Error lexico";
                            color = "GREEN";
                            estado = 0;
                        }
                        break;

                    case 8:
                        lexema += lineas[i].charAt(j); //agrega cada caracter al token
                        tipo1 = "Operador";
                        color = "BLUE";
                        patron = "[op]";
                        estado = 0;
                        if (lexema.equals("==") || lexema.equals(">=") || lexema.equals("<=") || lexema.equals("!=")) {
                            tipo2 = "Comparacion";
                        } else if (lexema.equals("**") || lexema.equals("//")) {
                            tipo2 = "Aritmetico";
                        } else if (lexema.equals("*=") || lexema.equals("-=")) {
                            tipo2 = "Asignacion";
                        }
                        break;

                    case 10://estado de aceptacion de operadores
                        lexema += lineas[i].charAt(j); //agrega cada caracter al token

                        if (caracterActual == 61 && caracterSiguiente == 61 || caracterActual == 33 && caracterSiguiente == 61
                                || caracterActual == 60 && caracterSiguiente == 61 || caracterActual == 62 && caracterSiguiente == 61
                                || caracterActual == 42 && caracterSiguiente == 42 || caracterActual == 47 && caracterSiguiente == 47) {
                            estado = 8;//si es un operador logico doble
                        } else {
                            tipo1 = "Operador";
                            color = "BLUE";
                            patron = "[op]";
                            estado = 0;
                            if (lexema.equals("+") || lexema.equals("-") || lexema.equals("%") || lexema.equals("/") || lexema.equals("*")) {
                                if (caracterSiguiente == 61) {
                                    estado = 8;
                                } else {
                                    tipo2 = "Aritmetico";
                                }
                            } else if (lexema.equals(">") | lexema.equals("<")) {
                                tipo2 = "Comparacion";
                            } else if (lexema.equals("=")) {
                                tipo2 = "Asignacion";
                            } else if (lexema.equals("(") || lexema.equals(")") || lexema.equals("{") || lexema.equals("}") || lexema.equals(".")
                                    || lexema.equals(":") || lexema.equals("[") || lexema.equals("]") || lexema.equals(",")) {
                                tipo2 = "Otros";
                            }
                        }
                        break;
                }
                if (estado == 0) {//agregando el token y su informacion a la tabla de tokens
                    esPalabraReservada = encontrarKW(lexema);
                    if (esPalabraReservada == true) {
                        tipo1 = "Palabra_Reservada";
                        color = "MAGENTA";
                        patron = "[kw]";
                    }
                    if (lexema.equals("and") || lexema.equals("or") || lexema.equals("not")) {
                        tipo2 = "Operador Logico";
                    } else if (lexema.equals("True") || lexema.equals("False")) {
                        tipo2 = "Constante Booleana";
                    }
                    if (tipo1 == "Error lexico") {
                        tablaErrores.add(new Token(lexema, i + 1, j + 1, tipo1, tipo2, patron, color));
                    } else {
                        tablaTokens.add(new Token(lexema, i + 1, j + 1, tipo1, tipo2, patron, color));
                    }
                    lexema = "";
                    tipo1 = "";
                    tipo2 = "";
                    patron = "";
                }
                if (estado == -2) {
                    estado = 0;
                }
            }
        }
    }

    /**
     * Esta funcion recibe el codigo para que lo separe linea por linea y
     * guardarlo en un arreglo, tambien recibe un string de comparacion para
     * identificar cuando crear una nueva posicion del arreglo
     *
     * @param codigo
     * @param separar
     * @return retorna un arreglo con el codigo fuente separado linea por linea
     */
    public String[] splitear(String codigo, char separador) {
        String linea = "";
        int contador = 0;

        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) == separador) {
                contador++;
            }
        }
        String[] lineas = new String[contador];
        contador = 0;

        for (int i = 0; i < codigo.length(); i++) {
            if (codigo.charAt(i) != separador) {
                linea = linea + String.valueOf(codigo.charAt(i));
            } else {
                lineas[contador] = linea;
                contador++;
                linea = "";
            }
        }
        return lineas;
    }

    /**
     * Esta funcion recibe un numero que se interpreta a traves del codigo
     * ascii, para hacer comparciones y asi determinar que tipo de caracter se
     * esta leyendo del codigo, segun el caracter que sea cambia el estado y asi
     * mismo cambia el tipo de token que se esta leyendo
     *
     * @param caracterAscii
     * @return retorna un estado para el analizador y asi define el token
     */
    public int evaluarEstadoTransicion(int caracterAscii) {
        if (caracterAscii > 47 && caracterAscii < 58) {
            return 1;//estado de aceptacion de numeros
        } else if (caracterAscii > 96 && caracterAscii < 123 || caracterAscii > 64 && caracterAscii < 91) {
            return 2;//estado  de aceptacion de letras
        } else if (caracterAscii == 32 || caracterAscii == 9 || caracterAscii == 13) {// detecta si hay espacio, tab 
            return 3;//estado de aceptacion de espacios o tabulaciones
        } else if (caracterAscii == 95) {
            return 5;//estado de aceptacion ID
        } else if (caracterAscii == 35) {
            return 6;//estado de aceptacion comentario
        } else if (caracterAscii == 34 || caracterAscii == 39) {
            return 7;//estado de aceptacion cadenas
        } else {
            return 10;//cuando el caracter siguiente es especial
        }
    }

    /**
     * Esta funcion recibe un token y lo compara en el arreglo operadores para
     * determinar si el token pertenece a este
     *
     * @param token
     * @return retorna true si el token es un operador y false en el caso que el
     * token no sea un operador
     */
    public boolean encontrarOperador(String token) {
        boolean encontrado = false;

        for (String elemento : operadores) {
            if (elemento.equals(token)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Esta funcion recibe un token y lo compara en el arreglo
     * palabrasReservadas para determinar si el token pertenece a este
     *
     * @param token
     * @return retorna true si el token es una palabra reservada y false en el
     * caso que no sea una palabra reservada
     */
    public boolean encontrarKW(String token) {
        boolean encontrado = false;

        for (String elemento : palabrasReservadas) {
            if (elemento.equals(token)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
}

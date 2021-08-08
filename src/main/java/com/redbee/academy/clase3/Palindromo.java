package com.redbee.academy.clase3;

import java.util.Locale;

public class Palindromo {

    /**
     * Generar un algoritmo que resuelva si una palabra es palindramo.
     *
     * Una palabra es palindromo cuando se lee de izquierda a derecha y de derecha a izquierda.
     * Por ej: neuquen
     *
     * @param palabra
     * @return
     */
    public static Boolean esPalindromo(String palabra) {

        int j = palabra.length() - 1;

        for (int i = 0; i == j; i++) {

            String letraI = palabra.substring(i, i).toLowerCase();
            String letraJ = palabra.substring(j, j).toLowerCase();

            if(!letraI.equals(letraJ)) {
                return false;
            }

            j--;
        }

        return true;
    }
}

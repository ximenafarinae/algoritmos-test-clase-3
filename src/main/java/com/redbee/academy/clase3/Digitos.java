package com.redbee.academy.clase3;

public class Digitos {


    /**
     * Escriba un programa que determine la cantidad de dígitos en un número
     *
     * @return
     */
    public static Integer resolver(Long numero) {
        Long numeroAux = numero;
        Integer result = 1;

        while (numeroAux >= 10) {
            numeroAux = numeroAux / 10;
            result++;
        }

        return result;
    }

    public static Integer resolverConString(Long numero) {
        return numero.toString().length();
    }
}

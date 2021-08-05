package com.redbee.academy.clase3;

public class Digitos {


    /**
     * Escriba un programa que determine la cantidad de dígitos en un número
     *
     * @return
     */
    public static Integer resolver(Long numero) {
        //TODO: implementar

        Long divisorInicial = 1L;
        Boolean yaDioCero = false;
        Integer cantidadNumeros = 0;

        while (!yaDioCero) {
            if(numero / divisorInicial > 0) {
                cantidadNumeros++;
                divisorInicial *= 10;
            } else if(numero.equals(0L)) {
                cantidadNumeros = 1;
                yaDioCero = true;
            } else {
                yaDioCero = true;
            }
        }

        return cantidadNumeros;
    }
}

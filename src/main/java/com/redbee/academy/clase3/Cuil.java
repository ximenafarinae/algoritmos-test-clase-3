package com.redbee.academy.clase3;

import javax.management.StringValueExp;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuil {

    /**
     * Un CUIL es un número que consta de 11 dígitos y está conformado de la siguiente manera:
     * <p>
     * XX-12345678-Y
     * <p>
     * Donde XX es el tipo de persona física o jurídica y pueden ser los siguientes:
     * 27 es para mujeres
     * 20 es para hombres
     * 23 puede ser ambos (se usa cuando hay otro número igual)
     * 30 empresas
     * <p>
     * Generar un algoritmo para poder calcular el valor de Y que se hace de la siguiente forma:
     * A cada uno de los 10 dígitos que conocemos, se multiplica por: 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 respectivamente
     * <p>
     * <p>
     * Se suman los valores obtenidos, el resultado se divide por 11, y del resultado  se toma el primer decimal.
     * Ese primer decimal se resta a 11 y el resultado es el numero verificador.
     * <p>
     * <p>
     * EJEMPLO
     * DNI 12.345.678 Masculino
     * <p>
     * 2 0 1 2 3 4 5 6 7 8
     * x
     * 5 4 3 2 7 6 5 4 3 2
     * ————————————————————
     * 10+0+3+4+21+24+25+24+21+16= 148
     * <p>
     * <p>
     * 148 dividido 11 = 5 ( porque 148/11= 13,454 –; .454 se redondea a 5).
     * 11-5 = 6
     * <p>
     * Entonces, el CUIL es 20-12345678-6
     *
     * @param tipoPersona
     * @param dni
     * @return
     */
    public static Integer calcular(Integer tipoPersona, Integer dni) {
        Long multiplicador = 5432765432L;
        Long suma = 0L;
        Long dividendo = 1000000000L;
        Long preCuil = (tipoPersona * (dividendo/10))+ dni;

        for (int i = 0; i < 10; i++) {

            Long num1 = preCuil / dividendo;
            Long num2 = multiplicador / dividendo;
            suma = suma + (num1 * num2);

            multiplicador = multiplicador - (num2 * dividendo);
            preCuil = preCuil - (num1 * dividendo);
            dividendo = dividendo / 10;
        }

        String result = String.valueOf(redondear(suma.doubleValue() / 11));
        int y = 11 - Integer.parseInt(result.substring(result.indexOf(".")+1));
        return y;
    }

    //devuelve un numero con un decimal redondeado.
    private static Double redondear(Double numero) {
        return new BigDecimal(numero.toString()).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

}

package com.jc.apiLogistics.utils.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
public class ValidarIdTransporte {

    /**
     * Funcion que recibe una placa como Stirng y a partir de una expresion regular valida si la placa en valida
     * Para que sea valida la placa debe iniciar con 3 letras en mayusculas seguida de 3 numeros
     * @Param String
     * @Return Boolean
     * */

    public static boolean validarPlaca(String placa) {

        Pattern pat = Pattern.compile("^[A-Z]{3}[0-9]{3}$");
        Matcher mat = pat.matcher(placa);

        return mat.find();
    }

    /**
     * Funcion que recibe un numero de flota como Stirng y a partir de una expresion regular valida si el numero de flota en valido
     * Para que sea valida el numero de flota debe iniciar con 3 letras en mayusculas seguida de 4 numeros y finalizar con una letra
     * @Param String
     * @Return Boolean
     * */

    public static boolean validarNoFlota(String flota) {

        Pattern pat = Pattern.compile("^[A-Z]{3}[0-9]{4}[A-Z]{1}$");
        Matcher mat = pat.matcher(flota);

        return mat.find();
    }
}

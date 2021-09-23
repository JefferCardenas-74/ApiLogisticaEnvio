package com.jc.apiLogistics.utils.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
public class ValidarIdTransporte {

    public static boolean validarPlaca(String placa) {

        Pattern pat = Pattern.compile("^[A-Z]{3}[0-9]{3}$");
        Matcher mat = pat.matcher(placa);

        return mat.find();
    }

    public static boolean validarNoFlota(String flota) {

        Pattern pat = Pattern.compile("^[A-Z]{3}[0-9]{4}[A-Z]{1}$");
        Matcher mat = pat.matcher(flota);

        return mat.find();
    }
}

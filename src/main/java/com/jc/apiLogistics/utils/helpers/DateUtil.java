package com.jc.apiLogistics.utils.helpers;

import javassist.Loader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
@Component
public class DateUtil {

    @Value("${jc.jwt.timezone}")
    private String TIMEZONE;

    private SimpleDateFormat simpleDateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return sdf;
    }

    public String getDateString(){
        Date now = new Date();
        return simpleDateFormat().format(now);
    }

    public long getDateMillis(){
        Date now = new Date();
        String strDate = simpleDateFormat().format(now);
        Date strNow = new Date();

        try {
            strNow = simpleDateFormat().parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return strNow.getTime();
    }

    public Date getDate(String fechaEntrega) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(fechaEntrega);

        return now;
    }

    public Date fechaActual(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        return now;
    }

    public boolean esMayor(String fechaEntrega) throws ParseException {
        boolean esMayor = false;

        Date now = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaMayor = formato.parse(fechaEntrega);

        if(fechaMayor.after(now)){
            esMayor = true;
        }
        return esMayor;
    }

    public boolean validarFecha(String fecha){
        boolean valida = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(fecha);
            valida = true;
        }catch(ParseException e){
        }

        return valida;
    }

}

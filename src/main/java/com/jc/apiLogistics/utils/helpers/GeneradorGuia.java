package com.jc.apiLogistics.utils.helpers;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
public class GeneradorGuia {

    private static String guia;

    public static String generadorGuia(){

        GeneradorGuia.guia = "";
        int opcion = 0;

        for(int i = 1; i <= 10; i++){
            opcion = (int)(Math.random()*2-1+1)+1;
            if(opcion == 1){
                GeneradorGuia.guia += (char)((int)(Math.random()*(122-97+1)+97));
            }else{
                GeneradorGuia.guia += (char)((int)(Math.random()*(57-48+1)+48));
            }

        }
        return GeneradorGuia.guia;
    }

}

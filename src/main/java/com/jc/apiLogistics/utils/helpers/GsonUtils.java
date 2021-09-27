package com.jc.apiLogistics.utils.helpers;

import com.google.gson.Gson;

/**
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 * @version 1.0
 */
public class GsonUtils {

    public static String serialize(Object src){
        Gson gson = new Gson();

        return gson.toJson(src);
    }

    public static <D> D toObject(String json,Class<D> dClass){
        Gson gson = new Gson();
        return gson.fromJson(json, dClass);
    }

    public static <D> D toObject(Object src,Class<D> dClass){
        Gson gson = new Gson();
        String srcJson = gson.toJson(src);
        return gson.fromJson(srcJson, dClass);
    }
}

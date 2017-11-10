package com.cxjd.nvwabao.utils;

import com.google.gson.Gson;

/**
 * Created by abu on 2017/10/30.
 */

public class JsonUtil {
    private static Gson mGson=new Gson();
    public static Object toObject(String json, Class classOfObject){
        return mGson.fromJson(json,classOfObject);
    }
    public static Object toJson(Object object){
        return mGson.toJson(object);
    }

}

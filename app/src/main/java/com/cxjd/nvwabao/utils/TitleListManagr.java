package com.cxjd.nvwabao.utils;

import android.content.Context;
import android.util.Log;


import com.cxjd.nvwabao.bean.FocusTitle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abu on 2017/10/31.
 */

public class TitleListManagr {
    public static final String str_all="title";
    public static final String str_show="titleshow";
    static List<FocusTitle> mList=new ArrayList<>();


    public static void saveTitleList(List<FocusTitle> mlist, Context context,String path){
        String str= (String) JsonUtil.toJson(mlist);
        (new FileOutandIn()).saveFile(str,path,context);
    }
    public static List<FocusTitle> readTitleList(Context context,String path){
        mList.clear();
        try {
            String stt=(new FileOutandIn()).readFile(path,context);
            JSONArray jsonArray=new JSONArray(stt);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                FocusTitle jsonMy=new FocusTitle(jsonObject.getString("titleName"),jsonObject.getInt("titleState"),jsonObject.getInt("title_check"));
                mList.add(jsonMy);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mList;
    }

}

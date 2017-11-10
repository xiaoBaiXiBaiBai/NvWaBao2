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
    static List<FocusTitle> mList=new ArrayList<>();
    public static void saveTitleList(List<FocusTitle> mlist, Context context){
        String str= (String) JsonUtil.toJson(mlist);
        (new FileOutandIn()).saveFile(str,"title",context);
    }
    public static List<FocusTitle> readTitleList(Context context){
        mList.clear();
        try {
            String stt=(new FileOutandIn()).readFile("title",context);
            JSONArray jsonArray=new JSONArray(stt);
            Log.i("WWW",jsonArray.length()+"");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                FocusTitle jsonMy=new FocusTitle(jsonObject.getString("titleName"),jsonObject.getString("titleState"),jsonObject.getInt("title_check"));
                mList.add(jsonMy);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mList;
    }

}

package com.cxjd.nvwabao.adapter;

import android.util.Log;

import com.cxjd.nvwabao.bean.TitleContentBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by abu on 2017/11/22.
 */

public class HttpTitleUtil {
    public interface HttpCallbackListener{
        void onFinish(String response);
        void onError(Exception e);
    }
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
          new Thread(new Runnable() {
              @Override
              public void run() {
                  HttpURLConnection connection=null;
                  try {
                      URL url=new URL(address);
                      connection= (HttpURLConnection) url.openConnection();
                      connection.setRequestMethod("GET");
                      connection.setConnectTimeout(8000);
                      connection.setReadTimeout(8000);
                      connection.setDoInput(true);
                      connection.setDoOutput(true);
                      InputStream in=connection.getInputStream();
                      BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                      StringBuilder response=new StringBuilder();
                      String line;
                      while((line=reader.readLine())!=null){
                          response.append(line);
                      }
                      Thread.sleep(2000);
                      if (listener!=null){
                          listener.onFinish(response.toString());
                      }
                  } catch (Exception e) {
                     if (listener!=null){
                         listener.onError(e);
                     }
                  } finally {
                      if (connection!=null){
                          connection.disconnect();
                      }
                  }
              }
          }).start();

    }

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
          OkHttpClient client=new OkHttpClient();
          Request request=new Request.Builder().url(address).build();
          client.newCall(request).enqueue(callback);
    }
     public static List<TitleContentBean> parseJsonWithGSON(String jsonData){
         Gson gson=new Gson();
         List<TitleContentBean> titleContentBeanList=gson.fromJson(jsonData,new TypeToken<List<TitleContentBean>>(){}.getType());
         return titleContentBeanList;
     }

}


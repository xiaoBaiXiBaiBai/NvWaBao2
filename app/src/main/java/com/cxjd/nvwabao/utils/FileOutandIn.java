package com.cxjd.nvwabao.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by abu on 2017/10/30.
 */

public class FileOutandIn {
      public  void saveFile(String string, String filename, Context context){
          FileOutputStream out=null;
          BufferedWriter writer=null;
          try {
              out=context.openFileOutput(filename,Context.MODE_PRIVATE);
              writer=new BufferedWriter(new OutputStreamWriter(out));
              writer.write(string);
          }  catch (IOException e) {
              e.printStackTrace();
          }finally {
              try {
                  if (writer!=null) {
                      writer.close();
                  }
                  if (out!=null){
                      out.close();
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }

          }
      }

    public  String readFile(String filename, Context context){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try {
            in=context.openFileInput(filename);
            reader=new BufferedReader(new InputStreamReader(in));
            String line=" ";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader!=null) {
                   reader.close();
                }if (in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return content.toString();
    }
}

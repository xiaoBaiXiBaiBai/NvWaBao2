package com.cxjd.nvwabao.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/12.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private  Context mContext;
    public  static final  String CREATE_BOOK = "create table Book(" +
            "id integer" +
            "type text" +
            "name text" +
            ")";
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext,"创建成功",Toast.LENGTH_SHORT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

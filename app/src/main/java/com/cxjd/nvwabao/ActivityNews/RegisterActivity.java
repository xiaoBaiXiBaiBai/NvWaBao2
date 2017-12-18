package com.cxjd.nvwabao.ActivityNews;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.bean.User;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.List;


import okhttp3.Call;
import okhttp3.Callback;;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity{
    public static final int SAVE_USER=1;
    private ProgressDialog progressDialog;
    EditText username_madel,userpass_model,user_acount_model;
    Button register_btn;
    String usercount,username,userpassword;
    String resultcontent = null;
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar=findViewById(R.id.registe_toobar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
    }

    private void initView() {
           username_madel=findViewById(R.id.user_name_model);
           user_acount_model=findViewById(R.id.user_count);
           userpass_model=findViewById(R.id.user_password_model);
           register_btn=findViewById(R.id.register_commit);
    }

     void registCommit(View view) {
        usercount = user_acount_model.getText().toString();
        username = username_madel.getText().toString();
        userpassword = userpass_model.getText().toString();
        resultcontent="";
        if (TextUtils.isEmpty(usercount)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            user_acount_model.findFocus();
        } else if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                    username_madel.findFocus();
        } else if (TextUtils.isEmpty(userpassword)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            userpass_model.findFocus();
        } else {
            showProgressDialog();
            String url = "http://192.168.31.227/user/addUsers/"+username+"/"+userpassword+"/"+usercount;
            HttpTitleUtil.sendOkHttpRequest(url,new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result=response.body().string();
                    try{
                        JSONObject jsonObject=new JSONObject(result);
                        Boolean usersuname,accountsuc,regisuc;
                        usersuname=jsonObject.getBoolean("user_name_exits");
                        accountsuc=jsonObject.getBoolean("user_phone_exits");
                        regisuc=jsonObject.getBoolean("add_user_success");
                        if (usersuname){
                            resultcontent="用户名已存在";
                        }
                        else if (accountsuc){
                            resultcontent="账号已注册";
                        }else if (regisuc){
                            resultcontent="注册成功";
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    closeProgressDialog();
                                    Toast.makeText(RegisterActivity.this, "register success", Toast.LENGTH_SHORT).show();
                                    User user=new User();
                                    user.setPassword(userpassword);
                                    user.setmName(username);
                                    user.setAccountNumbers(usercount);
                                    user.save();
                                   // Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                   // startActivity(intent);
                                    finish();
                                }
                            });
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

    }

    private void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("注册中...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    private void closeProgressDialog(){
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
    }

}

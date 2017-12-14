package com.cxjd.nvwabao.ActivityNews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cxjd.nvwabao.R;
import com.cxjd.nvwabao.adapter.HttpTitleUtil;
import com.cxjd.nvwabao.fragment.MineFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText user_account,user_password;
    private Button commit_btn,clear_btn1,clear_btn2;
    private TextView foget_pass,new_user;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar=findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
        Intent intent=getIntent();
        String useraccount=intent.getStringExtra("useraccount");
        String password=intent.getStringExtra("userpassword");
        if (useraccount!=null&&password!=null) {
            user_account.setText(useraccount);
            user_password.setText(password);
        }
    }
    private void init() {
        user_account=findViewById(R.id.user_account);
        user_password=findViewById(R.id.user_password);
        commit_btn=findViewById(R.id.commit_btn);
        clear_btn1=findViewById(R.id.clear_btn1);
        clear_btn2=findViewById(R.id.clear_btn2);
        foget_pass=findViewById(R.id.wjmm);
        new_user=findViewById(R.id.tv_newuser);

        new_user.setOnClickListener(this);
        commit_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_newuser:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.commit_btn:
                String useraccount,password;
                useraccount=user_account.getText().toString();
                password=user_password.getText().toString();
                if (TextUtils.isEmpty(useraccount)){
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    user_account.findFocus();
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    showProgressDialog();
                    String url = "http://192.168.31.227/user/checkUsers/"+useraccount+"/"+password;
                    HttpTitleUtil.sendOkHttpRequest(url.trim(), new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                              runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      closeProgressDialog();
                                      Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                  }
                              });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String result=response.body().string();
                            try {
                                JSONObject jsonObject=new JSONObject(result);
                                final Boolean loginresl=jsonObject.getBoolean("login_in_success");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        closeProgressDialog();
                                        if (loginresl){
                                            Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
                                            Intent intent1=new Intent(LoginActivity.this,MineFragment.class);
                                            startActivity(intent1);
                                            finish();
                                        }else {
                                            Toast.makeText(LoginActivity.this, "login faild", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
        }
    }

    private void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("登录中...");
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

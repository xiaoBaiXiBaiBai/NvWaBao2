package com.cxjd.nvwabao.ActivityNews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.cxjd.nvwabao.R;

public class RegisterActivity extends AppCompatActivity {
    EditText username_madel,userpass_model,user_acount_model;
    Button register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar=findViewById(R.id.registe_toobar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {
           username_madel=findViewById(R.id.user_name_model);
           user_acount_model=findViewById(R.id.user_count);
           userpass_model=findViewById(R.id.user_password_model);
           register_btn=findViewById(R.id.register_commit);
    }
}

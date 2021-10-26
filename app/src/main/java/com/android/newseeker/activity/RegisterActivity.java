package com.android.newseeker.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.newseeker.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerActivity_username;

    private EditText registerActivity_password;

    private Button registerActivity_confirmButton;

    private Button registerActivity_loginButton;

    private void init(){
        registerActivity_username = (EditText) findViewById(R.id.registerActivity_username);
        registerActivity_password = (EditText) findViewById(R.id.registerActivity_password);
        registerActivity_confirmButton = (Button) findViewById(R.id.registerActivity_confirmButton);
        registerActivity_loginButton = (Button) findViewById(R.id.registerActivity_loginButton);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        registerActivity_confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = registerActivity_username.getText().toString();
                String password = registerActivity_password.getText().toString();
                if (username.equals("") || password.equals("")){
                    Toast.makeText(RegisterActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }
            }
        });


        registerActivity_loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

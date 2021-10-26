package com.android.newseeker.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.newseeker.MainActivity;
import com.android.newseeker.R;

public class LoginActivity extends AppCompatActivity {

    private static String TAG = "LoginActivity";
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginbtn;
    private CheckBox remPwd;
    private int loginCheckFlag;
    private String username;
    private String password;
    private TextView newUser;
    private SharedPreferences sharepr;
    private SharedPreferences.Editor shEditor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        usernameEdit = (EditText) findViewById(R.id.loginActivity_username);
        passwordEdit = (EditText) findViewById(R.id.loginActivity_password);
        loginbtn = (Button) findViewById(R.id.loginActivity_loginButton);
        remPwd = (CheckBox) findViewById(R.id.loginActivity_rem_pwd);
        newUser = (TextView) findViewById(R.id.loginActivity_newUser);
        sharepr = PreferenceManager.getDefaultSharedPreferences(this);
        shEditor = sharepr.edit();
    }


}

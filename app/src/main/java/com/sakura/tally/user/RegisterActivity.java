package com.sakura.tally.user;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sakura.tally.R;
import com.sakura.tally.utils.MD5Utils;
import com.sakura.tally.utils.MySharePreferences;


/**
 * @author : Akubi
 * @date : 2024/2/25 1:47
 */
public class RegisterActivity extends AppCompatActivity {
    /**
     * 用户名，密码，再次输入的密码的控件
     */
    private EditText et_user_name, et_psw, et_psw_again, et_phone, et_addr, et_age;
    /**
     * 用户名，密码，再次输入的密码的控件的获取值
     */
    private String userName, psw, pswAgain;
    private MySharePreferences sp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sp = new MySharePreferences(this);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_register =
                findViewById(R.id.btn_register);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_psw = (EditText) findViewById(R.id.et_psw);
        et_psw_again = (EditText) findViewById(R.id.et_psw_again);
        et_phone = (EditText) findViewById(R.id.et_phone);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = et_user_name.getText().toString().trim();
                psw = et_psw.getText().toString().trim();
                pswAgain = et_psw_again.getText().toString().trim();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pswAgain)) {
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                } else if (!psw.equals(pswAgain)) {
                    Toast.makeText(RegisterActivity.this, "输入两次的密码不一样", Toast.LENGTH_SHORT).show();
                } else if (isExistUserName(userName)) {
                    Toast.makeText(RegisterActivity.this, "此账户名已经存在", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    sp.saveValueString(userName, MD5Utils.digest(psw));
                    User user = new User(et_user_name.getText().toString(),
                            MD5Utils.digest(et_psw.getText().toString()),
                            et_phone.getText().toString(),
                            et_addr.getText().toString(),
                            et_age.getText().toString());
                    userToString(user);
                    @SuppressLint("UnsafeIntentLaunch") Intent intent = getIntent();
                    intent.putExtra("userName", userName);
                    intent.putExtra("psd", psw);
                    setResult(2, intent);
                    finish();
                }
            }
        });

    }

    private boolean isExistUserName(String userName) {
        boolean has_userName = false;
        //获取密码
        String spPsw = sp.loadValueString(userName);
        //如果密码不为空则确实保存过这个用户名
        if (!TextUtils.isEmpty(spPsw)) {
            has_userName = true;
        }
        return has_userName;
    }

    private void userToString(User user) {
        Gson gson = new Gson();
        String customer_string = gson.toJson(user);
        sp.saveValueString("user_temp", customer_string);
    }
}
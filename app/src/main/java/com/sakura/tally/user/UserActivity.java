package com.sakura.tally.user;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sakura.tally.R;
import com.sakura.tally.utils.MD5Utils;
import com.sakura.tally.utils.MySharePreferences;

import org.jetbrains.annotations.Nullable;


public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    MySharePreferences sp;
    //获取的用户名，密码，加密密码
    private String userName, psw, pswMd5, spPsw;
    //编辑框
    private EditText et_user_name, et_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        sp = new MySharePreferences(this);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv_register =
                (TextView) findViewById(R.id.tv_register);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_login =
                (Button) findViewById(R.id.btn_login);
        tv_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_psw = (EditText) findViewById(R.id.et_psw);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_login) {
            userName = et_user_name.getText().toString();
            psw = et_psw.getText().toString();
            pswMd5 = MD5Utils.digest(psw);
            spPsw = sp.loadValueString(userName);
            if (TextUtils.isEmpty(userName)) {
                Toast.makeText(UserActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(psw)) {
                Toast.makeText(UserActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                // md5Psw.equals(); 判断，输入的密码加密后，是否与保存在SharedPreferences中一致
            } else if (pswMd5.equals(spPsw)) {
                Toast.makeText(UserActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                sp.saveValueBoolean("isload", true);
                UserActivity.this.finish();
                startActivity(new Intent(UserActivity.this, WelcomeActivity.class));
            } else if ((userName != null && !TextUtils.isEmpty(spPsw) && !pswMd5.equals(spPsw))) {
                Toast.makeText(UserActivity.this, "输入的用户名和密码不一致", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(UserActivity.this, "此用户名不存在", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.tv_register) {
            startActivityForResult(new Intent(UserActivity.this, RegisterActivity.class), 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            if (data != null) {
                String userName = data.getStringExtra("userName");
                if (!TextUtils.isEmpty(userName)) {
                    //设置用户名到 et_user_name 控件
                    et_user_name.setText(userName);
                    //et_user_name控件的setSelection()方法来设置光标位置
                    et_user_name.setSelection(userName.length());
                }
            }
        }

    }
}
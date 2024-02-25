package com.sakura.tally.user;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sakura.tally.R;

public class WelcomeActivity extends AppCompatActivity {

    TextView showhello;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //获取sharepreferences
        //显示欢迎
        showhello = this.findViewById(R.id.mainword);
        //获取用户名
        showhello.setText("欢迎你！");
    }

}
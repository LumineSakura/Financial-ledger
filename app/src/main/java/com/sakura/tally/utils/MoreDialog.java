package com.sakura.tally.utils;

/**
 * @author : Akubi
 * @date : 2024/2/23 17:03
 */

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.sakura.tally.AboutActivity;
import com.sakura.tally.HistoryActivity;
import com.sakura.tally.MonthChartActivity;
import com.sakura.tally.R;
import com.sakura.tally.SettingActivity;
import com.sakura.tally.user.UserActivity;
import com.sakura.tally.user.WelcomeActivity;


public class MoreDialog extends Dialog implements View.OnClickListener {
    MySharePreferences sp;
    Button aboutBtn, settingBtn, historyBtn, infoBtn, userBtn;
    ImageView errorIv;

    public MoreDialog(@NonNull Context context) {
        super(context);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_more);
        aboutBtn = findViewById(R.id.dialog_more_btn_about);
        settingBtn = findViewById(R.id.dialog_more_btn_setting);
        historyBtn = findViewById(R.id.dialog_more_btn_record);
        userBtn = findViewById(R.id.dialog_more_btn_user);
        infoBtn = findViewById(R.id.dialog_more_btn_info);
        errorIv = findViewById(R.id.dialog_more_iv);

        aboutBtn.setOnClickListener(this);
        userBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
        historyBtn.setOnClickListener(this);
        infoBtn.setOnClickListener(this);
        errorIv.setOnClickListener(this);

        //自定义的本程序的SharePreferences的工具类
        sp = new MySharePreferences(this.getContext());
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v.getId() == R.id.dialog_more_btn_about) {
            intent.setClass(getContext(), AboutActivity.class);
            getContext().startActivity(intent);
        } else if (v.getId() == R.id.dialog_more_btn_setting) {
            intent.setClass(getContext(), SettingActivity.class);
            getContext().startActivity(intent);
        } else if (v.getId() == R.id.dialog_more_btn_record) {
            intent.setClass(getContext(), HistoryActivity.class);
            getContext().startActivity(intent);
        } else if (v.getId() == R.id.dialog_more_btn_info) {
            intent.setClass(getContext(), MonthChartActivity.class);
            getContext().startActivity(intent);
        } else if (v.getId() == R.id.dialog_more_iv) {

        } else if (v.getId() == R.id.dialog_more_btn_user) {
            //加载MySharePreferences中的isload值
            boolean isload = sp.loadValueBoolean("isload");
            //如果isload为true跳转到欢迎界面    false跳转到登录界面
            if (isload) {
                intent.setClass(getContext(), WelcomeActivity.class);
                getContext().startActivity(intent);
            } else {
                intent.setClass(getContext(), UserActivity.class);
                getContext().startActivity(intent);
            }
        }
        cancel();
    }

    /**
     * 设置Dialog的尺寸和屏幕尺寸一致
     */
    public void setDialogSize() {
        //获取当前窗口对象
        Window window = getWindow();
        //获取窗口对象的参数
        WindowManager.LayoutParams wlp = window.getAttributes();
        //获取屏幕宽度
        Display d = window.getWindowManager().getDefaultDisplay();
        //对话框窗口为屏幕窗口
        wlp.width = (int) (d.getWidth());
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setAttributes(wlp);
    }
}

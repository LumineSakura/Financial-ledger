package com.sakura.tally;

import android.app.Application;

import com.sakura.tally.db.DBManager;

/**
 * @author : Akubi
 * @date : 2024/1/26 16:47
 */
public class UniteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化数据库
        DBManager.initDB(getApplicationContext());
    }
}

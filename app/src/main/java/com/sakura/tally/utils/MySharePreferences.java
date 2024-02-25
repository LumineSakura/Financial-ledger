package com.sakura.tally.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author 15018
 */
public class MySharePreferences {
    Context context;
    SharedPreferences sp;

    public MySharePreferences(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("Financial-ledger", Context.MODE_PRIVATE);
    }

    public void saveValueBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void saveValueString(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String loadValueString(String key) {
        return sp.getString(key, "");
    }


    public boolean loadValueBoolean(String key) {
        return sp.getBoolean(key, false);
    }


}

package com.example.myapp_db;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Practicant1.ORPO_KRG on 13.06.2014.
 */
public class SharedPrefs {

    // all urls are saved in MyPref.xml
    public final static String PREF_FILE = "MyPref";

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_FILE, 0);
    }

    // get url by key
    public static String getMyStringPref(Context context, String key) {
        return getPrefs(context).getString(key, "default");
    }

    //set url by key
    public static void setMyStringPref(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).commit();
    }
}

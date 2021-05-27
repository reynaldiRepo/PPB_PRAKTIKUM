package com.reynaldlancer.praktikumonline;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreference {
    static final String USER_SECRET = "SECREET";

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public  static  void setSecretKey (Context ctx, String data){
        SharedPreferences.Editor editor = getSharedPreference(ctx).edit();
        editor.putString(USER_SECRET  ,data);
        editor.apply();
    }

    public static  String getSecretKey (Context ctx){
        return getSharedPreference(ctx).getString(USER_SECRET, "");
    }

    public  static void  clearKey(Context ctx){
        SharedPreferences.Editor editor = getSharedPreference(ctx).edit();
        editor.remove(USER_SECRET);
        editor.apply();
    }

}

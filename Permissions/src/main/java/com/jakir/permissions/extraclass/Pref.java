package com.jakir.permissions.extraclass;


import android.content.Context;
import android.content.SharedPreferences;

public class Pref {

    public static void setPref(String data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putString(key,data);
        editor.apply();
    }
    public static String getPref(String key,Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getString(key,"");
    }
    public static void setiValue_default1(int data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putInt(key,data);
        editor.apply();
    }
    public static int getiValue_default1(String key, Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getInt(key,1);
    }


    public static void setfValue_default1(float data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putFloat(key,data);
        editor.apply();
    }
    public static float getfValue_default1(String key, Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getFloat(key,1);
    }



    public static void setiValue(int data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putInt(key,data);
        editor.apply();
    }
    public static int getiValue(String key, Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getInt(key,0);
    }

    public static void setAmount(int data, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences("amount",Context.MODE_PRIVATE).edit();
        editor.putInt("amount",data);
        editor.apply();
    }
    public static int getAmount(Context context){
        SharedPreferences preferences = context.getSharedPreferences("amount",Context.MODE_PRIVATE);
        return  preferences.getInt("amount",0);
    }

    public static void setState(boolean data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putBoolean(key,data);
        editor.apply();
    }
    public static boolean getState(String key,Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getBoolean(key,false);
    }
    public static void setStateP(boolean data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putBoolean(key,data);
        editor.apply();
    }
    public static boolean getStateP(String key, Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getBoolean(key,true);
    }

}
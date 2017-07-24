package com.example.user.qazaqbyexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

/**
 * Created by User on 21.07.2017.
 */

public class Pref {
    private static final String PREF_NAME = "QazByEx";
    private SharedPreferences mPreferences;
    private String mUsername;
    private static Pref sInstance;
    private Context context;

    public Pref(Context pContext, String pUsername) {
        context = pContext;
        mUsername = pUsername;
        mPreferences = pContext.getSharedPreferences(String.format(PREF_NAME, pUsername), Context.MODE_PRIVATE);
    }


    public String getUsername() {
        return mUsername;
    }

    public static Pref getPreferences(Context context, String username) {
        if (sInstance == null || !TextUtils.equals(sInstance.getUsername(), username)) {
            sInstance = new Pref(context, username);
        }
        return sInstance;
    }

    public void updateProgress(){
        int currentScore = mPreferences.getInt("userScore", 0);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt("color", ContextCompat.getColor(context, R.color.green));
        editor.putInt("userScore", currentScore + 10);
        editor.apply();
    }

    public int getProgress(){
        int progress = mPreferences.getInt("userScore", 0);
        return progress;
    }

    public void updateDict(String dictEntry){
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("dictEntry", dictEntry);
        editor.apply();
    }
}

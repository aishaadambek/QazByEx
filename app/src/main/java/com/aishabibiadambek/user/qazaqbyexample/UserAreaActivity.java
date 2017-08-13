package com.aishabibiadambek.user.qazaqbyexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);

        if(pref.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this, BaseActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.apply();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        TextView text = (TextView) findViewById(R.id.text);
        TextView welcomeUser = (TextView) findViewById(R.id.welcomeUser);
        Button startBtn = (Button) findViewById(R.id.startBtn);

        Typeface font = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        Typeface fontBold = Typeface.createFromAsset(getAssets(), "OpenSans-Bold.ttf");
        text.setTypeface(font);
        welcomeUser.setTypeface(fontBold);
        startBtn.setTypeface(font);

        SharedPreferences userInfo = getSharedPreferences("USER_INFO", Context.MODE_PRIVATE);
        String name = userInfo.getString("name", "");
        String message = "Добро пожаловать, " + name + "!";

        welcomeUser.setText(message);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAreaActivity.this, BaseActivity.class);
                UserAreaActivity.this.startActivity(intent);
                finish();
            }
        });

    }

}
